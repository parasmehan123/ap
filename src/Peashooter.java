package sample;

import javafx.scene.image.Image;

public class Peashooter extends Plant {

    public static Image im1,im2,pea;

    static
    {
        String path=Main1.path;
        im1=Helper.getImage(path+"PeaShooter_Idle1.gif");
        im2=Helper.getImage(path+"PeaShooter_Spit.gif");
        pea=Helper.getImage(path+"ProjectilePea.png");
    }
    public Peashooter(int x, int y)
    {
        super(x,y,100);

    }

    @Override
    public Image getIm()
    {
        return im1;
    }

    /*
    public void start_attack()
    {
        final int x=super.getX(),y=super.getY();
        final ImageView cur= this.ln.getImageView(x,y);
        cur.setImage(im2);
        cur.setFitWidth(100);
        cur.setFitHeight(150);
        final boolean[] flag={true};
        final long[] star = {System.nanoTime()};
        new AnimationTimer()
        {

            @Override
            public void handle(long now) {
                if(!flag[0])
                    stop();
                if((now - star[0]) > 1e9) {

                    ImageView pea1=new ImageView(pea);
                    pea1.setPreserveRatio(false);
                    pea1.setFitHeight(50);
                    pea1.setFitWidth(50);
                    int x1=320+90*x,y1=130+120*y;
                    pea1.setLayoutX(x1);
                    pea1.setLayoutY(y1);
                    PlayGameController.statmain.getChildren().add(pea1);
                    long time= (long) ((1200-x1)/150);
                    System.out.println("SPEED="+time);
                    TranslateTransition tr=new TranslateTransition(Duration.seconds(time),pea1);
                    tr.setByX(1200-cur.getLayoutX());
                    tr.play();
                    star[0] = now;
                }

            }
        }.start();
    }


     */

}
