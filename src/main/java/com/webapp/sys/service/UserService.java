package com.webapp.sys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.webapp.sys.model.Role;
import com.webapp.sys.model.User;
import com.webapp.sys.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public User save(User user) {

		String ecPwd = passwordEncoder.encode(user.getPassword());//encodePassword
		user.setPassword(ecPwd);
		user.setEnabled(true);
		Role role = new Role();
		
        role.setId(1l);
        user.getRoles().add(role);
		return userRepository.save(user);
	}
	
}
