package org.example.Interfaces;

import org.example.Game;
import org.example.Models.Enums.Difficulties;

public interface Difficulty {

    Difficulties getLevel();
    void move(Game game, Player player);

}
