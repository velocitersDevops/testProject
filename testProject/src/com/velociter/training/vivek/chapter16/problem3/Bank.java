package com.velociter.training.vivek.chapter16.problem3;



public class Bank 
{
	public void doTransaction(Transaction transaction)
	  {
		 switch(transaction.gettransactionType()) 
		 
		 {
		 case Transaction.CREDIT:
		  synchronized(transaction.getAccount())    
		 {
			System.out.println("start credit of "+transaction.getAccount()+" amount :"+transaction.getAmount()); 
			int balance =transaction.getAccount().getBalance();
			
			 balance=balance+transaction.getAmount();
			 
			 transaction.getAccount().setBalance(balance);
			 break;
		 }
		 
		 
		 
		 
		 
		 case Transaction.DEBIT:
			 
		       
			 synchronized(transaction.getAccount())    
			 {
				System.out.println("start Debit of "+transaction.getAccount()+" amount :"+transaction.getAmount()); 
				int balance =transaction.getAccount().getBalance();
				
				  // Credits require require a lot of checks:
		        try
		        {
		          Thread.sleep(100);		
		        } catch(InterruptedException e) 
		        {
		          System.out.println(e);
		        }
				
				 balance=balance-transaction.getAmount();
				 
				 try
				 {
			          Thread.sleep(150);
			      }
				 catch(InterruptedException e)
				 {
			          System.out.println(e);
			      }
				 
				 transaction.getAccount().setBalance(balance);
				 break;
			 }
			 
			 default:
				 System.out.println("Invalid trnsaction ");
				 System.exit(1);
	  }
		
		
	  }
}
