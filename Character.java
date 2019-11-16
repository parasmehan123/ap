package sample;

import javafx.scene.image.Image;

public abstract class Character {

    private int x;

    private Image im;

    public Character(int x,Image im)
    {
        this.x=x;
        this.im=im;
    }


    public int getX() {
        return x;
    }


    public Image getIm() {
        return im;
    }
}
