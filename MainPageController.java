package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainPageController implements Initializable {

    @FXML
    private ImageView background;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            FileInputStream fn=new FileInputStream("/home/parasmehan123/IdeaProjects/fx1/src/sample/main_page.png");
            background.setImage(new Image(fn));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
