package pl.javaacademy.tictactoe.game;


import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
 * Class storing board data. It has hardcoded 3x3 board
 */
class Board {

    //TODO: extract Fields class to manage fields
    private Map<Integer, Mark> fields;
    private BoardSize size;

    Board(BoardSize boardSize) {
        fields = new HashMap<>();
        this.size = boardSize;
        //TODO: magic numbers
        Stream<Integer> fieldIds = IntStream.rangeClosed(1, size.getHeight() * size.getWidth()).boxed();
        fieldIds.forEach(integer -> fields.put(integer, Mark.EMPTY));
    }

    void displayBoard() {
        fields.forEach((k, v) -> {
            System.out.printf("|%-3s", selectMark(k));
            if(k%size.getWidth() == 0) {
                System.out.print("|");
                System.out.println();
            }
        });
    }

    void updateBoard(Integer selectedField, Mark playerMark) {
        fields.put(selectedField, playerMark);
    }

    boolean isFieldSuitable(Integer selectedField) {
        return (isFieldFree(selectedField) && size.isFieldOnBoard(selectedField));
    }

    Integer getWidth() {
        return size.getWidth();
    }

    Integer getHeight() {
        return size.getHeight();
    }
    //TODO: it's possible to use stream here
    boolean boardIsFilled() {

        int emptyFieldsCounter = 0;
        for (int i = 0; i < size.getNumberOfFields(); i++) {
            if (fields.get(i) == Mark.EMPTY) {
                emptyFieldsCounter++;
            }
        }
        return emptyFieldsCounter == 0;
    }
    //TODO: get marks horizontal... or not
    List<Mark> getMarksFromRow(int rowNumber) {
        List<Mark> result = new ArrayList<>();
        List<Integer> indices = size.getHorizontalIndices(rowNumber);
        indices.forEach(integer -> result.add(fields.get(integer)));
        return result;
    }
    //TODO: get marks vertical
    List<Mark> getMarksFromColumn(int columnNumber) {
        List<Mark> result = new ArrayList<>();
        List<Integer> indices = size.getVerticalIndices(columnNumber);
        indices.forEach(integer -> result.add(fields.get(integer)));
        return result;
    }

    List<Mark> getMarksDiagonalDescending(int startingPoint) {
        List<Mark> result = new ArrayList<>();
        List<Integer> indices = size.getDiagonalIndicesDescending(startingPoint);
        indices.forEach(i -> result.add(fields.get(i)));
        return result;
    }

    List<Mark> getMarksDiagonalAscending(int startingPoint) {
        List<Mark> result = new ArrayList<>();
        List<Integer> indices = size.getDiagonalIndicesAscending(startingPoint);
        //TODO: review that later
        indices.forEach(i -> result.add(fields.get(i)));
        return result;
    }

    private boolean isFieldFree(Integer selectedField) {
        return fields.get(selectedField) == Mark.EMPTY;
    }

    private String selectMark(int id) {
        //TODO: show field numbers instead of dots
        return fields.get(id) != Mark.EMPTY ? String.valueOf(fields.get(id)) : String.valueOf(id);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        fields.forEach((k, v) -> {
            stringBuilder.append(String.format("|%-3s", selectMark(k)));
            if(k%size.getWidth() == 0) {
                stringBuilder.append("|");
                stringBuilder.append("\n");
            }
        });
        return stringBuilder.toString();
    }
}
