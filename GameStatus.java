package sample;

public class GameStatus {

    private int tokenCollected;

    GameStatus(int tokenCollected)
    {
        this.tokenCollected=tokenCollected;
    }

    public void increase()
    {
        this.tokenCollected+=10;
    }
}
