package client;

import compute.Task;
import java.io.Serializable;
import java.util.stream.IntStream;
import java.util.Vector;
public class SORT_SHELL implements  Serializable,  Task<int []> 
{
  
	int[] input = null; //input data
	private static final long serialVersionUID = 7739470682398121378L;

	SORT_SHELL(int [] input)
	{
		this.input = input; 
	}	
	
	int tmp, j, i, n, d, ch;
	
	public int[] execute()
	{
		d = n;
        d = d / 2;
        while (d > 0) {
            for (i = 1; i < n - d; i++) {
                j = i;
                while (j > 0 && input[j] > input[j + d]) {
                    ch = input[j];
                    input[j] = input[j + d];
                    input[j + d] = ch;
                    j--;
                }
            }
            d = d / 2;
        }
        return input;
	}
		
}