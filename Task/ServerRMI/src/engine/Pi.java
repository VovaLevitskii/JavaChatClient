package engine;

import compute.Task;
import java.io.Serializable;
import java.math.BigDecimal;

public class Pi implements  Serializable,  Task<String> 
{

	private static final long serialVersionUID = 7739470682398121378L;

	public String execute() 
	{
        return new String("5");
    }
}