package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.ResourceBundle;

public class PlayGameController implements Initializable {

    private Stage stage;

    @FXML
    private Text tmp;

    @FXML
    private GridPane lawn;

    public static boolean sunflag,peaflag,walnutflag,cherryflag;

    @FXML
    private AnchorPane main;
    public static AnchorPane statmain;

    public static GameStatus currentStatus;

    @FXML
    private VBox plant_box;
    private static VBox stat_plant_box;

    @FXML
    private ImageView stop_sun,stop_cherry,stop_pea,stop_walnut;
    private static ImageView stat_stop_sun,stat_stop_cherry,stat_stop_pea,stat_stop_walnut;

    public static Lawn ln;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        stage=Main2.statstage;
        stat_plant_box=plant_box;
        statmain=main;
        stat_stop_sun=stop_sun;
        stat_stop_cherry=stop_cherry;
        stat_stop_pea=stop_pea;
        stat_stop_walnut=stop_walnut;
        currentStatus=Main2.statgame;
        sunflag=false;
        peaflag=false;
        walnutflag=false;
        cherryflag=false;
        ln=new Lawn(lawn);
        handle_plants_button(currentStatus.which_plants_available());
    }

    @FXML
    private void sunButton()
    {
        sunflag=true;
        peaflag=false;
        walnutflag=false;
        cherryflag=false;
        System.out.println("clicked");
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
        ArrayList<String> plant_names = new ArrayList<String>(Arrays.asList(new String[]{"Peashooter", "Walnut", "Cherrybomb", "SunFlower"}));
        if(!plant_available.get("Peashooter"))
            stat_stop_pea.setVisible(true);
        else
            stat_stop_pea.setVisible(false);
        if(!plant_available.get("Walnut"))
            stat_stop_walnut.setVisible(true);
        else
            stat_stop_walnut.setVisible(false);
        if(!plant_available.get("Cherrybomb"))
            stat_stop_cherry.setVisible(true);
        else
            stat_stop_cherry.setVisible(false);
        if(!plant_available.get("SunFlower"))
            stat_stop_sun.setVisible(true);
        else
            stat_stop_sun.setVisible(false);
    }

}
