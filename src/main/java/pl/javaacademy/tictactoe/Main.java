package pl.javaacademy.tictactoe;

import pl.javaacademy.tictactoe.common.Marks;
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

        //System.out.println("Please type width of board");
        Integer boardWidth = 3;//integerReader.read();

        //System.out.println("Please type height of board");
        Integer boardHeight = 3;//integerReader.read();

        BoardSize boardSize = new BoardSize(boardWidth, boardHeight);
        System.out.println("Selected board size: " + boardSize);

        //TODO replace responsibilites from main to GameEngine
        Board board = new Board(boardSize);
        board.displayBoard();

        System.out.println("Please select field(1-9)");
        Integer selectedField = integerReader.read();
        while (!board.isFieldSuitable(selectedField)){
            System.out.println("Field is occupied or not on board, please select another one");
            selectedField = integerReader.read();
        }
        System.out.println("You selected: " + selectedField);

        board.updateBoard(selectedField, startingMark);
        board.displayBoard();
    }
}
