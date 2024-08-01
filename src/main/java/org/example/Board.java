package org.example;


public class Board {
    private static Character[][] board;
    private final int ROWS_BOARD = 3;
    private final int COLS_BOARD = 3;

    public Board() {
        board = new Character[ROWS_BOARD][COLS_BOARD];
    }

    public Character getCell(int row, int col) {
        return board[row][col];
    }

    public void setCell(int row, int col, Character value) {
        board[row][col] = value;
    }

    public int getRowsBoard() {
        return ROWS_BOARD;
    }

    public int getColsBoard() {
        return COLS_BOARD;
    }

    public int getEmptyCells() {
        int emptyCells = 0;
        for (int row = 0; row < ROWS_BOARD; row++) {
            for (int col = 0; col < COLS_BOARD; col++) {
                if(getCell(row, col) == null){
                    emptyCells++;
                }
            }
        }
        return emptyCells;
    }

    public void printBoard() {
        printHorizontalBars();
        for(int row = 0; row < ROWS_BOARD; row++) {
            System.out.print("| ");
            for (int col = 0; col < COLS_BOARD; col++) {
                if(board[row][col] == null){
                    System.out.print("  ");
                }else{
                    System.out.print(board[row][col] + " ");
                }
            }
            System.out.print("|\n");
        }
        printHorizontalBars();
    }

    private static void printHorizontalBars() {
        System.out.println("---------");
    }



}
