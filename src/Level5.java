package sample;

import java.util.HashMap;

public class Level5 extends LevelStatus {

    protected Level5(HashMap<Integer,Integer> rem, int time)
    {
        super(rem,time, 5);
    }

    public static Level5 getInstance()
    {
        int no=10;
        HashMap<Integer,Integer> mp=new HashMap<>();
        mp.put(1,10);mp.put(2,10);

        return new Level5(mp,12);
    }
}
