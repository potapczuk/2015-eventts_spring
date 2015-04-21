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
import com.potapczuk.events.controller.mapping.EventMapping;
import com.potapczuk.events.entity.Event;
import com.potapczuk.events.service.EventService;

@Controller
@RequestMapping("/event")
public class EventController extends BaseController {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private EventService service;

	@RequestMapping("/")
	public String list(Model model) {		
		logger.info("listing events");
		PageRequest page = new PageRequest(0, 20, Direction.ASC, "name");
		Page<Event> items = service.findAll(page);		
		
		model.addAttribute("items", items);
		
		return EventMapping.BASE_FOLDER + EventMapping.VIEW_LIST;
	}
	
	// TODO implement when login is ready
	@RequestMapping("/my")
	public String my(Model model) {
		return forward(EventMapping.BASE_FOLDER);
	}
	
	@RequestMapping("/view/{id}")
	public String view(@PathVariable("id") Long id, Model model) {
		Event item = service.findOne(id);		
		
		model.addAttribute("item", item);
		
		return EventMapping.BASE_FOLDER + EventMapping.VIEW_VIEW;
	}

    @RequestMapping(value = "/create", method = RequestMethod.GET) 
    public String create(Model model) {
    	model.addAttribute("item", new Event());

        return EventMapping.BASE_FOLDER + EventMapping.VIEW_FORM;
    }
    
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET) 
    public String edit(@PathVariable("id") Long id, Model model) {
    	model.addAttribute("item", service.findOne(id));

        return EventMapping.BASE_FOLDER + EventMapping.VIEW_FORM;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@Valid @ModelAttribute("item") Event created, BindingResult bindingResult, RedirectAttributes redirect) {
    	
    	Long id = created.getId();

	    if (bindingResult.hasErrors()) {
	    	return EventMapping.BASE_FOLDER + EventMapping.VIEW_FORM;
	    }
    
        service.save(created);
    
        if(id != null){
	    	flashMessage(redirect, "Item edited sucessfuly");
	    } else {
	    	flashMessage(redirect, "Item added sucessfuly");
	    }

        return redirect(EventMapping.BASE_FOLDER);
    }
    
    @RequestMapping(value = "/remove/{id}", method = RequestMethod.GET) 
    public String remove(@PathVariable("id") Long id, Model model) {
    	model.addAttribute("item", service.findOne(id));

        return EventMapping.BASE_FOLDER + EventMapping.VIEW_REMOVE;
    }
    
    @RequestMapping(value = "/remove", method = RequestMethod.POST) 
    public String removePerm(@RequestParam("id") Long id, RedirectAttributes redirect) {
    	service.delete(id);
    	
    	flashMessage(redirect, "Item removed sucessfuly");

        return redirect(EventMapping.BASE_FOLDER);
    }
}
