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

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;

public class Main1 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root=FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        primaryStage.setTitle("PlantsVsZombies");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

//        BufferedReader br=new BufferedReader(new FileReader("/Users/pawanmehan/ap_project/src/sample/path.txt"));
//        System.out.println(br.readLine());

    }


    public static void main(String[] args) {
        launch(args);
    }

}