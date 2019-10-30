package sample;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;

public class Main extends Application {

    public static Stage statStage;

    @Override
    public void start(Stage primaryStage) throws Exception {

        statStage=primaryStage;
        Parent root=FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        primaryStage.setTitle("PlantsVsZombies");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }

}