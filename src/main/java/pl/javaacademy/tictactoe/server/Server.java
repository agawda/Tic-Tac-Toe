package pl.javaacademy.tictactoe.server;

import pl.javaacademy.tictactoe.game.Mark;
import pl.javaacademy.tictactoe.game.ServerGame;

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

    public void run() {
        System.out.println("The server is running...");

        try  {
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
            name = (String)in.readObject();
            game.setPlayer(name, Mark.O);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        for(int i = 0; i < 3; i++) {

        }

    }

}
