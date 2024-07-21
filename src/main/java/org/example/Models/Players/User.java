package org.example.Models.Players;

import org.example.Game;
import org.example.Interfaces.Difficulty;
import org.example.Interfaces.Player;

public class User extends Player {

    public User(Character symbol, Difficulty difficulty) {
         super(symbol, difficulty);
    }

    @Override
    public void play(Game game) {
        getDifficulty().move(game, this);
    }


}
