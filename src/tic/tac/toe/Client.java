package tic.tac.toe;

import tic.tac.toe.components.Player;
import tic.tac.toe.enums.Coin;
import tic.tac.toe.game.TicTacToe;

public class Client {

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        Player p1 = new Player("Sumanth", Coin.X);
        Player p2 = new Player("Girish",Coin.O);
        game.createGame(p1, p2,3);
        game.startGame();
    }
}
