package tic.tac.toe.game;

import tic.tac.toe.components.Board;
import tic.tac.toe.components.Cell;
import tic.tac.toe.components.Player;
import tic.tac.toe.enums.Coin;
import tic.tac.toe.enums.Status;

import java.util.Scanner;

public class TicTacToe {

    private ScoreBoard scoreBoard;
    private Game game;
    private int boardSize;
    public TicTacToe() {
    }

    public void createGame(Player player1, Player player2, int boardSize) {
        this.boardSize = boardSize;
        this.game = new Game(player1, player2, boardSize);
        this.scoreBoard = new ScoreBoard();
    }

    private void renderBoard() {
        for(int i=0;i<boardSize;i++) {

            System.out.println();
            for(int j=0;j<boardSize;j++) {
                Coin cell = game.getBoard().getCell(i,j);
                System.out.print((cell==null ? " -- " : "   "+cell.toString())+"   " + "|");
            }
            System.out.println();
        }
    }

    public void startGame() {
        boolean currentPlayer = true; // true for player1, false for player2
        Scanner scanner = new Scanner(System.in);
        while(true) {
            renderBoard();
            Player player = currentPlayer ? game.getPlayer1() : game.getPlayer2();
            if(currentPlayer) {
                currentPlayer = false;
                System.out.println("Enter row and column for player "+game.getPlayer1().getName()+" (X): ");
                int row = scanner.nextInt();
                int col = scanner.nextInt();
                game.setCell(row, col, player);
            }else{
                currentPlayer = true;
                System.out.println("Enter row and column for player"+game.getPlayer2().getName()+" (O): ");
                int row = scanner.nextInt();
                int col = scanner.nextInt();
                game.setCell(row, col, player);
            }
            if(game.getStatus() == Status.WIN) {
                renderBoard();
                System.out.println(player.getName() + " wins!");
                scoreBoard.addGame(this.game);
                break;
            } else if(game.getStatus() == Status.DRAW) {
                renderBoard();
                System.out.println("It's a draw!");
                scoreBoard.addGame(this.game);
                break;
            }
        }
    }


}
