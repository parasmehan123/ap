package sample;

import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.IOException;

public class Cherrybomb extends Plant {

    public static Image im;

    static
    {
        im=Helper.getImage("/Users/pawanmehan/ap_project/src/sample/images/Cherrybomb.png");
    }
    public Cherrybomb(int x, int y)
    {
        super(x,y,im);

    }
}
