package sample;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.IOException;

public class SunFlower extends Plant {

    public static Image im;

    private int timetonextSun;

    static
    {
        String path=Main1.path;
        im=Helper.getImage(path+"Sunflower_transparent.gif");
    }

    public SunFlower(int x, int y)
    {
        super(x,y,70);
        this.timetonextSun=10;

    }

    public void oneSecond(){
        timetonextSun=Math.max(0,timetonextSun-1);
        if(timetonextSun==0){
            Button bn=new Button();
            bn.setPrefWidth(75);
            bn.setPrefHeight(75);
            bn.setStyle("-fx-background-color: transparent;");
            ImageView suntok=new ImageView(SunToken.getIm());
            suntok.setFitWidth(75);
            suntok.setFitHeight(75);
            bn.setGraphic(suntok);
            int x1=330+90*this.getX(),y1=130+120*this.getY();
            bn.setLayoutX(x1);
            bn.setLayoutY(y1);
            bn.setOnAction(e->{
                Main2.statgame.increaseSunToken();
                PlayGameController.statmain.getChildren().remove(bn);
            });
            PlayGameController.statmain.getChildren().add(bn);
            this.timetonextSun=10;
        }
    }
    @Override
    public Image getIm()
    {
        return im;
    }
}
