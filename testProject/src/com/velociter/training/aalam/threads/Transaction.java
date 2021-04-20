package com.velociter.training.aalam.threads;

public class Transaction
{

	 // Transaction types: constant type
	  public static final int DEBIT = 0;                 //thic constant will we use in Bank class to select Trasaction
	  public static final int CREDIT = 1;
	  public static String[] types = {"Debit","Credit"};
	  private Account account;
	  private int amount;
	  private int transactionType;

	  // Constructor: to set 3 values acount,and what we want to perform transection(debit or credi) with specific amount
	  public Transaction(Account account, int transactionType, int amount)
	  {
	    this.account = account;
	    this.transactionType = transactionType;
	    this.amount = amount;
	  }

	  public Account getAccount() 
	  {
	    return account;             //it will return Account Class Object
	  }

	  public int getTransactionType() {
	    return transactionType;
	  }

	  public int getAmount() {
	    return amount;
	  }

	  public String toString() {
	    return account+"  "+amount;
	  }

	 

}
