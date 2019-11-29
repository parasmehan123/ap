package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.Serializable;
import java.util.ArrayList;

public class Pea implements Serializable {
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
//            System.out.printf(tempZom.tempZom);
            if(tempZom.getX()- this.x<=-60 && tempZom.getY()- this.y==0){
                //System.out.println(tempZom.getHealth());
                tempZom.setHealth(tempZom.getHealth()- this.damage);
                //System.out.println(tempZom.getHealth());
                PlayGameController.statmain.getChildren().remove(pi);
                Main2.statgame.remove_pea(this);
                if(tempZom.getHealth()<=0){
                    Main2.remove_zombie(tempZom);
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
