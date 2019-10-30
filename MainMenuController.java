package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

public class MainMenuController implements Initializable {

    @FXML
    private StackPane rootPane;

    @FXML
    private ImageView background,start_game,resume_game,instructions,leaderboard,exit;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            FileInputStream fn1=new FileInputStream("/home/parasmehan123/IdeaProjects/fx1/src/sample/images/MAIN_PAGE.png");
            background.setImage(new Image(fn1));
            FileInputStream fn2=new FileInputStream("/home/parasmehan123/IdeaProjects/fx1/src/sample/images/START_NEW_GAME.png");
            start_game.setImage(new Image(fn2));
            FileInputStream fn3=new FileInputStream("/home/parasmehan123/IdeaProjects/fx1/src/sample/images/RESUME_GAME.png");
            resume_game.setImage(new Image(fn3));
            FileInputStream fn4=new FileInputStream("/home/parasmehan123/IdeaProjects/fx1/src/sample/images/INSTRUCTION_MAIN_BUTTON.png");
            instructions.setImage(new Image(fn4));
            FileInputStream fn5=new FileInputStream("/home/parasmehan123/IdeaProjects/fx1/src/sample/images/LEADERBOARDS_BUTTON.png");
            leaderboard.setImage(new Image(fn5));
            FileInputStream fn6=new FileInputStream("/home/parasmehan123/IdeaProjects/fx1/src/sample/images/EXIT_BUTTON.png");
            exit.setImage(new Image(fn6));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

    @FXML
    private void startNewGamePressed(ActionEvent event) throws IOException {

        //change this######################################################################################################################################################################
        Parent root=FXMLLoader.load(getClass().getResource("Instructions.fxml"));
        //change this######################################################################################################################################################################
        Scene sc=new Scene(root);
        Stage Main_window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Main_window.setScene(sc);
        Main_window.show();
    }

    @FXML
    private void resumeGamePressed(ActionEvent event) throws IOException
    {
        Parent root=FXMLLoader.load(getClass().getResource("LoadGame.fxml"));
        Scene sc=new Scene(root);
        Stage Main_window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Main_window.setScene(sc);
        Main_window.show();
    }

    @FXML
    private void instructionsPressed(ActionEvent event) throws IOException
    {
        Parent root=FXMLLoader.load(getClass().getResource("Instructions.fxml"));
        Scene sc=new Scene(root);
        Stage Main_window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Main_window.setScene(sc);
        Main_window.show();
    }

    @FXML
    private void leaderPressed(ActionEvent event) throws IOException
    {
        Parent root=FXMLLoader.load(getClass().getResource("LeaderBoard.fxml"));
        Scene sc=new Scene(root);
        Stage Main_window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Main_window.setScene(sc);
        Main_window.show();
    }

    @FXML
    private void exitPressed(ActionEvent event) throws IOException
    {
        ((Stage) ((Node)event.getSource()).getScene().getWindow()).close();

    }
}
