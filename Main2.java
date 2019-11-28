package sample;
import javafx.animation.AnimationTimer;
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

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;

public class Main2 extends Application {

    public static Stage statstage;

    public static String path;

    @Override
    public void start(Stage primaryStage) throws Exception {


        BufferedReader br = new BufferedReader(new FileReader("/Users/pawanmehan/ap_project/src/sample/path.txt"));
        path=br.readLine();

        Parent root=FXMLLoader.load(getClass().getResource("PlayGame.fxml"));
        primaryStage.setTitle("PlantsVsZombies");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
        statstage=primaryStage;

        final int[] co = {0};
        final long[] star = {System.nanoTime()};
        new AnimationTimer()
        {

            @Override
            public void handle(long now) {
                if((now - star[0]) > 5e9) {
                    SunToken.sky();
                    star[0] = now;
                }

            }
        }.start();
//        ImageView zomb1=PlayGameController.statzomb1,lm1=PlayGameController.statlm1;
//        TranslateTransition tr=new TranslateTransition(Duration.seconds(25),zomb1);
//        tr.setByX(-1300);
//        tr.play();
//
//        Image im1=PlayGameController.statp1.getImage(),im2=PlayGameController.statsuntoken.getImage();
//        ImageView pea=PlayGameController.statpea1;
//        Image im3=pea.getImage();
//
//        pea.setImage(null);
//        PlayGameController.statsuntoken.setImage(null);
//        PlayGameController.statp1.setImage(null);
//
//        tr.setOnFinished(e->{
//            zomb1.setImage(null);
//            TranslateTransition tr2=new TranslateTransition(Duration.seconds(4),lm1);
//            tr2.setByX(+1560);
//            tr2.play();
//            tr2.setOnFinished(e2->{
//                lm1.setImage(null);
//                PlayGameController.statsuntoken.setImage(im2);
//                TranslateTransition tr3=new TranslateTransition(Duration.seconds(5),PlayGameController.statsuntoken);
//                tr3.setByY(500);
//                tr3.play();
//                tr3.setOnFinished(e3->{
//                    pea.setImage(im3);
//                    PlayGameController.statp1.setImage(im1);
//                    TranslateTransition tr4=new TranslateTransition(Duration.seconds(5),pea);
//                    tr4.setByX(1500);
//                    tr4.play();
//                });
//
//            });
//        });

    }


    public static void main(String[] args) {
        launch(args);
    }

}