package com.velociter.training.aalam.threads;

public class Clerk implements Runnable 
{
	private Bank bankObject =null;
	private Transaction trasactionObject =null;
	private Supervisor supervisor;
	
	String clerkName =null;
	  // Constructors
	
	  public Clerk(Bank theBank ,Transaction transaction)
	  {
	    this.bankObject = theBank;          	
	    this.trasactionObject =  transaction;        
	  }
	  
	  public Clerk(Bank theBank ,Transaction transaction,String name)
	  {
	    this.bankObject = theBank;          	
	    this.trasactionObject =  transaction; 
	    this.clerkName = name;
	  }
	  
	
		  // getName method:
		  public String getName() 
		  {
			  System.out.println("clerk  "+clerkName);
		    return clerkName;
		  }

		  // Thread Will Start Running:
   public void run()
   {
     bankObject.doTransaction(trasactionObject);
    }

public Clerk setSupervisor(Supervisor supervisor)
{
	this.supervisor =  supervisor;
	return this;
}

}
