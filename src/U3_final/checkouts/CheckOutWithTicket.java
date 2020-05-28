package U3_final.checkouts;

import U3_final.OutMachine;
import U3_final.Ticket;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class CheckOutWithTicket implements OutMachine {

    private Random rand = new Random();
    private Scanner keyboard = new Scanner(System.in);
    private LocalTime leaveTimeFormatter;
    private LocalTime enterTimeFormatter;
    private int stayCost = 0;
    private double totalCollected = 0.00;
    private int checkOutCount = 0;
    private boolean foundTix;

    @Override
    public void outMachineStuff(List<Ticket> tickets, List<Ticket> tickets2) {
        do {
            System.out.println("Enter Ticket ID:");
            String id = keyboard.nextLine();
            int ID = Integer.parseInt(id);
            for (Ticket ticket : tickets) {
                if (ID == ticket.getId()) {
                    foundTix = true;
                    stayCost = 5;
                    int leaveTime = (rand.nextInt(12) + 12);
                    int timeDiff = (leaveTime - ticket.getEnterTime());
                    for (Ticket ticket2 : tickets2) {
                        if (ID == ticket2.getId())
                        {
                            ticket2.setExitTime(leaveTime);
                        }
                    }
                    // formatting for out put
                    leaveTimeFormatter = LocalTime.of(leaveTime, 0);
                    enterTimeFormatter = LocalTime.of(ticket.getEnterTime(), 0);

                    // did they say for more than 3 hours?
                    if (timeDiff > 3) {
                        stayCost += (timeDiff - 3);
                    }
                    totalCollected += stayCost;
                    System.out.println("Time to pay!");
                    System.out.println("You owe $" + stayCost);
                    try {
                        Thread.sleep(3000);
                        System.out.println("Paid!");
                    } catch (InterruptedException ignore) {

                    }
                    tickets.remove(ticket);
                    checkOutCount++;
                    break;
                } else {
                    foundTix = false;
                    System.out.println(
                            "***************************************************\n" +
                            "Hm, seems like we don't have a ticket with that ID.\n" +
                            "Check again\n" +
                            "***************************************************"
                    );
                }
            }
        } while (!foundTix);
    }

    @Override
    public double getTotalSales() {
        return totalCollected;
    }

    @Override
    public int getTotalVisitors() {
        return checkOutCount;
    }

    @Override
    public void displayInfo() {
        System.out.println("\n*************************\n" +
                "Best Value Parking Garage\n" +
                "*************************\n" +
                "**********RECEIPT********\n" +
                "Hours Parked: " + enterTimeFormatter.format(DateTimeFormatter.ofPattern("hh:mm a")) +
                " - " + leaveTimeFormatter.format(DateTimeFormatter.ofPattern("hh:mm a")) +
                "\nAmount Paid: $" + stayCost);
    }
}
