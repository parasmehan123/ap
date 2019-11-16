package sample;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

public class PlayGameController implements Initializable {

    @FXML
    private GridPane lawn;

    private boolean ch=false,wal=false,peashooter=false,sunflower=false;

    @FXML
    private ImageView zomb1,lm1,p1,suntoken,pea1,bk1,bk2,suncounter,pause,exitgame;

    public static ImageView statzomb1,statlm1,statp1,statsuntoken,statpea1;

    @FXML
    private AnchorPane main;

    public static AnchorPane statmain;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ch=false;
        wal=false;
        peashooter=false;
        sunflower=false;
        System.out.println("hahahaha");
        statmain=main;
        statp1=p1;
        statzomb1=zomb1;
        statlm1=lm1;
        statsuntoken=suntoken;
        statpea1=pea1;

        FileInputStream fn1= null,fn2=null;
        //        try {
        //            fn1 = new FileInputStream("/home/parasmehan123/IdeaProjects/fx1/src/sample/images/circled-pause.png");
        //            fn2=new FileInputStream("/home/parasmehan123/IdeaProjects/fx1/src/sample/images/EXIT_BUTTON.png");
        //        } catch (FileNotFoundException e) {
        //            e.printStackTrace();
        //        }
        pause.setImage(new Image(fn1));
        exitgame.setImage(new Image(fn2));


    }

    @FXML
    private void cherry()
    {
        ch=true;
        wal=false;
        peashooter=false;
        sunflower=false;
    }

    @FXML
    private void peashooter()
    {
        ch=false;
        wal=false;
        peashooter=true;
        sunflower=false;
    }

    @FXML
    private void walnut()
    {
        ch=false;
        wal=true;
        peashooter=false;
        sunflower=false;
    }
    @FXML
    private void sunflower()
    {
        ch=false;
        wal=false;
        peashooter=false;
        sunflower=true;
    }

}
