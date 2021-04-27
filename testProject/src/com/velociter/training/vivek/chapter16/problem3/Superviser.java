package com.velociter.training.vivek.chapter16.problem3;

import java.util.Random;
import java.util.Vector;



public class Superviser implements Runnable
{
	private Bank theBank;
	private String name;
	private Vector<Clerk> clerkTeam= new Vector<Clerk>();
	private boolean busy=true;
	
	Superviser(Bank theBank,String name)
	{
		this.theBank=theBank;
		this.name=name;
	}
	
	public String getName()
    {
		return this.name;
    }
	
	public void addClerk(Clerk clerk)
	{
		clerkTeam.add(clerk.setSuperviser(this));
	}
	
	synchronized public void run()
	{
		StringBuffer team=new StringBuffer();
		
		for(Clerk clerk:clerkTeam)
		{
			team.append(clerk.getName());
		}
		
		System.out.println(name+"  has started work my team is"+team+"\n");
	
	
	Thread clerkThread=null;
	
	for(Clerk clerk:clerkTeam)
	{
		
		 clerkThread=new Thread(clerk);
		
		clerkThread.setDaemon(true);
		clerkThread.start();
	}
	
	
	 Random rand = new Random();                      // Random number generator.
	    Transaction transaction;                         // Stores a transaction.
	    int amount = 0;                                  // Stores an amount of money
	    int select = 0;                                  // Selects the account
	    int transactionType = 0;                         // Credit or debit

	    int transactionCount = 20;          // Number of transactions, debits or credits.

	    for(int i = 1; i <= transactionCount; i++) 
	    {
	      // Generate a credit or debit at random for a random account
	    	
	      amount = 50 + rand.nextInt(26);                // Generate amount of $50 to $75.
	      select = rand.nextInt(BankOperation.accounts.length);
	      transactionType = rand.nextInt(2)==1 ? Transaction.CREDIT:     // Credit 
	                                             Transaction.DEBIT;      // or Debit

	      transaction = new Transaction(BankOperation.accounts[select],transactionType,amount); // Account.
	                                                  // Credit or debit
	                                                            // of amount.
	        
	      switch(transactionType){
	        case Transaction.CREDIT:
	          BankOperation.totalCredits[select] += amount;        // Keep total credit tally.
	          BankOperation.nCredits[select]++;
	          break;
	        case Transaction.DEBIT:
	          BankOperation.totalDebits[select] += amount;         // Keep total debit tally.
	          BankOperation.nDebits[select]++;
	          break;
	        default:
	          assert false : "Invalid transaction type.";
	      }

	      // Pick a random clerk to take care of the transaction:
	      if(clerkTeam.size() < 0 ) 
	      {
	    	  System.out.println("No clerks in the team!");
	    	  }
	      clerkTeam.elementAt(rand.nextInt(clerkTeam.size())).doTransaction(transaction); 
	    } 
	      // A supervisor must continue to work while any clerk in the team is working
	      for(Clerk clerk : clerkTeam)
	      {
	        clerk.isBusy(); 
	      }
	   
	      // All the clerks in the team are idle so we can make the supervisor idle
	      busy = false;
	      notifyAll();
	      
	    }

	    // Supervisor busy check
	    synchronized public void isBusy() 
	    {
	      while(busy) {                         // While this supervisor is busy
	        try {
	              wait();                       // Wait for notify call.
	        } catch(InterruptedException e) {
	           System.out.println(e);
	       }
	    }
	      
	    }

	    }


