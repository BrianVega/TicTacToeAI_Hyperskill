package org.example.ai.Difficulties;

import org.example.Board;
import org.example.Game;
import org.example.Interfaces.Player;
import org.example.ai.Enums.Difficulties;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyChar;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MediumTest {

    @InjectMocks
    Medium medium;

    @Mock
    Game game;

    @Mock
    Player player;

    @Mock
    Board board;

    @Mock
    Easy easy;

    @BeforeEach
    void setUp() {
        lenient().when(game.getBoard()).thenReturn(board);
        lenient().when(player.getSymbol()).thenReturn('X');
    }

    @Test
    void getLevel() {
        Difficulties difficultyLevel = Difficulties.MEDIUM;
        assertThat(difficultyLevel).isEqualTo(medium.getLevel());
    }

    @DisplayName("Test Medium class move method to win the game")
    @Test
    void testMoveToWin() {
        setupBoardForWinningMove();

        medium.move(game, player);

        verify(board).setCell(anyInt(), anyInt(), anyChar());
    }

    @DisplayName("Test Medium class move method to block opponent")
    @Test
    void testMoveToBlock() {
        setupBoardForBlockingMove();

        medium.move(game, player);

        verify(board).setCell(anyInt(), anyInt(), anyChar());
    }

    @DisplayName("Test Medium class move method fallback to Easy class move")
    @Test
    void testMoveFallbackToEasy() {
        setupBoardForFallback();

        medium.move(game, player);

        verify(board).setCell(anyInt(), anyInt(), anyChar());
    }

    // Winning setup
    private void setupBoardForWinningMove() {
        lenient().when(board.getCell(0, 0)).thenReturn('X');
        lenient().when(board.getCell(0, 1)).thenReturn('X');
        lenient().when(board.getCell(0, 2)).thenReturn(null);
        lenient().when(board.getRowsBoard()).thenReturn(3);
        lenient().when(board.getColsBoard()).thenReturn(3);
    }

    // Blocking opportunity
    private void setupBoardForBlockingMove() {
        lenient().when(board.getCell(0, 0)).thenReturn('O');
        lenient().when(board.getCell(0, 1)).thenReturn('O');
        lenient().when(board.getCell(0, 2)).thenReturn(null);
        lenient().when(board.getRowsBoard()).thenReturn(3);
        lenient().when(board.getColsBoard()).thenReturn(3);
    }

    // makeEasy
    private void setupBoardForFallback() {
        lenient().when(board.getCell(anyInt(), anyInt())).thenReturn(null);
        lenient().when(board.getRowsBoard()).thenReturn(3);
        lenient().when(board.getColsBoard()).thenReturn(3);
    }
}
