package org.example.ai.Difficulties;

import org.example.Board;
import org.example.Game;
import org.example.Interfaces.Player;
import org.example.ai.Enums.Difficulties;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
class EasyTest {

    @InjectMocks
    Easy easy;

    @Mock
    Game game;

    @Mock
    Player player;

    @Mock
    Board board;

    @BeforeEach
    void setUp() {
        lenient().when(board.getRowsBoard()).thenReturn(3);
        lenient().when(board.getColsBoard()).thenReturn(3);

        lenient().when(game.getBoard()).thenReturn(board);

        lenient().when(player.getSymbol()).thenReturn('X');
    }

    @Test
    void getLevel() {
        Difficulties difficultyLevel = easy.getLevel();

        assertThat(difficultyLevel).isEqualTo(Difficulties.EASY);
    }

    @Test
    void move() {
        given(board.getCell(anyInt(), anyInt()))
                .willReturn(null);

        easy.move(game, player);

        then(board).should(times(1))
                .setCell(anyInt(), anyInt(), eq('X'));
    }
}