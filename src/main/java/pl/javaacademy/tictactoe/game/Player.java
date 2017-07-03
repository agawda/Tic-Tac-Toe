package pl.javaacademy.tictactoe.game;

class Player implements Comparable {
    private String name;
    private Mark mark;
    private Integer score;

    Player(String name) {
        this.name = name;
        this.score = 0;
    }

    Player(String name, Mark mark) {
        this.name = name;
        this.mark = mark;
        this.score = 0;
    }

    String getPlayerName() {
        return name;
    }

    void setMark(Mark mark) {
        this.mark = mark;
    }

    public Mark getMark() {
        return mark;
    }

    Integer getScore() {
        return score;
    }

    void setScore(Integer score) {
        this.score = score;
    }

    void addThreeScore() {
        this.score += 3;
    }

    void addOneScore() {
        this.score++;
    }

    @Override
    public int compareTo(Object o) {
        if(this == o) return 0;
        Player that = (Player) o;
        if(this.score.equals(that.score)) return 0;
        if(this.score < that.score) return -1;
        return 1;
    }
}
