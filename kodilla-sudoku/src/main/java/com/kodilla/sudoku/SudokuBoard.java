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

    public SudokuBoard deepCopy() {
        SudokuBoard clonedBoard = new SudokuBoard(this.size);
        clonedBoard.sectionSize = this.sectionSize;

        for (int i = 0; i < size; i++) {
            SudokuRow originalRow = this.rows.get(i);
            SudokuRow clonedRow = clonedBoard.rows.get(i);

            for (int j = 0; j < size; j++) {
                SudokuElement originalElement = originalRow.getElement(j);
                SudokuElement clonedElement = clonedRow.getElement(j);

                clonedElement.setValue(originalElement.getValue());

                List<Integer> originalPossibleValues = originalElement.getPossibleValues();
                List<Integer> clonedPossibleValues = new ArrayList<>(originalPossibleValues);

                clonedElement.getPossibleValues().clear();
                clonedElement.getPossibleValues().addAll(clonedPossibleValues);
            }
        }
        return clonedBoard;
    }
}
