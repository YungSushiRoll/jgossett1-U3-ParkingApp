package U3_final;

/**
 *
 * @author Josh Gossett
 */

public interface MachineStrategy {

    /**
     * Accepts a string and matches against enum to choose a check in class
     * @param type the type of check in class
     * @return a type of checking in machine based off the enum string
     */
    InMachine getInMachineType (String type);

    /**
     * Accepts a string and matches against enum to choose a check out class
     * @param string the type of check out class
     * @return a type of checking out machine based off the enum string
     */
    OutMachine getOutMachineType (String string);

}
