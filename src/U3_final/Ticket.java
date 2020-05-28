package U3_final;

public class Ticket {

    private int id;
    private int enterTime;
    private int exitTime;

    public Ticket(int id, int enterTime)
    {
        this.id = id;
        this.enterTime = enterTime;
    }

    public Ticket(int id, int enterTime, int exitTime)
    {
        this.id = id;
        this.enterTime = enterTime;
        this.exitTime = exitTime;
    }

    public int getId() {
        return id;
    }

    public int getEnterTime() {
        return enterTime;
    }

    public void setExitTime(int exitTime) {
        this.exitTime = exitTime;
    }

    public int getExitTime() {
        return exitTime;
    }
}
