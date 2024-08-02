package org.example.ai.Enums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayersTest {

    @Test
    void testEnumValues() {
        assertNotNull(Players.COMPUTER);
        assertNotNull(Players.USER);
    }

    @Test
    void testEnumValueOf() {
        assertEquals(Players.COMPUTER, Players.valueOf("COMPUTER"));
        assertEquals(Players.USER, Players.valueOf("USER"));
    }
}