package sample;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.FileInputStream;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root=FXMLLoader.load(getClass().getResource("PlayGame.fxml"));
        primaryStage.setTitle("PlantsVsZombies");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

        ImageView zomb1=PlayGameController.statzomb1,lm1=PlayGameController.statlm1;
        TranslateTransition tr=new TranslateTransition(Duration.seconds(25),zomb1);
        tr.setByX(-1300);
        tr.play();

        Image im1=PlayGameController.statp1.getImage(),im2=PlayGameController.statsuntoken.getImage();
        ImageView pea=PlayGameController.statpea1;
        Image im3=pea.getImage();

        pea.setImage(null);
        PlayGameController.statsuntoken.setImage(null);
        PlayGameController.statp1.setImage(null);

        tr.setOnFinished(e->{
            zomb1.setImage(null);
            TranslateTransition tr2=new TranslateTransition(Duration.seconds(4),lm1);
            tr2.setByX(+1560);
            tr2.play();
            tr2.setOnFinished(e2->{
                lm1.setImage(null);
                PlayGameController.statsuntoken.setImage(im2);
                TranslateTransition tr3=new TranslateTransition(Duration.seconds(5),PlayGameController.statsuntoken);
                tr3.setByY(500);
                tr3.play();
                tr3.setOnFinished(e3->{
                    pea.setImage(im3);
                    PlayGameController.statp1.setImage(im1);
                    TranslateTransition tr4=new TranslateTransition(Duration.seconds(5),pea);
                    tr4.setByX(1500);
                    tr4.play();
                });

            });
        });


//                AnchorPane main=PlayGameController.statmain;

//        Circle c=new Circle();
//        c.setRadius(27);
//        c.setCenterX(675);
//        c.setCenterY(583);
//        c.setFill(Color.web("0x0c6b02",1));
//        PlayGameController.statmain.getChildren().add(c);
//        TranslateTransition tr2=new TranslateTransition(Duration.seconds(10),c);
//        tr2.setByX(1000);
//        tr2.play();






    }


    public static void main(String[] args) {
        launch(args);
    }

}