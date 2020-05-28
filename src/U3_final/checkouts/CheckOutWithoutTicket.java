package U3_final.checkouts;

import U3_final.Menu;
import U3_final.OutMachine;
import U3_final.Ticket;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

public class CheckOutWithoutTicket implements OutMachine {

    private Random rand = new Random();
    private LocalTime leaveTimeFormatter;
    private LocalTime enterTimeFormatter;
    private int lostCost = 25;
    private double totalLostCollected = 0.00;
    private int lostCheckoutCount = 0;

    @Override
    public void outMachineStuff(List<Ticket> tickets, List<Ticket> tickets2) {
        System.out.println("You lost your ticket?! *tisk* *tisk*\n" +
                "let's see what we can do for you\n");
        try {
            for (int i = 0; i <= 2; i++) {
                Thread.sleep(1000);
                System.out.print(".");
            }
        } catch (InterruptedException ingore) {

        }
        for (Ticket ticket : tickets) {
            int lostLeaveTime = (rand.nextInt(12) + 12);

            // formatting for out put
            leaveTimeFormatter = LocalTime.of(lostLeaveTime, 0);
            enterTimeFormatter = LocalTime.of(ticket.getEnterTime(), 0);

            /**
             * setting lost cost
             *
             */

            for (Ticket ticket2 : tickets2) {
                if (ticket.getId() == ticket2.getId()) {
                    ticket2.setCost(lostCost);
                }
            }

            totalLostCollected += lostCost;
            System.out.println("\nWe'll let it slide this time for an easy paymet of $" + lostCost +
                    "\nSound good?");
            try {
                for (int i = 0; i <= 2; i++) {
                    Thread.sleep(1000);
                    System.out.print(".");
                }
            } catch (InterruptedException ingore) {
                System.out.println("Great!\nYou owe $" + lostCost);
                try {
                    Thread.sleep(3000);
                    System.out.println("Paid!");
                } catch (InterruptedException ignore) {

                }
            }
            tickets.remove(ticket);
            lostCheckoutCount++;
            break;
        }
    }

    @Override
    public double getTotalSales() {
        return totalLostCollected;
    }

    @Override
    public int getTotalVisitors() {

        return lostCheckoutCount;
    }

    @Override
    public void displayInfo() {
        Menu menu = new Menu();
        menu.printLogo();
        System.out.println(
                "**********RECEIPT********\n" +
                "Hours Parked: " + enterTimeFormatter.format(DateTimeFormatter.ofPattern("hh:mm a")) +
                " - " + leaveTimeFormatter.format(DateTimeFormatter.ofPattern("hh:mm a")) +
                "\nAmount Paid: $" + lostCost +
                "\n*************************\n" +
                "Don't lose your ticket next time!!");
    }
}
