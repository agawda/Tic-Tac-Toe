package pl.javaacademy.tictactoe;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Board {

    private Stream<Integer> fieldIds = IntStream.range(1, 10).boxed(); //generate numbers 1-9

    Map<Integer, Marks> fields;

    public Board() {
        fields = new HashMap<>();
        fieldIds.forEach(integer -> fields.put(integer, null));
    }

    public void displayBoard() {
        System.out.println(selectMark(1) + selectMark(2) + selectMark(3));
        System.out.println(selectMark(4) + selectMark(5) + selectMark(6));
        System.out.println(selectMark(7) + selectMark(8) + selectMark(9));
    }

    private String selectMark(int id) {
        return fields.get(id) != null ? String.valueOf(fields.get(id)) : ".";
    }
}
