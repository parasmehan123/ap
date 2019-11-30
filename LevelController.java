package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LevelController implements Initializable{

    @FXML
    private ImageView stop1,stop2,stop3,stop4,stop5;

    private int n;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            n = Main2.statgame.get_level().getNum();
            if(Main2.statgame.isFinish())
                n+=1;
        }catch (NullPointerException e){n=1;}

        stop1.setVisible(false);
        if(n>=2)
            stop2.setVisible(false);
        if(n>=3)
            stop3.setVisible(false);
        if(n>=4)
            stop4.setVisible(false);
        if(n>=5)
            stop5.setVisible(false);
    }

    @FXML
    private void level1(ActionEvent event) throws Exception {

        if (n >= 1) {
            WaitingPageController.game = new GameStatus(Main2.statgame.getPlayer(), Level1.getInstance());
            Main1.ob.show_screen("WaitingPage.fxml");

        }
    }
    @FXML
    private void level2() throws Exception {
        if(n>=2)
        {
            WaitingPageController.game=new GameStatus(Main2.statgame.getPlayer(),Level2.getInstance());
            Main1.ob.show_screen("WaitingPage.fxml");
        }
    }

    @FXML
    private void level3() throws Exception {
        if(n>=3)
        {
            WaitingPageController.game=new GameStatus(Main2.statgame.getPlayer(),Level3.getInstance());
            Main1.ob.show_screen("WaitingPage.fxml");
        }
    }

    @FXML
    private void level4() throws Exception {
        if(n>=4)
        {
            WaitingPageController.game=new GameStatus(Main2.statgame.getPlayer(),Level4.getInstance());
            Main1.ob.show_screen("WaitingPage.fxml");
        }
    }

    @FXML
    private void level5() throws Exception {
        if(n==5)
        {
            WaitingPageController.game=new GameStatus(Main2.statgame.getPlayer(),Level5.getInstance());
            Main1.ob.show_screen("WaitingPage.fxml");
        }
    }

    @FXML
    private void backPressed(ActionEvent event) throws IOException
    {
        Main1.ob.show_screen("MainMenu.fxml");
    }
}
