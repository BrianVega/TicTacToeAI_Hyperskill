package org.example;

import org.example.ai.Enums.Difficulties;
import org.example.ai.Enums.Players;

public class Utils {

    static Difficulties getDifficultyFrom(String difficulty) {
        if(difficulty.equalsIgnoreCase(Difficulties.EASY.name())){
            return Difficulties.EASY;
        } else if(difficulty.equalsIgnoreCase(Difficulties.MEDIUM.name())){
            return Difficulties.MEDIUM;
        } else if(difficulty.equalsIgnoreCase(Difficulties.HARD.name())){
            return Difficulties.HARD;
        } else if (difficulty.equalsIgnoreCase(Players.USER.name())){
            return Difficulties.INPUT;
        } else {
            return null;
        }
    }

    static Players getPlayerFrom(String player){
        if(player.equalsIgnoreCase(Difficulties.EASY.name())
                || player.equalsIgnoreCase(Difficulties.MEDIUM.name())
                || player.equalsIgnoreCase(Difficulties.HARD.name())) {
            return Players.COMPUTER;
        } else if (player.equalsIgnoreCase(Players.USER.name())) {
            return Players.USER;
        } else {
            return null;
        }
    }
}
