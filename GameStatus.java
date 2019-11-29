package sample;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GameStatus implements Serializable {

    private final String player;

    private final int level;

    private int sun_tokens_collected;

    private ArrayList<Zombie> zombies;

    private ArrayList<Plant> plants;

    private final Map<String,Integer> time_remaining,price;

    private ArrayList<String> plant_names = new ArrayList<String>(Arrays.asList(new String[]{"Peashooter", "Walnut", "Cherrybomb", "SunFlower"}));

    GameStatus(String player,int level)
    {
        this.level=level;
        this.player=player;
        this.sun_tokens_collected=0;
        this.zombies=new ArrayList<>();
        this.plants=new ArrayList<>();

        this.time_remaining=new HashMap<>();
        time_remaining.put("Peashooter",10);
        time_remaining.put("Walnut",10);
        time_remaining.put("Cherrybomb",10);
        time_remaining.put("SunFlower",10);
        this.price=new HashMap<>();
        price.put("Peashooter",10);
        price.put("Walnut",10);
        price.put("Cherrybomb",10);
        price.put("SunFlower",10);
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

    public void one_second()
    {

        for (Map.Entry<String, Integer> entry : time_remaining.entrySet()) {
            String k = entry.getKey();
            Integer v = entry.getValue();
            time_remaining.put(k, Math.max(0, v - 1));
        }

    }

    //TODO
    public Map<String,Boolean> which_plants_available()
    {

    }


    //TODO -similar for other plants use plant_names object
    public boolean isPeaAvailable(){
        return true;
    }



}
