package sample;

import java.util.HashMap;

public class Level3 extends LevelStatus {

    protected Level3(HashMap<Integer,Integer> rem, int time)
    {
        super(rem,time, 3);
    }

    public static Level3 getInstance()
    {
        int no=10;
        HashMap<Integer,Integer> mp=new HashMap<>();
        mp.put(1,10);mp.put(2,5);

        return new Level3(mp,16);
    }
}
