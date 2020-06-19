package com.aneesh.di.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

	@Bean
	public SchoolService schoolService() {
		return new LiteratureSchool();
	}

	
	@Bean
	public Student student() {
		Student student = new Student();
		student.setSchoolService(schoolService());
		
		return student;
		
//		return new Student(schoolService());
	}
	
}
