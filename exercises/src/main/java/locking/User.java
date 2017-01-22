package locking;

/**
 * @author victorp
 */
public class User {
    public String name;
    public int age;
    public int score;
    public long gameState = 0 ;


    public User(String name, int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public long getGameState() {
        return gameState;
    }

    public void setGameState(long gameState) {
        this.gameState = gameState;
    }
}
