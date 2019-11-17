package sample;


import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.IOException;

public class Helper {


    public static Image getImage(String path)
    {
        Image im=null;
        try
        {
            FileInputStream fn=new FileInputStream(path);
            im=new Image(fn);
        }catch (IOException E){}
        return im;
    }

}
