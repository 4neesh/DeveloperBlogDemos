package com.aneesh.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class APIController {

	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/todo-items")
	public String getPrices(){
		String url = "https://jsonplaceholder.typicode.com/todos";
		return this.restTemplate.getForObject(url, String.class);
	
	
	}
	
	@GetMapping("/todo-objects")
	public ToDo[] getPostAsObject() {
		String url = "https://jsonplaceholder.typicode.com/todos";
		return this.restTemplate.getForObject(url, ToDo[].class);
		
	}
	
	
}

