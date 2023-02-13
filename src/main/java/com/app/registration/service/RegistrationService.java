package com.app.registration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.registration.model.User;
import com.app.registration.repository.RegistrationRepository;

@Service
public class RegistrationService 
{
	
	@Autowired
	private RegistrationRepository repo;
	public User saveUser(User user)
	{
		return repo.save(user);
	}
	
	public User getUserByEmailId(String emailId)
	{
		return repo.findByEmailId(emailId);
	}
	public User getUserByEmailIdAndPassword(String emailId , String pass)
	{
		return repo.findByEmailIdAndPassword(emailId, pass);
	}
}
