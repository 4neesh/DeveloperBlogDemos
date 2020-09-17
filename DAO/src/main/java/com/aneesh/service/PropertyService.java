package com.aneesh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aneesh.entity.Property;
import com.aneesh.repository.JpaRepositoryImpl;

@Service
public class PropertyService {

	@Autowired
	private JpaRepositoryImpl repositoryService;
	
	
	public void save(Property property) {
		
		repositoryService.save(property);
		
	}
	
	
	public List<Property> getAllProperties() {
		return repositoryService.findAll();
	}
	
	public Property getProperty(int id) {

		Property property = repositoryService.findById(id).get();
		
		return property;
	}
	
	
}
