package com.kodilla.sudoku;

import java.util.Scanner;

public class SudokuGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        while (playAgain) {
            System.out.println("Welcome to Sudoku game!");
            System.out.println("Enter size of the board (e.g. 9): ");
            int boardSize = scanner.nextInt();
            scanner.nextLine();

            SudokuBoard board = new SudokuBoard(boardSize);
            board.initializeBoard();

            System.out.println("Enter Sudoku in the form \"x,y,z\", where x is the row, y is the column, z is the value. Enter 'SUDOKU' to solve: ");
            String input;
            boolean enteredSudoku = false;

            while (true) {
                input = scanner.nextLine();
                if (input.equalsIgnoreCase("SUDOKU")) {
                    enteredSudoku = true;
                    break;
                } else {
                    String[] values = input.split(",");
                    if (values.length == 3) {
                        int row = Integer.parseInt(values[0]) - 1;
                        int col = Integer.parseInt(values[1]) - 1;
                        int value = Integer.parseInt(values[2]);
                        SudokuElement element = board.getElement(row, col);
                        element.setValue(value);
                        System.out.println(board);
                    } else {
                        System.out.println("Incorrect format. Enter the data in the form of \"x,y,z\" or 'SUDOKU' to solve.");
                    }
                }
            }

            if (enteredSudoku) {
                GameLogic gameLogic = new GameLogic(board);
                boolean solved = gameLogic.resolveSudoku();
                if (solved) {
                    System.out.println("Sudoku solved");
                    System.out.println(board);
                } else {
                    System.out.println("Sudoku not solved. Try again.");
                }
            }

            System.out.println("Do you want to solve another Sudoku? (y/n): ");
            String playAgainInput = scanner.nextLine();
            if (!playAgainInput.equalsIgnoreCase("y")) {
                playAgain = false;
            }
        }

        System.out.println("Thank you for playing Sudoku!");
    }
}
