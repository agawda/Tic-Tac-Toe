package pl.javaacademy.tictactoe.io;

import pl.javaacademy.tictactoe.Marks;

public class MarksInput extends UserCommunication<Marks> {

    @Override
    Marks castUserInput(String userInput) throws IllegalArgumentException {
        return Marks.valueOf(userInput);
    }
}
