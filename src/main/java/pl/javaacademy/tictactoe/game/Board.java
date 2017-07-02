package pl.javaacademy.tictactoe.game;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
 * Class storing board data. It has hardcoded 3x3 board
 */
class Board {

    private Stream<Integer> fieldIds = IntStream.range(1, 10).boxed(); //generate numbers 1-9
    //TODO: extract Fields class to manage fields
    Map<Integer, Mark> fields;
    BoardSize size;

    Board(BoardSize boardSize) {
        fields = new HashMap<>();
        fieldIds.forEach(integer -> fields.put(integer, Mark.EMPTY));

        this.size = boardSize;
    }

    void displayBoard() {
        System.out.println(selectMark(1) + selectMark(2) + selectMark(3));
        System.out.println(selectMark(4) + selectMark(5) + selectMark(6));
        System.out.println(selectMark(7) + selectMark(8) + selectMark(9));
    }

    void updateBoard(Integer selectedField, Mark playerMark) {
        fields.put(selectedField, playerMark);
    }

    boolean isFieldSuitable(Integer selectedField) {
        return (isFieldFree(selectedField) && size.isFieldOnBoard(selectedField));
    }

    //TODO: it's possible to use stream here
    boolean boardIsFilled() {

        int emptyFieldsCounter = 0;
        for (int i = 0; i < size.getNumberOfFields(); i++) {
            if (fields.get(i) == null) {
                emptyFieldsCounter++;
            }
        }
        return emptyFieldsCounter == 0;
    }

    List<Mark> getMarksFromRow(int rowNumber) {

        List<Mark> result = new ArrayList<>();
        List<Integer> indices = size.getHorizontalIndices(rowNumber);
        indices.forEach(integer -> result.add(fields.get(integer)));
        return result;
    }

    List<Mark> getMarksFromColumn(int columnNumber) {

        List<Mark> result = new ArrayList<>();
        List<Integer> indices = size.getVerticalIndices(columnNumber);
        indices.forEach(integer -> result.add(fields.get(integer)));
        return result;
    }

    List<Mark> getMarksDiagonalDescending() {
        //TODO: remove magic number
        List<Mark> result = new ArrayList<>();
        List<Integer> indices = size.getDiagonalIndicesDescending(1);
        indices.forEach(i -> result.add(fields.get(i)));
        return result;
    }

    List<Mark> getMarksDiagonalAscending() {
        //TODO: remove magic number
        List<Mark> result = new ArrayList<>();
        List<Integer> indices = size.getDiagonalIndicesAscending(3);
        indices.forEach(i -> result.add(fields.get(i)));
        return result;
    }

    private boolean isFieldFree(Integer selectedField) {
        return fields.get(selectedField) == Mark.EMPTY;
    }

    private String selectMark(int id) {
        //TODO: show field number instead of dots
        return fields.get(id) != Mark.EMPTY ? String.valueOf(fields.get(id)) : ".";
    }
}
