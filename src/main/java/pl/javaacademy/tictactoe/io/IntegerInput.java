package pl.javaacademy.tictactoe.io;

/*
 * I was playing with generics to learn them better and it worked, so I don.t changed it
 */
public class IntegerInput extends UserCommunication<Integer> {

    @Override
    Integer castUserInput(String userInput) throws IllegalArgumentException {
        return Integer.valueOf(userInput);
    }
}
