package U3_final;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author Josh Gossett
 */

public class TicketWriter {

    private DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
    private Date today = Calendar.getInstance().getTime();
    private String reportDate = df.format(today);
    private String dateToPrintToFile = reportDate;

    /**
     *
     * Takes all the tickets and adds them to the Ticket file
     * with time stamp from closed time
     * @param tickets list of the tickets
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void writeToFile(List<Ticket> tickets) throws FileNotFoundException, IOException {
        BufferedWriter out = new BufferedWriter(new FileWriter("tickets.txt", true));
        out.write("\nTickets from\n" +
                    dateToPrintToFile +
                "\n----------------------\n");
        for (Ticket ticket : tickets) {
            out.write("Ticket ID: " + ticket.getId() + ", Cost: " + ticket.getCost() + "\n");
        }

        out.close();
    }
}
