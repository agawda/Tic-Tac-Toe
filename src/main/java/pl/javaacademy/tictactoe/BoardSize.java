package pl.javaacademy.tictactoe;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
 * Important class for me, because it knows size of board and thanks to this it can
 * calculate indexes to check for winner
 *
 */
class BoardSize {

    private Integer width;
    private Integer height;

    BoardSize(Integer width, Integer height) {
        this.width = width;
        this.height = height;
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
        int lastIndex = startingPoint * width + 1;

        Stream<Integer> stream = IntStream.range(firstIndex, lastIndex).boxed();
        List<Integer> result = new ArrayList<>();

        stream.forEach(result::add);
        return result;
    }

    List<Integer> getVerticalIndices(int startingPoint) {
        List<Integer> result = new ArrayList<>();
        while (startingPoint <= width * height) {
            result.add(startingPoint);
            startingPoint += width;
        }
        return result;
    }

    @Override
    public String toString() {
        return "BoardSize{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }
}
