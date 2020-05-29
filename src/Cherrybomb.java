package sample;

import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Cherrybomb extends Plant {

    public static Image im;

    static
    {
        String path=Main1.path;
        im=Helper.getImage(path+"Cherrybomb.png");
    }
    public Cherrybomb(int x, int y)
    {
        super(x,y,100);

    }

    public void burst(ArrayList<Zombie> arrZ){
        for(int i=arrZ.size()-1;i>=0;i--){
            Zombie zm=arrZ.get(i);
            if(Math.abs(this.getX()*120 +130 - arrZ.get(i).getX())<=200 && Math.abs(this.getY()- arrZ.get(i).getY())<=2)
            {
                System.out.println("phooota");
                Main2.remove_zombie(zm);
            }
        }
    }
    @Override
    public Image getIm()
    {
        return im;
    }
}
