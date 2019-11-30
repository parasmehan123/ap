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

        Main1.ob.show_screen("Login.fxml");
    }

    @FXML
    private void loadGamePressed(ActionEvent event) throws IOException
    {
        Main1.ob.show_screen("LoadGame.fxml");
    }

    @FXML
    private void instructionsPressed(ActionEvent event) throws IOException
    {
        Main1.ob.show_screen("Instructions.fxml");

    }

    @FXML
    private void leaderPressed(ActionEvent event) throws IOException
    {
        Main1.ob.show_screen("LeaderBoard.fxml");
    }

    @FXML
    private void exitPressed(ActionEvent event) throws IOException
    {
        ((Stage) ((Node)event.getSource()).getScene().getWindow()).close();

    }

    @FXML
    private void chooselevel(ActionEvent event) throws IOException
    {
        Main2.statgame=new GameStatus("John Doe",Level5.getInstance());
        Main1.ob.show_screen("Level.fxml");
    }
}
