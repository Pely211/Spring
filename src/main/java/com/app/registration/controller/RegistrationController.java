package com.app.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.registration.model.User;
import com.app.registration.service.RegistrationService;

@RestController
public class RegistrationController {
	
	@Autowired
	private RegistrationService service;
	
	@PostMapping("/registeruser")
	@CrossOrigin(origins = "http://localhost:4200")
	public User registerUser(@RequestBody User user) throws Exception
	{
		String tempEmailId = user.getEmailId();
		if(tempEmailId!=null && !tempEmailId.equals(""))
		{
			User userObj = service.getUserByEmailId(tempEmailId);
			if(userObj != null) 
			{
				throw new Exception("user with "+ tempEmailId + " already exists.");
				
			}
		}
		User userObj = null;
		userObj = service.saveUser(user);
		return userObj; //dodge la bug
	}
	@PostMapping("/login")
	@CrossOrigin(origins = "http://localhost:4200")
	public User loginUser(@RequestBody User user) throws Exception 
	{
		String tempEmailId = user.getEmailId();
		String tempPass = user.getPassword();
		User userObj = null;
		if(tempEmailId != null && tempPass != null)
		{
			userObj = service.getUserByEmailIdAndPassword(tempEmailId, tempPass);
		}
		if(userObj == null) 
		{
			throw new Exception("Incorrect credentials");
		}
		return userObj;
	}
	
}
