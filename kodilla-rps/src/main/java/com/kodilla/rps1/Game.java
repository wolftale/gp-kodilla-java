package com.kodilla.rps1;

import java.util.Scanner;

public class Game {
    private String playerName;
    private int roundsToWin;
    private String difficulty;
    private Player player;
    private Computer computer;

    public Game(String playerName, int roundsToWin, String difficulty) {
        this.playerName = playerName;
        this.roundsToWin = roundsToWin;
        this.difficulty = difficulty;
        this.player = new Player(playerName);
        this.computer = new Computer(difficulty);
    }

    public void play() {
        int playerScore = 0;
        int computerScore = 0;

        while (playerScore < roundsToWin && computerScore < roundsToWin) {
            Round round = new Round(player, computer);
            round.play();

            if (round.getPlayerScoredPoint()) {
                playerScore++;
            } else if (round.getComputerScoredPoint()) {
                computerScore++;
            }

            System.out.println("\n===== Game Progress =====");
            System.out.println("Player: " + playerName);
            System.out.println("Round wins to finish: " + roundsToWin);
            System.out.println("Player score: " + playerScore);
            System.out.println("Computer score: " + computerScore);
            System.out.println("==========================\n");
        }

        System.out.println("\n===== Game Over =====");
        printGameSummary(playerName, playerScore, computerScore);
        System.out.println("=======================\n");
    }

    private static void printGameSummary(String playerName, int playerScore, int computerScore) {
        System.out.println("===== Game Summary =====");
        System.out.println("Player: " + playerName);
        System.out.println("Player score: " + playerScore);
        System.out.println("Computer score: " + computerScore);
        if (playerScore > computerScore) {
            System.out.println("Congratulations " + playerName + "! You won the game!");
        } else if (playerScore < computerScore) {
            System.out.println("Computer wins! Better luck next time, " + playerName + "!");
        } else {
            System.out.println("It's a tie!");
        }
    }

    public static String chooseDifficulty(Scanner scanner) {
        System.out.println("Choose difficulty level:");
        System.out.println("1 - Easy");
        System.out.println("2 - Normal");
        System.out.println("3 - Hard");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                return "easy";
            case 2:
                return "normal";
            case 3:
                return "hard";
            default:
                System.out.println("Invalid choice. Setting difficulty level to normal.");
                return "normal";
        }
    }
}
