package com.velociter.training.mukesh.chapter16;

class Bank 
{
 
	  public void doTransaction(Transaction transaction) 
	  {
	    
			switch(transaction.getTransactionType()) 
		    {
		      
		    	case Transaction.CREDIT:
		     
			    	  synchronized(transaction.getAccount()) 
					  {
			    		  			
						    		  // Get current balance:
						    		int balance = transaction.getAccount().getBalance();
						
						        
							        try 
							        {
							          Thread.sleep(100);		
							        } 
							        catch(InterruptedException e)
							        {
							          System.out.println(e);
							        }
							        balance =balance+ transaction.getAmount();             // Increment the balance.
							        transaction.getAccount().setBalance(balance);   		// Restore account balance.
						
						        
							        System.out.println(" credit of " +transaction.getAccount() + " amount: " + transaction.getAmount());
							        break;
			    	  }
		         
		    	case Transaction.DEBIT:
		          
		        	 synchronized(transaction.getAccount())
		        	 {
						       
						        int balance = transaction.getAccount().getBalance();
		
				        
						        try
						        {
						          Thread.sleep(100);
						        } catch(InterruptedException e) 
						        {
						          System.out.println(e);
						        }
						       
						        balance = balance-transaction.getAmount();            
						        transaction.getAccount().setBalance(balance);         
				
						        System.out.println(" debit of " +transaction.getAccount() + " amount: " +transaction.getAmount());
						        break;
		        	 }
		    	
		    	default:                                        
			        System.out.println("Invalid transaction");
			        System.exit(1);
		    }
	  }
}
