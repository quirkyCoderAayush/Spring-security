package com.quirkycoder.springsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.quirkycoder.springsecurity.entities.Role;
import com.quirkycoder.springsecurity.entities.User;
import com.quirkycoder.springsecurity.repository.UserRepository;

@SpringBootApplication
public class SpringsecurityApplication implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringsecurityApplication.class, args);
		System.out.println("Hello quirkyCoder!!!");
	}

	@Override
	public void run(String... args) throws Exception {
		
		User adminAccount = userRepository.findByRole(Role.ADMIN);
		
		if(null == adminAccount) {
			User user = new User();
			
			user.setEmail("admin@gmail.com");
			user.setFirstName("admin");
			user.setLastName("admin");
			user.setRole(Role.ADMIN);
			user.setPassword(new BCryptPasswordEncoder().encode("2024Admin@@11"));
			
			userRepository.save(user);
		}
		
	}

}
