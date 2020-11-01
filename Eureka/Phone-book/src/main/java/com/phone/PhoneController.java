package com.phone;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PhoneController {
	
    @GetMapping("/contacts")
    public ResponseEntity<?> getContacts() {
    	
	 List<Contact> contactList = new ArrayList<>();
		contactList.add(new Contact(123, "Alice"));
		contactList.add(new Contact(456, "Bob"));
		contactList.add(new Contact(789, "Charlie"));
        	
        return ResponseEntity.ok(contactList);
    }
	
}
