package com.velociter.training.mukesh.chapter16;


import java.util.Random;

public class BankOperationSupervisor 
{
		
		// Bank Account information:
		static int[] initialBalance = {500, 800};
		static int size=initialBalance.length;
		
		static int[] totalCredits = new int[size]; 
		static int[] totalDebits = new int[size];  
		static int[] numberOfCredits = new int[size]; 	  
		static int[] numberOfDebits = new int[size];  	  
		
		static Account[] accounts = new Account[size];

		public static void main(String[] args) 
		{
				String[] supervisorNames = {"mukesh", "vivek"};
	
				Bank bankObject = new Bank();                                

			    // Create the accounts, and initialize total credits and debits:
				 for(int i = 0; i < size; i++) 
				 {
				   accounts[i] = new Account(i+1, BankOperationSupervisor.initialBalance[i]); 
				   totalCredits[i] = BankOperationSupervisor.totalDebits[i] = 0;
				   numberOfCredits[i] = numberOfDebits[i] = 0;
				 }

				 // Create the supervisors:
				 Supervisor[] supervisors = new Supervisor[supervisorNames.length];
				 for(int i = 0; i < supervisors.length; i++) 
				 {
				   supervisors[i] = new Supervisor(bankObject, supervisorNames[i]);
				 }
		 
 
		 		 String[] nameOfClerks = { "soutam", "narayan", "ankit", "karan","aalam" }; 
		 		 
		 		 int pick = 0;       // Picks one or other supervisor
		 	    for(String clerkName : nameOfClerks) 
		 	    {
		 	     supervisors[pick++ % supervisors.length].addClerk(new ClerkWithName(bankObject, clerkName));
		 	    }

		 	    Thread supervisorThread = null;
		 	    for(Supervisor supervisor : supervisors) 
		 	    {
		 	      supervisorThread = new Thread(supervisor);
		 	      supervisorThread.start();
		 	    }

		 	    // Sit here until the Supervisors say they're done:
		 	    for(Supervisor supervisor : supervisors)
		 	    {
		 	      supervisor.isBusy();
		 	    }

		 	    // Now output the results:
		 	    for(int i = 0; i < BankOperationSupervisor.accounts.length; i++) {
		 	      System.out.println("Account Number:"+accounts[i].getAccountNumber()+"\n"+
		 	         "Number of credits   :  " + numberOfCredits[i] + "\n" +
		 	         "Number of debits    :  " + numberOfDebits[i] + "\n" +
		 	         "Original balance    : $" + initialBalance[i] + "\n" +
		 	         "Total credits       : $" + totalCredits[i] + "\n" +
		 	         "Total debits        : $" + totalDebits[i] + "\n" +
		 	         "Final balance       : $" + accounts[i].getBalance());
		 	    }
		 	  }
		 		 
		
		}
