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

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main2 extends Application {

    public static Stage statstage;

    public static String path;

    public static GameStatus statgame;

    public static Map<Zombie,ImageView> zomb_im=new HashMap<Zombie,ImageView>();

    public static Map<Pea,ImageView> pea_im=new HashMap<Pea,ImageView>();

    public static Map<Zombie, Boolean> ShouldZombieStop = new HashMap<Zombie, Boolean>();

    public static ArrayList<Lawn_Mover> moving_lawn_mover=new ArrayList<>();

    public static boolean save_flag=true;

    @Override
    public void start(Stage primaryStage) throws Exception {

        //TODO - save lawn mover

        BufferedReader br = new BufferedReader(new FileReader("/Users/pawanmehan/ap_project/src/sample/path.txt"));
        path=br.readLine();

        ArrayList<GameStatus> save=deserialise();
        GameStatus game=null;
        if(save.size()==0)
        {
            System.out.println("YES1");
            game=new GameStatus("Player",Level1.getInstance());
            save.add(game);
        }
        else
        {
            game=save.get(0);
            System.out.println(game.getZombies().size());
            System.out.println("now i am called");
        }

        statgame=game;
        System.out.println("No of tokens:"+game.getSun_tokens_collected());

        Parent root=FXMLLoader.load(getClass().getResource("PlayGame.fxml"));
        primaryStage.setTitle("PlantsVsZombies");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);

        statstage=primaryStage;

        initialise_play_game();
        primaryStage.show();
        LevelStatus level=game.get_level();
        //spawn_pea(0,1);

        long tmp=System.nanoTime();
        final long[] star = {tmp,tmp,tmp,tmp,tmp};
        new AnimationTimer()
        {

            @Override
            public void handle(long now) {

                if(!save_flag)
                {
                    System.out.println("saved");
                    try {
                        serialize(save);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    stop();
                }
                if((now - star[0]) > 10e9) {
                    SunToken.sky();
                    star[0] = now;
                    cherry_bomb_blast();

                }
                if((now-star[1]>1e9)){
                    statgame.one_second();
                    PlayGameController.handle_plants_button(statgame.which_plants_available());
                    spawn_sun_tokens();

                    star[1]= now;
                }
                if(now-star[2]>level.getTime()*1e9)
                {
                    Map<Integer,Integer> mp=level.getMap();
                    Random rand=new Random();
                    int yf = -1;
                    while(yf == -1 && level.isZombieAvailable())
                    {
//                        spawn_zombie(rand.nextInt(5)5);
                        int y = rand.nextInt(2);
                        if(mp.containsKey(y+1) && mp.get(y+1)>0){
                            yf = y+1;
                        }
                    }
                    spawn_zombie(1000,rand.nextInt(5), yf,null);
                    mp.put(yf, mp.get(yf)-1);
                    star[2]=now;
                }
                if(now-star[3]>1e9)
                {
                    peashooting();
                    star[3]=now;
                }

                move_zombies(0.5);

                ArrayList<Pea> tmp2=new ArrayList<>();
                pea_im.forEach((k,v)->{
                    if (k.CheckCollision(statgame.getZombies(), v))
                        tmp2.add(k);
                });

                for(Pea tmp3: tmp2)
                    pea_im.remove(tmp3);

                ZombieCollideWithPLant(statgame.getPlants(), statgame.getZombies());
                move_lawn_mover(5);
                move_pea(4);
            }
        }.start();

    }


    public static void initialise_play_game(){

        ArrayList<Zombie> zombie=statgame.getZombies();
        for(Zombie z:zombie)
        {
            spawn_zombie(z.getX(),z.getY(),z.getType(),z);
        }
        ArrayList<Plant> plan=statgame.getPlants();
        for(Plant pl:plan) {
            ImageView tmp = PlayGameController.ln.plants.get(pl.getY()).get(pl.getX());
            tmp.setImage(pl.getIm());
            tmp.setFitWidth(100);
            tmp.setFitHeight(150);
        }

        ArrayList<Pea> peas=statgame.getPeas();
        for(Pea pea:peas)
        {
            spawn_pea(pea.getX(),pea.getY(),pea);
        }
    }


    public static void buy_plant(int x,int y)
    {
        Map<String,Boolean> avail=statgame.which_plants_available();
        boolean sunflag=PlayGameController.sunflag,peaflag=PlayGameController.peaflag,walnutflag=PlayGameController.walnutflag,cherryflag=PlayGameController.cherryflag;
        boolean flag=false;
        Plant pl=null;
        ImageView tmp = PlayGameController.ln.plants.get(y).get(x);


        //new String[]{"Peashooter", "Walnut", "Cherrybomb", "SunFlower"}))
        if(sunflag==true && cherryflag==false && peaflag==false && walnutflag==false && avail.get("SunFlower") && tmp.getImage()==null)
        {
            flag=true;
            pl=new SunFlower(x,y);
            statgame.increase_time("SunFlower",10);
            statgame.decrase_sun_tokens_collected(statgame.getPrice("SunFlower"));
        }
        else if(cherryflag==true && sunflag==false && peaflag==false && walnutflag==false && avail.get("Cherrybomb") && tmp.getImage()==null)
        {
            flag=true;
            pl=new Cherrybomb(x,y);
            statgame.increase_time("Cherrybomb",10);
            statgame.decrase_sun_tokens_collected(statgame.getPrice("Cherrybomb"));
        }
        else if(peaflag==true && sunflag==false && cherryflag==false && walnutflag==false && avail.get("Peashooter") && tmp.getImage()==null)
        {
            flag=true;
            pl=new Peashooter(x,y);
            statgame.increase_time("Peashooter",10);
            statgame.decrase_sun_tokens_collected(statgame.getPrice("Peashooter"));

        }
        else if(walnutflag==true && sunflag==false && cherryflag==false && peaflag==false && avail.get("Walnut") && tmp.getImage()==null)
        {
            flag=true;
            pl=new Walnut(x,y);
            statgame.increase_time("Walnut",10);
            statgame.decrase_sun_tokens_collected(statgame.getPrice("Walnut"));
        }

        if(flag) {
            statgame.addPlant(pl);

            tmp.setImage(pl.getIm());
            tmp.setFitWidth(100);
            tmp.setFitHeight(150);

        }
        PlayGameController.sunflag=false;
        PlayGameController.peaflag=false;
        PlayGameController.walnutflag=false;
        PlayGameController.cherryflag=false;

    }

    public static void spawn_zombie(int x,int y,int type,Zombie zm)
    {
        System.out.println("X= "+x+"Y= "+y+" TYPE= "+type);
        if(zm==null)
        {
            if(type==1)
                zm = new Zombie(x, y, 100, 10,1);
            else if(type==2)
                zm = new Zombie(x, y, 100, 10,2);
            statgame.addZombie(zm);
        }

        ImageView iv=new ImageView();
        if(type==1) {
            iv.setImage(Zombie.normal_image);
        }
        else {
            iv.setImage(Zombie.conehead_image);
        }
        iv.setFitWidth(150);
        iv.setFitHeight(150);
        iv.setLayoutX(zm.getX());
        iv.setLayoutY(130+120*zm.getY());
        zomb_im.put(zm,iv);
        PlayGameController.statmain.getChildren().add(iv);
        ShouldZombieStop.put(zm, false);
    }


    public static void spawn_pea(int x,int y,Pea pea)
    {
        //        System.out.println("hahds");

        if(pea==null) {
            pea = new Pea(320 + 90 * x, y);
            statgame.addPea(pea);
        }

        ImageView iv=new ImageView();
        iv.setImage(Pea.im);
        iv.setFitWidth(25);
        iv.setFitHeight(25);
        iv.setLayoutX(pea.getX());
        iv.setLayoutY(170+120*y);
        pea_im.put(pea,iv);
        PlayGameController.statmain.getChildren().add(iv);

    }

    public static void move_zombies(double delta)
    {
        zomb_im.forEach((k,v)->{
            if(!ShouldZombieStop.get(k)) {
                v.setLayoutX(v.getLayoutX() - delta);
                if(v.getLayoutX()<=225)
                    zombie_reached_home(k.getY());
                k.setX((int) v.getLayoutX());
            }
        });
    }

    //TODO - not available
    public static void zombie_reached_home(int y)
    {
        if(statgame.is_lm_available(y)){
            moving_lawn_mover.add(PlayGameController.get_lawn_mover(y));
            statgame.remove_availability(y);
        }
        else
            System.out.println("GAME LOST");

    }

    public static void remove_plant(Plant pl)
    {
        statgame.remove_plant(pl);
        PlayGameController.ln.plants.get(pl.getY()).get(pl.getX()).setImage(null);
    }

    public static void move_pea(double delta)
    {
        ArrayList<Pea> tmp=new ArrayList<>();
        pea_im.forEach((k,v)->{
            v.setLayoutX(Math.min(1200,v.getLayoutX()+delta));
            k.setX((int)v.getLayoutX());
            if(k.getX()>=1100)
                tmp.add(k);
        });
        for(Pea tmp2:tmp)
        {
            PlayGameController.statmain.getChildren().remove(pea_im.get(tmp2));
            pea_im.remove(tmp2);
            Main2.statgame.remove_pea(tmp2);
        }
    }

    public static void move_lawn_mover(double delta)
    {
        for(int i=moving_lawn_mover.size()-1;i>=0;i--){
            Lawn_Mover lawnX=moving_lawn_mover.get(i);
            ImageView im= lawnX.getIm();
            im.setLayoutX(im.getLayoutX()+delta);

            if(im.getLayoutX()>=1000)
            {
                PlayGameController.statmain.getChildren().remove(im);
                moving_lawn_mover.remove(i);
            }

            ArrayList<Zombie> ar=statgame.getZombies();
            for(int j=ar.size()-1;j>=0;j--)
            {
                if(ar.get(j).getY()==lawnX.getY() && ar.get(j).getX()<=lawnX.getIm().getLayoutX())
                    remove_zombie(ar.get(j));
            }

        }
    }

    public static void remove_zombie(Zombie tempZom)
    {
        PlayGameController.statmain.getChildren().remove(Main2.zomb_im.get(tempZom));
        Main2.zomb_im.remove(tempZom);
        Main2.statgame.remove_zombie(tempZom);
    }

    public static void ZombieCollideWithPLant(ArrayList<Plant> arrPLants, ArrayList<Zombie> arrzomb){

        for(Zombie tempz: arrzomb){
            boolean flag= false;
            for(int i=arrPLants.size()-1;i>=0;i--) {
                Plant tempP=arrPLants.get(i);
                if ((320 + 90 * tempP.getX() - tempz.getX()) == 90 && Math.abs(120 * tempP.getY() - 120 * tempz.getY()) <= 20) {
//                    System.out.println((320+90*tempP.getX()- tempz.getX()));
                    tempz.attack(tempP);
                    System.out.println(tempP.getHealth());
                    ShouldZombieStop.put(tempz, true);
                    flag = true;
                }
            }

            if(!flag){
                ShouldZombieStop.put(tempz, false);
            }
        }
    }

    public static void spawn_sun_tokens()
    {
        ArrayList<Plant> ar=statgame.getPlants();
        for(Plant p:ar)
        {
            if(p.getClass().getName().equals(SunFlower.class.getName()))
                ((SunFlower) p).oneSecond();
        }
    }

    public static void cherry_bomb_blast()
    {
        ArrayList<Plant> ar=statgame.getPlants();
        for(int i=ar.size()-1;i>=0;i--)
            if(ar.get(i).getClass().getName().equals(Cherrybomb.class.getName()))
            {
                ((Cherrybomb) ar.get(i)).burst(statgame.getZombies());
                remove_plant(ar.get(i));
            }

    }

    public static void peashooting()
    {
        ArrayList<Plant> ar=statgame.getPlants();
        for(int i=ar.size()-1;i>=0;i--)
        {
            Plant pl=ar.get(i);
            if(pl.getClass().getName().equals(Peashooter.class.getName()))
            {
                boolean flag = false;
                for(int j = 0; j<statgame.getZombies().size(); j++){
                    if(statgame.getZombies().get(j).getY()== pl.getY()) {
                        flag = true;
                        break;
                    }
                }
                if(flag) {
                    int x1 = 330 + 90 * pl.getX(), y1 = 130 + 120 * pl.getY();
                    System.out.println(y1 + " " + x1);
                    spawn_pea(pl.getX(), pl.getY(), null);
                    PlayGameController.ln.plants.get(pl.getY()).get(pl.getX()).setImage(Peashooter.im2);
                }
                else
                    PlayGameController.ln.plants.get(pl.getY()).get(pl.getX()).setImage(Peashooter.im1);

            }
        }
    }

    public static void serialize(ArrayList<GameStatus> gs) throws IOException, ClassNotFoundException {
        ObjectOutputStream out = null;
        try{
            out = new ObjectOutputStream( new FileOutputStream("/Users/pawanmehan/ap_project/src/sample/save.txt"));
            out.writeObject(gs);
        }
        finally {
            if(out!= null)
            out.close();
        }
    }

    public static ArrayList<GameStatus> deserialise() throws IOException, ClassNotFoundException{
        ArrayList<GameStatus> reto = null;
        ObjectInputStream in = null;
        try{
            in = new ObjectInputStream(new FileInputStream("/Users/pawanmehan/ap_project/src/sample/save.txt"));
            reto = (ArrayList<GameStatus>)in.readObject();
        }
        finally {
            if(in!=null){
                in.close();
            }
        }
        return reto;
    }

    public static void main(String[] args) {
        launch(args);
    }

}