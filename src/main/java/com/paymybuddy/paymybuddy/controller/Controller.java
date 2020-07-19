package com.paymybuddy.paymybuddy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.paymybuddy.paymybuddy.dao.UserDao;
import com.paymybuddy.paymybuddy.model.User;
import com.paymybuddy.paymybuddy.service.UsersService;

@RestController
public class Controller {
	
	@Autowired
	private UsersService usersService;
	//private UserDao userDao;
	
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public String getMailById(@PathVariable int id) {
		return usersService.getMailById(id);
	}
	
	@PostMapping(value = "/user")
	public void addUser(@RequestBody User user) {
		usersService.saveUser(user);
	}
}
