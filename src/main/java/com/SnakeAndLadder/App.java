package com.SnakeAndLadder;

import java.util.Random;

/**
 * Hello world!
 *
 */
public class App {
	static int currentPosition = 0;

	public static void main(String[] args) {
		rollDice();
		System.out.println("Welcome to Snake and Ladder Program");

	}

	static int rollDice() {

		Random randomGenerator = new Random();
		int diceValue = randomGenerator.nextInt(6) + 1;
		System.out.println(diceValue);
		return diceValue;

	}
}
