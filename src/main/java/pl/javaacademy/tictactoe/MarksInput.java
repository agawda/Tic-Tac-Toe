package pl.javaacademy.tictactoe;

/*
 * I was playing with generics to learn them better and it worked, so I don.t changed it
 */
class MarksInput extends UserCommunication<Mark> {

    @Override
    Mark castUserInput(String userInput) throws IllegalArgumentException {
        return Mark.valueOf(userInput);
    }
}
