package snake.game.components;

import java.util.Map;

public class Snake {
    private Map<Integer, Integer> snakePositions;

    public Snake(){}

    public Snake(Map<Integer, Integer> snakePositions) {
        this.snakePositions = snakePositions;
    }

    public Map<Integer, Integer> getSnakePositions() {
        return snakePositions;
    }

    public  void setSnakePositions(Map<Integer, Integer> snakePositions) {}
}
