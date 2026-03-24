package snake.game.game;

import snake.game.components.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Client {

    public static void main(String[] args) {

        List<Player> players = new ArrayList<>();

        players.add(new Player("Player1"));
        players.add(new Player("Player2"));
        players.add(new Player("Player3"));

        Map<Integer,Integer> snakePositions = Map.of(
                5,2,
                8,4,
                11,7,
                14,9,
                17,12
        );

        Map<Integer,Integer> ladderPositions = Map.of(
                3,6,
                6,10,
                9,15,
                12,18,
                15,20
        );

        Game game = new Game(snakePositions, ladderPositions, players);
        game.start();
        for(Player player : game.getWinners()) {
            System.out.println(player.getName() + " won with score " + player.getScore());
        }
   }
}
