package org.example;

import org.example.ai.Enums.Difficulties;
import org.example.ai.Enums.Players;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {

    @InjectMocks
    Utils utils;

    @Test
    void testInstance() {
        utils = new Utils();
        assertThat(utils).isNotNull();
    }

    @Test
    void testGetDifficultyFrom() {
        assertEquals(Difficulties.EASY, Utils.getDifficultyFrom("easy"));
        assertEquals(Difficulties.MEDIUM, Utils.getDifficultyFrom("medium"));
        assertEquals(Difficulties.HARD, Utils.getDifficultyFrom("hard"));
        assertEquals(Difficulties.INPUT, Utils.getDifficultyFrom("user"));
        assertNull(Utils.getDifficultyFrom("invalid"));
    }

    @Test
    void testGetPlayerFrom() {
        assertEquals(Players.COMPUTER, Utils.getPlayerFrom("easy"));
        assertEquals(Players.COMPUTER, Utils.getPlayerFrom("medium"));
        assertEquals(Players.COMPUTER, Utils.getPlayerFrom("hard"));
        assertEquals(Players.USER, Utils.getPlayerFrom("user"));
        assertNull(Utils.getPlayerFrom("invalid"));
    }
}
