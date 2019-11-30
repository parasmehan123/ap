package sample;

import java.util.Comparator;

public class Gamestatuscomparator implements Comparator<GameStatus>
{
    @Override
    public int compare(GameStatus o1, GameStatus o2) {
        if(o1.get_level().getNum()< o2.get_level().getNum()){
            return -1;
        }
        else if(o1.get_level().getNum()> o2.get_level().getNum())
            return 1;
        else
        return 0;
    }
}
