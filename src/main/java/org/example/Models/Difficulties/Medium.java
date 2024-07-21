package org.example.Models.Difficulties;

import org.example.Board;
import org.example.Game;
import org.example.Interfaces.Difficulty;
import org.example.Interfaces.Player;
import org.example.Models.Enums.Difficulties;

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

    /**
     * @param winOrBlock -> {1 : winGame, 2: BlockOpponent}
     */
    private static boolean mediumMove(Board board, char move, int winOrBlock){
        char fillSpace = move;
        if(winOrBlock == 2){
            fillSpace = fillSpace == 'X' ? 'O' : 'X';
        }
        for(int idx = 0; idx < board.getRowsBoard(); idx++){
            String currentIdx = String.valueOf(idx);
            //Horizontal
            if(mediumGameMove(board, new String[]{currentIdx.concat(",0"), currentIdx.concat(",1")
                    , currentIdx.concat(",2") }, move, fillSpace)){
                return true;
                // Vertical
            } else if(mediumGameMove(board, new String[]{"0,".concat(currentIdx), "1,".concat(currentIdx)
                    , "2,".concat(currentIdx) }, move, fillSpace)){
                return true;
            }
        }

        if(mediumGameMove(board, new String[]{"0,0", "1,1", "2,2"}, move, fillSpace)){
            return true;
        }else
            return mediumGameMove(board, new String[]{"0,2", "1,1", "2,0"}, move, fillSpace);
    }

    /**
     *     // Terminal states : 3 in a row of move parameter || No more empty cells
     *     // Points : Player playing wins = 1 (Max score), Opponent wins = -1(Min score), Tie : 0
     *     // If the player moving can not win, he rather tie than let his opponent win
     * @param board
     * @param positions
     * @param move
     * @param fillSpaceMove
     * @return whether if the cell was filled or not
     */
    private static boolean mediumGameMove(Board board, String[] positions, Character move, char fillSpaceMove){
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
