package com.velociter.training.vivek.chapter16.problem2;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.velociter.training.vivek.chapter16.problem2.Bank;
import com.velociter.training.vivek.chapter16.problem2.Transaction;

public class Clerk implements Runnable
{
	
		
		
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
			    return;                           // It is free now.
			  }
		
		
		
		private Bank theBank;
		private String name;

		private	List<Transaction> inTray= Collections.synchronizedList(new LinkedList<Transaction>()) ;
		private int maxTransaction=8; 
}
