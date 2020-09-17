package com.aneesh.repository;

import java.util.List;

import com.aneesh.entity.Property;

public interface PropertyDao {

	public List<Property> getProperties();

	public void saveProperty(Property property);

	public Property getProperty(int id);

	public void deleteProperty(int id);
	
}