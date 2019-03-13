package com.greenfox.error.model;

import com.greenfox.error.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FinderApplication {

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(FinderApplication.class, args);
	}
}
