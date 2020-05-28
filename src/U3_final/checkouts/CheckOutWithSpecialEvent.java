package U3_final.checkouts;

import U3_final.Menu;
import U3_final.OutMachine;
import U3_final.Ticket;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

public class CheckOutWithSpecialEvent implements OutMachine {

    private Random rand = new Random();
    private LocalTime leaveTimeFormatter;
    private LocalTime enterTimeFormatter;
    private int eventCost = 20;
    private double totalEventCollected = 0.00;
    private int eventCheckoutCount = 0;

    @Override
    public void outMachineStuff(List<Ticket> tickets, List<Ticket> tickets2) {
        System.out.println("Processing event ticket");
        try {
            for (int i = 0; i <= 2; i++)
            {
                Thread.sleep(1000);
                System.out.print(".");
            }
        } catch (InterruptedException ingore)
        {

        }
        for (Ticket ticket : tickets) {
            int eventLeaveTime = (rand.nextInt(12) + 12);

            // formatting for out put
            leaveTimeFormatter = LocalTime.of(eventLeaveTime, 0);
            enterTimeFormatter = LocalTime.of(ticket.getEnterTime(), 0);

            /**
             * setting event cost
             *
             */

            for (Ticket ticket2 : tickets2) {
                if (ticket.getId() == ticket2.getId())
                {
                    ticket2.setCost(eventCost);
                }
            }

            totalEventCollected += eventCost;
            System.out.println("\nTime to pay!");
            System.out.println("You owe $" + eventCost);
            try {
                Thread.sleep(3000);
                System.out.println("Paid!");
            } catch (InterruptedException ignore) {

            }
            tickets.remove(ticket);
            eventCheckoutCount++;
            break;
        }
    }

    @Override
    public double getTotalSales() {

        return totalEventCollected;
    }

    @Override
    public int getTotalVisitors() {

        return eventCheckoutCount;
    }

    @Override
    public void displayInfo() {
        Menu menu = new Menu();
        menu.printLogo();
        System.out.println(
                "**********RECEIPT********\n" +
                "Hours Parked: " + enterTimeFormatter.format(DateTimeFormatter.ofPattern("hh:mm a")) +
                " - " + leaveTimeFormatter.format(DateTimeFormatter.ofPattern("hh:mm a")) +
                "\nAmount Paid: $" + eventCost +
                "\n*************************\n" +
                "Hope you enjoyed the event!");
    }
}
