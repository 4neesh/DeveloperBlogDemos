package com.aneesh.di.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@Autowired
	Student student;
	
	@RequestMapping("/")
	public List<String> index(){
		return student.getSchoolService().learn();
	}
}
