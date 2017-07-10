package pl.javaacademy.tictactoe.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {
    private static List<String> messageQueue;

    public static void main(String[] args) {
        messageQueue = new ArrayList<>();
        try (
                Socket requestSocket = new Socket("localhost", 4444);
                ObjectOutputStream out = new ObjectOutputStream(requestSocket.getOutputStream());
                ObjectInputStream in = new ObjectInputStream(requestSocket.getInputStream())
        ) {
            String message = (String) in.readObject();
            System.out.println(message);
            Scanner scanner = new Scanner(System.in);
            String name = scanner.nextLine();
            out.flush();
            out.writeObject(name);
            out.flush();
//            String message;
//            Scanner scanner = new Scanner(System.in);
//            while(true) {
//                out.flush();
//                message = scanner.nextLine();
//                out.writeObject(message);
//                out.flush();
//                System.out.println(requestSocket.isClosed());
//            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void getMessage(String message) {
        messageQueue.add(message);
    }
}
