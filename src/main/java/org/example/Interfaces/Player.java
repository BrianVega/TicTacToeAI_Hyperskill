package org.example.Interfaces;

import org.example.Game;

public abstract class Player {
    private Character symbol;
    private Difficulty difficulty;

    public Player(Character symbol, Difficulty difficulty) {
        this.symbol = symbol;
        this.difficulty = difficulty;
    }

    public Character getSymbol() {
        return symbol;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public abstract void play(Game game);

}
