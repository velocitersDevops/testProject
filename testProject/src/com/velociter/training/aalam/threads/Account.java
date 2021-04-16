package com.velociter.training.aalam.threads;

public class Account
{
	  private int balance;                             // The current account balance.
	  private int accountNumber; 

	 
	  public Account(int accountNumber, int balance) 
	  {
	    this.accountNumber = accountNumber;            // Set the account number.
	    this.balance = balance;                        // Set the initial balance.
	  }

	  // Return the current balance:
	  public int getBalance() 
	  {
	    return balance;
	  }

	  // Set the current balance:
	  public void setBalance(int balance)
	  {
	    this.balance = balance;
	  }

	  public int getAccountNumber()
	  {
	    return accountNumber;
	  }

	  public String toString()
	  {
	    return "A//C No. "+accountNumber+" :Current Balance Rs."+balance;
	  }

	                      // Identifies this account.

	
}
