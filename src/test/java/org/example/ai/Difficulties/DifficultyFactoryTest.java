package org.example.ai.Difficulties;

import org.example.Interfaces.Difficulty;
import org.example.ai.Enums.Difficulties;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class DifficultyFactoryTest {

    @InjectMocks
    DifficultyFactory difficultyFactory;

    @Test
    void setDifficultyEasyTest() {
        Difficulty actualEasy
                = difficultyFactory.setDifficulty(Difficulties.EASY);

        assertThat(actualEasy)
                .isInstanceOf(Easy.class);
    }

    @Test
    void setDifficultyMediumTest() {
        Difficulty actualMedium
                = difficultyFactory.setDifficulty(Difficulties.MEDIUM);

        assertThat(actualMedium)
                .isInstanceOf(Medium.class);
    }

    @Test
    void setDifficultyHardTest() {
        Difficulty actualHard
                = difficultyFactory.setDifficulty(Difficulties.HARD);

        assertThat(actualHard)
                .isInstanceOf(Hard.class);
    }

    @Test
    void setDifficultyInputTest() {
        Difficulty actualInput
                = difficultyFactory.setDifficulty(Difficulties.INPUT);

        assertThat(actualInput)
                .isInstanceOf(Input.class);
    }
}