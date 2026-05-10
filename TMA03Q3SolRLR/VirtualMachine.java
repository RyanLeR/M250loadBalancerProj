import java.lang.Comparable;
/**
 * Question 3(c)
 * 
 * A class to create Virtual Machine objects that hold a state
 * that includes machine creation number, machine ID,
 * CPU processing power, physical memory and 
 * number of connected users
 *
 * @author Ryan Le Roux
 * @version 1.0
 */


public class VirtualMachine implements Comparable<VirtualMachine>
{
    //Question 3(c)
    
    //Static field
    public static int machineCreationNumber = 1;
    
    //Instance fields
    private String machineId;
    private double cpuMaxGHz;
    private int physicalMemory;
    private int connectedUsers;
    

    /**
     * Question 3(c)
     * 
     * The parameterised constructor expects two arguments 
     * namely newCpuMaxGHz and newPhysicalMemory. Number of connected
     * users is initialised to 0
     */
    public VirtualMachine(double newCpuMaxGHz, int newPhysicalMemory)
    {
        cpuMaxGHz = newCpuMaxGHz;
        physicalMemory = newPhysicalMemory;
        machineId = "VM: " + machineCreationNumber;
        machineCreationNumber++;
        connectedUsers = 0;
    }
    
    /**
     * Question 3(c)
     * 
     * This method overrides the toString()
     * method from the super class Object.
     * It returns gives a representation of
     * the object's current state.
     *
     * @return The machine ID is returned
     */
    @Override
    public String toString()
    {
        String returnedString = "Virtual machine " + "'" 
        + getMachineId() + "'" + " has a max CPU speed of " 
        + getCpuSpeed() + ","
        + "has " + getPhysMemory() + 
        " Gigabytes of physical memory and currently has " 
        + getNumUsers() +
        " users connected.";
        
        return returnedString;
    }

    /**
     * Question 3(c)
     * 
     * This method acts as an accessor, to provide
     * the ID of the virtual machine instance
     *
     * @return Returns machineID of the virtual machine
     */
    public String getMachineId()
    {
        return machineId;
    }
    
    /**
     * Question 3(c)
     * 
     * This method acts as an accessor, to provide
     * the max CPU speed of a virtual machine instance
     *
     * @return Returns the max CPU speed of the object
     */
    public double getCpuSpeed()
    {
        return cpuMaxGHz;
    }
    
    /**
     * Question 3(c)
     * 
     * This method acts as an accessor, to provide
     * the amount of phyiscal memory for an instance
     * of virtual machine in GigaBytes
     *
     * @return The amount of physical memory is returned
     */
    public int getPhysMemory()
    {
        return physicalMemory;
    }
    
    /**
     * Question 3(c)
     * 
     * This method acts as an accessor, to provide
     * the number of connected users for an instance
     * of virtual machine
     *
     * @return Returns the number of connected users
     */
    public int getNumUsers()
    {
        return connectedUsers;
    }
    
    /**
     * Question 3(c)
     * 
     * This method acts as a mutator, to increment
     * the number of connected users for an instance
     * of virtual machine
     *
     */
    public void addConnectedUser()
    {
        connectedUsers++;
    }
    
    /**
     * Question 3(c)(ii)
     * This overridden equals method checks if
     * the invoking object has the same ID as the one
     * passed as an argument.
     * 
     *@return True if they have the same machine ID or are same
     *same object, false if not
     */
    @Override
    public boolean equals(Object comparedObj)
    {
        //if same memory address, obviously is same object
        if(comparedObj == this)
        {
            return true;
        } 
        
        if(!(comparedObj instanceof VirtualMachine))
        {
            return false;
        }
        
        /**If not same memory address but of same object type, check then if
         * machineID is the same. If so, return true and if not, return false
         */
        VirtualMachine comparedMachine = (VirtualMachine) comparedObj;
        return comparedMachine.getMachineId().equals(getMachineId());
    }
    
    
    /**
     * Question 3(c)(ii)
     * Overridden method of Object class. Returns unique identifier
     * using String's built-in hashcode, as an int datatype is needed
     * if overriding hashCode()
     * 
     * @return Unique hashcode for instance of virtual machine
     */
    @Override
    public int hashCode()
    {
        return getMachineId().hashCode();
    }
    
    /**
     * Question 3(c)(ii)
     * This implementation overrides the generic Comparable 
     * interface offered by java.lang.Comparable 
     * interface, and compares virtual machines based 
     * on their machineIDs, where if the invoking
     * object has a lower VM number, -1 is return. If it's
     * the same object, 0 is returned and if it has a higher 
     * machineID number than the compared
     * object, 1 is returned
     * 
     * @return an indicator if machineID is higher, lower or the
     * same as the compared object
     */
    
    @Override
    public int compareTo(VirtualMachine otherVm)
    
    {
        return this.machineId.compareTo(otherVm.machineId);
    }
    
    /**
     * This method sets the number of connected users
     * for a virtual machine instance
     * 
     * @param Number of connected users we want
     */
    
    public void setNumUsers(int usersToSet)
    {
        connectedUsers = usersToSet;
    }
    
    
    
    
}