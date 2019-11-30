package sample;
import java.util.HashMap;

public class Level2 extends LevelStatus {

    protected Level2(HashMap<Integer,Integer> rem,int time)
    {
        super(rem,time, 2);
    }

    public static Level2 getInstance()
    {
        int no=10;
        HashMap<Integer,Integer> mp=new HashMap<>();
        mp.put(1,10);mp.put(2,5);

        return new Level2(mp,20);
    }
}

