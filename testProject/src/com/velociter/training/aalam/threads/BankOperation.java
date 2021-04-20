/*
 * 
 * Modify the last example in the chapter so that each transaction is a debit or a credit at random
 */

package com.velociter.training.aalam.threads;

import java.util.Random;

public class BankOperation
{
    public static void main(String[] args)
	{
	     int currentbalance =8000;
   		 int accountNumber =(int)(140000000*Math.random() + 120000000); //12 
		
		int amount =(int)(5000 *Math.random() + 1000); //12 
		
		int transactionType = (int)(2*Math.random() ); 
		String trasactionStatus = null;
		
		if(transactionType == 0)
		{
			trasactionStatus = "Debit";
			System.err.println("Before "+trasactionStatus  +" Trasaction ");
		}else
		{
			trasactionStatus = "Credit";
			System.err.println("Before "+trasactionStatus  +" Trasaction ");
		}
		System.out.println("Account Number  is "+accountNumber);
		 Account accountObject = new Account(accountNumber,currentbalance);
		 System.out.println("Your Current Balance  is  "+accountObject.getBalance());
		 System.out.println();
		 System.out.println("transaction amount  is Rs. "+amount);
		 System.out.println();
		Transaction transactionObject = new Transaction(accountObject,transactionType,amount); //here account is refrence
		System.err.println("After "+trasactionStatus  +" Trasaction ");
		Bank theBank = new Bank();                 // Create a bank.
	    Clerk clerk1 = new Clerk(theBank,transactionObject);         // Create the first clerk.
		  
		// Create the threads for the clerks as daemon, and start them off:
	    Thread clerk1Thread = new Thread(clerk1);
	    clerk1Thread.start();   
	    // Start the first.
	    
	}
}
