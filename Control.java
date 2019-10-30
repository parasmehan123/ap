package sample;

import javafx.animation.PathTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.*;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

public class Control implements Initializable {

    @FXML
    private Text tex;

    @FXML
    private Polygon poly;

    @FXML
    private AnchorPane row1,row2,row3,row4,row5,row6;

    @FXML
    private Button but11,but12,but13,but14,but15,but16,but17,but18,but19,but21,but22,but23,but24,but25,but26,but27,but28,but29,but31,but32,but33,but34,but35,but36,but37,but38,but39,but41,but42,but43,but44,but45,but46,but47,but48,but49;

    @FXML
    private Button but51,but52,but53,but54,but55,but56,but57,but58,but59,but61,but62,but63,but64,but65,but66,but67,but68,but69;

    @FXML
    private Rectangle rec1;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            FileInputStream fn=new FileInputStream("/home/parasmehan123/IdeaProjects/fx1/src/sample/Conehead_Zombie.gif");
            rec1.setFill(new ImagePattern(new Image(fn)));
            TranslateTransition tr=new TranslateTransition(Duration.seconds(4),rec1);
            tr.setByX(-500);
            tr.play();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }


    @FXML
    private void display(MouseEvent event)
    {
        tex.setText("X="+event.getX()+" Y="+event.getY());
    }

    @FXML
    private void print(MouseEvent event)
    {
        Button btn = (Button) event.getSource();
        String id = btn.getId();
        System.out.println("Button"+id+" Clicked!!");
    }
}
