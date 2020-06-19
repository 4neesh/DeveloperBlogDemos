package com.aneesh.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {

	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context
		= new AnnotationConfigApplicationContext(SpringConfig.class);

		FootballGame footballGame = context.getBean("footballGame", FootballGame.class);

//		footballGame.playGame();
		try {
			System.out.println("Main method has counted players value of: " + footballGame.countPlayers());
		}
		catch (Exception e){
			System.out.println("Main method has caught exception: " + e.getMessage());
		}

		context.close();
		
	}

}
