package com.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Configuration
@RefreshScope
public class ClientController {

	@Value("${User}")
	private String username;
	
	@Value("${Environment}")
	private String environment;
	
	@Value("${Database}")
	private String db;
	
	
	@GetMapping("/username")
	public String getUsername() {
		return "Username: " + username + "\nEnvironment: " + environment + "\nDatabase: " + db;
	}
	
}
