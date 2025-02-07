package org.example.ai.Players;

import org.example.Game;
import org.example.Interfaces.Difficulty;
import org.example.Interfaces.Player;


public class Computer extends Player {

    public Computer(Character symbol, Difficulty difficulty) {
        super(symbol, difficulty);
    }

    @Override
    public void play(Game game) {
        getDifficulty().move(game, this);
    }
}
