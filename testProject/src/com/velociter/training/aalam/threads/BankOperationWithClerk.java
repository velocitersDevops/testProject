/*
 * 
 *2nd problem - Modify the result of the previous exercise to incorporate an array of clerks, each running in their
own thread and each able to handle both debits and credits.(in simply how many clerk that many Clerk object with name and Bank Object and 
Thread will create .we will show the name of clerk for each thread witch clerk do witch task) 
 */

package com.velociter.training.aalam.threads;

public class BankOperationWithClerk {

	public static void main(String[] args) {
		int currentbalance = 8000;
		// clerk names
		String[] clerkNames = { "Arjun kumar", "ram singh", "rajpal Sindhe", "piyush chavla" };

		for (int i = 0; i < clerkNames.length; i++) {
			int accountNumber = (int) (140000000 * Math.random() + 120000000);
			int amount = (int) (5000 * Math.random() + 1000);
			int transactionType = (int) (2 * Math.random());
			String trasactionStatus = null;
			if (transactionType == 0) {
				trasactionStatus = "Debit";
				System.err.println("Before " + trasactionStatus + " Trasaction ");
			} else {
				trasactionStatus = "Credit";
				System.err.println("Before " + trasactionStatus + " Trasaction ");
			}
			System.out.println("Account Number  is " + accountNumber);
			Account accountObject = new Account(accountNumber, currentbalance);
			System.out.println("Your Current Balance  is  " + accountObject.getBalance());
			System.out.println();
			System.out.println("transaction amount  is Rs. " + amount);
			System.out.println();
			Transaction transactionObject = new Transaction(accountObject, transactionType, amount); // here account is
																										// refrence
			System.err.println("After " + trasactionStatus + " Trasaction ");

			// Create the clerks:
			Clerk[] clerks = new Clerk[clerkNames.length]; // clerk array object created
			Bank theBank = new Bank(); // Create a bank. // create thread Object (4 clerk object will create
			clerks[i] = new Clerk(theBank, transactionObject, clerkNames[i]); // Create the first clerk with name.
			clerks[i].getName();

			// Create the threads equaly to clerks (How many clerk that many Thread will
			// create):
			Thread[] clerkThread = new Thread[clerks.length]; // thread array

			clerkThread[i] = new Thread(clerks[i]);
			clerkThread[i].start();
			System.out.println();
			int j = i;
			j++;
			System.out.println(j + "  transaction completed");
			System.out.println();
		}

	}

}
