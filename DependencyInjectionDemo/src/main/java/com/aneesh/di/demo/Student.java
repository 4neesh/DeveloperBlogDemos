package com.aneesh.di.demo;



public class Student {

	private SchoolService schoolService;
	
	
	public Student(SchoolService schoolService) {
				
		this.schoolService = schoolService;

	}
	
	public Student() {
		
	}

	public SchoolService getSchoolService() {
		return this.schoolService;
	}
	
	public void setSchoolService(SchoolService schoolService) {
		this.schoolService = schoolService;
	}
	

	
}
