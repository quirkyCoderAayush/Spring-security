package com.quirkycoder.springsecurity.services.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.quirkycoder.springsecurity.dto.SignUpRequest;
import com.quirkycoder.springsecurity.entities.Role;
import com.quirkycoder.springsecurity.entities.User;
import com.quirkycoder.springsecurity.repository.UserRepository;
import com.quirkycoder.springsecurity.services.AuthenticationService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
	
	private final UserRepository userRepository;
	
	private final PasswordEncoder passwordEncoder;
	
	public User signup(SignUpRequest signUpRequest) {
		
		User user = new User();
		
		user.setEmail(signUpRequest.getEmail());
		user.setFirstName(signUpRequest.getFirstName());
		user.setLastName(signUpRequest.getLastName());
		user.setRole(Role.USER);
		user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
		
		return userRepository.save(user);
	}

}
