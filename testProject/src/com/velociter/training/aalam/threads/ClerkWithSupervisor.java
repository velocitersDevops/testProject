package com.velociter.training.aalam.threads;

import java.util.ArrayList;
import java.util.List;

public class ClerkWithSupervisor implements Runnable
{
	private String clerkName;
	private Supervisor supervisor;
	private Bank bank;
	private List<Transaction> listObject = new ArrayList<Transaction>();
	private int maxTransactions=6;

	public ClerkWithSupervisor(Bank bank , String name)
	{
		this.bank = bank;
		this.clerkName = name;
	}

	// to get clerk name
	public String getName() {
		return this.clerkName;
	}

	public ClerkWithSupervisor setSupervisor(Supervisor supervisor) {
		this.supervisor = supervisor;
		return this;
	}
	
	 // Receive a transaction:
	   public void doTransaction(Transaction transaction) 
	   {
	    while(listObject.size() >= maxTransactions)
	    try {
	      wait();
	    } catch(InterruptedException e) {
	      System.out.println(e);
	    }
	    listObject.add(transaction);
	   
	  }
	
	 // The working clerk:
	  synchronized public void run() {
	    while(true) {
	      while(listObject.size() == 0) {     // No transaction waiting?
	        System.out.println(clerkName + " (supervised by " + supervisor.getName() + ") is idle.");
	        try {
	          wait();                   // Then take a break until there is.
	        } catch(InterruptedException e) {
	          System.out.println(e);
	        }
	      }
	       System.out.println(clerkName + " (supervised by " + supervisor.getName()+ ") is working!");
	      bank.doTransaction(listObject.remove(0));
	                    
	    }
	  }

}
