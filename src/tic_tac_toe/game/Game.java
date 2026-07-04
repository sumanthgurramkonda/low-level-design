package tic_tac_toe.game;

import tic_tac_toe.components.Board;
import tic_tac_toe.components.Player;
import tic_tac_toe.enums.Status;

public class Game {

    private Player player1;
    private Player player2;
    private Board board;
    private Status status;
    private int movesCount=0;
    private Player winner;

    public Game(Player player1, Player player2, int boardSize) {
        this.player1 = player1;
        this.player2 = player2;
        this.board = new Board(boardSize);
        this.status = Status.IN_PROGRESS;
    }

    public void setCell(int row, int col, Player player) {
        if (status != Status.IN_PROGRESS) {
            throw new IllegalStateException("Game is not in progress");
        }
        if (board.getCell(row, col) != null) {
//            throw new IllegalArgumentException("Cell is already occupied");
            System.out.println("Cell already exists");
            return;
        }
        board.setCell(row, col, player.getCoin());
        movesCount++;
        updateStatus(player, row, col);
    }

    private void updateStatus(Player player, int row, int col) {
        if (checkWin(player, row, col)) {
            status = Status.WIN;
        } else if (checkDraw()) {
            winner=player;
            status = Status.DRAW;
        }
    }

    public boolean checkWin(Player player, int row, int col) {

        int n = board.getSize();

        // Row check
        boolean win = true;
        for (int i = 0; i < n; i++) {
            if (board.getCell(row, i) != player.getCoin()) {
                win = false;
                break;
            }
        }
        if (win) return true;

        // Column check
        win = true;
        for (int i = 0; i < n; i++) {
            if (board.getCell(i, col) != player.getCoin()) {
                win = false;
                break;
            }
        }
        if (win) return true;

        // Main diagonal
        if (row == col) {
            win = true;
            for (int i = 0; i < n; i++) {
                if (board.getCell(i, i) != player.getCoin()) {
                    win = false;
                    break;
                }
            }
            if (win) return true;
        }

        // Anti-diagonal
        if (row + col == n - 1) {
            win = true;
            for (int i = 0; i < n; i++) {
                if (board.getCell(i, n - 1 - i) != player.getCoin()) {
                    win = false;
                    break;
                }
            }
            if (win) return true;
        }

        return false;
    }


    private  boolean checkDraw() {
        if(movesCount==board.getSize() * board.getSize()){
            return true;
        }
        return false;
    }


    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public Board getBoard() {
        return board;
    }

    public Status getStatus() {
        return status;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }
    public  Player getWinner() {return winner;}


}
