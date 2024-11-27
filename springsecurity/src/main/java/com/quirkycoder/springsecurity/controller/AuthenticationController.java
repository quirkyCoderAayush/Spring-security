package com.quirkycoder.springsecurity.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quirkycoder.springsecurity.dto.JWTAuthenticationResponse;
import com.quirkycoder.springsecurity.dto.RefreshTokenRequest;
import com.quirkycoder.springsecurity.dto.SignInRequest;
import com.quirkycoder.springsecurity.dto.SignUpRequest;
import com.quirkycoder.springsecurity.entities.User;
import com.quirkycoder.springsecurity.services.AuthenticationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
	
	private final AuthenticationService authenticationService;
	
	@PostMapping("/signup")
	public ResponseEntity<User> signup(@RequestBody SignUpRequest signUpRequest) {
		return ResponseEntity.ok(authenticationService.signup(signUpRequest));
	}
	
	@PostMapping("/signin")
	public ResponseEntity<JWTAuthenticationResponse> signin(@RequestBody SignInRequest signInRequest) {
		return ResponseEntity.ok(authenticationService.signin(signInRequest));
	}
	
	@PostMapping("/refreshtoken")
	public ResponseEntity<JWTAuthenticationResponse> refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest) {
		return ResponseEntity.ok(authenticationService.refreshToken(refreshTokenRequest));
	}
	

}
