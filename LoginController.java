package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private TextField username;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private void continuePressed(ActionEvent event) throws IOException
    {
        Parent root= FXMLLoader.load(getClass().getResource("Level.fxml"));
        Scene sc=new Scene(root);
        Stage Main_window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Main_window.setScene(sc);
        Main_window.show();
//        Player selected=(Player) table.getSelectionModel().getSelectedItem();
//        System.out.println("Player with rank "+selected.getRank()+" selected.");
    }

    @FXML
    private void backPressed(ActionEvent event) throws IOException
    {
        Parent root= FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        Scene sc=new Scene(root);
        Stage Main_window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Main_window.setScene(sc);
        Main_window.show();
    }
}
