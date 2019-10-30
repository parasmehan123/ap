package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

public class LevelController implements Initializable{

    @FXML
    private ImageView background;

    @FXML
    private Button back;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try
        {
            FileInputStream fn=new FileInputStream("/home/parasmehan123/IdeaProjects/fx1/src/sample/images/LEVEL_PAGE.png");
            background.setImage(new Image(fn));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void level1()
    {
        System.out.println("");
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
    private void backPressed()
    {
        System.out.println("Back Button Pressed!!");
    }
}
