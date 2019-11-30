package sample;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class LevelStatus implements Serializable {

    private final int no,time;
    private HashMap<Integer,Integer> rem;
    private double progress;

    protected LevelStatus(int no,HashMap<Integer,Integer> rem,int time)
    {
        this.no=no;
        this.rem=rem;
        this.time=time;
        this.progress=0;
    }

    public int getTime() {
        return time;
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

    public double getProgress() {
        return progress;
    }

    public void setProgress(double progress) {
        this.progress = progress;
    }
}
