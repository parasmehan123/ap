package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PauseMenuController implements Initializable {

    @FXML
    private ImageView background,savegame,restartlevel,resumegame,exitgame;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            FileInputStream fn1 = new FileInputStream("/home/parasmehan123/IdeaProjects/fx1/src/sample/images/PAUSE_MENU.png"), fn2 = new FileInputStream("/home/parasmehan123/IdeaProjects/fx1/src/sample/images/SAVE_GAME_BUTTON.png"), fn3 = new FileInputStream("/home/parasmehan123/IdeaProjects/fx1/src/sample/images/RESTART_LEVL.png"), fn4 = new FileInputStream("/home/parasmehan123/IdeaProjects/fx1/src/sample/images/RESUME_GAME.png"), fn5 = new FileInputStream("/home/parasmehan123/IdeaProjects/fx1/src/sample/images/EXIT_BUTTON.png");
            background.setImage(new Image(fn1));
            savegame.setImage(new Image(fn2));
            restartlevel.setImage(new Image(fn3));
            resumegame.setImage(new Image(fn4));
            exitgame.setImage(new Image(fn5));
        }catch (IOException e){}
    }
}
