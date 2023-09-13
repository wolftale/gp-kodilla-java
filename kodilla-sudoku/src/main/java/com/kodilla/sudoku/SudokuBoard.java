package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuBoard extends Prototype<SudokuBoard> {
    private List<SudokuRow> rows = new ArrayList<>();
    private int size;
    private int sectionSize;

    public SudokuBoard(int size) {
        this.size = size;
        this.sectionSize = (int) Math.sqrt(size);
        for (int i = 0; i < size; i++) {
            rows.add(new SudokuRow());
        }
    }

    public void initializeBoard() {
        for (SudokuRow row : rows) {
            for (SudokuElement element : row.getSudokuElements()) {
                element.setValue(SudokuElement.EMPTY);
            }
        }
    }

    public int getSize() {
        return size;
    }

    public SudokuElement getElement(int row, int col) {
        return rows.get(row).getElement(col);
    }

    @Override
    public String toString() {
        StringBuilder sudokuBoard = new StringBuilder();
        for (SudokuRow row : rows) {
            sudokuBoard.append(row).append("\n");
            for (int i = 0; i < size * 4; i++) {
                sudokuBoard.append("-");
            }
            sudokuBoard.append("\n");
        }
        return sudokuBoard.toString();
    }
}

