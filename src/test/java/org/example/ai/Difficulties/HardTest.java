package org.example.ai.Difficulties;

import org.example.Board;
import org.example.Game;
import org.example.Interfaces.Player;
import org.example.PlayingStatus;
import org.example.ai.Enums.Difficulties;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

@ExtendWith(MockitoExtension.class)
class HardTest {

    @InjectMocks
    Hard hard;

    @Mock
    Game game;

    @Mock
    Player player;

    @Mock
    Board board;

    @Mock
    Easy easy;

    @Mock
    PlayingStatus playingStatus;

    @BeforeEach
    void setUp() {
        lenient().when(game.getBoard()).thenReturn(board);
        lenient().when(board.getRowsBoard()).thenReturn(3);
        lenient().when(board.getColsBoard()).thenReturn(3);
        lenient().when(board.getCell(anyInt(), anyInt()))
                .thenReturn(null);
        lenient().when(player.getSymbol()).thenReturn('X');
        lenient().when(game.gameResult()).thenReturn(playingStatus);
        lenient().when(playingStatus.getStatus()).thenReturn("X");

    }

    @Test
    void getLevel() {
        Difficulties difficultyLevel = Difficulties.HARD;

        assertThat(difficultyLevel).isEqualTo(Difficulties.HARD);
    }

    @DisplayName("Test move method when board is empty")
    @Test
    void testMoveWhenBoardIsEmpty() {
        given(board.getEmptyCells()).willReturn(9);

        hard.move(game, player);

        then(board).should().setCell(anyInt(), anyInt(), eq('X'));
    }

//    @DisplayName("Test move method when board is not empty")
//    @Test
//    void testMoveWhenBoardIsNotEmpty() {
//        given(board.getEmptyCells()).willReturn(8);
//
//        int[] bestMove = {0, 0};
//        given(hard.getBestMove(game, player)).willReturn(bestMove);
//
//        hard.move(game, player);
//
//        verify(board).setCell(0, 0, 'X');
//    }
//
//    @DisplayName("Test getBestMove method")
//    @Test
//    void testGetBestMove() {
//        given(board.getCell(0, 0)).willReturn(null);
//        given(board.getCell(0, 1)).willReturn(null);
//        given(board.getCell(0, 2)).willReturn(null);
//        given(board.getCell(1, 0)).willReturn(null);
//        given(board.getCell(1, 1)).willReturn(null);
//        given(board.getCell(1, 2)).willReturn(null);
//        given(board.getCell(2, 0)).willReturn(null);
//        given(board.getCell(2, 1)).willReturn(null);
//        given(board.getCell(2, 2)).willReturn(null);
//
//        given(hard.miniMax(game, 12, Integer.MIN_VALUE, Integer.MAX_VALUE, false, 'X')).willReturn(1);
//
//        int[] result = hard.getBestMove(game, player);
//
//        assertEquals(0, result[0]);
//        assertEquals(0, result[1]);
//    }
}
