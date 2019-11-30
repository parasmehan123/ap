package sample;

import java.util.HashMap;

public class Level4 extends LevelStatus {

    protected Level4(HashMap<Integer,Integer> rem, int time)
    {
        super(rem,time, 4);
    }

    public static Level4 getInstance()
    {
        int no=10;
        HashMap<Integer,Integer> mp=new HashMap<>();
        mp.put(1,10);mp.put(2,8);

        return new Level4(mp,16);
    }
}
