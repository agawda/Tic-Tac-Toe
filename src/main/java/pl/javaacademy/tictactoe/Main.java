package pl.javaacademy.tictactoe;

import pl.javaacademy.tictactoe.game.BestOfThreeGame;
import pl.javaacademy.tictactoe.game.Game;
import pl.javaacademy.tictactoe.server.Client;
import pl.javaacademy.tictactoe.server.Server;

public class Main {

    public static void main(String[] args) {
        if(args.length == 0 || args[0].equals("local")) {
            Game game = new BestOfThreeGame();
            game.initialize();
            game.play();
        } else if(args[0].equals("server")) {
            Server server = new Server();
            server.run();
        }
//        } else if (args[0].equals("client")) {
//            Client client = new Client();
//            client.run();
//        }

    }
}
