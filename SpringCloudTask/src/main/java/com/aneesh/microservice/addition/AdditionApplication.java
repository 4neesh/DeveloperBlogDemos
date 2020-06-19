package com.aneesh.microservice.addition;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableTask
public class AdditionApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdditionApplication.class, args);
	}
		

	@Bean
	public Concatenator createConcatenator() {
		return new Concatenator();
	}
	
	public class Concatenator implements CommandLineRunner{

		@Override
		public void run(String... args) throws Exception {

			if(args.length > 0) {
				StringBuilder concatenation = new StringBuilder();
				for(String argument : args) {
					concatenation = concatenation.append(argument);
				}
				System.out.println("Concatenated arguments: " + concatenation);
			}
			else {
				System.out.println("No arguments made to spring task");
			}
			
		}
		
	}
}
