package org.example;

import org.example.Interfaces.Player;
import org.example.ai.Difficulties.Easy;
import org.example.ai.Enums.Difficulties;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

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

    @BeforeEach
    void setUp() {
        board = new Board();
        player1 = mock(Player.class);
        player2 = mock(Player.class);
        game = new Game(board, player1, player2);

        lenient().when(player1.getDifficulty()).thenReturn(new Easy());
        lenient().when(player2.getDifficulty()).thenReturn(new Easy());
    }

    @Test
    void testGameStarts() {
        // Configurar el comportamiento de los jugadores
        doAnswer(invocation -> {
            board.setCell(0, 0, 'X');
            return null;
        }).when(player1).play(any(Game.class));

        doAnswer(invocation -> {
            board.setCell(1, 1, 'O');
            return null;
        }).when(player2).play(any(Game.class));

        // Simular el resultado del juego
        PlayingStatus stillPlayingStatus = new PlayingStatus();
        stillPlayingStatus.setStillPlaying(true);
        stillPlayingStatus.setStatus("Game not finished");

        PlayingStatus finishedStatus = new PlayingStatus();
        finishedStatus.setStillPlaying(false);
        finishedStatus.setStatus("X wins");

        when(game.gameResult())
                .thenReturn(stillPlayingStatus) // Primeras llamadas, el juego aún no termina
                .thenReturn(stillPlayingStatus)
                .thenReturn(finishedStatus);   // Finalmente, el juego termina

        // Simular el comportamiento del tablero
        when(board.getCell(0, 0)).thenReturn('X');
        when(board.getCell(1, 1)).thenReturn('O');

        // Ejecutar el método gameStarts
        game.gameStarts();

        // Verificar que el método play de ambos jugadores fue llamado
        verify(player1, atLeastOnce()).play(any(Game.class));
        verify(player2, atLeastOnce()).play(any(Game.class));
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
