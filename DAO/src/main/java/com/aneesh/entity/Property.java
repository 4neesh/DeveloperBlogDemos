package com.aneesh.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="estate_table")
public class Property {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="property_type")
	private String propertyType;
	
	@Column(name="address")
	private String address;
	
	@Column(name="bedrooms")
	private int bedrooms;
	
	@Column(name="price")
	private double price;

	public String getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getBedrooms() {
		return bedrooms;
	}

	public void setBedrooms(int bedrooms) {
		this.bedrooms = bedrooms;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Property [id=" + id + ", propertyType=" + propertyType + ", address=" + address + ", bedrooms="
				+ bedrooms + ", price=" + price + "]";
	}
	
	
}
