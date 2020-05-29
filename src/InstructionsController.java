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

public class InstructionsController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    @FXML
    private void backPressed(ActionEvent event) throws IOException
    {
        Main1.ob.show_screen("MainMenu.fxml");
    }
    @FXML
    private void frontPressed() throws IOException
    {
        Main1.ob.show_screen("Instructions2.fxml");
    }
}
