package client;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public  class RAND_F {

	public static void main(){	RandomFileGenerator();	}
	
      public static void RandomFileGenerator() 
      {
        File out = new File(C_MAIN.DefaultFileName); // create file
        FileWriter fw = null;
        int n = C_MAIN.nNumbers;
        try 
        {
            fw = new FileWriter(out);
            BufferedWriter writer = new BufferedWriter(fw);
        
            int line;
            Random random = new Random();  
            
            while (n > 0)
            {
                line = random.nextInt(10000); 
                writer.write(line + " ");
                n--;
            }
            writer.close(); 
        } 
        catch (IOException e)
        {
            e.printStackTrace();
            System.exit(0);
        }
    }
}