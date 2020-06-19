package com.aneesh.di.demo;

import java.util.ArrayList;
import java.util.List;

public class ArtSchool implements SchoolService {

	
public List<String> learn(){
		
		List<String> list = new ArrayList<>();
		list.add("Painting");
		list.add("Abstract art");
		return list;
	}

}
