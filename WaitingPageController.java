package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

import java.lang.*;
public class WaitingPageController implements Initializable {

    @FXML
    private ImageView background;

    @FXML
    private  ProgressBar bar;

    public static ProgressBar statbar;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        statbar=bar;
    }

}
