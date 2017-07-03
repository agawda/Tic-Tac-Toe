package pl.javaacademy.tictactoe.game;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
 * Important class for me, because it knows size of the board and thanks to this it can
 * calculate indices to check for winner
 *
 * Difference between diagonal cells:
 * Top left - bottom right - width + 1 - descending
 * Bottom left - top rigth - width - 1 - ascending
 */
class BoardSize {

    private Integer width;
    private Integer height;
    private Integer winningSequence;

    BoardSize(Integer width, Integer height) {
        this.width = width;
        this.height = height;
        this.winningSequence = 3;
    }

    public BoardSize(Integer width, Integer height, Integer winningSequence) {
        this.width = width;
        this.height = height;
        this.winningSequence = winningSequence;
    }

    // TODO: make sure field is > 0
    boolean isFieldOnBoard(Integer selectedField) {
        return selectedField <= width * height;
    }

    int getNumberOfFields() {
        return width * height;
    }

    List<Integer> getHorizontalIndices(int startingPoint) {
        int firstIndex = (startingPoint - 1) * width + 1;
//        int lastIndex = startingPoint * width + 1;
        int lastIndex = winningSequence < width ? startingPoint * winningSequence + 1 : startingPoint * width + 1;
        Stream<Integer> stream = IntStream.range(firstIndex, lastIndex).boxed();
        List<Integer> result = new ArrayList<>();

        stream.forEach(result::add);
        return result;
    }

    List<Integer> getVerticalIndices(int startingPoint) {
        List<Integer> result = new ArrayList<>();
        int lastIndex = winningSequence < height ? winningSequence : height;
        while (startingPoint <= width * lastIndex) {
            result.add(startingPoint);
            startingPoint += width;
        }
        return result;
    }

    List<Integer> getDiagonalIndicesDescending(int startingPoint) {
        int formula = width + 1;
        return IntStream.iterate(startingPoint, i -> i + formula).limit(3).boxed().collect(Collectors.toList());
    }

    List<Integer> getDiagonalIndicesAscending(int startingPoint) {
        int formula = width - 1;
        return IntStream.iterate(startingPoint, i -> i + formula).limit(3).boxed().collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "BoardSize{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }
}
