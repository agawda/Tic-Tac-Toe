## To run:
1. mvn clean install
2. java -jar PROJECT_DIRECTORY/target/TicTacToe-1.0.jar

## TODO:
:octocat: - done
* Create a class which validates user input
* Create a winning algorithm (diagonals) :octocat:
* Empty board should display numbers, not dots
* Create a server
* Create methods in Mark enum :octocat:
* Game interface and class :octocat:
* Output class (when the server is done I think)
* Generalize winning algorithm
* Best of three actually
* Player names (so Player class)
* Players class (to manage collection)
* Fields class (to manage collection)
* Player scores
* ... more coming soon

## Requirements list:
1. It is "best of three", though I can quit mid-way through.
1. Characters: O (naught) and X (cross)
1. Players have names and scores.
1. Winner has better score. Draw is possible.
1. Interactive:
1. it should accept players instructions about each move
1. it should ask who begins
1. it informs about session result, who’s turn it is now and the like
1. Match gives points: win 3, draw 1, loss 0. 3 matches == game.
1. Game works with square or rectangular board.
1. Player wins, if he has unbroken line of his characters, in a row, in a column or diagonally.
1. Winning is announced in a message: Wygrywa O. O: 1 X: 0 (numbers are current points).
1. Game is configurable:
1. Board dimensions: 3x3, 4x4, 99x101, etc. (user provides)
1. Winning condition has variable number of characters: 3, 4, 5, etc. (user provides)
1. Game messages should have configurable target: console (System.out) or logs (for the sake of this exercise it’s OK to make it System.err), or external printer.
1. before game starts it asks who goes first, O or X
1. We are bi-lingual: Polish and English are fine. In future we want to add more languages: messages are to be read from a file for chosen language. Choosing the language depends on configuration variable.
1. Client-server










#### Old readme.MD:
Author: Piotr Sekuła
Project of Tic Tac Toe game.



TODO List:
1. IO - select starting mark
2. IO - set board size
3. Display empty board
4. Select field
5. Check if selected field is available
6. Update board
7. Display updated board
8. Add restrictions to user input
9. Allow users to make moves alternately
10. Check game for win
11. Check for match winner (best of 3 games)
12. Calculating points (3 - for game winner, 1 - when its draw)
13. Customize win condition


