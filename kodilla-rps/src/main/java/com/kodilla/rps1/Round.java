package com.kodilla.rps1;

import java.util.Scanner;

public class Round {
    private Player player;
    private Computer computer;
    private boolean playerScoredPoint;
    private boolean computerScoredPoint;

    public Round(Player player, Computer computer) {
        this.player = player;
        this.computer = computer;
        this.playerScoredPoint = false;
        this.computerScoredPoint = false;
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n===== Rock, Paper, Scissors, Lizard, Spock =====");
        System.out.println("Player: " + player.getName());
        System.out.println("Computer: ");
        System.out.println("===============================\n");

        System.out.println("Game controls:");
        System.out.println("1 - Play 'rock'");
        System.out.println("2 - Play 'paper'");
        System.out.println("3 - Play 'scissors'");
        System.out.println("4 - Play 'lizard'");
        System.out.println("5 - Play 'spock'");
        System.out.println("x - End the game");
        System.out.println("n - Start a new game\n");

        System.out.print("Enter your choice: ");
        String playerChoice = getPlayerChoice(scanner);

        String computerChoice = computer.makeMove();

        System.out.println("\nPlayer: " + player.getName());
        System.out.println("Player's choice: " + playerChoice);
        System.out.println("Computer's choice: " + computerChoice);

        if (playerChoice.equals(computerChoice)) {
            System.out.println("It's a tie!");
        } else if (
                (playerChoice.equals("rock") && (computerChoice.equals("scissors") || computerChoice.equals("lizard"))) ||
                        (playerChoice.equals("paper") && (computerChoice.equals("rock") || computerChoice.equals("spock"))) ||
                        (playerChoice.equals("scissors") && (computerChoice.equals("paper") || computerChoice.equals("lizard"))) ||
                        (playerChoice.equals("lizard") && (computerChoice.equals("paper") || computerChoice.equals("spock"))) ||
                        (playerChoice.equals("spock") && (computerChoice.equals("rock") || computerChoice.equals("scissors")))
        ) {
            System.out.println("Player wins the round!");
            playerScoredPoint = true;
        } else {
            System.out.println("Computer wins the round!");
            computerScoredPoint = true;
        }
    }

    private String getPlayerChoice(Scanner scanner) {
        String choice = scanner.next();

        switch (choice) {
            case "1":
                return "rock";
            case "2":
                return "paper";
            case "3":
                return "scissors";
            case "4":
                return "lizard";
            case "5":
                return "spock";
            case "x":
                System.out.print("Are you sure you want to end the game? (y/n): ");
                char endChoice = scanner.next().charAt(0);
                if (endChoice == 'y') {
                    System.out.println("Game ended. Thank you for playing!");
                    System.exit(0);
                } else {
                    return getPlayerChoice(scanner);
                }
            case "n":
                System.out.print("Are you sure you want to end the current game? (y/n): ");
                char newGameChoice = scanner.next().charAt(0);
                if (newGameChoice == 'y') {
                    System.out.println("Game ended. Thank you for playing!");
                    System.exit(0);
                } else {
                    return getPlayerChoice(scanner);
                }
            default:
                System.out.println("Invalid choice. Please try again.");
                return getPlayerChoice(scanner);
        }
    }

    public boolean getPlayerScoredPoint() {
        return playerScoredPoint;
    }

    public boolean getComputerScoredPoint() {
        return computerScoredPoint;
    }
}
