package com.kodilla.sudoku;

public class Backtrack {
    private SudokuBoard board;
    private int row;
    private int col;
    private int guessedValue;

    public Backtrack(SudokuBoard board, int row, int col, int guessedValue) {
        this.board = board;
        this.row = row;
        this.col = col;
        this.guessedValue = guessedValue;
    }

    public void applyBacktrack(int row, int col) {
        SudokuElement element = board.getElement(row, col);
        element.setValue(SudokuElement.EMPTY);
    }

    public SudokuBoard getBoard() {
        return board;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int getGuessedValue() {
        return guessedValue;
    }
}
