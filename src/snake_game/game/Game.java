package snake_game.game;

import snake.game.components.*;
import snake_game.components.BoardEntity;
import snake_game.components.Dice;
import snake_game.components.Player;
import snake_game.entity.Status;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Game {

    private BoardEntity board;
    private List<Player> players;
    private List<Player> winners = new ArrayList<>();
    private Status status;
    private int maxScore = 100;
    private Dice dice;

    public Game(Map<Integer, Integer> snakePositions, Map<Integer, Integer> ladderPositions, List<Player> players) {
        this.board = new BoardEntity(snakePositions,ladderPositions);
        this.players = players;
        this.status = Status.IN_PROGRESS;
        this.dice = new Dice();
    }

    public void start() {

        int playerCount = players.size();
        while (true) {
            Iterator<Player> iterator = players.iterator();
            while(iterator.hasNext()) {
                Player player = iterator.next();
                int steps = 0;
                do{
                    steps = dice.roll();
                    if(movePlayer(player,steps)){
                        iterator.remove();
                        playerCount--;
                        if(playerCount==1){
                            status = Status.COMPLETED;
                            return;
                        };
                    }
                }while(steps==6);
            }
        }

    }

    public boolean movePlayer(Player player, int steps) {

        int currentPosition = player.getPosition();
        int newPosition = currentPosition + steps;
        int boardSize =  board.getSize();
        if (newPosition > boardSize) {
            return false;
        }
        if (newPosition == boardSize) {
            player.setScore(maxScore);
            player.move(newPosition);
            winners.add(player);
            maxScore--;
            return true;
        }
        int newPositionAfterEntity = board.getNewPosition(newPosition);
        player.move(newPositionAfterEntity);
        return false;
    }


    public List<Player> getWinners() {return winners;}
}
