package pl.javaacademy.tictactoe.server;

import java.io.IOException;

public class GameServer {
    public static void main(String[] args) {
        Server server = new Server();
        server.run();
        try {
            System.out.println(server.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Integer getFieldNumber() {

        return 0;
    }
}
