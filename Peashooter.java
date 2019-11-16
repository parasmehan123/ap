package sample;

import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.IOException;

public class Peashooter extends Plant {

    public static Image im;

    static
    {
        try
        {
            FileInputStream fn=new FileInputStream("/Users/pawanmehan/ap_project/src/sample/images/PeaShooter_Idle1.gif");
            im=new Image(fn);
        }catch (IOException E){}
    }
    public Peashooter(int x, int y)
    {
        super(x,y,im);

    }
}
