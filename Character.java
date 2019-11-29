package sample;

import java.io.Serializable;

public abstract class Character implements Serializable {

    private int x,y;
    private int health;

    protected Character(int x,int y,int health)
    {
        this.x = x;
        this.y = y;
        this.health = health;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
