package U3_final;

/**
 * @author Josh Gossett
 */

public class Menu {

    /**
     *  prints company logo
     */
    public void printLogo()
    {
        System.out.println(
                "\n*************************\n" +
                    "Best Value Parking Garage\n" +
                    "*************************\n");
    }

    /**
     * prints main menu
     */
    public void printMainMenu()
    {
        System.out.println(
                "1 - Check-in\n" +
                "2 - Close Garage");
    }

    /**
     * prints checkin menu
     */
    public void printCheckinMenu()
    {
        System.out.println(
                "How would you like to check in?\n" +
                "*******************************\n" +
                "1 - Check-in\n" +
                "2 - Special Event");
    }

    /**
     * prints checkout menu
     */
    public void printCheckoutMenu()
    {
        System.out.println(
                "How would you like to check out?\n" +
                "*******************************\n" +
                "1 - With Ticket ID\n" +
                "2 - Special Event\n" +
                "3 - Lost Ticket");
    }

    /**
     * prints closing menu
     */
    public void closingTime()
    {
        System.out.println("*Speakers start to blast \"Closing Time\" by Semisonic*\n");
        try
        {
            Thread.sleep(1500);
        } catch (InterruptedException ignore)
        {

        }
    }
}
