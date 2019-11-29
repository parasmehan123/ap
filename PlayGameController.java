package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

public class PlayGameController implements Initializable {

    private Stage stage;

    @FXML
    private ImageView pea1,cherry1,walnu1,sun1;

    @FXML
    private Text tmp;

    @FXML
    private GridPane lawn;

    public static boolean sunflag,peaflag,walnutflag,cherryflag;

    @FXML
    private AnchorPane main;
    public static AnchorPane statmain;

    public static GameStatus currentStatus;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        stage=Main2.statstage;
        statmain=main;
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

    @FXML
    private void display(MouseEvent event)
    {
        tmp.setText(event.getX()+" "+event.getY());
    }

    //TODO
    public static void handle_plants_button(Map<String,Boolean> plant_available)
    {

    }

}
