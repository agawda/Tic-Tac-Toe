package pl.javaacademy.tictactoe.server;

import java.util.ArrayList;
import java.util.List;

public class MessageQueue {
    List<String> messages;

    public MessageQueue() {
        this.messages = new ArrayList<>();
    }

    public void addMessage(String message) {
        this.messages.add(message);
    }

    public String getMessage() {
        return this.messages.get(0);
    }
}
