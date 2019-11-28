package sample;

import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.IOException;

public class Walnut extends Plant {

    public static Image im;

    static
    {
        String path=Main2.path;
        im=Helper.getImage(path+"walnut.gif");
    }

    public Walnut(int x, int y)
    {
        super(x,y,im);

    }
}
