package pl.javaacademy.tictactoe;

class BoardSize {

    private Integer width;
    private Integer height;

    BoardSize(Integer width, Integer height) {
        this.width = width;
        this.height = height;
    }

    // TODO: make sure field is > 0
    boolean isFieldOnBoard(Integer selectedField) {
        return selectedField <= width*height;
    }

    @Override
    public String toString() {
        return "BoardSize{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }
}
