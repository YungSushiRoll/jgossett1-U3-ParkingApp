package U3_final;

import java.util.List;

/**
 * @author Josh Gossett
 */
public interface OutMachine {

    /**
     * Used to check out a car, removes from first list and updates second list
     * @param tickets gets removed after check out
     * @param tickets2 cost is updated
     */
    void outMachineStuff(List<Ticket> tickets, List<Ticket> tickets2);

    /**
     *
     * @return total sales for the specified ticket check out
     */
    double getTotalSales();

    /**
     *
     * @return total visitors for specified ticket check out
     */
    int getTotalVisitors();

    /**
     * used to display receipt information
     */
    void displayInfo();
}
