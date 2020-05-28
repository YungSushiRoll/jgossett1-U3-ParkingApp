package U3_final;

import java.util.List;

public interface OutMachine {

    void outMachineStuff(List<Ticket> tickets, List<Ticket> tickets2);

    double getTotalSales();

    int getTotalVisitors();

    void displayInfo();
}
