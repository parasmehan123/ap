package sample;

public class Player {
    private int rank;
    private final String name;
    private final int level;
    private final boolean completed;

    Player(int rank,String name,int level,boolean completed)
    {
        this.rank=rank;
        this.name=name;
        this.level=level;
        this.completed=completed;
    }
    public String getName(){return this.name;}

    public boolean getCompleted(){return this.completed;}

    public int getLevel(){return this.level;}

    public int getRank(){return this.rank;}
}
