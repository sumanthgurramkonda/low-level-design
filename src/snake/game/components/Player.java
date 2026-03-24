package snake.game.components;

public class Player {

    private String name;
    private int position;
    private int score;

    public Player(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score+= score;
    }

    public void move(int position) {
        this.position = position;
    }

    public int getPosition() {return position;}

}
