package sample;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class Lawn {

    private GridPane lawn;
    ArrayList<ArrayList<ImageView>> plants;

    public Lawn(GridPane lawn)
    {
        this.lawn=lawn;
        this.plants=new ArrayList<>();

        for(int i=0;i<9;i++)
        {
            plants.add(new ArrayList<ImageView>());
            for(int j=0;j<5;j++)
            {
                ImageView im=new ImageView();
                im.setFitWidth(100);
                im.setFitHeight(150);
                im.setPreserveRatio(false);
                plants.get(i).add(im);
                Button bn=new Button();
                bn.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
                bn.setStyle("-fx-background-color: transparent;");
                im.setFitHeight(bn.getMinHeight());
                im.setFitWidth(bn.getPrefWidth());
                bn.setGraphic(im);
                bn.addEventFilter(MouseEvent.MOUSE_PRESSED, event ->{
                    Integer x=GridPane.getRowIndex( bn),y=GridPane.getColumnIndex( bn);
                    System.out.println( "Node: " + " at " + x + "/" + y);
                    plant(x,y);

                });
                lawn.add(bn,i,j);

            }
        }
    }

    public void plant(int x,int y)
    {
        boolean sunflag=PlayGameController.sunflag,peaflag=PlayGameController.peaflag,walnutflag=PlayGameController.walnutflag,cherryflag=PlayGameController.cherryflag;
        boolean flag=false;
        Plant pl=null;

        if(sunflag==true && cherryflag==false && peaflag==false && walnutflag==false)
        {
            flag=true;
            pl=new SunFlower(x,y);

        }
        else if(cherryflag==true && sunflag==false && peaflag==false && walnutflag==false)
        {
            flag=true;
            pl=new Cherrybomb(x,y);

        }
        else if(peaflag==true && sunflag==false && cherryflag==false && walnutflag==false)
        {
            flag=true;
            pl=new Peashooter(x,y);

        }
        else if(walnutflag==true && sunflag==false && cherryflag==false && peaflag==false)
        {
            flag=true;
            pl=new Walnut(x,y);
        }

        if(flag) {
            ImageView tmp = this.plants.get(y).get(x);
            tmp.setImage(pl.getIm());
            tmp.setFitWidth(100);
            tmp.setFitHeight(150);
        }
        PlayGameController.sunflag=false;
        PlayGameController.peaflag=false;
        PlayGameController.walnutflag=false;
        PlayGameController.cherryflag=false;


    }


}
