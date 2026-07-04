package snake_game.components;

import java.util.Map;

public class Ladder {

    private Map<Integer, Integer> ladderPositions;

    public  Ladder() {}

    public Ladder(Map<Integer, Integer> ladderPositions) {
        this.ladderPositions = ladderPositions;
    }

    public Map<Integer, Integer> getLadderPositions() {
        return ladderPositions;
    }

    public void setLadderPositions(Map<Integer, Integer> ladderPositions) {
        this.ladderPositions = ladderPositions;
    }
}
