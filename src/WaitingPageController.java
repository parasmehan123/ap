package sample;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;

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
        final long[] star = {System.nanoTime()};
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                if(now- star[0] >5e7)
                {
                    bar.setProgress(bar.getProgress()+0.05);
                    star[0] =now;
                }
                if(bar.getProgress()>=1)
                {
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
