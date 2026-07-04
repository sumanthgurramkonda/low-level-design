package snake_game.components;

import snake_game.components.interfaces.Board;

import java.util.Map;

public class BoardEntity implements Board {
    private Snake snake;
    private Ladder ladder;
    private int size;

    public BoardEntity(Map<Integer, Integer> snakePositions, Map<Integer, Integer> ladderPositions) {
        this.snake = new Snake(snakePositions);
        this.ladder = new Ladder(ladderPositions);
        this.size = SIZE;
    }

    public int getNewPosition(int position) {
        if(snake.getSnakePositions().containsKey(position)) {
            return snake.getSnakePositions().get(position);
        } else if(ladder.getLadderPositions().containsKey(position)) {
            return ladder.getLadderPositions().get(position);
        }
        return position;
    }

    public int getSize() {return size;}

}
