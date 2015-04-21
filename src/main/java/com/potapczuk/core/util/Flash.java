package com.potapczuk.core.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Component
@Scope("prototype")
public class Flash {
	final String MESSAGES_KEY = "flashMessages";
	final String ERRORS_KEY = "flashErrors";

	@SuppressWarnings("unchecked")
	public void message(RedirectAttributes redirect, String msg) {
		List<String> messages;
		if(redirect.getFlashAttributes().containsKey(MESSAGES_KEY)){
			messages = (List<String>)redirect.getFlashAttributes().get(MESSAGES_KEY);
		} else {
			messages = new ArrayList<String>();
		}
		messages.add(msg);
		redirect.addFlashAttribute(MESSAGES_KEY, messages);
	}

	@SuppressWarnings("unchecked")
	public void error(RedirectAttributes redirect, String msg) {
		List<String> messages;
		if(redirect.getFlashAttributes().containsKey(ERRORS_KEY)){
			messages = (List<String>)redirect.getFlashAttributes().get(ERRORS_KEY);
		} else {
			messages = new ArrayList<String>();
		}
		messages.add(msg);
		redirect.addFlashAttribute(ERRORS_KEY, messages);
	}
}
