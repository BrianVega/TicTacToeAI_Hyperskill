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
    Player playerX;

    @Mock
    Player playerO;

    @Mock
    Board board;

    @BeforeEach
    void setUp() {
        lenient().when(game.getBoard()).thenReturn(board);
        lenient().when(playerX.getSymbol()).thenReturn('X');
        lenient().when(playerO.getSymbol()).thenReturn('O');
    }

    @Test
    void getLevel() {
        Difficulties difficultyLevel = Difficulties.MEDIUM;
        assertThat(difficultyLevel).isEqualTo(medium.getLevel());
    }

    @DisplayName("Test Medium class move method to win the game vertically")
    @Test
    void testMoveToWinXHorizontally() {
        setupBoardForWinningXMoveHorizontally();

        medium.move(game, playerX);

        verify(board).setCell(anyInt(), anyInt(), anyChar());
    }

    @DisplayName("Test Medium class move method to win the game horizontally")
    @Test
    void testMoveToWinXVertically() {
        setupBoardForWinningXMoveVertically();

        medium.move(game, playerX);

        verify(board).setCell(anyInt(), anyInt(), anyChar());
    }

    @DisplayName("Test Medium class move method to win the game vertically")
    @Test
    void testMoveToWinOHorizontally() {
        setupBoardForWinningOMoveHorizontally();

        medium.move(game, playerO);

        verify(board).setCell(anyInt(), anyInt(), anyChar());
    }

    @DisplayName("Test Medium class move method to win the game horizontally")
    @Test
    void testMoveToWinOVertically() {
        setupBoardForWinningOMoveVertically();

        medium.move(game, playerO);

        verify(board).setCell(anyInt(), anyInt(), anyChar());
    }

    @DisplayName("Test Medium class move method to block opponent")
    @Test
    void testMoveToBlockOVertically() {
        setupBoardForBlockingMoveOVertically();

        medium.move(game, playerX);

        verify(board).setCell(anyInt(), anyInt(), anyChar());
    }

    @DisplayName("Test Medium class move method to block opponent")
    @Test
    void testMoveToBlockOHorizontally() {
        setupBoardForBlockingMoveOHorizontally();

        medium.move(game, playerX);

        verify(board).setCell(anyInt(), anyInt(), anyChar());
    }

    @DisplayName("Test Medium class move method to block opponent")
    @Test
    void testMoveToBlockXVertically() {
        setupBoardForBlockingMoveXVertically();

        medium.move(game, playerO);

        verify(board).setCell(anyInt(), anyInt(), anyChar());
    }

    @DisplayName("Test Medium class move method to block opponent")
    @Test
    void testMoveToBlockXHorizontally() {
        setupBoardForBlockingMoveXHorizontally();

        medium.move(game, playerO);

        verify(board).setCell(anyInt(), anyInt(), anyChar());
    }

    @DisplayName("Test Medium class move method fallback to Easy class move")
    @Test
    void testMoveFallbackToEasy() {
        setupBoardForFallback();

        medium.move(game, playerX);

        verify(board).setCell(anyInt(), anyInt(), anyChar());
    }

    // Winning setup
    private void setupBoardForWinningXMoveHorizontally() {
        lenient().when(board.getCell(0, 0)).thenReturn('X');
        lenient().when(board.getCell(0, 1)).thenReturn('X');
        lenient().when(board.getCell(0, 2)).thenReturn(null);
        lenient().when(board.getRowsBoard()).thenReturn(3);
        lenient().when(board.getColsBoard()).thenReturn(3);
    }

    // Winning setup
    private void setupBoardForWinningXMoveVertically() {
        lenient().when(board.getCell(0, 0)).thenReturn('X');
        lenient().when(board.getCell(1, 0)).thenReturn('X');
        lenient().when(board.getCell(2, 0)).thenReturn(null);
        lenient().when(board.getRowsBoard()).thenReturn(3);
        lenient().when(board.getColsBoard()).thenReturn(3);
    }

    // Winning setup
    private void setupBoardForWinningOMoveHorizontally() {
        lenient().when(board.getCell(0, 0)).thenReturn('O');
        lenient().when(board.getCell(0, 1)).thenReturn('O');
        lenient().when(board.getCell(0, 2)).thenReturn(null);
        lenient().when(board.getRowsBoard()).thenReturn(3);
        lenient().when(board.getColsBoard()).thenReturn(3);
    }

    // Winning setup
    private void setupBoardForWinningOMoveVertically() {
        lenient().when(board.getCell(0, 0)).thenReturn('O');
        lenient().when(board.getCell(1, 0)).thenReturn('O');
        lenient().when(board.getCell(2, 0)).thenReturn(null);
        lenient().when(board.getRowsBoard()).thenReturn(3);
        lenient().when(board.getColsBoard()).thenReturn(3);
    }

    // Blocking opportunity
    private void setupBoardForBlockingMoveOVertically() {
        lenient().when(board.getCell(0, 0)).thenReturn('O');
        lenient().when(board.getCell(0, 1)).thenReturn('O');
        lenient().when(board.getCell(0, 2)).thenReturn(null);
        lenient().when(board.getRowsBoard()).thenReturn(3);
        lenient().when(board.getColsBoard()).thenReturn(3);
    }

    // Blocking opportunity
    private void setupBoardForBlockingMoveOHorizontally() {
        lenient().when(board.getCell(0, 0)).thenReturn('O');
        lenient().when(board.getCell(1, 0)).thenReturn('O');
        lenient().when(board.getCell(2, 0)).thenReturn(null);
        lenient().when(board.getRowsBoard()).thenReturn(3);
        lenient().when(board.getColsBoard()).thenReturn(3);
    }

    private void setupBoardForBlockingMoveXVertically() {
        lenient().when(board.getCell(0, 0)).thenReturn('X');
        lenient().when(board.getCell(0, 1)).thenReturn('X');
        lenient().when(board.getCell(0, 2)).thenReturn(null);
        lenient().when(board.getRowsBoard()).thenReturn(3);
        lenient().when(board.getColsBoard()).thenReturn(3);
    }

    // Blocking opportunity
    private void setupBoardForBlockingMoveXHorizontally() {
        lenient().when(board.getCell(0, 0)).thenReturn('X');
        lenient().when(board.getCell(1, 0)).thenReturn('X');
        lenient().when(board.getCell(2, 0)).thenReturn(null);
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
