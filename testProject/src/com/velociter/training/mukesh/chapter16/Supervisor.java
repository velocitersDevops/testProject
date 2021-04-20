package com.velociter.training.mukesh.chapter16;

import java.util.Vector;
import java.util.Random;

public class Supervisor implements Runnable 
{
  
	  private Bank bankObject;            
	  private String name;
	  private Vector<ClerkWithName> clerkTeam = new Vector<ClerkWithName>();
	
	  public Supervisor(Bank bankObject, String name) 
	  {
		  this.bankObject = bankObject;
		  this.name = name;
	  }

	
	  public String getName() 
	  {
		  return this.name;
	  }

	  // Add a clerk to this supervisor's team 
	  
	  public void addClerk(ClerkWithName clerk) 
	  {
		  clerkTeam.add(clerk.setSupervisor(this));
	  }

  // The supervisor:
	  synchronized public void run() 
	  {

	    StringBuffer team = new StringBuffer();
	    
	    for(ClerkWithName clerk : clerkTeam)
	    {
	      team.append(' ').append(clerk.getName());
	    }
	    
	    System.out.println(name + " has started work!" + " My team is: " + team + "\n" );


	    Thread clerkThread = null;
	    for(ClerkWithName clerk : clerkTeam) 
	    {
		      clerkThread = new Thread(clerk);
		      clerkThread.start();
	    }

    // Generate transactions of each type and pass to the clerks:
    Random random = new Random();                     
    Transaction transaction;                         
    int amount = 0;                                  
    int select = 0;                                 
    int transactionType = 0;                         

    int transactionCount = 5;          

    for(int i = 1; i <= transactionCount; i++) 
    {
      
	      amount = 50 + random.nextInt(20);                
	      select = random.nextInt(BankOperationSupervisor.accounts.length);
	      transactionType = random.nextInt(2)==1 ? Transaction.CREDIT: Transaction.DEBIT;      
	
	      transaction = new Transaction(BankOperationSupervisor.accounts[select], transactionType, amount);                        
	        
	      switch(transactionType)
	      {
		        case Transaction.CREDIT:
		          
		        	BankOperationSupervisor.totalCredits[select] += amount;       
		            BankOperationSupervisor.numberOfCredits[select]++;
		          
		            break;
		        case Transaction.DEBIT:
		          
		        	BankOperationSupervisor.totalDebits[select] += amount;        
		            BankOperationSupervisor.numberOfDebits[select]++;
		          
		            break;
		        default:
		         System.out.println( "Invalid transaction type.");
		   }
	
		      assert clerkTeam.size() > 0 : "No clerks in the team!";
		      clerkTeam.elementAt(random.nextInt(clerkTeam.size())).doTransaction(transaction); 
    	}


    		// A supervisor must continue to work while any clerk in the team is working
    
		    for(ClerkWithName clerk : clerkTeam)
		    {
		      clerk.isBusy(); 
		    }
 
		    busy = false;
		    notifyAll();
    
	  }

		  // Supervisor busy check
		  boolean busy = true;
		  synchronized public void isBusy() 
		  {
			    while(busy) 
			    {                         // While this supervisor is busy
			      try
			      {
			            wait();                       // Wait for notify call.
			      } catch(InterruptedException e) 
			      {
			         System.out.println(e);
			     }
			  }
		   }
	   
}