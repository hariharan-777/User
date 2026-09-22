package com.userservice.User;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.userservice")
public class UserApplication {

	public static void main(String[] args) {

        SpringApplication.run(UserApplication.class, args);
	}

}
