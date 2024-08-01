package org.example.ai.Difficulties;

import org.example.Board;
import org.example.Game;
import org.example.Interfaces.Difficulty;
import org.example.Interfaces.Player;
import org.example.ai.Enums.Difficulties;

public class Medium implements Difficulty {
    private final Difficulties level = Difficulties.MEDIUM;

    @Override
    public Difficulties getLevel() {
        return level;
    }

    @Override
    public void move(Game game, Player player) {
        Board board = game.getBoard();
        // Win game
        if(mediumMove(board, player.getSymbol(), 1)){
            return;
        }
        // Block opponent
        if (mediumMove(board, player.getSymbol() == 'X' ? 'O' : 'X', 2)){
            return;
        }

        // Can't win or block, then random move
        Easy easy = new Easy();
        easy.move(game, player);

    }

    private static boolean mediumMove(Board board, char move, int winOrBlock){
        char fillSpace = move;
        if(winOrBlock == 2){
            fillSpace = fillSpace == 'X' ? 'O' : 'X';
        }
        for(int idx = 0; idx < board.getRowsBoard(); idx++){
            //Horizontal
            if(mediumGameMove(board, move, fillSpace)){
                return true;
                // Vertical
            } else if(mediumGameMove(board, move, fillSpace)){
                return true;
            }
        }

        if(mediumGameMove(board, move, fillSpace)){
            return true;
        }else
            return mediumGameMove(board, move, fillSpace);
    }

    private static boolean mediumGameMove(Board board, Character move, char fillSpaceMove){
        String[] winningLines = {"0,0.0,1.0,2 1,0.1,1.1,2 2,0.2,1.2,2",  // Horizontal
                                 "0,0.1,0.2,0 1,0.1,1.1,2 2,0.2,1.2,2",  // Vertical
                                 "0,0.1,1.2,2 0,2.1,1.2,0 0,2.1,1.2,0"}; // Diagonal
        for (String lines : winningLines) {
            String[] threeInARow = lines.split(" ");
            for (String line : threeInARow) {
                String[] coordinates = line.split("\\.");

                int x1 = Integer.parseInt(coordinates[0].split(",")[0]);
                int y1 = Integer.parseInt(coordinates[0].split(",")[1]);

                int x2 = Integer.parseInt(coordinates[1].split(",")[0]);
                int y2 = Integer.parseInt(coordinates[1].split(",")[1]);

                int x3 = Integer.parseInt(coordinates[2].split(",")[0]);
                int y3 = Integer.parseInt(coordinates[2].split(",")[1]);

                if(board.getCell(x1, y1) == move && board.getCell(x2, y2) == move
                        && board.getCell(x3, y3) == null) {
                    board.setCell(x3, y3, fillSpaceMove);
                    return true;
                }
            }
        }
        return false;
    }
}
