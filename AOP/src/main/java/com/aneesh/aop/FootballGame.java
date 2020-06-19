package com.aneesh.aop;

import org.springframework.stereotype.Component;

@Component
public class FootballGame {

	int playersOnPitch = 22;

	public void playGame() {
		System.out.println("Game has started.");
	}

	public int countPlayers() throws Exception{

		if (playersOnPitch == 22){
			System.out.println("FootballGame Class has successfully got 22 players.");
			return playersOnPitch;
		}
		else{
			System.out.println("FootballGame Class has not got 22 players and will throw Exception.");
			throw new Exception("FootballGame class Exception: Incorrect number of players.");
		}

	}

}