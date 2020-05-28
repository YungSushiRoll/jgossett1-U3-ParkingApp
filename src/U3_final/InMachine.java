package U3_final;

import java.util.List;

/**
 * @author Josh Gossett
 */

public interface InMachine {

    /**
     * Used to check in a car and adds to both lists
     * @param tickets a list of tickets
     * @param historyTix another list of tickets that will be used to write and read to a file
     */
    void inMachineStuff(List<Ticket> tickets, List<Ticket> historyTix);

    /**
     * Used to display ticket information
     */
    void displayInfo();
}
