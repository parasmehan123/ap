package sample;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene sc=new Scene(new VBox(new Label("A JavaFX Label")));
        sc.setCursor(Cursor.OPEN_HAND);
        primaryStage.setScene(sc);
        primaryStage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}