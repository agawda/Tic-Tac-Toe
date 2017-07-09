package pl.javaacademy.tictactoe.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static final int PORT_NUMBER = 4444;

    private ServerSocket serverSocket;
    private Socket connection;
    ObjectInputStream in;
    ObjectOutputStream out;


    public void init() {

    }

    public void run() {
        try {
            serverSocket = new ServerSocket(PORT_NUMBER, 2);
            connection = serverSocket.accept();
            in = new ObjectInputStream(connection.getInputStream());
            out = new ObjectOutputStream(connection.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

//        try {
//            out.flush();
//            out.writeObject("Hello.");
//            out.flush();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        try (
//                ServerSocket serverSocket = new ServerSocket(PORT_NUMBER, 2);
//                Socket connection = serverSocket.accept();
//                ObjectOutputStream out = new ObjectOutputStream(connection.getOutputStream());
//                ObjectInputStream in = new ObjectInputStream(connection.getInputStream())
//
//        ) {
//            while(true) {
//                String exitMessage = "bye";
//                String message = (String) in.readObject();
//                System.out.println(message);
//                if(message.equals(exitMessage)) break;
//            }
////            out.flush();
////            out.writeObject("Hello.");
////            out.flush();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
    }

    public Object getMessage() throws IOException, ClassNotFoundException {
        String number = (String) in.readObject();
        return number;
    }
}
