package com.kodilla.rps;

import java.util.Scanner;

public class RpsRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String playerName = scanner.nextLine();

        boolean playAgain = true;

        while (playAgain) {
            System.out.print("Enter the number of rounds to win: ");
            int roundsToWin = scanner.nextInt();

            String difficulty = chooseDifficulty(scanner);

            int playerScore = 0;
            int computerScore = 0;
            boolean gameFinished = false;

            while (!gameFinished) {
                System.out.println("\n===== Rock, Paper, Scissors, Lizard, Spock =====");
                System.out.println("Player: " + playerName);
                System.out.println("Round wins to finish: " + roundsToWin);
                System.out.println("Player score: " + playerScore);
                System.out.println("Computer score: " + computerScore);
                System.out.println("===============================================\n");

                System.out.println("Game controls:");
                System.out.println("1 - Play 'rock'");
                System.out.println("2 - Play 'paper'");
                System.out.println("3 - Play 'scissors'");
                System.out.println("4 - Play 'lizard'");
                System.out.println("5 - Play 'spock'");
                System.out.println("x - End the game");
                System.out.println("n - Start a new game\n");

                System.out.print("Enter your choice: ");
                char choice = scanner.next().charAt(0);

                switch (choice) {
                    case '1':
                        int[] scores1 = playRound("rock", playerName, roundsToWin, scanner, playerScore, computerScore);
                        playerScore = scores1[0];
                        computerScore = scores1[1];
                        break;
                    case '2':
                        int[] scores2 = playRound("paper", playerName, roundsToWin, scanner, playerScore, computerScore);
                        playerScore = scores2[0];
                        computerScore = scores2[1];
                        break;
                    case '3':
                        int[] scores3 = playRound("scissors", playerName, roundsToWin, scanner, playerScore, computerScore);
                        playerScore = scores3[0];
                        computerScore = scores3[1];
                        break;
                    case '4':
                        int[] scores4 = playRound("lizard", playerName, roundsToWin, scanner, playerScore, computerScore);
                        playerScore = scores4[0];
                        computerScore = scores4[1];
                        break;
                    case '5':
                        int[] scores5 = playRound("spock", playerName, roundsToWin, scanner, playerScore, computerScore);
                        playerScore = scores5[0];
                        computerScore = scores5[1];
                        break;
                    case 'x':
                        System.out.print("Are you sure you want to end the game? (y/n): ");
                        char endChoice = scanner.next().charAt(0);
                        if (endChoice == 'y') {
                            gameFinished = true;
                            playAgain = false;
                            System.out.println("Game ended. Thank you for playing!");
                        }
                        break;
                    case 'n':
                        System.out.print("Are you sure you want to end the current game? (y/n): ");
                        char newGameChoice = scanner.next().charAt(0);
                        if (newGameChoice == 'y') {
                            gameFinished = true;
                        }
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }

                if (playerScore == roundsToWin || computerScore == roundsToWin) {
                    gameFinished = true;
                    System.out.println("\n===== Game Over =====");
                    printGameSummary(playerName, playerScore, computerScore);
                    System.out.println("=======================\n");

                    System.out.println("\n===== Choose an option: =====");
                    System.out.println("n - Start a new game");
                    System.out.println("x - End the game");

                    String opcja = scanner.next();
                    if (opcja.equals("n")) {
                        playerScore = 0;
                        computerScore = 0;
                        System.out.println("Starting a new game...");
                    } else if (opcja.equals("x")) {
                        System.out.println("Game ended. Thank you for playing!");
                        playAgain = false;
                    } else {
                        System.out.println("Invalid choice. Please try again.");
                    }
                }
            }
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

    public static int[] playRound(String playerChoice, String playerName, int roundsToWin, Scanner scanner, int playerScore, int computerScore) {
        String[] choices = {"rock", "paper", "scissors", "lizard", "spock"};
        String computerChoice = choices[(int) (Math.random() * choices.length)];

        System.out.println("\nPlayer: " + playerName);
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
            playerScore++;
        } else {
            System.out.println("Computer wins the round!");
            computerScore++;
        }

        return new int[]{playerScore, computerScore};
    }

    public static void printGameSummary(String playerName, int playerScore, int computerScore) {
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
}
