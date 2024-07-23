package org.example;

import org.example.Interfaces.Player;
import org.example.ai.Difficulties.*;
import org.example.ai.Enums.Difficulties;
import org.example.ai.Enums.Players;
import org.example.ai.Players.PlayersFactory;
import java.util.*;
import java.util.regex.Pattern;
import static org.example.Utils.*;

public class Main {
    static final Scanner SCANNER = new Scanner(System.in);

    private static void starter() {
        final Pattern PARAMETER_INPUT_PATTERN = Pattern.compile("^start\\s[a-zA-Z]+\\s[a-zA-Z]+$");
        String opc;
        do{
            opc = SCANNER.nextLine().trim().toLowerCase();
            if(PARAMETER_INPUT_PATTERN.matcher(opc).matches()){
                String[] parameters = Arrays.stream(opc.split(" "), 1, 3)
                        .toArray(String[]::new);

                Difficulties difficultyType1 = getDifficultyFrom(parameters[0]);
                Difficulties difficultyType2 = getDifficultyFrom(parameters[1]);
                Players playerType1 = getPlayerFrom(parameters[0]);
                Players playerType2 = getPlayerFrom(parameters[1]);

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
