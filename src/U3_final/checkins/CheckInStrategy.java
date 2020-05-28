package U3_final.checkins;

import U3_final.InMachine;
import U3_final.MachineStrategy;
import U3_final.OutMachine;

public enum CheckInStrategy implements MachineStrategy {

    INSTANCE;

    CheckInStrategy(){
        try {
            // Simulate a long-running constructor, maybe a network or database call?
            Thread.currentThread().sleep(1500);
        } catch (InterruptedException ex) {
        }
    }

    @Override
    public InMachine getInMachineType(String type)
    {
        switch (type)
        {
            case "checkin":
                return new CheckIn();
            case "checkinwithspecialevent":
                return new CheckInSpecialEvent();
            default:
                return null;
        }
    }

    @Override
    public OutMachine getOutMachineType(String string) {
        return null;
    }
}
