package com.aneesh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aneesh.entity.Property;
import com.aneesh.service.PropertyService;

@RestController
@RequestMapping("/")
public class Controller {

	@Autowired
	private PropertyService service;
	
	@GetMapping("/get/{id}")
	public Property getProperty(@PathVariable String id) {
		
		int idVal = Integer.parseInt(id);
		Property property = service.getProperty(idVal);
		
		if(property == null) {
			throw new IllegalArgumentException("Property " + id + " is not found.");
		}
		
		return property;
		
	}
	
	@GetMapping("/getAll")
	public List<Property> getAll() {

		return service.getAllProperties();
	}
	
	@PostMapping("/addProperty")
	public String save(@RequestBody Property property) {
				
		service.save(property);
		return "Property added: " + "\n" + property.toString();
	}
	
}

