package pl.javaacademy.tictactoe.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static final int PORT_NUMBER = 4444;

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        try (
                ServerSocket serverSocket = new ServerSocket(PORT_NUMBER, 2);
                Socket connection = serverSocket.accept();
                ObjectOutputStream out = new ObjectOutputStream(connection.getOutputStream());
                ObjectInputStream in = new ObjectInputStream(connection.getInputStream())

        ) {
            while(true) {
                String exitMessage = "bye";
                String message = (String) in.readObject();
                System.out.println(message);
                if(message.equals(exitMessage)) break;
            }
//            out.flush();
//            out.writeObject("Hello.");
//            out.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
