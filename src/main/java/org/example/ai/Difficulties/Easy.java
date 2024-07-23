package org.example.ai.Difficulties;

import org.example.Board;
import org.example.Game;
import org.example.Interfaces.Difficulty;
import org.example.Interfaces.Player;
import org.example.ai.Enums.Difficulties;

import java.util.Random;

public class Easy implements Difficulty {
    private final Difficulties level = Difficulties.EASY;

    @Override
    public Difficulties getLevel() {
        return level;
    }

    @Override
    public void move(Game game, Player player) {
        Board board = game.getBoard();
        Random random = new Random();
        while(true){
            int row = random.nextInt(board.getRowsBoard());
            int col = random.nextInt(board.getColsBoard());
            if(board.getCell(row, col) == null){
                board.setCell(row, col, player.getSymbol());
                break;
            }
        }
    }
}
