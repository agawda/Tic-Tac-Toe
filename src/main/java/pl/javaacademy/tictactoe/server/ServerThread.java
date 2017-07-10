package pl.javaacademy.tictactoe.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerThread extends Thread{
    private Socket socket;
    private ObjectInputStream in;
    private ObjectOutputStream out;
    private MessageQueue messageQueue;


    public ServerThread(Socket socket, MessageQueue messageQueue) {
        this.socket = socket;
        this.messageQueue = messageQueue;
    }

    public void run() {
        try {
            in = new ObjectInputStream(socket.getInputStream());
            out = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        String line;
        while(true) {
            try {
                out.flush();

                line = (String) in.readObject();
                System.out.println(line);
                if (line.equalsIgnoreCase("quit")) {
                    socket.close();
                    return;
                } else {
                    out.writeObject(line + "\n");
                    out.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
