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
import java.util.ArrayList;
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

        TableColumn name=new TableColumn("Name");
        name.setMinWidth(250);
        name.setCellValueFactory(new PropertyValueFactory<Player,String>("player"));

        TableColumn level=new TableColumn("Level");
        level.setCellValueFactory(new PropertyValueFactory<Player, Integer>("num"));

        TableColumn progress=new TableColumn("Progress");
        progress.setMinWidth(250);
        progress.setCellValueFactory(new PropertyValueFactory<Player, Double>("progress"));

        table.getColumns().clear();
        table.getColumns().addAll(name,level,progress);
        ObservableList<GameStatus> list= FXCollections.observableArrayList();
        ArrayList<GameStatus> ar=null;
        try {
            ar=Main2.deserialise();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        for(GameStatus g:ar)
        {
            list.add(g);
        }

        table.setItems(list);


    }

    @FXML
    private void continuePressed(ActionEvent event) throws Exception
    {
        GameStatus selected=(GameStatus) table.getSelectionModel().getSelectedItem();
        Main2.ob.play_game(selected);
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
