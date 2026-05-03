
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
public class VirtualMachine
{
    //Question 3(c)
    
    //Static field
    public static int machineCreationNumber = 1;
    
    //Instance fields
    private String machineID;
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
        machineID = "VM: " + machineCreationNumber;
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
        String returnedString = "Virtual machine " + getMachineID() + " has " + getCpuSpeed() + "\n"
        + getPhysMemory() + "Gigabytes physical memory , and currently has" + getNumUsers() +
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
    public String getMachineID()
    {
        return machineID;
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
    public boolean equals(Object obj)
    {
        //if same memory address, obviously is same object
        if(obj == this)
        {
            return true;
        } 
        
        if(!(obj instanceof VirtualMachine))
        {
            return false;
        }
        
        /**If not same memory address but of same object type, check then if
         * machineID is the same. If so, return true and if not, return false
         */
        VirtualMachine comparedMachine = (VirtualMachine) obj;
        return comparedMachine.getMachineID().equals(getMachineID());
    }
    
    
    /**
     * Question 3(c)(ii)
     * Overridden method of Object class. Returns unique identifier
     * to allow VirtualMachine objects to be stored in a set
     * 
     * @return Unique hashcode for instance of virtual machine
     */
    @Override
    public int hashCode()
    {
        return getMachineID().hashCode();
    }
    
    
    
    
    
    
    
    
    
    
    
}