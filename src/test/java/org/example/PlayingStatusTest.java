package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)

class PlayingStatusTest {

    @InjectMocks
    PlayingStatus playingStatus;

    @BeforeEach
    void setUp() {
        playingStatus.setStatus("X Wins");
        playingStatus.setStillPlaying(false);
    }

    @Test
    void getStillPlaying() {
        assertThat(playingStatus.getStillPlaying()).isFalse();
    }

    @Test
    void setStillPlaying() {
        playingStatus.setStillPlaying(true);
        assertThat(playingStatus.getStillPlaying()).isTrue();
    }

    @Test
    void getStatus() {
        assertEquals(playingStatus.getStatus(), "X Wins");
    }

    @Test
    void setStatus() {
        playingStatus.setStatus("X wins");
        assertEquals("X wins", playingStatus.getStatus());
    }
}