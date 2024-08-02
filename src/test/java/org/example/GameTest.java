package org.example;

import org.example.Interfaces.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class GameTest {

    @InjectMocks
    Game game;

    @Mock
    Board board;

    @Mock
    Player player1;

    @Mock
    Player player2;

    @Mock
    PlayingStatus playingStatus;

    @BeforeEach
    void setUp() {
        board = new Board();
        game = new Game(board, player1, player2);
        playingStatus.setStillPlaying(false);
    }

    @Test
    void testGetBoard() {
        assertEquals(board, game.getBoard());
    }


    @Test
    void testGameResult_Player1WinsHorizontally() {
        board.setCell(0, 0, 'X');
        board.setCell(0, 1, 'X');
        board.setCell(0, 2, 'X');

        PlayingStatus result = game.gameResult();

        assertFalse(result.getStillPlaying(), "Game should be finished");
        assertEquals("X wins", result.getStatus(), "Player 1 should win horizontally");
    }

    @Test
    void testGameResult_Player1WinsVertically() {
        board.setCell(0, 0, 'X');
        board.setCell(1, 0, 'X');
        board.setCell(2, 0, 'X');

        PlayingStatus result = game.gameResult();

        assertFalse(result.getStillPlaying(), "Game should be finished");
        assertEquals("X wins", result.getStatus(), "Player 1 should win Vertically");
    }

    @Test
    void testGameResult_Player1WinsDiagonally1() {
        board.setCell(0, 0, 'X');
        board.setCell(1, 1, 'X');
        board.setCell(2, 2, 'X');

        PlayingStatus result = game.gameResult();

        assertFalse(result.getStillPlaying(), "Game should be finished");
        assertEquals("X wins", result.getStatus(), "Player 1 should win Diagonally");
    }

    @Test
    void testGameResult_Player1WinsDiagonally2() {
        board.setCell(0, 2, 'X');
        board.setCell(1, 1, 'X');
        board.setCell(2, 0, 'X');

        PlayingStatus result = game.gameResult();

        assertFalse(result.getStillPlaying(), "Game should be finished");
        assertEquals("X wins", result.getStatus(), "Player 1 should win Diagonally");
    }

    @Test
    void testGameResult_Draw() {
        board.setCell(0, 0, 'X');
        board.setCell(0, 1, 'O');
        board.setCell(0, 2, 'X');
        board.setCell(1, 0, 'X');
        board.setCell(1, 1, 'O');
        board.setCell(1, 2, 'X');
        board.setCell(2, 0, 'O');
        board.setCell(2, 1, 'X');
        board.setCell(2, 2, 'O');

        PlayingStatus result = game.gameResult();

        assertFalse(result.getStillPlaying(), "Game should be finished");
        assertEquals("Draw", result.getStatus(), "Game should end in a draw");
    }

    @Test
    void testGameResult_GameNotFinished() {
        board.setCell(0, 0, 'X');
        board.setCell(0, 1, 'O');

        PlayingStatus result = game.gameResult();

        assertTrue(result.getStillPlaying(), "Game should not be finished");
        assertEquals("Game not finished", result.getStatus(), "Game should not be finished yet");
    }

    @Test
    void testCheckLine() {
        assertTrue(game.checkLine('X', 'X', 'X'), "Should return true for three equal non-null characters");
        assertFalse(game.checkLine('X', 'O', 'X'), "Should return false for different characters");
        assertFalse(game.checkLine('X', null, 'X'), "Should return false if any character is null");
    }

    @Test
    void testPrintWinner() {
        String result = game.printWinner('X');
        assertEquals("X wins", result, "Should return the correct winner string");
    }
}
