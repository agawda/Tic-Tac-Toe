package pl.javaacademy.tictactoe;

import pl.javaacademy.tictactoe.game.BestOfThreeGame;
import pl.javaacademy.tictactoe.game.Game;

public class Main {

    public static void main(String[] args) {
        if(args.length == 0 || args[0].equals("local")) {
            Game game = new BestOfThreeGame();
            game.initialize();
            game.play();
        }
    }
}
