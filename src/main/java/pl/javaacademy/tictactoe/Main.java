package pl.javaacademy.tictactoe;

import pl.javaacademy.tictactoe.game.BestOfThreeGame;
import pl.javaacademy.tictactoe.game.Game;

public class Main {

    public static void main(String[] args) {
        Game game = new BestOfThreeGame();
        game.initialize();
        game.play();

    }
}
