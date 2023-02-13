package com.app.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import jakarta.persistence.Entity;

import com.app.registration.model.User;

@SuppressWarnings("unused")
public interface RegistrationRepository extends JpaRepository<User, Integer> {

	public User findByEmailId(String emailId);
	
	public User findByEmailIdAndPassword(String emailId , String password);
}
