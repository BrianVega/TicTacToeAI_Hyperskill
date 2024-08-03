package org.example.ai.Difficulties;

import org.example.Board;
import org.example.Game;
import org.example.Interfaces.Difficulty;
import org.example.Interfaces.Player;
import org.example.Main;
import org.example.ai.Enums.Difficulties;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
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
        Difficulties difficultyLevel = input.getLevel();

        assertThat(difficultyLevel).isEqualTo(Difficulties.INPUT);
    }

    @Test
    void moveCorrectInput() {
        String userInput = "1 1\n";
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));

        input.SCANNER = new Scanner(System.in);

        given(board.getCell(anyInt(), anyInt()))
                .willReturn(null);

        input.move(game, player);

        then(board).should().setCell(0, 0 , 'X');
    }

    @Test
    void moveNotNumbers() {
        final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        String userInput = "a\n1 1\n";
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));
        given(board.getCell(anyInt(), anyInt()))
                .willReturn(null);

        input.SCANNER = new Scanner(System.in);

        input.move(game, player);

        System.setOut(new PrintStream(outputStreamCaptor));

        String output = outputStreamCaptor.toString().trim();
        assertThat(output).contains("You should enter numbers!");
    }

    @Test
    void moveInvalidCoordinates() {
        final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        String userInput = "0 0\n1 1\n";
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));
        given(board.getCell(anyInt(), anyInt()))
                .willReturn(null);

        input.SCANNER = new Scanner(System.in);

        input.move(game, player);

        System.setOut(new PrintStream(outputStreamCaptor));

        String output = outputStreamCaptor.toString().trim();
        assertThat(output).contains("Coordinates should be from 1 to 3!");
    }

    @Test
    void moveOcuppiedCell() {
        final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        String userInput = "1 1\n2 2\n";
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));
        given(board.getCell(1, 1))
                .willReturn('X');
        given(board.getCell(2, 2))
                .willReturn(null);

        input.SCANNER = new Scanner(System.in);

        input.move(game, player);

        System.setOut(new PrintStream(outputStreamCaptor));

        String output = outputStreamCaptor.toString().trim();
        assertThat(output).contains("This cell is occupied! Choose another one!");
    }
}