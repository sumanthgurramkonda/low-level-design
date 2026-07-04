package tic_tac_toe.components;

import tic_tac_toe.enums.Coin;

public class Cell {
    private Coin coin;

    public Cell() {
        this.coin = null;
    }

    public Coin getCoin() {
        return coin;
    }

    public void setCoin(Coin coin) {
        this.coin = coin;
    }
}
