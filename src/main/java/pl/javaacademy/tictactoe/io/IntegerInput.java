package pl.javaacademy.tictactoe.io;

public class IntegerInput extends UserCommunication<Integer> {

    @Override
    Integer castUserInput(String userInput) throws IllegalArgumentException {
        return Integer.valueOf(userInput);
    }
}
