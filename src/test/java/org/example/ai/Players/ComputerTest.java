package org.example.ai.Players;

import org.example.Game;
import org.example.Interfaces.Difficulty;
import org.example.Interfaces.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ComputerTest {

    @InjectMocks
    Computer computer;

    @Mock
    Difficulty difficulty;

    @Mock
    Game game;

    @BeforeEach
    void setUp() {
        computer = new Computer('X', difficulty);
    }

    @Test
    void computerConstructorTest() {
        assertEquals('X', computer.getSymbol());
        assertEquals(difficulty, computer.getDifficulty());
    }

    @Test
    void playTest() {
        computer.play(game);

        verify(difficulty).move(eq(game), eq(computer));
    }

    @Test
    void getSymbolPlayerTest() {
        Character symbol = computer.getSymbol();
        assertEquals('X', symbol);
    }

    @Test
    void getDifficultyPlayerTest() {
        Difficulty difficultyComputer = computer.getDifficulty();
        assertEquals(difficulty, difficultyComputer);
    }
}
