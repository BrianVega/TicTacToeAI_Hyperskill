package org.example;

import org.example.Interfaces.Player;
import org.example.ai.Enums.Difficulties;

public class Game {
    private Board board;
    private Player player1;
    private Player player2;

    private static final String GAME_NOT_FINISHED_STATUS = "Game not finished";
    private static final String DRAW_STATUS = "Draw";

    Game(Board board, Player player1, Player player2) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
    }

    public void gameStarts(){

        PlayingStatus currentGameStatus;
        Player currentPlayer;
        int currentPlayerIndex = 1;


        board.printBoard();

        do {
            currentPlayer = currentPlayerIndex % 2 != 0 ? player1 : player2;

            Difficulties currentDifficulty = currentPlayer.getDifficulty().getLevel();
            switch (currentDifficulty) {
                case EASY:
                    System.out.println("Making move level \"easy\"");
                    break;
                case MEDIUM:
                    System.out.println("Making move level \"medium\"");
                    break;
                case HARD:
                    System.out.println("Making move level \"hard\"");
                    break;
                default:
                    break;
            }

            currentPlayer.play(this);
            board.printBoard();
            currentGameStatus = gameResult();
            currentPlayerIndex += 1;


        } while(currentGameStatus.getStillPlaying());
        System.out.println(currentGameStatus.getStatus());
    }

    public PlayingStatus gameResult() {
        PlayingStatus status = new PlayingStatus();
        status.setStillPlaying(false);

        boolean hasEmptyCells = false;
        for (int idx = 0; idx < board.getRowsBoard(); idx++) {
            // Horizontal check
            if (checkLine(board.getCell(idx, 0), board.getCell(idx, 1), board.getCell(idx,2))) {
                status.setStatus(printWinner(board.getCell(idx, 0)));
                return status;

                // Vertical check
            } else if (checkLine(board.getCell(0, idx), board.getCell(1, idx), board.getCell(2, idx))) {
                status.setStatus(printWinner(board.getCell(0, idx)));
                return status;
            }
        }
        if(checkLine(board.getCell(0, 0), board.getCell(1, 1), board.getCell(2, 2))){
            status.setStatus(printWinner(board.getCell(0, 0)));
            return status;
        }else if(checkLine(board.getCell(0, 2), board.getCell(1, 1), board.getCell(2, 0))){
            status.setStatus(printWinner(board.getCell(0, 2)));
            return status;
        }

        hasEmptyCells = board.getEmptyCells() > 0;
        if (hasEmptyCells) {
            status.setStillPlaying(true);
            status.setStatus(GAME_NOT_FINISHED_STATUS);
        } else {
            status.setStatus(DRAW_STATUS);
        }
        return status;
    }

    private boolean checkLine(Character a, Character b, Character c) {
        return a != null && a.equals(b) && a.equals(c);
    }

    public Board getBoard() {
        return board;
    }

    private String printWinner(char winner){
        return winner + " wins";
    }

}
