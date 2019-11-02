package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LevelController implements Initializable{

    @FXML
    private ImageView background,st1,st2,st3,st4,st5,l1,l2,l3,l4,l5;

    @FXML
    private Button back;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        try
//        {
//            FileInputStream fn1=new FileInputStream("/home/parasmehan123/IdeaProjects/fx1/src/sample/images/LEVEL_PAGE.png");
//            background.setImage(new Image(fn1));
//            FileInputStream lev1=new FileInputStream("/home/parasmehan123/IdeaProjects/fx1/src/sample/images/level1.png");
//            l1.setImage(new Image(lev1));
//            FileInputStream lev2=new FileInputStream("/home/parasmehan123/IdeaProjects/fx1/src/sample/images/level2.png");
//            l2.setImage(new Image(lev2));
//            FileInputStream lev3=new FileInputStream("/home/parasmehan123/IdeaProjects/fx1/src/sample/images/level3.png");
//            l3.setImage(new Image(lev3));
//            FileInputStream lev4=new FileInputStream("/home/parasmehan123/IdeaProjects/fx1/src/sample/images/level4.png");
//            l4.setImage(new Image(lev4));
//            FileInputStream lev5=new FileInputStream("/home/parasmehan123/IdeaProjects/fx1/src/sample/images/level5.png");
//            l5.setImage(new Image(lev5));
//            FileInputStream stop=new FileInputStream("/home/parasmehan123/IdeaProjects/fx1/src/sample/images/stop.png");
////            st2.setImage(new Image(stop));
////            st3.setImage(new Image(stop));
//            st4.setImage(new Image(stop));
////            st5.setImage(new Image(stop));
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
    }

    @FXML
    private void level1(ActionEvent event) throws IOException
    {
//        Parent root= FXMLLoader.load(getClass().getResource("PlayGame.fxml"));
//        Scene sc=new Scene(root);
//        Stage Main_window = (Stage) ((Node)event.getSource()).getScene().getWindow();
//        Main_window.setScene(sc);
//        Main_window.show();
    }

    @FXML
    private void level2()
    {
        System.out.println("2");
    }

    @FXML
    private void level3()
    {
        System.out.println("3");
    }

    @FXML
    private void level4()
    {
        System.out.println("4");
    }

    @FXML
    private void level5()
    {
        System.out.println("5");
    }

    @FXML
    private void backPressed(ActionEvent event) throws IOException
    {
        Parent root= FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        Scene sc=new Scene(root);
        Stage Main_window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Main_window.setScene(sc);
        Main_window.show();
    }
}
