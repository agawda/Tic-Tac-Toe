package pl.javaacademy.tictactoe;

import java.util.Scanner;

abstract class UserCommunication<T> {

    private Scanner scanner = new Scanner(System.in);

    // TODO: add some restrictions (eg. board size < 100)
    T read() {

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
