package pl.javaacademy.tictactoe.game;

import pl.javaacademy.tictactoe.io.IntegerInput;
import pl.javaacademy.tictactoe.io.UserCommunication;

class Play {
    private Board board;
    private PlayerSelector playerSelector;
    private WinningSequence winningSequence;
    //TODO: get this stuff from client app
    private UserCommunication<Integer> integerInput;

    Play(Board board, Mark startingMark, WinningSequence winningSequence) {
        this.board = board;
        Mark currentMark = startingMark;
        this.winningSequence = winningSequence;
        this.playerSelector = new PlayerSelector(startingMark);
        this.integerInput = new IntegerInput();
    }

    Mark runTheGame() {
        board.displayBoard();
        int moveCounter = 1;
        WinnerChecker winnerChecker = new WinnerChecker(winningSequence);
        //TODO: refactor this
        while (winnerChecker.findWinner(board) == GameState.NO_WINNER && moveCounter <= board.getHeight() * board.getWidth()) {
            Mark currentPlayerMark = playerSelector.getPlayerForMove(moveCounter);
            System.out.println(String.format("Player %s, please select field(1-%d)", String.valueOf(currentPlayerMark), board.getHeight() * board.getWidth()));
            Integer selectedField = integerInput.read();
            while (!board.isFieldSuitable(selectedField)) {
                System.out.println("Field is occupied or not on board, please select another one");
                selectedField = integerInput.read();
            }
            System.out.println("You selected: " + selectedField);

            board.updateBoard(selectedField, currentPlayerMark);
            board.displayBoard();
            moveCounter++;
        }
        return winnerChecker.getWinnerMark();
    }
}
