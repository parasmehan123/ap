package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PauseMenuController implements Initializable {

    public boolean save_flag;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        save_flag=true;
    }

    @FXML
    private void save_game() throws IOException, ClassNotFoundException {
        if(save_flag)
        {
            Main2.serialize(Main2.statgame);
            System.out.println("Game Saved!!!!!!!!!!");
            save_flag=false;
        }
        else
            System.out.println("Game not saved - already saved!!!!!");

    }

    @FXML
    private void restart_level() throws Exception {
        LevelStatus l=Main2.statgame.get_level();
        GameStatus new_game=null;
        if(l.getNum()==1)
            new_game=new GameStatus(Main2.statgame.getPlayer(),Level1.getInstance());
        else if(l.getNum()==2)
            new_game=new GameStatus(Main2.statgame.getPlayer(),Level2.getInstance());
        else if(l.getNum()==3)
            new_game=new GameStatus(Main2.statgame.getPlayer(),Level3.getInstance());
        else if(l.getNum()==4)
            new_game=new GameStatus(Main2.statgame.getPlayer(),Level4.getInstance());
        else
            new_game=new GameStatus(Main2.statgame.getPlayer(),Level5.getInstance());
        Main2.ob.play_game(new_game);
    }

    @FXML
    private void resume_game() throws Exception {
        Main2.ob.play_game(Main2.statgame);
    }

    @FXML
    private void exit_game() throws IOException {
        Main1.ob.show_screen("MainMenu.fxml");
    }
}
