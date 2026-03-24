package tic.tac.toe.game;

import tic.tac.toe.components.Board;
import tic.tac.toe.components.Player;
import tic.tac.toe.enums.Status;

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
