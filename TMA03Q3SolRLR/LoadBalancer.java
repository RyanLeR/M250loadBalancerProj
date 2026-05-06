import java.util.TreeMap;
import java.util.TreeSet;
import java.util.ArrayList;
/**
 * Question 4(a)
 *This class creates load balancer objects, 
 *to store and help manager a number of virtual
 *machines in a theoretical small private network
 *
 * @author Ryan Le Roux
 * @version 1.0
 */
public class LoadBalancer
{
    //Question 4(a)
    private String loadBalancerName;
    private TreeMap<String, VirtualMachine> registeredVms;
    
    /**
     * The constructor for LoadBalancer objects initialises
     * two fields. One is for the object's name, passed
     * as an argument and another for an empty TreeMap 
     * that later will hold Virtual
     * Machine objects.
     */
    public LoadBalancer(String newName)
    {
        loadBalancerName = newName;
        registeredVms = new TreeMap<>();
    }

    /**
     * Question 4(a)
     * This method simply returns the name of 
     * the load balancer instance
     *
     * @return    The name of the load balancer
     */
    public String getLbName()
    {
        return loadBalancerName;
    }

    /**
     * Question 4(a)
     * This method simply returns the number
     * of VMs held by the organisation instance in
     * its registered Vms collection
     *
     * @return    The number of vms in this instance's collection
     */
    public int numberOfVmsHeld()
    {
        return registeredVms.size();
    }
    
    /**
     * This toString method overrides the same method
     * in the Object class and returns a list of all
     * currently help vms and includes their information
     * 
     * @return all held vms and their information
     */


    public void addMachines()
    {
        VirtualMachine mc1 = new VirtualMachine(2501, 16);
        VirtualMachine mc2 = new VirtualMachine(4001, 32);

        registeredVms.put("machine1", mc1);
        registeredVms.put("machine2", mc2);

    }

    @Override
    public String toString()
    {
        String ans = "";
        for(VirtualMachine targetMachine : registeredVms.values())
        {
            ans = ans + targetMachine.toString() + "\n";
        }
        System.out.println(ans);
        return ans;
    }


    public void clear()
    {
        registeredVms.clear();
    }
    
    public void populate()
    {
        
    }
    
    
    
    
    
    
    
    
    
    
    
}