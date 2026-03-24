package tic.tac.toe.components;

import tic.tac.toe.enums.Coin;

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
