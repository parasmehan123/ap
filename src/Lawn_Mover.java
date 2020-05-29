package sample;


import javafx.scene.image.ImageView;

public class Lawn_Mover {

    private ImageView im;
    private int y;

    public Lawn_Mover(int y,ImageView im)
    {
        this.im=im;
        this.y=y;
    }

    public ImageView getIm() {
        return im;
    }

    public int getY() {
        return y;
    }
}
