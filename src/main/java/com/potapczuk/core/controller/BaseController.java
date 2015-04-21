package com.potapczuk.core.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.potapczuk.core.controller.mapping.BaseMapping;
import com.potapczuk.core.util.Flash;

public class BaseController {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private Flash flash;
	
	public String redirect(String path) {
		return BaseMapping.REDIRECT + path;
	}
	
	public String forward(String path) {
		return BaseMapping.FORWARD + path;
	}
	
	public void flashMessage(RedirectAttributes redirect, String msg) {
		flash.message(redirect, msg);
	}
	
	public void flashError(RedirectAttributes redirect, String msg) {
		flash.error(redirect, msg);
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handleAllException(Exception ex, HttpServletRequest req) {
		logger.error("Request: " + req.getRequestURL() + " raised " + ex);
		
		ModelAndView map = new ModelAndView();
		map.addObject("exception", ex);
		map.addObject("url", req.getRequestURL());
		
		map.addObject("debug", true);
		
		map.setViewName("error/error");
		
		return map;
	}
	
	@RequestMapping(value="/404")
    public String error404(HttpServletRequest req){
		logger.error("Request: " + req.getRequestURL() + " was not found");
		
        return "error/404";
    }
}
