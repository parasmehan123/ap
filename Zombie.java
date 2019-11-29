package sample;

import javafx.scene.image.Image;

import java.awt.*;

public class Zombie extends Character{

    public static Image normal_image,conehead_image;

    static
    {
        String path=Main2.path;
        normal_image=Helper.getImage(path+"TheAdvancing_zombie.gif");
        conehead_image=Helper.getImage(path+"Conehead_Zombie.gif");;
    }

    private final int attack_strength;
    protected Zombie(int x,int y,int health,int attack_strength)
    {
        super(x,y,health);
        this.attack_strength=attack_strength;
    }

    //TODO
    public void die(){}

}
