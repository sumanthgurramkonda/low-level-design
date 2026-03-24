package tic.tac.toe.components;

import tic.tac.toe.enums.Coin;

public class Board {

    private Coin[][] board;
    private int size;

    public Board(int n) {
        this.size=n;
        this.board = new Coin[n][n];
    }

    public Coin getCell(int row, int col) {
        return board[row][col];
    }

    public void setCell(int row, int col, Coin value) {
        board[row][col] = value;
    }

    public int getSize() {return size;}

}
