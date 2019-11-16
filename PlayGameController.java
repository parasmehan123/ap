package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PlayGameController implements Initializable {

    private Stage stage;

    @FXML
    private ImageView pea1,cherry1,walnu1,sun1;

    @FXML
    private Text tex;

    @FXML
    private GridPane lawn;

    public static boolean sunflag,peaflag,walnutflag,cherryflag;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        stage=Main2.statstage;

        sunflag=false;
        peaflag=false;
        walnutflag=false;
        cherryflag=false;

        Lawn ln=new Lawn(lawn);

    }

    @FXML
    private void sunButton()
    {
        sunflag=true;
        peaflag=false;
        walnutflag=false;
        cherryflag=false;

    }

    @FXML
    private void cherryButton()
    {
        sunflag=false;
        peaflag=false;
        walnutflag=false;
        cherryflag=true;

    }

    @FXML
    private void peaButton()
    {
        sunflag=false;
        peaflag=true;
        walnutflag=false;
        cherryflag=false;

    }

    @FXML
    private void walnutButton()
    {
        sunflag=false;
        peaflag=false;
        walnutflag=true;
        cherryflag=false;

    }





}
