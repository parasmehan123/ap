package sample;
import com.sun.xml.internal.ws.message.saaj.SAAJHeader;
import javafx.animation.AnimationTimer;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main2 extends Application {

    public static Stage statstage;

    public static String path;

    public static GameStatus statgame;

    public static Map<Zombie,ImageView> zomb_im=new HashMap<Zombie,ImageView>();

    public static Map<Pea,ImageView> pea_im=new HashMap<Pea,ImageView>();

    public static Map<Zombie, Boolean> ShouldZombieStop = new HashMap<Zombie, Boolean>();

    @Override
    public void start(Stage primaryStage) throws Exception {


        BufferedReader br = new BufferedReader(new FileReader("/Users/pawanmehan/ap_project/src/sample/path.txt"));
        path=br.readLine();

        GameStatus game=new GameStatus("Player",1);
        statgame=game;


        Parent root=FXMLLoader.load(getClass().getResource("PlayGame.fxml"));
        primaryStage.setTitle("PlantsVsZombies");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
        statstage=primaryStage;


        long tmp=System.nanoTime();
        final long[] star = {tmp,tmp,tmp};

        initialise_play_game();

        spawn_pea(0,1);
        spawn_zombie(1,1);
        new AnimationTimer()
        {

            @Override
            public void handle(long now) {

                /*TODO
                zombie_reached_plant();

                remove_dead_characters();

                peas_attack_zombies();

                zombie_reached_home();

                increase_timer();

                unlock_plants();

                zombie_attacking_plant();

                sunflower
                */

                if((now - star[0]) > 10e9) {
                    SunToken.sky();
                    star[0] = now;
                }
                if((now-star[1]>1e9)){
                    game.one_second();
                    PlayGameController.handle_plants_button(game.which_plants_available());
                    star[1]= now;
                }
                if(now-star[2]>1e9){
                    move_zombies(0.5);
                    ArrayList<Pea> tmp=new ArrayList<>();
                    pea_im.forEach((k,v)->{
                        if(k.CheckCollision(game.getZombies(),v))
                            tmp.add(k);
                    });
                    ZombieCollideWithPLant(game.getPlants(), game.getZombies());
                }

            }
        }.start();


    }


    public static void initialise_play_game(){ }


    public static void buy_plant(int x,int y)
    {
        Map<String,Boolean> avail=statgame.which_plants_available();
        boolean sunflag=PlayGameController.sunflag,peaflag=PlayGameController.peaflag,walnutflag=PlayGameController.walnutflag,cherryflag=PlayGameController.cherryflag;
        boolean flag=false;
        Plant pl=null;

        //new String[]{"Peashooter", "Walnut", "Cherrybomb", "SunFlower"}))
        if(sunflag==true && cherryflag==false && peaflag==false && walnutflag==false && avail.get("SunFlower"))
        {
            flag=true;
            pl=new SunFlower(x,y);
            statgame.increase_time("SunFlower",10);
        }
        else if(cherryflag==true && sunflag==false && peaflag==false && walnutflag==false && avail.get("Cherrybomb"))
        {
            flag=true;
            pl=new Cherrybomb(x,y);
            statgame.increase_time("Cherrybomb",10);
        }
        else if(peaflag==true && sunflag==false && cherryflag==false && walnutflag==false && avail.get("Peashooter"))
        {
            flag=true;
            pl=new Peashooter(x,y);
            statgame.increase_time("Peashooter",10);

        }
        else if(walnutflag==true && sunflag==false && cherryflag==false && peaflag==false && avail.get("Walnut"))
        {
            flag=true;
            pl=new Walnut(x,y);
            statgame.increase_time("Walnut",10);
        }

        if(flag) {
            statgame.addPlant(pl);
            ImageView tmp = PlayGameController.ln.plants.get(y).get(x);
            tmp.setImage(pl.getIm());
            tmp.setFitWidth(100);
            tmp.setFitHeight(150);

        }
        PlayGameController.sunflag=false;
        PlayGameController.peaflag=false;
        PlayGameController.walnutflag=false;
        PlayGameController.cherryflag=false;

    }

    public static void spawn_zombie(int y,int type)
    {
        Zombie zm=null;
        ImageView iv=new ImageView();
        if(type==1) {
            zm = new Zombie(1200, 130 + 120 * y, 100, 10);
            iv.setImage(Zombie.normal_image);
        }
        else {
            zm = new Zombie(1200, 130 + 120 * y, 100, 10);
            iv.setImage(Zombie.conehead_image);
        }
        iv.setFitWidth(150);
        iv.setFitHeight(150);
        iv.setLayoutX(1000);
        iv.setLayoutY(130+120*y);
        zomb_im.put(zm,iv);
        statgame.addZombie(zm);
        PlayGameController.statmain.getChildren().add(iv);
        ShouldZombieStop.put(zm, false);

    }

    public static void spawn_pea(int x,int y)
    {

        Pea pea=new Pea(320+90*x,130+120*y);
        ImageView iv=new ImageView();
        iv.setImage(Pea.im);
        iv.setFitWidth(25);
        iv.setFitHeight(25);
        iv.setLayoutX(320+90*x);
        iv.setLayoutY(130+120*y);
        pea_im.put(pea,iv);
        statgame.addPea(pea);
        PlayGameController.statmain.getChildren().add(iv);

    }

    public static void move_zombies(double delta)
    {
        zomb_im.forEach((k,v)->{
            if(!ShouldZombieStop.get(k)) {
                v.setLayoutX(Math.max(0, v.getLayoutX() - delta));
                k.setX((int) v.getLayoutX());
            }
        });
    }

    public static void move_pea(double delta)
    {
        pea_im.forEach((k,v)->{
            v.setLayoutX(Math.min(1200,v.getLayoutX()+delta));
            k.setX((int)v.getLayoutX());
        });
    }

    public static void ZombieCollideWithPLant(ArrayList<Plant> arrPLants, ArrayList<Zombie> arrzomb){
        for(Plant tempP : arrPLants){
            for(Zombie tempz: arrzomb){
                if((320+90*tempP.getX()- tempz.getX())== 90 && Math.abs(130+120*tempP.getY()-tempz.getY())<=20){
                    tempz.attack(tempP);
                    System.out.println(tempP.getHealth());
                    ShouldZombieStop.put(tempz, true);
                }
            }
        }

    }
    public static void main(String[] args) {
        launch(args);
    }

}