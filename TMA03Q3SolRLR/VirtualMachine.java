
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
        machineCreationNumber++;
        connectedUsers = 0;
    }

    /**
     * Question 3(c)
     * 
     * This method acts as an accessor, to provide
     * the machineID of the virtual machine object
     *
     * @return The machine ID is returned
     */
    public String getID()
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
     * of virtual machine
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
    public void setNumUsers()
    {
        connectedUsers++;
    }
    
    @Override
    public void toString()
    {
        
    }
}