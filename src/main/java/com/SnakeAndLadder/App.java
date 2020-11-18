package com.SnakeAndLadder;

import java.util.Random;

/**
 * Hello world!
 *
 */
public class App {
	static int currentPosition = 0;
	static int SNAKE = 2;
	static int LADDER = 1;
	static int NOPLAY = 0;

	public static void main(String[] args) {
		System.out.println("Welcome to Snake and Ladder Program");

		while (true) {
			int diceValue = rollDice();
			int move = checkIfMovingAheadOrBack();
			if (move > NOPLAY) {
				if (move == LADDER) {
					currentPosition += diceValue;
					if (currentPosition > 100)
						currentPosition -= diceValue;
				} else
					currentPosition -= diceValue;
			}
			if (checkIfWon()) {
				break;
			}
		}
	}

	private static boolean checkIfWon() {
		System.out.println(currentPosition);
		// TODO Auto-generated method stub
		if (currentPosition == 100)
			return true;
		else {
			if (currentPosition < 0) {
				currentPosition = 0;
			}
			return false;
		}
	}

	private static int checkIfMovingAheadOrBack() {
		// TODO Auto-generated method stub
		Random randomGenerator = new Random();
		int randomValue = randomGenerator.nextInt(3);
		return randomValue;
	}

	static int rollDice() {

		Random randomGenerator = new Random();
		int diceValue = randomGenerator.nextInt(6) + 1;
		System.out.println(diceValue);
		return diceValue;

	}
}
