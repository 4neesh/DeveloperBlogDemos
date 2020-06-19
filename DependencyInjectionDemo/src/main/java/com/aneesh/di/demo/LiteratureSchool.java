package com.aneesh.di.demo;

import java.util.ArrayList;
import java.util.List;

public class LiteratureSchool implements SchoolService {

	
public List<String> learn(){
		
		List<String> list = new ArrayList<>();
		list.add("Shakespeare");
		list.add("Of Mice and Men");
		return list;
	}
}
