package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuRow {

    private List<SudokuElement> elements = new ArrayList<>();

    public SudokuRow() {
        for (int i = 0; i < 9; i++) {
            elements.add(new SudokuElement());
        }
    }

    public List<SudokuElement> getSudokuElements() {
        return elements;
    }

    public SudokuElement getElement(int col) {
        return elements.get(col);
    }

    @Override
    public String toString() {
        StringBuilder sudokuRow = new StringBuilder("|");
        for (SudokuElement element : elements) {
            sudokuRow.append(" ").append(element).append(" |");
        }
        return sudokuRow.toString();
    }
}
