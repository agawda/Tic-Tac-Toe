package pl.javaacademy.tictactoe.server;

import pl.javaacademy.tictactoe.io.IntegerInput;
import pl.javaacademy.tictactoe.io.UserCommunication;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

class Client {
    private static UserCommunication<Integer> integerInput;
    public void run() {
        integerInput = new IntegerInput();
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

            for(int i = 0; i < 3; i++) {
                String line;
                while (true) {
                    line = (String) in.readObject();
                    if(line.equalsIgnoreCase("bye")) break;
                    System.out.println(line);
                    line = (String) in.readObject();
                    if(line.equalsIgnoreCase("bye")) break;
                    System.out.println(line);
                    Integer field = integerInput.read();
                    out.flush();
                    out.writeObject(field);
                    out.flush();
                    line = (String) in.readObject();
                    if(line.equalsIgnoreCase("bye")) break;

                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
