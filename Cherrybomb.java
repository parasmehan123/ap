package sample;

import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.IOException;

public class Cherrybomb extends Plant {

    public static Image im;

    static
    {
        String path=Main2.path;
        im=Helper.getImage(path+"Cherrybomb.png");
    }
    public Cherrybomb(int x, int y)
    {
        super(x,y,100);

    }
    @Override
    public Image getIm()
    {
        return im;
    }
}
