package com.potapczuk.events.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.potapczuk.core.controller.BaseController;
import com.potapczuk.events.entity.Event;
import com.potapczuk.events.entity.User;
import com.potapczuk.events.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	private final String BASE_FILE = "user/";
	
	@Autowired
	private UserService service;

	@RequestMapping("/")
	public String index(Model model) {
		logger.info("listing events");
		PageRequest page = new PageRequest(0, 20, Direction.ASC, "name");
		Page<User> items = service.getRepository().findAll(page);		
		
		model.addAttribute("items", items);
		
		return BASE_FILE + "list";
	}
	
	@RequestMapping("/view/{id}")
	public String view(@PathVariable("id") Long id, Model model) {
		User item = service.getRepository().findOne(id);		
		
		model.addAttribute("item", item);
		
		return BASE_FILE + "view";
	}

    @RequestMapping(value = "/create", method = RequestMethod.GET) 
    public String create(Model model) {
    	model.addAttribute("item", new Event());

        return BASE_FILE + "form";
    }
    
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET) 
    public String edit(@PathVariable("id") Long id, Model model) {
    	model.addAttribute("item", service.getRepository().findOne(id));

        return BASE_FILE + "form";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@Valid @ModelAttribute("item") User created, BindingResult bindingResult, RedirectAttributes redirect) {
    	
    	Long id = created.getId();

	    if (bindingResult.hasErrors()) {
	    	return BASE_FILE + "form";
	    }
    
        service.getRepository().saveAndFlush(created);
    
        if(id != null){
    	flashMessage(redirect, "Item edited sucessfuly");
    } else {
    	flashMessage(redirect, "Item added sucessfuly");
    }

        return redirect(BASE_FILE);
    }
    
    @RequestMapping(value = "/remove/{id}", method = RequestMethod.GET) 
    public String remove(@PathVariable("id") Long id, Model model) {
    	model.addAttribute("item", service.getRepository().findOne(id));

        return BASE_FILE + "remove";
    }
    
    @RequestMapping(value = "/remove", method = RequestMethod.POST) 
    public String removePerm(@RequestParam("id") Long id, RedirectAttributes redirect) {
    	service.getRepository().delete(id);
    	
    	flashMessage(redirect, "Item removed sucessfuly");

        return redirect(BASE_FILE);
    }
}
