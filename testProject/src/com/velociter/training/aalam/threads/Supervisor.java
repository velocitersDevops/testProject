package com.velociter.training.aalam.threads;

import java.util.Random;
import java.util.Vector;
public class Supervisor implements Runnable
{
   private Bank bank;
   private String supervisorName;
   private Vector<ClerkWithSupervisor> vectorObjectForclerkTeam = new Vector<ClerkWithSupervisor>();                     //to hold clerk Object in vector
   //constructor initialized with  bank and supervisor value
   public Supervisor(Bank bank , String supervisorName)
   {
	   this.bank = bank;
	   this.supervisorName = supervisorName;
   }
   
   //return the supervisor name
   public String getName()
   {
	   return supervisorName;
   }
   
   // Add a clerk to this supervisor's team 
   public void addClerk(ClerkWithSupervisor clerkObject)
  {                                                               //we have to pass Supervisor object to clerk class becouse there we need to call getName()
	   vectorObjectForclerkTeam.add(clerkObject.setSupervisor(this));   //go to clerk class setsupervisor() with current Supervisor Object and it return back with ClerkObject 
   }                                                              //then add to the Vector object
  
   public void run() 
   {
		StringBuffer stringBufferObjectForClerkTeam = new StringBuffer(); //using stringBuffer to hold name of superviser team member
		for(ClerkWithSupervisor clerk : vectorObjectForclerkTeam)
		{
			stringBufferObjectForClerkTeam.append(' ').append(clerk.getName());    //here clerk name will be uppend to the stringbuffer object with space every iteration
		}
		System.out.println(supervisorName + "  started work!"  + " My team is: " + stringBufferObjectForClerkTeam  );
       
		
		Thread clerkThread = null;  //creating refrence of thread for create Clerk Threads
        for(ClerkWithSupervisor clerkObject : vectorObjectForclerkTeam)
        {
        	clerkThread = new Thread(clerkObject);
        	clerkThread.start();
        }
        
        int currentbalance = 8000;
		
		
			int accountNumber = (int) (140000000 * Math.random() + 120000000);
			int amount = (int) (5000 * Math.random() + 1000);
			int transactionType = (int) (2 * Math.random());
			String trasactionStatus = null;
			if (transactionType == 0) {
				trasactionStatus = "Debit";
				System.out.println("Before " + trasactionStatus + " Trasaction ");
			} else {
				trasactionStatus = "Credit";
				System.out.println("Before " + trasactionStatus + " Trasaction ");
			}
			System.out.println("Account Number  is " + accountNumber);
			Account accountObject = new Account(accountNumber, currentbalance);
			System.out.println("Your Current Balance  is  " + accountObject.getBalance());
			System.out.println();
			System.out.println("transaction amount  is Rs. " + amount);
			System.out.println();
			Transaction transactionObject = new Transaction(accountObject, transactionType, amount); // here account is
																										// refrence
			System.out.println("After " + trasactionStatus + " Trasaction ");
            Random randomObject = new Random();
            // Pick a random clerk to take care of the transaction:
            vectorObjectForclerkTeam.elementAt(randomObject.nextInt(vectorObjectForclerkTeam.size())).doTransaction(transactionObject);
			bank.doTransaction(transactionObject);
//			
		
	}

}

