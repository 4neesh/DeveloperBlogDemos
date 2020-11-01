package com.hr;

public class Contact {
	
	private int number;
	private String name;
	
	public Contact() {
		
	}
	
	public Contact(int number, String name) {
		super();
		this.number = number;
		this.name = name;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
