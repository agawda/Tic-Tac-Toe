package pl.javaacademy.tictactoe;

import pl.javaacademy.tictactoe.io.IntegerInput;
import pl.javaacademy.tictactoe.io.MarksInput;
import pl.javaacademy.tictactoe.io.UserCommunication;

public class Main {

    public static void main(String[] args) {

        UserCommunication<Integer> integerReader = new IntegerInput();
        UserCommunication<Marks> userMarkReader = new MarksInput();

        System.out.println("Choose starting mark ('X' or 'O')");
        Marks startingMark = userMarkReader.read();
        System.out.println("You selected: " + startingMark);

        System.out.println("Please type width of board");
        Integer boardWidth = integerReader.read();

        System.out.println("Please type height of board");
        Integer boardHeight = integerReader.read();

        BoardSize boardSize = new BoardSize(boardWidth, boardHeight);
        System.out.println("Selected board size: " + boardSize);

        Board board = new Board();
        board.displayBoard();

        System.out.println("Please select field(1-9)");
        Integer selectedField = integerReader.read();
        System.out.println("You selected: " + selectedField);
    }
}
