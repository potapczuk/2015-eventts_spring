package com.potapczuk.events.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.jstl.core.Config;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.potapczuk.core.controller.BaseController;

@Controller
public class HomeController extends BaseController {

	@RequestMapping("/")
	public String index(ModelMap model) {		
		return "index";
	}
	
	// TODO not working
	@RequestMapping("/change-lang/{lang}")
	public String changeLang(@PathVariable(value="lang") String lang, HttpServletRequest request, RedirectAttributes redirect)
	{
        Locale locale = new Locale(lang);
 
        Config.set(request.getSession(), Config.FMT_LOCALE, locale);
        Config.set(request.getSession(), Config.FMT_FALLBACK_LOCALE, locale);
        
        // TODO i18n
        flashMessage(redirect, "Language changed to " + lang);
 
        return "redirect:/";
	}
}
