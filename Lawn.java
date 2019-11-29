package sample;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class Lawn
{

    private GridPane lawn;
    ArrayList<ArrayList<ImageView>> plants;

    public Lawn(GridPane lawn)
    {
        this.lawn=lawn;
        this.plants=new ArrayList<>();

        for(int i=0;i<5;i++)
        {
            plants.add(new ArrayList<ImageView>());
            for(int j=0;j<9;j++)
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
                    Integer y=GridPane.getRowIndex( bn),x=GridPane.getColumnIndex( bn);
                    System.out.println( "Node: " + " at " + x + "/" + y);
                    Main2.buy_plant(x,y);
                });
                lawn.add(bn,j,i);

            }
        }
    }


    public ImageView getImageView(int x,int y)
    {
        return this.plants.get(y).get(x);
    }

}
