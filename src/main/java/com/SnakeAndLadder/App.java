package com.SnakeAndLadder;

import java.util.Random;

public class App {
	static int player1 = 0, player2 = 0;;
	static int SNAKE = 2;
	static int LADDER = 1;
	static int NOPLAY = 0;

	public static void main(String[] args) {
		System.out.println("Welcome to Snake and Ladder Program");
		int currentPlayer = -1;
		int rollCountToWin = 0;
		while (true) {
			int move = checkIfMovingAheadOrBack();
			if (currentPlayer == -1) {
				if (move > NOPLAY) {
					int diceValue = rollDice();
					rollCountToWin++;
					if (move == LADDER) {
						currentPlayer = -currentPlayer;
						player1 += diceValue;
						if (player1 > 100)
							player1 -= diceValue;
					} else {
						player1 -= diceValue;
					}
				}
				if (checkIfWon(player1, currentPlayer)) {
					break;
				}
			} else {
				if (move > NOPLAY) {
					int diceValue = rollDice();
					rollCountToWin++;
					if (move == LADDER) {
						currentPlayer = -currentPlayer;
						player2 += diceValue;
						if (player2 > 100)
							player2 -= diceValue;
					} else {
						player2 -= diceValue;
					}
				}
				if (checkIfWon(player2, currentPlayer)) {
					break;
				}
			}
			currentPlayer = -currentPlayer;

		}
		System.out.println("Number of times Dice was rolled was:" + rollCountToWin);
	}

	private static boolean checkIfWon(int player, int currentPlayer) {
		int currentPosition = player;
		if (currentPlayer == -1)
			System.out.println("player 1 current position" + currentPosition);
		else
			System.out.println("player 2 current position" + currentPosition);
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
		Random randomGenerator = new Random();
		int randomValue = randomGenerator.nextInt(3);
		return randomValue;
	}

	static int rollDice() {

		Random randomGenerator = new Random();
		int diceValue = randomGenerator.nextInt(6) + 1;
		System.out.println(diceValue + " Dice");
		return diceValue;

	}
}
