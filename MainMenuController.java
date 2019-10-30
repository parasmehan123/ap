package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

public class MainMenuController implements Initializable {

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
    private void startNewGamePressed()
    {

    }

    @FXML
    private void resumeGamePressed()
    {

    }

    @FXML
    private void instructionsPressed()
    {

    }

    @FXML
    private void leaderPressed()
    {

    }

    @FXML
    private void exitPressed()
    {

    }
}
