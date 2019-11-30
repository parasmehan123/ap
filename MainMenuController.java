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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private void startNewGamePressed(ActionEvent event) throws IOException {

        Parent root=FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene sc=new Scene(root);
        Stage Main_window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Main_window.setScene(sc);
        Main_window.show();
    }

    @FXML
    private void loadGamePressed(ActionEvent event) throws IOException
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

    @FXML
    private void chooselevel(ActionEvent event) throws IOException
    {
        //TODO
    }
}
