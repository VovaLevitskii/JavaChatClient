package client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import java.io.File;
import compute.Compute;

public class C_MAIN 
{
	
	public static final int nNumbers = 50000; //rand numb
	public static final String DefaultFileName = new String ("random.txt"); // file name
	
	static int[] ParceFileData(String file_path) throws Exception 
	{ 
		Scanner sc = new Scanner(new File(file_path));
     	int [] fRand = new int [nNumbers];
     	int i = 0;
     	
     	while(sc.hasNextInt()){		fRand[i++] = sc.nextInt();	}
     	
     	return fRand;
	}
		
    public static void main(String args[])
    {    	    	  
    	if (System.getSecurityManager() == null)
    	{
    		System.setSecurityManager(new SecurityManager());
    	}
         	 
         String name = "Compute";
         try 
         {	
        	 
         Registry registry = LocateRegistry.getRegistry(2009);
         Compute comp = (Compute) registry.lookup(name);  
         Scanner io = new Scanner(System.in);   
       
         System.out.println("Type command: ping, echo, exit, or file_path");
         
        while (true)
         {         	
        	String command = io.nextLine();	   
        	String []parts = command.split(" ");
            if(parts[0].equals("ping"))
            {
            	comp.ping();
            	System.out.println("Ping come");
            }
            else if(parts[0].equals("echo"))
            {
            	String s = comp.echo(new String("Some string"));
            	System.out.println("Echo come:" + ((parts[0].length() > 1)? parts[1]:""));
            }
            else if(parts[0].equals("exit"))
            {
            	System.out.println("Exit client");
            	return;
            }
            	
            else
            {
            	System.out.println("Starting a Binary search task:");
        		long startTime =  System.currentTimeMillis();  // start measure time 
        		
            	int[] input_data = ParceFileData(command); 
            	
            	SORT_SHELL task = new SORT_SHELL(input_data); // sort
                int[] arr = comp.executeTask(task); //get sorted arr
            
            	long endTime = System.currentTimeMillis(); // start measure time
        		System.out.println("That took " + (endTime - startTime) + " milliseconds");
            
        		String resulting = new String(); 
                for(int k = 0; k< arr.length;++k)
                	resulting.concat(""+ arr[k]+',');          
                System.out.println("Positions are: " + (arr.length > 0? resulting:" no one found"));
            }           
        }
     } 
        catch (Exception e){ 	e.printStackTrace();	 }     
    }
}   

    