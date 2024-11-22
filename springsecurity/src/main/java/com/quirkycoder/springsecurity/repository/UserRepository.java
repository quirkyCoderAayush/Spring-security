package com.quirkycoder.springsecurity.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quirkycoder.springsecurity.entities.Role;
import com.quirkycoder.springsecurity.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByEmail(String email);
	
	User findByRole(Role role);
}
