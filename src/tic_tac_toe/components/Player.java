package tic_tac_toe.components;

import tic_tac_toe.enums.Coin;

public class Player {

    private String name;
    private Coin coin;

    public Player(String name, Coin coin) {
        this.name = name;
        this.coin = coin;
    }

    public String getName() {
        return name;
    }

    public Coin getCoin() {
        return coin;
    }


}
