package com.velociter.training.aalam.threads;

public class BankOperationWithSuperviser
{

	public static void main(String[] args)
	{
		 String[] supervisorNames = {"Mr. RajKisor Mishra", "Mr. alok kumar"};
		
		 // Create the bank
		 Bank bankObject = new Bank(); 
		 
		 // Create the supervisorsName Array Object to hold supervisor Object:
		 Supervisor[] supervisorsObject = new Supervisor[supervisorNames.length];   //2 object will create
		 for(int i=0; i < supervisorsObject.length;i++ )
		 {
			 supervisorsObject[i] = new Supervisor(bankObject, supervisorNames[i]);
		 }
		 
		 //deviding the clerks in supervisor team
		 String clerkNames [] = {"ashok" , "rohit" , "sneha" , "ashok", "pramod" ,"siva" };
		 
		 int pick = 0;
		 //Adding clerk to supervisor team
		  for(String clerkName : clerkNames)
		  {
			 
			  supervisorsObject[pick++ % supervisorsObject.length].addClerk(new ClerkWithSupervisor(bankObject, clerkName)); 
			  //System.out.println("above code alway index will be 0 or 1");
		  }
		  
		  // Create the threads for the supervisors and start them off:
		    Thread supervisorThread = null;
		    for(Supervisor supervisor : supervisorsObject)  //it will ierate 2 times for each supervisor
		    {
		      supervisorThread = new Thread(supervisor);
		      supervisorThread.start();
		    }
	}

}
