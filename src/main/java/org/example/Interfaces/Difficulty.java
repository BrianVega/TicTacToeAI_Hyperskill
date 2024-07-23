package org.example.Interfaces;

import org.example.Game;
import org.example.ai.Enums.Difficulties;

public interface Difficulty {

    Difficulties getLevel();
    void move(Game game, Player player);

}
