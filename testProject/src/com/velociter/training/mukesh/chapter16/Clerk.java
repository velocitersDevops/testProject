package com.velociter.training.mukesh.chapter16;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;


public class Clerk implements Runnable 
{
	
	private Bank bankObject;
	private List<Transaction> list = Collections.synchronizedList(new ArrayList<Transaction>());    // To store transactions:
	private int maxTransactions = 8;           // Maximum transactions in the ist.
  
	public Clerk(Bank bankObject) 
	{
	    this.bankObject = bankObject;          	// Who the clerk works for.
	                   
	 }

	// Receive a transaction:
	  synchronized public void doTransaction(Transaction transaction) 
	  {
		    while(list.size() >= maxTransactions) 
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
		      
		    list.add(transaction);
		      
		    notifyAll();
	  }

  
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
			      bankObject.doTransaction(list.remove(0));
			      
			      notifyAll();                  
			    }
		  }

		  // Busy check:
		  synchronized public void isBusy() 
		  {
			    while(list.size() != 0) 
				{       								// Is this object busy?
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
