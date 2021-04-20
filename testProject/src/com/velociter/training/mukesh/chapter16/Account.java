package com.velociter.training.mukesh.chapter16;

public class Account 
{
 
	 	private int balance;                             
	 	private int accountNumber; 
	  
	  public Account(int accountNumber, int balance) 
	  {
		    this.accountNumber = accountNumber;            // account number.
		    this.balance = balance;                        // initial balance.
	  }

	  public void setBalance(int balance) 
	  {
		  	this.balance = balance;
	  }
 
	  public int getBalance() 
	  {
		  return balance;
	  }

	  public int getAccountNumber() 
	  {
		  return accountNumber;
	  }

	  public String toString() 
	  {
		  return "A//C No. "+accountNumber+" : $"+balance;
	  }

                       
}
