package com.hr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HrController {

	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/request-contacts")
	@ResponseBody
	public Contact[] contacts() {
	        Contact[] result = restTemplate.getForObject("http://phone-book/contacts", Contact[].class);
	        return result;
	    }
	
}
