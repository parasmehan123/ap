package sample;


import javafx.scene.image.Image;

public abstract class Plant extends Character{


    protected Plant(int x,int y,int health)
    {
        super(x,y,health);
    }

    public abstract Image getIm();

}
