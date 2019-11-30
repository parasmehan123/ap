package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
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
    private Text tmp,sun_token_display;
    public static Text stat_sun_token_display;

    @FXML
    private GridPane lawn;

    public static boolean sunflag,peaflag,walnutflag,cherryflag;

    @FXML
    private AnchorPane main;
    public static AnchorPane statmain;

    @FXML
    private VBox plant_box;
    private static VBox stat_plant_box;

    @FXML
    private ImageView stop_sun,stop_cherry,stop_pea,stop_walnut;
    private static ImageView stat_stop_sun,stat_stop_cherry,stat_stop_pea,stat_stop_walnut;

    public static Lawn ln;

    public static ArrayList<Lawn_Mover> lawn_movers;

    @FXML
    public ImageView mover1,mover2,mover3,mover4,mover5;
    public static ImageView stat_mover1,stat_mover2,stat_mover3,stat_mover4,stat_mover5;

    private static GameStatus game;

    @FXML
    private ProgressBar progress_bar;
    private static ProgressBar stat_progress_bar;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        stage=Main2.statstage;
        stat_plant_box=plant_box;
        statmain=main;
        stat_stop_sun=stop_sun;
        stat_stop_cherry=stop_cherry;
        stat_stop_pea=stop_pea;
        stat_stop_walnut=stop_walnut;
        stat_sun_token_display=sun_token_display;
        stat_progress_bar=progress_bar;

        stat_mover1=mover1;
        stat_mover2=mover2;
        stat_mover3=mover3;
        stat_mover4=mover4;
        stat_mover5=mover5;
        game=Main2.statgame;

        sunflag=false;
        peaflag=false;
        walnutflag=false;
        cherryflag=false;
        ln=new Lawn(lawn);
        lawn_movers=new ArrayList<>();
        init_lawn_movers();
        set_sun_tokens_display(game.getSun_tokens_collected());
        handle_plants_button(game.which_plants_available());
        progress_bar.setProgress(0);
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

    public static void init_lawn_movers()
    {
        if(!game.is_lm_available(0))
            statmain.getChildren().remove(stat_mover1);

        if(!game.is_lm_available(1))
            statmain.getChildren().remove(stat_mover2);

        if(!game.is_lm_available(2))
            statmain.getChildren().remove(stat_mover3);

        if(!game.is_lm_available(3))
            statmain.getChildren().remove(stat_mover4);

        if(!game.is_lm_available(4))
            statmain.getChildren().remove(stat_mover5);

        lawn_movers.add(new Lawn_Mover(0,stat_mover1));
        lawn_movers.add(new Lawn_Mover(1,stat_mover2));
        lawn_movers.add(new Lawn_Mover(2,stat_mover3));
        lawn_movers.add(new Lawn_Mover(3,stat_mover4));
        lawn_movers.add(new Lawn_Mover(4,stat_mover5));

    }

    public static Lawn_Mover get_lawn_mover(int i)
    {
        return lawn_movers.get(i);
    }

    @FXML
    public void pause_button_clicked()
    {
        Main2.save_flag=false;
    }

    public static void set_sun_tokens_display(int i)
    {
        stat_sun_token_display.setText(String.valueOf(i));
    }

    public static void change_progress(double i)
    {
        stat_progress_bar.setProgress(i);
    }

}
