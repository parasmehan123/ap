package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HandleScreens {

    public void handle(String screen,Stage Main_window) throws IOException {
        if(screen.equals("Level.fxml"))
        {
            Parent root= FXMLLoader.load(getClass().getResource("Level.fxml"));
            Scene sc=new Scene(root);
            Main_window.setScene(sc);
            Main_window.show();
        }
    }
}
