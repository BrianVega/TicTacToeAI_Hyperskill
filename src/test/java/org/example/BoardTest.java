package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    private Board board;

    @BeforeEach
    void setUp() {
        board = new Board();
    }

    @Test
    void testInitialBoardState() {
        for (int row = 0; row < board.getRowsBoard(); row++) {
            for (int col = 0; col < board.getColsBoard(); col++) {
                assertNull(board.getCell(row, col), "All cells should be initially null");
            }
        }
    }

    @Test
    void testSetAndGetCell() {
        board.setCell(0, 0, 'X');
        assertEquals('X', board.getCell(0, 0), "Cell (0, 0) should contain 'X'");

        board.setCell(1, 1, 'O');
        assertEquals('O', board.getCell(1, 1), "Cell (1, 1) should contain 'O'");
    }

    @Test
    void testGetEmptyCells() {
        assertEquals(9, board.getEmptyCells(), "Initial board should have 9 empty cells");

        board.setCell(0, 0, 'X');
        assertEquals(8, board.getEmptyCells(), "After setting one cell, there should be 8 empty cells");

        board.setCell(1, 1, 'O');
        assertEquals(7, board.getEmptyCells(), "After setting two cells, there should be 7 empty cells");
    }

    @Test
    void testPrintBoard() {
        board.setCell(0, 0, 'X');
        board.setCell(1, 1, 'O');
        board.setCell(2, 2, 'X');

        board.printBoard();
    }

    @Test
    void testRowsAndColsConstants() {
        assertEquals(3, board.getRowsBoard(), "The number of rows should be 3");
        assertEquals(3, board.getColsBoard(), "The number of columns should be 3");
    }
}
