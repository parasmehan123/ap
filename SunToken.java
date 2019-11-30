package sample;


import javafx.animation.TranslateTransition;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class SunToken {

    private static Image im;

    static
    {
        String path=Main1.path;
        im=Helper.getImage(path+"suntoken.png");
    }

    public SunToken()
    {

    }

    public static Image getIm() {
        return im;
    }

    public static void sky()
    {
        Button bn=new Button();
        bn.setPrefWidth(75);
        bn.setPrefHeight(75);
        bn.setStyle("-fx-background-color: transparent;");
        ImageView suntok=new ImageView(im);
        suntok.setFitWidth(75);
        suntok.setFitHeight(75);
        bn.setGraphic(suntok);
        bn.setLayoutY(0);
        bn.setLayoutX(300+Math.random()*600);
        bn.setOnAction(e->{
            Main2.statgame.increaseSunToken();
            PlayGameController.statmain.getChildren().remove(bn);
        });
        TranslateTransition tr=new TranslateTransition(Duration.seconds(10),bn);
        tr.setByY(150+Math.random()*500);
        PlayGameController.statmain.getChildren().add(bn);
        tr.play();

    }
}
