package com.velociter.training.vivek.chapter16.problem2;

import com.velociter.training.vivek.chapter16.problem2.Account;

public class Transaction 
{
  
	public final static int   DEBIT=1;
	public final static int  CREDIT=0;
	private  Account account;
	private int amount;
	private int transactionType;
	public static String  type []= {"CREDI","DEBIT"};
	
	Transaction(Account account,int transactionType,int amount)
	{
		this.account=account;
		this.amount=amount;
		this.transactionType=transactionType;
	}
	
	public Account getAccount()
	{
		return account;
	}
	
	public int getAmount()
	{
		return amount;
	}
	public int gettransactionType()
	{
		return transactionType;
	}
	
	public String toString()
	{
		return type[transactionType]+"Rs :"+amount;
	}
	
	
}
