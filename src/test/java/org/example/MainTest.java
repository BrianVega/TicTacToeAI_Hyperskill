package org.example;

import org.example.Interfaces.Player;
import org.example.ai.Difficulties.DifficultyFactory;
import org.example.ai.Enums.Difficulties;
import org.example.ai.Enums.Players;
import org.example.ai.Players.PlayersFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class MainTest {

    @Mock
    PlayersFactory playersFactory;

    @Mock
    DifficultyFactory difficultyFactory;

    @Mock
    Game game;

    @Mock
    Player player1;

    @Mock
    Player player2;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testStarterWithValidParameters() {
        String input = "start easy user\nexit\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Main.main(new String[]{});

        String output = out.toString();
        assertTrue(output.contains("Making move level \"easy\""));

        System.setIn(System.in);
        System.setOut(System.out);
    }

    @Test
    void testStarterWithInvalidParameters() {
        String input = "start invalid user\nexit\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Main.main(new String[]{});

        String output = out.toString();
        assertTrue(output.contains("Bad parameters!"));
    }

    @Test
    void testExitCommand() {
        String input = "exit\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Main.main(new String[]{});

        String output = out.toString();
        assertTrue(output.trim().isEmpty());
    }
}
