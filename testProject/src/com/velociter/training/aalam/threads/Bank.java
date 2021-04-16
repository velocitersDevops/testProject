package com.velociter.training.aalam.threads;

public class Bank 
{

	
	// Perform a transaction:
	  public void doTransaction(Transaction transaction) 
	  {
	    switch(transaction.getTransactionType())                  // based on credit or debit execute the case
	    {
	    
	      case Transaction.CREDIT:                                
	    	   int balance = transaction.getAccount().getBalance();    // Get current balance:here getBalance() is a Refrence Type Of  Account Class
	        try 
	        {
	          Thread.sleep(2000);		                            //to stop execution for 100 milisecond (1 second)
	        }
	        catch(InterruptedException e) 
	        {           
	          System.out.println(e);
	        }
	        balance += transaction.getAmount();                    // Increment the balance.
	        transaction.getAccount().setBalance(balance);          // Restore account balance. or update balance with new balance after credit amount
	        System.out.println("   credit Transaction from " + transaction.getAccount());           
	        break;
	     
	//=====================================================================================================
	      case Transaction.DEBIT:                              
	    	 
 	       // System.out.println("Start debit  of " + transaction.getAccount() + " amount: " +transaction.getAmount());
	        int bbalance = transaction.getAccount().getBalance();    // Get current balance
	        try 
	        {
	          Thread.sleep(2000);                                   //stop or hold execution for 150 millicecond
	        } 
	        catch(InterruptedException e) 
	        {
	          System.out.println(e);
	        }
	        bbalance -= transaction.getAmount();                    // Decrement the balance.
	        transaction.getAccount().setBalance(bbalance);          // Restore account balance.or update balance after debit amount from account
            System.out.println("  Debit Transaction from " + transaction.getAccount());
	        break;
	      
	      
	      default:                                          // We should never get here.
	        System.out.println("Invalid transaction");
	        System.exit(1);
	    }
	  }

	
}

