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

}
