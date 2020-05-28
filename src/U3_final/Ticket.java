package U3_final;

/**
 * @author Josh Gossett
 */

public class Ticket {

    private int id;
    private int enterTime;
    private int cost;

    /**
     * Constructor to create checkin ticket
     * @param id
     * @param enterTime
     */
    public Ticket(int id, int enterTime)
    {
        this.id = id;
        this.enterTime = enterTime;
    }

    /**
     * Used to update cost when adding to file
     * @param id
     * @param enterTime
     * @param cost
     */
    public Ticket(int id, int enterTime, int cost)
    {
        this.id = id;
        this.enterTime = enterTime;
        this.cost = cost;
    }

    /**
     *
     * @return ticket id
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @return ticket enter time
     */
    public int getEnterTime() {
        return enterTime;
    }

    /**
     * sets cost for ticket
     * @param cost
     */
    public void setCost(int cost) {
        this.cost = cost;
    }

    /**
     *
     * @return cost
     */
    public int getCost() {
        return cost;
    }
}
