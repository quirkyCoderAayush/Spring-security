package com.quirkycoder.springsecurity.services;

import com.quirkycoder.springsecurity.dto.SignUpRequest;
import com.quirkycoder.springsecurity.entities.User;

public interface AuthenticationService {
	
	User signup(SignUpRequest signUpRequest);

}
