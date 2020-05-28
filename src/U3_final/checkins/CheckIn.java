package U3_final.checkins;

import U3_final.InMachine;
import U3_final.Ticket;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

public class CheckIn implements InMachine {

    private Random rand = new Random();
    private Ticket newTicket;
    private int TicketId = 1;

    @Override
    public void inMachineStuff(List<Ticket> tickets, List<Ticket> historyTix) {
        int enterTime = (rand.nextInt(6) + 7);
        newTicket = new Ticket(TicketId, enterTime);
        tickets.add(newTicket);
        historyTix.add(newTicket);
        for (Ticket ticket : tickets) {
            if (ticket.getId() == TicketId)
            {
                TicketId++;
            }
        }
    }

    @Override
    public void displayInfo() {
        LocalTime enterTimeFormatter = LocalTime.of(newTicket.getEnterTime(), 0);
        System.out.println("Printing Ticket (Keep in your car)\n");
        System.out.println("\n********* Ticket *********\n" +
                "Ticket Id: " + newTicket.getId() +  "\n" +
                "Car entered garage at " + enterTimeFormatter.format(DateTimeFormatter.ofPattern("hh:mm a")));
        try
        {
            Thread.sleep(1500);
        } catch (InterruptedException ignored) {

        }
    }
}
