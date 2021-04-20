package com.velociter.training.mukesh.chapter16;

import java.util.Random;

public class BankOperation 
{
	  public static void main(String[] args)   
	  {
		    int[] initialBalance = {500, 800}; 
		    
		    int size=initialBalance.length;
		    
		    int[] totalCredits = new int[size]; 
		    int[] totalDebits = new int[size];  
		    int[] numberOfCredits = new int[size]; 		 
		    int[] numberOfDebits = new int[size];  		 
		    
		    
		    Bank bankObject = new Bank();                
		   
		    Clerk firstclerk = new Clerk(bankObject);        
		    Clerk secondclerk = new Clerk(bankObject);         
		
		   
		    Account[] accounts = new Account[size];
		    
		    for(int i = 0; i < size; i++) 
		    {
		      accounts[i] = new Account(i+1, initialBalance[i]); 
		      
		      totalCredits[i] = totalDebits[i] = 0;
		      numberOfCredits[i] =numberOfDebits[i] = 0;
		    }

		    Thread firstclerkThread = new Thread(firstclerk);
		    Thread secondclerkThread = new Thread(secondclerk);
		    	
		    	firstclerkThread.start();                           
		    	secondclerkThread.start();                            

		    	Random random = new Random();                      
		    	Transaction transaction;                         
		    	int amount;                                      
		    	int select;                                      // Selects an acount
		    	int transactionCount = 5;      
		    	
		    	for(int i = 1; i <= transactionCount; i++) 
		    	{
      
		    		if(random.nextInt(2)==1) 
		    		{
		    			// Generate a random account index for credit operation:
		    			select = random.nextInt(accounts.length);
		    			amount = 50 + random.nextInt(20);                
		    			transaction = new Transaction(accounts[select], Transaction.CREDIT, amount);           
		    			totalCredits[select] += amount;                
		    			numberOfCredits[select]++;

		    			firstclerk.doTransaction(transaction);
		    		}
		    		else 
		    		{
		    			// Generate a random account index for debit operation:
		    			select = random.nextInt(accounts.length);
		    			amount = 30 + random.nextInt(20);                	
		    			transaction = new Transaction(accounts[select], Transaction.DEBIT, amount);             
		    			totalDebits[select] += amount;                 	
		    			numberOfDebits[select]++;

		    			secondclerk.doTransaction(transaction);
		    		}
		    	}
			
			    // Wait until both clerks are done
			   firstclerk.isBusy();
			   secondclerk.isBusy();

    
			   // Now output the results:
			   for(int i = 0; i < accounts.length; i++)
				   System.out.println("Account Number:"+accounts[i].getAccountNumber()+"\n"+
						   			  "Number of credits   :  " +numberOfCredits[i] + "\n" +
						   			  "Number of debits    :  " +numberOfDebits[i] + "\n" +
						   			  "Original balance    : $" + initialBalance[i] + "\n" +
						   			  "Total credits       : $" + totalCredits[i] + "\n" +
						   			  "Total debits        : $" + totalDebits[i] + "\n" +
						   			  "Final balance       : $" + accounts[i].getBalance() );
  }
}