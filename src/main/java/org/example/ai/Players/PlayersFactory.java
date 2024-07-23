package org.example.ai.Players;

import org.example.Interfaces.Difficulty;
import org.example.Interfaces.Player;
import org.example.ai.Enums.Players;

public class PlayersFactory {

    public Player createPlayer(Players type, Difficulty difficulty, Character symbol) {
        return switch (type) {
            case USER -> new User(symbol, difficulty);
            case COMPUTER -> new Computer(symbol, difficulty);
        };
    }
}
