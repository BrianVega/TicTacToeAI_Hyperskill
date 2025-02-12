package org.example.ai.Difficulties;

import org.example.Interfaces.Difficulty;
import org.example.ai.Enums.Difficulties;

public class DifficultyFactory {

    public Difficulty setDifficulty(Difficulties difficulty) {
        return switch (difficulty) {
            case EASY -> new Easy();
            case MEDIUM -> new Medium();
            case HARD -> new Hard();
            case INPUT -> new Input();
        };
    }

}
