package sample;

import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.IOException;

public class Walnut extends Plant {

    public static Image im;

    static
    {
        try
        {
            FileInputStream fn=new FileInputStream("/Users/pawanmehan/ap_project/src/sample/images/walnut.gif");
            im=new Image(fn);
        }catch (IOException E){}
    }

    public Walnut(int x, int y)
    {
        super(x,y,im);

    }
}
