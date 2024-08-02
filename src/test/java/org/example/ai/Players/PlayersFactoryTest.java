package org.example.ai.Players;

import org.example.Interfaces.Difficulty;
import org.example.Interfaces.Player;
import org.example.ai.Difficulties.Easy;
import org.example.ai.Enums.Players;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PlayersFactoryTest {

    @InjectMocks
    PlayersFactory playersFactory;

    @Mock
    Difficulty difficulty;

    @BeforeEach
    void setUp() {
        difficulty = new Easy();
    }

    @Test
    void createPlayerUser() {
        Player player = playersFactory.createPlayer(Players.USER, difficulty, 'X');

        assertTrue(player instanceof User, "Player should be an instance of User");

        User createdUser = (User) player;
        assertEquals('X', createdUser.getSymbol());
        assertEquals(difficulty, createdUser.getDifficulty());
    }

    @Test
    void createPlayerComputer() {
        Player player = playersFactory.createPlayer(Players.COMPUTER, difficulty, 'X');

        assertTrue(player instanceof Computer, "Player should be an instance of Computer");

        Computer createdComputer = (Computer) player;
        assertEquals('X', createdComputer.getSymbol());
        assertEquals(difficulty, createdComputer.getDifficulty());
    }
}
