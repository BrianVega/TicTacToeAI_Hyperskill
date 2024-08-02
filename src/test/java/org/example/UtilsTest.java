package org.example;

import org.example.ai.Enums.Difficulties;
import org.example.ai.Enums.Players;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class UtilsTest {

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
