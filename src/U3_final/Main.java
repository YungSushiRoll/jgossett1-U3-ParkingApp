package U3_final;

import U3_final.checkins.CheckInStrategy;
import U3_final.checkouts.OutMachineStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Ticket> tickets = new ArrayList();
        List<Ticket> fileTickets = new ArrayList();
        MachineStrategy checkInStrategy = CheckInStrategy.INSTANCE;
        InMachine checkIn = checkInStrategy.getInMachineType("checkin");
        InMachine eventIn = checkInStrategy.getInMachineType("checkinwithspecialevent");
        MachineStrategy checkOutStrategy = OutMachineStrategy.INSTANCE;
        OutMachine outWID = checkOutStrategy.getOutMachineType("withid");
        OutMachine lost = checkOutStrategy.getOutMachineType("lost");
        OutMachine outWEvent = checkOutStrategy.getOutMachineType("specialevent");
        // FileIn fi new FileIn();
        // fi.readFile()
        // FileOut fo new FileOut();
        Scanner keyboard = new Scanner(System.in);
        boolean endOfNight = false;
        boolean inAndOut = false;
        do {
            if(!inAndOut) {
                System.out.println("Checking in");
                String check = keyboard.nextLine();
                switch (check) {
                    case "1":
                        System.out.println("check in how");
                        String checkingIN = keyboard.nextLine();
                        switch (checkingIN) {
                            case "1":
                                System.out.println("checkin");
                                checkIn.inMachineStuff(tickets, fileTickets);
                                checkIn.displayInfo();
                                inAndOut = true;
                                break;
                            case "2":
                                System.out.println("event");
                                inAndOut = true;
                                break;
                        }
                        break;
                    case "2":
                        System.out.println("Closing");
                        System.out.println("Total sales from Checkouts with ticket: $" +
                                outWID.getTotalSales() + "\nTotal customers checked out with tickets: " +
                                + outWID.getTotalVisitors() +
                                "\n*******************************************\n");
                        // fileTickets to file
                        // takes fileTickets calcs totals and prints
                        endOfNight = true;
                        break;
                }
            } else {
                System.out.println("Checking out");
                String resp = keyboard.nextLine();
                switch (resp) {
                    case "1":
                        System.out.println("checking out with id");
                        outWID.outMachineStuff(tickets, fileTickets);
                        outWID.displayInfo();
                        for (Ticket ticket : tickets) {
                            System.out.println(ticket.getId() + " t " + ticket.getEnterTime());
                        }
                        for (Ticket ticket2 : fileTickets) {
                            System.out.println(ticket2.getId() + " file " + ticket2.getEnterTime() + " " + ticket2.getExitTime());
                        }
                        inAndOut = false;
                        break;
                    case "2":
                        System.out.println("checking out lost");
                        inAndOut = false;
                        break;
                    case "3":
                        System.out.println("checking out event");
                        inAndOut = false;
                        break;
                }
            }

        }while(!endOfNight);

    }
}
