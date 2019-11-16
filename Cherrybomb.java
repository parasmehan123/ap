package sample;

import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.IOException;

public class Cherrybomb extends Plant {

    public static Image im;

    static
    {
        try
        {
            FileInputStream fn=new FileInputStream("/Users/pawanmehan/ap_project/src/sample/images/Cherrybomb.png");
            im=new Image(fn);
        }catch (IOException E){}
    }
    public Cherrybomb(int x, int y)
    {
        super(x,y,im);

    }
}
