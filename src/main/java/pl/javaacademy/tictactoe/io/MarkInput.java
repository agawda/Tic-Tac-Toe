package pl.javaacademy.tictactoe.io;

import pl.javaacademy.tictactoe.game.Mark;

/*
 * I was playing with generics to learn them better and it worked, so I don.t changed it
 */
public class MarkInput extends UserCommunication<Mark> {
    //TODO: this will be in the client app
    @Override
    public Mark castUserInput(String userInput) throws IllegalArgumentException {
        return Mark.valueOf(userInput);
    }
}
