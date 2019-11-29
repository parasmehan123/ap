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

    private ArrayList<Pea> peas;

    private final Map<String,Integer> time_remaining,price;

    private ArrayList<String> plant_names = new ArrayList<String>(Arrays.asList(new String[]{"Peashooter", "Walnut", "Cherrybomb", "SunFlower"}));

    GameStatus(String player,int level)
    {
        this.level=level;
        this.player=player;
        this.sun_tokens_collected=0;
        this.zombies=new ArrayList<>();
        this.plants=new ArrayList<>();
        this.peas=new ArrayList<>();

        this.time_remaining=new HashMap<>();
        time_remaining.put("Peashooter",15);
        time_remaining.put("Walnut",20);
        time_remaining.put("Cherrybomb",30);
        time_remaining.put("SunFlower",10);
        this.price=new HashMap<>();
        price.put("Peashooter",4);
        price.put("Walnut",2);
        price.put("Cherrybomb",6);
        price.put("SunFlower",2);
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
            //System.out.println(time_remaining.get(k));
        }

    }

    public Map<String,Boolean> which_plants_available()
    {

        int currBalance = sun_tokens_collected;
        HashMap<String, Boolean> avaialabePlants = new HashMap<String, Boolean>();
        price.forEach((k, v)-> {
            if(v<= currBalance && time_remaining.get(k)==0 ){
                avaialabePlants.put(k, true);
            }
            else{
                avaialabePlants.put(k, false);
            }
        });
        return avaialabePlants;
    }

    public void increase_time(String as,int time)
    {
        time_remaining.put(as,time);
    }

    public void addPlant(Plant pl)
    {
        //        System.out.println(pl.toString());
        this.plants.add(pl);
    }

    public void addZombie(Zombie zm)
    {
        this.zombies.add(zm);
    }

    public void addPea(Pea p){this.peas.add(p);}

    public void remove_pea(Pea p){this.peas.remove(p);}


}
