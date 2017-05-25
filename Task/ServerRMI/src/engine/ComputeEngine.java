package engine;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import compute.Compute;
import compute.Task;

public class ComputeEngine implements Compute 
{

	public String echo(String input)
	{
		return String.format("ECHO: %s", input);
	}
	
    public <T> T executeTask(Task<T> t) 
    {
        return t.execute();
    }
    
	public void ping() 
	{
		return; 
	}

	

    public static void main(String[] args)
    {
        if (System.getSecurityManager() == null)
        {
            System.setSecurityManager(new SecurityManager());
        }
        try 
        {
        	Registry reg = LocateRegistry.createRegistry(2009);
            String name = "Compute";
            Compute engine = new ComputeEngine();
            Compute stub =  (Compute) UnicastRemoteObject.exportObject(engine,15011);
          
            reg.rebind(name, stub);
            
            System.out.println("ComputeEngine bound");
        } 
        catch (Exception e)
        {
            System.err.println("ComputeEngine exception:");
            e.printStackTrace();
        }
    }
}