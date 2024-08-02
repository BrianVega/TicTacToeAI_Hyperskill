package org.example.ai.Difficulties;

import org.example.Board;
import org.example.Game;
import org.example.Interfaces.Difficulty;
import org.example.Interfaces.Player;
import org.example.ai.Enums.Difficulties;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.lenient;

@ExtendWith(MockitoExtension.class)
class InputTest {

    @InjectMocks
    Input input;

    @Mock
    Game game;

    @Mock
    Player player;

    @Mock
    Board board;

    @BeforeEach
    void setUp() {
        lenient().when(game.getBoard()).thenReturn(board);
        lenient().when(player.getSymbol()).thenReturn('X');
    }

    @Test
    void getLevel() {
        Difficulties difficultyLevel = Difficulties.INPUT;

        assertThat(difficultyLevel).isEqualTo(Difficulties.INPUT);
    }

    @Test
    void move() {
        String userInput = "1 1\n";
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));

        input.SCANNER = new Scanner(System.in);

        given(board.getCell(anyInt(), anyInt()))
                .willReturn(null);

        input.move(game, player);

        then(board).should().setCell(0, 0 , 'X');

    }
}