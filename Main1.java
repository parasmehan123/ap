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

import java.io.*;
import java.util.ArrayList;

public class Main1{

//    @Override
//    public void start(Stage primaryStage) throws Exception {
//
//        Parent root=FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
//        primaryStage.setTitle("PlantsVsZombies");
//        primaryStage.setScene(new Scene(root));
//        primaryStage.show();

//        BufferedReader br=new BufferedReader(new FileReader("/Users/pawanmehan/ap_project/src/sample/path.txt"));
//        System.out.println(br.readLine());




    public static void main(String[] args)throws IOException {
//        launchnch(args);


        ArrayList<GameStatus> gs = new ArrayList<>();
        ObjectOutputStream out = null;
        try{
            out  = new ObjectOutputStream(new FileOutputStream("/home/tejas/IdeaProjects/ap/src/sample/save.txt"));
            out.writeObject(gs);
        }
        catch (Exception e){

        }
        finally {
            if(out!= null){
                out.close();
            }
        }
    }
}