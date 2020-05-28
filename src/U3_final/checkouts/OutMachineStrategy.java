package U3_final.checkouts;

import U3_final.InMachine;
import U3_final.MachineStrategy;
import U3_final.OutMachine;

public enum OutMachineStrategy implements MachineStrategy {

    INSTANCE;

    OutMachineStrategy()
    {
        try
        {
            Thread.currentThread().sleep(1500);
        } catch (InterruptedException ex)
        {

        }
    }

    @Override
    public InMachine getInMachineType(String type) {
        return null;
    }

    @Override
    public OutMachine getOutMachineType(String type) {
        switch (type)
        {
            case "withid":
                return new CheckOutWithTicket();
            case "lost":
                return new CheckOutWithoutTicket();
            case "specialevent":
                return new CheckOutWithSpecialEvent();
            default:
                return null;
        }
    }
}
