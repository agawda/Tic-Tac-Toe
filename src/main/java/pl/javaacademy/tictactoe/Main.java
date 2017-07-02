package pl.javaacademy.tictactoe;

import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        UserCommunication<Integer> integerReader = new IntegerInput();
        UserCommunication<Mark> userMarkReader = new MarksInput();

        System.out.println("Choose starting mark ('X' or 'O')");
        Mark startingMark = userMarkReader.read();
        System.out.println("You selected: " + startingMark);
        PlayerSelector playerSelector = new PlayerSelector(startingMark);

        //System.out.println("Please type width of board");
        Integer boardWidth = 3;//integerReader.read();

        //System.out.println("Please type height of board");
        Integer boardHeight = 3;//integerReader.read();

        BoardSize boardSize = new BoardSize(boardWidth, boardHeight);
        System.out.println("Selected board size: " + boardSize);

        //TODO replace responsibilites from main to GameEngine
        Board board = new Board(boardSize);
        board.displayBoard();
        int moveCounter = 1;
        WinnerChecker winnerChecker = new WinnerChecker();
        while (winnerChecker.findWinner(board).equals(GameState.NO_WINNER) && moveCounter < 10) {
            Mark currentPlayerMark = playerSelector.getPlayerForMove(moveCounter);
            System.out.println(String.format("Player %s, please select field(1-9)", String.valueOf(currentPlayerMark)));
            Integer selectedField = integerReader.read();
            while (!board.isFieldSuitable(selectedField)) {
                System.out.println("Field is occupied or not on board, please select another one");
                selectedField = integerReader.read();
            }
            System.out.println("You selected: " + selectedField);

            board.updateBoard(selectedField, currentPlayerMark);
            board.displayBoard();
            moveCounter++;
        }

    }
}
