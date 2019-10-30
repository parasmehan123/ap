package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoadGameController implements Initializable{

    @FXML
    private ImageView background;

    @FXML
    private Button back;

    @FXML
    private TableView table;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try
        {
            FileInputStream fn=new FileInputStream("/home/parasmehan123/IdeaProjects/fx1/src/sample/images/SAVED_GAME.png");
            background.setImage(new Image(fn));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        TableColumn rank=new TableColumn("Rank");
        rank.setCellValueFactory(new PropertyValueFactory<Player, Integer>("rank"));

        TableColumn name=new TableColumn("Name");
        name.setMinWidth(250);
        name.setCellValueFactory(new PropertyValueFactory<Player,String>("name"));

        TableColumn level=new TableColumn("Level");
        level.setCellValueFactory(new PropertyValueFactory<Player, Integer>("level"));

        TableColumn completed=new TableColumn("Completed");
        completed.setMinWidth(250);
        completed.setCellValueFactory(new PropertyValueFactory<Player, Boolean>("completed"));

        table.getColumns().clear();
        table.getColumns().addAll(rank,name,level,completed);
        ObservableList<Player> list= FXCollections.observableArrayList(
                new Player(1,"Player1",5,true),
                new Player(2,"Player2",5,false),
                new Player(3,"Player3",4,true),
                new Player(4,"Player4",4,false),
                new Player(5,"Player5",1,true));

        table.setItems(list);


    }

    @FXML
    private void backPressed()
    {
        System.out.println("Back Button Pressed!!");
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
