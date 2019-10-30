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

public class InstructionsController implements Initializable {


    @FXML
    private ImageView background;

    @FXML
    private Button back;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try
        {
            FileInputStream fn=new FileInputStream("/home/parasmehan123/IdeaProjects/fx1/src/sample/images/INSTRUCTION_PAGE.png");
            background.setImage(new Image(fn));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    @FXML
    private void backPressed()
    {
        System.out.println("Back Button Pressed!!");
    }
}
