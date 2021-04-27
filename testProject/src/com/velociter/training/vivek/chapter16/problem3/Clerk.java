package com.velociter.training.vivek.chapter16.problem3;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;



public class Clerk implements Runnable
{
	public Clerk(Bank theBank)
	{
		this.theBank=theBank;
	}
	public Clerk(Bank theBank,String name)
	{
		this.theBank=theBank;
		this.name=name;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public Clerk setSuperviser(Superviser superviser)
	{
		this.superviser=superviser;
		return this;
	}
	
	synchronized public void doTransaction(Transaction transaction)
	{  
		
		
		while(inTray.size()>=maxTransaction)
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
		
		
		inTray.add(transaction);
		notifyAll();
		
	}
	
	
	
	synchronized public void run()
	{
	    while(true)
	    {
	      while(inTray.size() == 0)
	      {     // No transaction waiting?
	        System.out.println(name + " (supervised by " + superviser.getName() 
	                                                     + ") is idle.");
	        try 
	        {
	          wait();                   // Then take a break until there is.
	        }
	        catch(InterruptedException e)
	        {
	          System.out.println(e);
	        }
	      }
	      System.out.println(name + " (supervised by " + superviser.getName() 
	                                                   + ") is working!");
	      theBank.doTransaction(inTray.remove(0));
	      notifyAll();                  // Notify other threads locked on this clerk.
	    }
	  }
	 synchronized public void isBusy()
	 {
		    while(inTray.size() != 0) {       // Is this object busy?
		      try {
		        wait();                       // Yes, so wait for notify call.
		      } catch(InterruptedException e) {
		        System.out.println(e);
		      }
		    }
		    return;                           // It is free now.
		  }
	
	
	
	private Bank theBank;
	private String name;
	private Superviser superviser;
	private	List<Transaction> inTray= Collections.synchronizedList(new LinkedList<Transaction>()) ;
	private int maxTransaction=8;


}
