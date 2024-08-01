package org.example;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;
import org.example.Interfaces.Player;
import org.example.ai.Difficulties.DifficultyFactory;
import org.example.ai.Enums.Difficulties;
import org.example.ai.Enums.Players;
import org.example.ai.Players.PlayersFactory;

public class Main {
    static final Scanner SCANNER = new Scanner(System.in);
    static final int maxUserParametersLength = 3;

    private static void starter() {
        final Pattern PARAMETER_INPUT_PATTERN = Pattern.compile("^start\\s[a-zA-Z]+\\s[a-zA-Z]+$");
        String opc;
        do{
            opc = SCANNER.nextLine().trim().toLowerCase();
            if(PARAMETER_INPUT_PATTERN.matcher(opc).matches()){
                String[] parameters = Arrays.stream(opc.split(" "), 1, maxUserParametersLength)
                        .toArray(String[]::new);

                Difficulties difficultyType1 = Utils.getDifficultyFrom(parameters[0]);
                Difficulties difficultyType2 = Utils.getDifficultyFrom(parameters[1]);
                Players playerType1 = Utils.getPlayerFrom(parameters[0]);
                Players playerType2 = Utils.getPlayerFrom(parameters[1]);

                boolean validParametersChecked = difficultyType1 != null && difficultyType2 != null
                        && playerType1 != null && playerType2 != null;

                if(validParametersChecked){
                    PlayersFactory playersFactory = new PlayersFactory();
                    DifficultyFactory difficultyFactory = new DifficultyFactory();


                    Player player1 = playersFactory.createPlayer(
                            playerType1
                            , difficultyFactory.setDifficulty(difficultyType1)
                            , 'X');

                    Player player2 = playersFactory.createPlayer(
                            playerType2
                            , difficultyFactory.setDifficulty(difficultyType2)
                            , 'O');


                    Game game = new Game(new Board(), player1, player2);
                    game.gameStarts();
                }else{
                    System.out.println("Bad parameters!");
                }
            }else if(!opc.startsWith("exit")){
                System.out.println("Bad parameters!");
            }

        }while(!opc.startsWith("exit"));
    }


    public static void main(String[] args) {
        starter();
    }
}
