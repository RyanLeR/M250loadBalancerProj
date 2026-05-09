import java.util.TreeMap;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Random;
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
     * Question 4(b)(i)
     * This method creates a new virtual machine
     * and adds it to the registeredVm treeSet. It 
     * adds the instance regardless, even if it existed
     * in the treeset. If it pre-existed, method returns
     * true, else returns false
     * 
     * @return Whether or not a machine with the same
     * id existed in the treeset before this method was
     * invoked
     */

    public boolean addVmInstance(double chosenCpuSpeed, int chosenRam)
    {
        VirtualMachine newVm = new VirtualMachine(chosenCpuSpeed, chosenRam);
        boolean exists = false;
        for(String comparedKey : registeredVms.keySet())
        {
            if(comparedKey.equals(newVm.getMachineId()))
            {
                exists = true;
            }
        }
        registeredVms.put(newVm.getMachineId(), newVm);
        
        return exists;
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

    /**
     * Question 4(b)(ii)
     * This method clears all data in the registeredVms
     * treeMap
     */

    public void clear()
    {
        registeredVms.clear();
    }
    
    /**
     * This is a helper method to help the populate method
     * create variance in the machines it populates to
     * mimic random simulations of added machines to the
     * map, where it provides a random CPU speed
     * 
     * return a CPU speed in GHz
     */
    
    public double randCpuSpeed()
    {
        Random randCpuInt = new Random();
        int newRandCpuInt = randCpuInt.nextInt(2, 5);
        
        Random randCpuDec = new Random();
        double newRandCpuDec = (randCpuDec.nextDouble() * 0.8) + 0.1;
        
        return newRandCpuInt + newRandCpuDec;
    }
    
    /**
     * This is a helper method to help the populate method
     * create variance in the machines it populates to
     * mimic random simulations of added machines to the
     * map, where it provides a random amount of phyiscal
     * memory
     * 
     * return a high (32) or low (16) ram amount in GBs
     */
    
    public int randRamAmount()
    {
        int lowRam = 16;
        int highRam = 32;
        int ans = 16;
        
        Random randRamPicker = new Random();
        boolean lowRamSelected = randRamPicker.nextBoolean();
        if(!lowRamSelected)
        {
            ans = highRam;
        }
        return ans;
    }
    
    /**
     * Question 4(c)(iii)
     * This method clears the registeredVms map before populating 
     * the registeredVms TreeSet with any number of machines between
     * 3 and 10 to create variance when testing populate. It calls
     * helper methods randRamAmount and randCpuSpeed to use
     * as arguments when creating new VMs
     * 
     */
    public void populate()
    {
        clear();
        
        Random numGenerator = new Random();
        int instancesToGenerate = numGenerator.nextInt(3, 11);
        
        int vmAddIteration = 0;
        
        while(vmAddIteration < instancesToGenerate)
        {
            addVmInstance(randCpuSpeed(),randRamAmount());
            vmAddIteration++;
        }
        
    }
    
    public void getRegVmSize()
    {
        System.out.println(registeredVms.size());
    }
    
    /**
     * Question 4(b)(iv)
     * 
     * This method accepts a string that may match the key
     * of an object held in the registeredVms TreeMap. If an
     * object with the key exists in the map, it is removed
     * and the method returns true. If not, this method simply 
     * returns false.
     * 
     * @param a String representing the sought machine Id
     * 
     * @return A boolean showing whether an object with the sought ID
     * existed in the TreeMap registeredVms or not
     */
    public boolean removeVmEntry(String soughtVmId)
    {
        
        
        
        boolean objFound = false;
        
        if(machineExists(soughtVmId))
        {
            VirtualMachine soughtObj;
            for(VirtualMachine targetMachine : registeredVms.values())
            {
                if(targetMachine.getMachineId().equals(soughtVmId))
                {
                    objFound = true;
                    for(String targetKey : registeredVms.keySet())
                    {
                        VirtualMachine innerTargetMachine = registeredVms.get(targetKey);
                        if(innerTargetMachine.getMachineId().equals(soughtVmId))
                        {
                            String foundId = soughtVmId;
                        }
                    }
                }
            }
        
            if(objFound == true)
            {
                registeredVms.remove(soughtVmId);
            }
        
        }

        return objFound;
        
    }
    
    /**
     * public boolean removeVmEntry(String soughtVmId)
    {
        boolean objFound = false;
        
        VirtualMachine soughtObj;
        for(VirtualMachine targetMachine : registeredVms.values())
        {
            if(targetMachine.getMachineId().equals(soughtVmId))
            {
                objFound = true;
                for(String targetKey : registeredVms.keySet())
                {
                    VirtualMachine innerTargetMachine = registeredVms.get(targetKey);
                    if(innerTargetMachine.getMachineId().equals(soughtVmId))
                    {
                        String foundId = soughtVmId;
                    }
                }
            }
        }
        
        if(objFound == true)
        {
            registeredVms.remove(soughtVmId);
        }
        
        return objFound;
        
    }
     */
    
    /**
     * This helper method determines if a machine with
     * a sought machineId exists in the registeredVms
     * TreeMap
     * 
     * @return true if machine with sought key exists
     * in the map. False if not
     */
    public boolean machineExists(String soughtVm)
    {
        boolean ans = false;
        if(registeredVms.containsKey(soughtVm))
        {
            ans = true;
        }
        return ans;
    }
    
    
    
    
    
}