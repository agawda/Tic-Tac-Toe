package pl.javaacademy.tictactoe.io;

import java.util.Scanner;

public abstract class UserCommunication<T> {

    private Scanner scanner = new Scanner(System.in);

    public T read() {

        T value = null;
        while ((value == null)) {
            try {
                String userInput = scanner.nextLine();
                value = castUserInput(userInput);

            } catch (ClassCastException | IllegalArgumentException e) {
                System.err.println("You put wrong value, please try again");
            }
        }
        return value;
    }

    abstract T castUserInput(String userInput);
}
