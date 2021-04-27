package com.velociter.training.vivek.chapter16;

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
			
			 balance=balance-transaction.getAmount();
			 
			 transaction.getAccount().setBalance(balance);
			 break;
		 }
		 
		 default:
			 System.out.println("Invalid trnsaction ");
			 System.exit(1);
  }
	
	
  }
}
