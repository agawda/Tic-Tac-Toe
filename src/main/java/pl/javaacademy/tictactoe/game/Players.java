package pl.javaacademy.tictactoe.game;

import java.util.HashMap;
import java.util.Map;

class Players {
    private Map<Mark, Player> players;

    Players() {
        this.players = new HashMap<>();
    }

    void addPlayer(Player player) {
        players.put(player.getMark(), player);
    }

    String getPlayerName(Mark mark) {
        return players.get(mark).getPlayerName();
    }

    void addPlayerScoreThreePoints(Mark mark) {
        Player player = players.get(mark);
        player.addThreeScore();
        players.replace(mark, player);
    }

    void addBothPlayersScoreOnePoint() {
        players.forEach((k, v) -> v.addOneScore());
    }

    Integer getPlayerScore(Mark mark) {
        return players.get(mark).getScore();
    }

    Mark getPlayerWithBetterScore() {
        Player player1 = players.get(Mark.X);
        Player player2 = players.get(Mark.O);
        if(player1.compareTo(player2) == 1) return player1.getMark();
        if(player1.compareTo(player2) == -1) return player2.getMark();
        return Mark.EMPTY;
    }
}
