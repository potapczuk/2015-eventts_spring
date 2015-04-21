package com.potapczuk.events.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.potapczuk.core.service.BaseService;
import com.potapczuk.events.entity.User;
import com.potapczuk.events.repository.UserRepository;

@Service
public class UserService extends BaseService<User> {
	
	@Autowired
	private UserRepository repository;
	
	public UserRepository getRepository(){
		return repository;
	}
	
	/**
	 * Return the logged user
	 * @return
	 */
	public User getLoggedUser() {
		return null;
	}
}
