package com.quirkycoder.springsecurity.services;

import com.quirkycoder.springsecurity.dto.JWTAuthenticationResponse;
import com.quirkycoder.springsecurity.dto.RefreshTokenRequest;
import com.quirkycoder.springsecurity.dto.SignInRequest;
import com.quirkycoder.springsecurity.dto.SignUpRequest;
import com.quirkycoder.springsecurity.entities.User;

public interface AuthenticationService {
	
	User signup(SignUpRequest signUpRequest);
	
	JWTAuthenticationResponse signin(SignInRequest signInRequest);
	
	JWTAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest);

}
