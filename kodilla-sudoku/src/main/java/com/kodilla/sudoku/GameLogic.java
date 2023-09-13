package com.kodilla.sudoku;

public class GameLogic {
    private SudokuBoard board;
    private Backtrack backtrack;

    public GameLogic(SudokuBoard board) {
        this.board = board;
        this.backtrack = new Backtrack(board, 0, 0, 0);
    }

    public SudokuBoard getBoard() {
        return board;
    }

    public boolean resolveSudoku() {
        return resolveSudoku(0, 0);
    }

    private boolean resolveSudoku(int row, int col) {
        if (row == board.getSize()) {
            return true; // Sudoku has been solved correctly
        }

        if (col == board.getSize()) {
            return resolveSudoku(row + 1, 0);
        }

        SudokuElement currentElement = board.getElement(row, col);

        if (currentElement.getValue() != SudokuElement.EMPTY) {
            return resolveSudoku(row, col + 1);
        }

        for (int value = 1; value <= board.getSize(); value++) {
            if (isValidMove(row, col, value)) {
                currentElement.setValue(value);

                if (resolveSudoku(row, col + 1)) {
                    return true;
                }

                // Backtrack if the current move leads to an invalid solution
                currentElement.setValue(SudokuElement.EMPTY);
            }
        }

        backtrack.applyBacktrack(row, col);
        return false;
    }

    private boolean isValidMove(int row, int col, int value) {
        // Check if the value is valid in the current row, column, and section
        if (!isValidRow(row, value) || !isValidColumn(col, value) || !isValidSection(row, col, value)) {
            return false;
        }
        return true;
    }

    private boolean isValidRow(int row, int value) {
        for (int col = 0; col < board.getSize(); col++) {
            if (board.getElement(row, col).getValue() == value) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidColumn(int col, int value) {
        for (int row = 0; row < board.getSize(); row++) {
            if (board.getElement(row, col).getValue() == value) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidSection(int row, int col, int value) {
        int sectionSize = (int) Math.sqrt(board.getSize());
        int startRow = row - (row % sectionSize);
        int startCol = col - (col % sectionSize);

        for (int i = 0; i < sectionSize; i++) {
            for (int j = 0; j < sectionSize; j++) {
                if (board.getElement(startRow + i, startCol + j).getValue() == value) {
                    return false;
                }
            }
        }
        return true;
    }
}
