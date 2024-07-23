package org.example.ai.Difficulties;

import org.example.Board;
import org.example.Game;
import org.example.Interfaces.Player;
import org.example.Interfaces.Difficulty;
import org.example.ai.Enums.Difficulties;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Input implements Difficulty {
    private Difficulties level = Difficulties.INPUT;
    final Scanner SCANNER = new Scanner(System.in);
    final static Pattern GAME_INPUT_PATTERN = Pattern.compile("^[0-9]{1}\\s[0-9]{1}$");

    @Override
    public Difficulties getLevel() {
        return level;
    }

    @Override
    public void move(Game game, Player player) {
        Board board = game.getBoard();
        while (true) {
            int row, col;

            System.out.print("Enter the coordinates: ");
            String coordinates = SCANNER.nextLine();

            if (!GAME_INPUT_PATTERN.matcher(coordinates).matches()) {
                System.out.println("You should enter numbers!");
            } else {
                row = Integer.parseInt(coordinates.split(" ")[0]) - 1;
                col = Integer.parseInt(coordinates.split(" ")[1]) - 1;
                if (row < 0 || row > 2 || col < 0 || col > 2) {
                    System.out.println("Coordinates should be farom 1 to 3!");
                    row = 0;
                    col = 0;
                } else if (board.getCell(row, col) != null) {
                    System.out.println("This cell is occupied! Choose another one!");
                } else {
                    board.setCell(row, col, player.getSymbol());
                    break;
                }
            }
        }
    }
}
