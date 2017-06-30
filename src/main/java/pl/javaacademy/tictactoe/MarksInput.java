package pl.javaacademy.tictactoe;

/*
 * I was playing with generics to learn them better and it worked, so I don.t changed it
 */
class MarksInput extends UserCommunication<Marks> {

    @Override
    Marks castUserInput(String userInput) throws IllegalArgumentException {
        return Marks.valueOf(userInput);
    }
}
