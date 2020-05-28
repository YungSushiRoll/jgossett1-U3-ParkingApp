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
        Menu menu = new Menu();
        double totalEarnings;
        TicketWriter fo = new TicketWriter();
        Scanner keyboard = new Scanner(System.in);
        boolean endOfNight = false;
        boolean inAndOut = false;
        do {
            if(!inAndOut) {
                menu.printLogo();
                menu.printMainMenu();
                String check = keyboard.nextLine();
                switch (check) {
                    case "1":
                        menu.printCheckinMenu();
                        String checkingIN = keyboard.nextLine();
                        switch (checkingIN) {
                            case "1":
                                checkIn.inMachineStuff(tickets, fileTickets);
                                checkIn.displayInfo();
                                inAndOut = true;
                                break;
                            case "2":
                                eventIn.inMachineStuff(tickets, fileTickets);
                                eventIn.displayInfo();
                                inAndOut = true;
                                break;
                        }
                        break;
                    case "2":
                        menu.closingTime();
                        System.out.println("*******************************************\n" +
                                "$" + outWID.getTotalSales() + " was collected from " + outWID.getTotalVisitors() + " Check Ins\n");
                        System.out.println("$" + outWEvent.getTotalSales() + " was collected from "+ outWEvent.getTotalVisitors() + " Special Events\n");
                        System.out.println("$" + lost.getTotalSales() + " was collected from " + lost.getTotalVisitors() + " Lost Tickets\n\n");

                        totalEarnings = (outWID.getTotalSales() + outWEvent.getTotalSales() + lost.getTotalSales());

                        System.out.println("$" + totalEarnings + " was collected overall" +
                                "\n*******************************************\n");

                        // writes tickets to file
                        try {
                            fo.writeToFile(fileTickets);
                        } catch (Exception e)
                        {
                            System.out.println(e.getMessage());
                        }

                        endOfNight = true;
                        break;
                }
            } else {
                menu.printLogo();
                menu.printCheckoutMenu();
                String resp = keyboard.nextLine();
                switch (resp) {
                    case "1":
                        outWID.outMachineStuff(tickets, fileTickets);
                        outWID.displayInfo();
                        inAndOut = false;
                        break;
                    case "2":
                        outWEvent.outMachineStuff(tickets,fileTickets);
                        outWEvent.displayInfo();
                        inAndOut = false;
                        break;
                    case "3":
                        lost.outMachineStuff(tickets,fileTickets);
                        lost.displayInfo();
                        inAndOut = false;
                        break;
                }
            }

        }while(!endOfNight);

    }
}
