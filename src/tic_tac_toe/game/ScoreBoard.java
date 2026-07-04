package tic_tac_toe.game;

import java.util.ArrayList;
import java.util.List;

public class ScoreBoard {
    private List<Game> games;

    public ScoreBoard() {
        this.games = new ArrayList<>();
    }

    public List<Game> getGames() {return games.stream().toList();}

    public void addGame(Game game) {games.add(game);}
}
