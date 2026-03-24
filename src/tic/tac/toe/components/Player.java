package tic.tac.toe.components;

import tic.tac.toe.enums.Coin;

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
