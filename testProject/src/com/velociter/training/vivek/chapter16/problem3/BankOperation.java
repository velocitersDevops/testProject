package com.velociter.training.vivek.chapter16.problem3;

public class BankOperation
{
	static int[] initialBalance = {500, 800, 1500};  			    
	  static int[] totalCredits = new int[initialBalance.length]; 
	  static int[] totalDebits = new int[initialBalance.length];  
	  static int[] nCredits = new int[initialBalance.length]; 	  
	  static int[] nDebits = new int[initialBalance.length];  	  
	  static Account[] accounts = new Account[initialBalance.length];

	  public static void main(String[] args)
	  {
	    String[] superviserNames = {"Mahak", "allaiya"};

	    // Create the bank
	    Bank theBank = new Bank();                                // Create a bank.

	    // Create the accounts, and initialize total credits and debits:
	    for(int i = 0; i < BankOperation.initialBalance.length; i++)
	    {
	      accounts[i] = new Account(i+1, BankOperation.initialBalance[i]); // Create accounts
	      totalCredits[i] = BankOperation.totalDebits[i] = 0;
	      nCredits[i] = nDebits[i] = 0;
	    }

	    // Create the Supervisers:
	    Superviser[] supervisers = new Superviser[superviserNames.length];
	    for(int i = 0; i < supervisers.length; i++) 
	    {
	      supervisers[i] = new Superviser(theBank, superviserNames[i]);
	    }
	    
	    // Create sufficient clerks for each Superviser to have a team
	    // of four, and distribute the clerks between the Supervisers
	    String[] clerkNames = { "Mojan", "Rohan","abhishek", "Dave","sohan" , "Feridanand", "Gina"  , "Henry" };
	                            

	    int pick = 0;       // Picks one or other Superviser
	    for(String clerkName : clerkNames)
	    {
	     supervisers[pick++ % supervisers.length].addClerk(new Clerk(theBank, clerkName));
	    }

	    // Create the threads for the Supervisers and start them off:
	    Thread superviserThread = null;
	    for(Superviser superviser : supervisers)
	    {
	      superviserThread = new Thread(superviser);
	      superviserThread.setDaemon(true);
	      superviserThread.start();
	    }

	    // Sit here until the Supervisers say they're done:
	    for(Superviser Superviser : supervisers) 
	    {
	      Superviser.isBusy();
	    }

	    // Now output the results:
	    for(int i = 0; i < BankOperation.accounts.length; i++) 
	    {
	      System.out.println("Account Number:"+accounts[i].getAccountNumber()+"\n"+
	         "Number of credits   :  " + nCredits[i] + "\n" +
	         "Number of debits    :  " + nDebits[i] + "\n" +
	         "Original balance    : $" + initialBalance[i] + "\n" +
	         "Total credits       : $" + totalCredits[i] + "\n" +
	         "Total debits        : $" + totalDebits[i] + "\n" +
	         "Final balance       : $" + accounts[i].getBalance() + "\n" +
	         "Should be           : $" + (initialBalance[i] + totalCredits[i] -
	                                        totalDebits[i]) + "\n");
	    }
	  }
}
