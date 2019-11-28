package sample;

import java.io.Serializable;
import java.util.ArrayList;

public class GameStatus implements Serializable {

    private final String player;

    private final int level;

    private int sun_tokens_collected;

    private ArrayList<Zombie> zombies;

    private ArrayList<Plant> plants;

    GameStatus(String player,int level)
    {
        this.level=level;
        this.player=player;
        this.sun_tokens_collected=0;
        this.zombies=new ArrayList<>();
        this.plants=new ArrayList<>();
    }


    public ArrayList<Zombie> getZombies() {
        return zombies;
    }

    public void setZombies(ArrayList<Zombie> zombies) {
        this.zombies = zombies;
    }

    public ArrayList<Plant> getPlants() {
        return plants;
    }

    public void setPlants(ArrayList<Plant> plants) {
        this.plants = plants;
    }

    public void increaseSunToken(){
        this.sun_tokens_collected+=1;
        System.out.println(this.sun_tokens_collected);
    }
}
