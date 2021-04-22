package com.velociter.training.vivek.chapter16;

import java.util.Collections;
import java.util.List;
import java.util.LinkedList;
//import com.velociter.training.aalam.chepter6.LinkedList;

public class Clerk implements Runnable
{
	//private Bank theBank;
	//LinkedList<Transaction> list= new LinkedList<Transaction>();
	
//private	List<Transaction> inTray= Collections.synchronizedList(new LinkedList<Transaction>()) ;
	
	//private int maxTransaction=8;
	
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
		  while(inTray.size()==0)
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
		  theBank.doTransaction(inTray.remove(0));
		  notifyAll();
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
		                              // It is free now.
		  }
	
	
	
	private Bank theBank;
	private String name;

	private	List<Transaction> inTray= Collections.synchronizedList(new LinkedList<Transaction>()) ;
	private int maxTransaction=8;

}
