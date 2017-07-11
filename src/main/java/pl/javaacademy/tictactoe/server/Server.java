package pl.javaacademy.tictactoe.server;

import pl.javaacademy.tictactoe.game.GameState;
import pl.javaacademy.tictactoe.game.Mark;
import pl.javaacademy.tictactoe.game.ServerGame;
import pl.javaacademy.tictactoe.io.IntegerInput;
import pl.javaacademy.tictactoe.io.UserCommunication;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static final int PORT_NUMBER = 4444;

    private ServerSocket serverSocket;
    private Socket client;
    private ObjectInputStream in;
    private ObjectOutputStream out;
    private UserCommunication<Integer> integerInput;

    public Server() {
        this.integerInput = new IntegerInput();
    }

    public void run() {
        System.out.println("The server is running...");

        try {
            serverSocket = new ServerSocket(PORT_NUMBER);
            client = serverSocket.accept();
            in = new ObjectInputStream(client.getInputStream());
            out = new ObjectOutputStream(client.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        ServerGame game = new ServerGame();
        game.initialize();

        System.out.println("Enter your name: ");
        Scanner scanner = new Scanner(System.in);

        game.setPlayer(scanner.nextLine(), Mark.X);

        String name;
        try {
            out.flush();
            out.writeObject("Enter your name: ");
            out.flush();
            name = (String) in.readObject();
            game.setPlayer(name, Mark.O);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 3; i++) {
            game.play();
            for(int j = 0; j < 5; j++) {
                displayBoard(game);
                move(game);
                if(oneRound(game)) {
                    try {
                        out.flush();
                        out.writeObject("bye");
                        out.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
            }
        }

    }

    private boolean oneRound(ServerGame game) {
        GameState gameResult = game.checkWin();
        if(gameResult != GameState.NO_WINNER) {
            System.out.println(gameResult);
            try {
                out.flush();
                out.writeObject(gameResult.toString());
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return true;
        }
        return false;
    }

    private void move(ServerGame game) {
        String chooseField = "Choose a field: ";
        System.out.println(chooseField);
        Integer field = integerInput.read();
        String takenField = "You've chosen a taken field, please choose another one: ";
        while (!game.isFieldTaken(field)) {
            System.out.println(takenField);
            field = integerInput.read();
        }
        game.updateBoard(field, Mark.X);
        displayBoard(game);
        try {
            out.flush();
            out.writeObject(chooseField);
            out.flush();
            field = (Integer) in.readObject();
            while (!game.isFieldTaken(field)) {
                System.out.println(takenField);
                field = (Integer) in.readObject();
            }
            game.updateBoard(field, Mark.O);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void displayBoard(ServerGame game) {
        System.out.println(game.displayBoard());
        try {
            out.flush();
            out.writeObject(game.displayBoard());
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
