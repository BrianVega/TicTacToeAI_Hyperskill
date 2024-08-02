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
class UserTest {

    @InjectMocks
    User user;

    @Mock
    Difficulty difficulty;

    @Mock
    Game game;

    @BeforeEach
    void setUp() {
        user = new User('X', difficulty);
    }

    @Test
    void computerConstructorTest() {
        assertEquals('X', user.getSymbol());
        assertEquals(difficulty, user.getDifficulty());
    }

    @Test
    void playTest() {
        user.play(game);

        verify(difficulty).move(eq(game), eq(user));
    }
}