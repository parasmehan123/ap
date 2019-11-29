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

    public static GameStatus statgame;

    @Override
    public void start(Stage primaryStage) throws Exception {


        BufferedReader br = new BufferedReader(new FileReader("/Users/pawanmehan/ap_project/src/sample/path.txt"));
        path=br.readLine();

        GameStatus game=new GameStatus("Player",1);
        statgame=game;

        Parent root=FXMLLoader.load(getClass().getResource("PlayGame.fxml"));
        primaryStage.setTitle("PlantsVsZombies");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
        statstage=primaryStage;


        long tmp=System.nanoTime();
        final long[] star = {tmp,tmp,tmp};

        initialise_play_game();

        new AnimationTimer()
        {

            @Override
            public void handle(long now) {

                /*TODO
                zombie_reached_plant();

                remove_dead_characters();

                peas_attack_zombies();

                zombie_reached_home();

                increase_timer();

                unlock_plants();

                spwan_zombies();

                zombie_attacking_plant();

                sunflower
                */

                if((now - star[1]) > 10e9) {
                    SunToken.sky();
                    star[1] = now;
                }
                if((now-star[2]>1e9)){
                    game.one_second();

                    PlayGameController.handle_plants_button(game.which_plants_available());


                }

            }
        }.start();


    }


    public static void initialise_play_game(){


    }


    public static void main(String[] args) {
        launch(args);
    }

}