package org.example.ai.Difficulties;

import org.example.Board;
import org.example.Game;
import org.example.Interfaces.Difficulty;
import org.example.Interfaces.Player;
import org.example.ai.Enums.Difficulties;


public class Hard implements Difficulty {
    private final Difficulties level = Difficulties.HARD;
    private static final int MAX_DEPTH = 12;
    private static final int minimizerBestValue = Integer.MAX_VALUE;
    private static final int maximizerBestValue = Integer.MIN_VALUE;
    private static final int MAX_TOTAL_CELLS = 9;

    @Override
    public Difficulties getLevel() {
        return level;
    }

    @Override
    public void move(Game game, Player player) {
        Board board = game.getBoard();
        if(board.getEmptyCells() == MAX_TOTAL_CELLS){
            Easy easy = new Easy();
            easy.move(game, player);
        }else{
            int[] coordinates = getBestMove(game, player); // Player.move
            int row = coordinates[0];
            int col = coordinates[1];
            board.setCell(row, col, player.getSymbol());
        }
    }

    int[] getBestMove(Game game, Player player) {
        Board board = game.getBoard();
        int boardRows = board.getRowsBoard();
        int boardCols = board.getColsBoard();

        int[] bestMove = {-1, -1};
        int currentBestValue = maximizerBestValue;

        for(int row = 0; row < boardRows; row++){
            for(int col = 0; col < boardCols; col++){
                if(board.getCell(row, col) == null){
                    board.setCell(row, col, player.getSymbol());
                    // Evaluate move
                    int moveResult = miniMax(game, MAX_DEPTH, maximizerBestValue, minimizerBestValue, false, player.getSymbol());
                    // Undo move
                    board.setCell(row, col, null);
                    // Evaluate pastMove
                    if(moveResult > currentBestValue){
                        bestMove[0] = row;
                        bestMove[1] = col;
                        currentBestValue = moveResult;
                    }
                }
            }
        }
        return bestMove;
    }

    int miniMax(Game game, int depth, int wantMaximize, int wantMinimize,
                boolean maximizeValue, char currentPlayer){
        Board board = game.getBoard();


        char opponent = currentPlayer == 'X' ? 'O' : 'X';
        if(board.getEmptyCells() == 0){
            int currentStatusGame = evaluateBoard(game, currentPlayer, currentPlayer == 'X' ? 'O' : 'X');
            if(Math.abs(currentStatusGame) > 0 || depth == 0 || board.getEmptyCells() == 0){
                return currentStatusGame;
            }
        }

        if(maximizeValue){
            int highestValue = Integer.MIN_VALUE;
            for(int row = 0; row < board.getRowsBoard(); row++){
                for(int col = 0; col < board.getColsBoard(); col++){
                    if(board.getCell(row, col) == null){
                        // Make move
                        board.setCell(row, col, currentPlayer);
                        // Evaluate move recursively
                        highestValue = Math.max(highestValue,
                                miniMax(game, depth - 1,
                                        wantMaximize, wantMinimize, false, currentPlayer));
                        // Undo move
                        board.setCell(row, col, null);
                        // Evaluate past move
                        wantMaximize = Math.max(wantMaximize, highestValue);
                        if(wantMaximize >= wantMinimize){
                            return highestValue;
                        }
                    }
                }
            }
            return highestValue;
        }else{
            int lowestValue = Integer.MAX_VALUE;
            for(int row = 0; row < board.getRowsBoard(); row++){
                for(int col = 0; col < board.getColsBoard(); col++){

                    if(board.getCell(row, col) == null){
                        board.setCell(row, col, opponent);
                        // Evaluate move recursively
                        lowestValue = Math.min(lowestValue, miniMax(game, depth - 1,
                                wantMaximize, wantMinimize, true, currentPlayer));
                        // Undo move
                        board.setCell(row, col, null);
                        // Evaluate past move
                        wantMinimize = Math.min(wantMinimize, lowestValue);
                        if(wantMinimize <= wantMaximize) { // wantMinimize >= wantMaximize
                            return lowestValue;
                        }
                    }
                }
            }
            return lowestValue;
        }
    }

    private static int evaluateBoard(Game game, char currentPlayer, char currentOpponent){

        String currentBoardValue = game.gameResult().getStatus();
            // X WON
        if(currentBoardValue.startsWith(String.valueOf(currentPlayer))){
            return 1;
            // O WON
        }else if(currentBoardValue.startsWith(String.valueOf(currentOpponent))){
            return -1;
            // TIE
        }else {
            return 0;
        }
    }
}
