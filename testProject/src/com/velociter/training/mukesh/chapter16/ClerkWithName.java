package com.velociter.training.mukesh.chapter16;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;


public class ClerkWithName implements Runnable 
{
		  private Bank bankObject;
		  private List<Transaction> list = Collections.synchronizedList(new ArrayList<Transaction>());
		  private String name;
		  private Supervisor supervisor;
		  private int maxTransactions = 8;      // Maximum transactions in the in list.
		
		  public ClerkWithName(Bank bankObject, String name) 
		  {
		    this.bankObject = bankObject;                  
		    this.name = name;
		  }
	 
		  public String getName() 
		  {
			    return this.name;
		  }

		  public ClerkWithName setSupervisor(Supervisor supervisor) 
		  {
			  this.supervisor = supervisor;
			  return this;
		  }

		  
		  synchronized public void doTransaction(Transaction transaction) 
		  {
		    while(list.size() >= maxTransactions)
		    {
			    try 
			    {
			      wait();
			    } catch(InterruptedException e) 
			    {
			      System.out.println(e);
			    }
		    }
		    list.add(transaction);
		    notifyAll();
	  }

		  // The working clerk:
		  synchronized public void run() 
	  {
		    while(true) 
		    {
			      while(list.size() == 0) 
			      {    
				        
				        try 
				        {
				          wait();                  
				        } 
				        catch(InterruptedException e)
				        {
				          System.out.println(e);
				        }
			      }
		     System.out.println(name + " (supervised by " + supervisor.getName()  + ") is working");
		      bankObject.doTransaction(list.remove(0));
		      notifyAll();                  
		    }
	  }

		  // Busy check:
		  synchronized public void isBusy() 
	  {
		    while(list.size() != 0) 
		    {
			    try 
			    {
			        wait();                       
			    } 
			    catch(InterruptedException e) 
			    {
			        System.out.println(e);
			    }
		    }                              
	  }

	  
}
