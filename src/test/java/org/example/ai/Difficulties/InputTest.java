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

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        lenient().when(game.getBoard()).thenReturn(board);
        lenient().when(player.getSymbol()).thenReturn('X');
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    private void setInput(String userInput) {
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));
        input.SCANNER = new Scanner(System.in);
    }

    private String getOutput() {
        return outputStreamCaptor.toString().trim();
    }

    @Test
    void getLevel() {
        Difficulties difficultyLevel = input.getLevel();

        assertThat(difficultyLevel).isEqualTo(Difficulties.INPUT);
    }

    @Test
    void moveCorrectInput() {
        setInput("1 1\n");

        given(board.getCell(anyInt(), anyInt())).willReturn(null);

        input.move(game, player);

        then(board).should().setCell(0, 0, 'X');
    }

    @Test
    void moveNotNumbers() {
        setInput("a\n1 1\n");

        given(board.getCell(anyInt(), anyInt())).willReturn(null);

        input.move(game, player);

        assertThat(getOutput()).contains("You should enter numbers!");
    }

    @Test
    void moveInvalidCoordinates() {
        setInput("0 0\n1 1\n");

        given(board.getCell(anyInt(), anyInt())).willReturn(null);

        input.move(game, player);

        assertThat(getOutput()).contains("Coordinates should be from 1 to 3!");
    }

    @Test
    void moveOccupiedCell() {
        setInput("1 1\n2 2\n");

        lenient().when(board.getCell(0, 0)).thenReturn('X');
        lenient().when(board.getCell(1, 1)).thenReturn(null);

        input.move(game, player);

        assertThat(getOutput()).contains("This cell is occupied! Choose another one!");
    }
}
