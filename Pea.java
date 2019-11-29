package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Pea {
    private int x;
    private int y;
    private final int damage;

    public static Image im;

    static {
        String path = Main2.path;
        im = Helper.getImage(path + "ProjectilePea.png");

    }

    public Pea(int x,int y){
        this.x = x;
        this.y = y;
        damage = 20;
    }

    public boolean CheckCollision(ArrayList<Zombie> arr, ImageView pi){
        for(Zombie tempZom : arr){
            if(tempZom.getX()- this.x<=-60 && tempZom.getY()- this.y<=4){
                System.out.println(tempZom.getHealth());
                tempZom.setHealth(tempZom.getHealth()- this.damage);
                System.out.println(tempZom.getHealth());
                PlayGameController.statmain.getChildren().remove(pi);
                //Main2.pea_im.remove(this);
                Main2.statgame.remove_pea(this);
                if(tempZom.getHealth()<=0){
                    tempZom.die();
                }
                return true;
            }
        }
        return false;
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
}
