package pl.javaacademy.tictactoe.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    public void run() {
        try (
                Socket requestSocket = new Socket("localhost", 4444);
                ObjectOutputStream out = new ObjectOutputStream(requestSocket.getOutputStream());
                ObjectInputStream in = new ObjectInputStream(requestSocket.getInputStream());
        ) {
//            String message = (String) in.readObject();
//            System.out.println(message);
            out.flush();
            Scanner scanner = new Scanner(System.in);
            String message = scanner.nextLine();
            out.writeObject(message);
            out.flush();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
