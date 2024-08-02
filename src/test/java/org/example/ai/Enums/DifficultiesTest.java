package org.example.ai.Enums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DifficultiesTest {

    @Test
    void testEnumValues() {
        assertNotNull(Difficulties.EASY);
        assertNotNull(Difficulties.MEDIUM);
        assertNotNull(Difficulties.HARD);
        assertNotNull(Difficulties.INPUT);
    }

    @Test
    void testEnumValueOf() {
        assertEquals(Difficulties.EASY, Difficulties.valueOf("EASY"));
        assertEquals(Difficulties.MEDIUM, Difficulties.valueOf("MEDIUM"));
        assertEquals(Difficulties.HARD, Difficulties.valueOf("HARD"));
        assertEquals(Difficulties.INPUT, Difficulties.valueOf("INPUT"));
    }
}