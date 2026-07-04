package tic_tac_toe;

import tic_tac_toe.components.Player;
import tic_tac_toe.enums.Coin;
import tic_tac_toe.game.TicTacToe;

public class Client {

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        Player p1 = new Player("Sumanth", Coin.X);
        Player p2 = new Player("Girish",Coin.O);
        game.createGame(p1, p2,3);
        game.startGame();
    }
}
