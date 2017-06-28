package pl.javaacademy.tictactoe;

class BoardSize {

    private Integer width;
    private Integer height;

    public BoardSize(Integer width, Integer height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public String toString() {
        return "BoardSize{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }
}
