package com.kodilla.rps1;

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

            String difficulty = Game.chooseDifficulty(scanner);

            Game game = new Game(playerName, roundsToWin, difficulty);
            game.play();

            //Po zakończeniu gry
            System.out.println("\n===== Choose an option: =====");
            System.out.println("n - Start a new game");
            System.out.println("x - End the game");

            String option = scanner.next();
            if (option.equals("n")) {
                System.out.println("Starting a new game...");
            } else if (option.equals("x")) {
                System.out.println("Game ended. Thank you for playing!");
                playAgain = false;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }

//    public static String chooseDifficulty(Scanner scanner) {
//        System.out.println("Choose difficulty level:");
//        System.out.println("1 - Easy");
//        System.out.println("2 - Normal");
//        System.out.println("3 - Hard");
//        System.out.print("Enter your choice: ");
//        int choice = scanner.nextInt();
//
//        switch (choice) {
//            case 1:
//                return "easy";
//            case 2:
//                return "normal";
//            case 3:
//                return "hard";
//            default:
//                System.out.println("Invalid choice. Setting difficulty level to normal.");
//                return "normal";
//        }
//    }
}
