package sample;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import java.lang.*;
public class WaitingPageController implements Initializable {

    @FXML
    private ProgressBar bar;

    public static GameStatus game;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        bar.setProgress(0);
        long tmp=System.nanoTime();
        //Media media = new Media(new File("/Users/pawanmehan/ap_project/src/sample/images/mario_game_over.mp3").toURI().toString());
        //MediaPlayer mediaPlayer = new MediaPlayer(media);

        //System.out.println(url.toString());
        final long[] star = {tmp,tmp};
        final boolean[] flag = {true};
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                if(now- star[0] >5e8)
                {
                    bar.setProgress(bar.getProgress()+0.1);
                    star[0] =now;
                }
                if(now-star[1]>5e9){
                    System.out.println("hahaha");
                    try {
                        Main1.ob.show_screen("Level.fxml");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        Main2.ob.play_game(game);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    stop();
                }
            }
        }.start();

    }
}
