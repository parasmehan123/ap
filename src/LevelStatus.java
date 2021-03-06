package sample;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class LevelStatus implements Serializable {

    private final int num, time;
    private HashMap<Integer,Integer> rem;


    protected LevelStatus(HashMap<Integer,Integer> rem,int time, int num)
    {
        this.num = num;
        this.rem=rem;
        this.time=time;
    }

    public int getTime() {
        return time;
    }

    public int getNum() {
        return num;
    }

    public HashMap<Integer, Integer> getMap(){
        return this.rem;
    }

    public boolean isZombieAvailable()
    {
        boolean flag=false;
        for (Map.Entry<Integer, Integer> entry : rem.entrySet()) {
            Integer k = entry.getKey();
            Integer v = entry.getValue();
            if (v > 0) {
                flag=true;
                break;
            }
        }
        return flag;
    }

    public double getProgress(){
        final double[] remaining = {0};
        rem.forEach((k,v)->{
            remaining[0] +=v;
        });
        return  remaining[0] /(10+num*2);
    }

}
