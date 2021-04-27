package com.velociter.training.vivek.chapter16;

public class Account
{
	
	int accountNumber;
	int balance;
	
	Account(int accountNumber,int balance)
	{
		this.accountNumber=accountNumber;
		this.balance=balance;
	}
	
	public void setBalance(int balance)
	{
		this.balance=balance;
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
		return "AC. No "+accountNumber+"   "+"balance is "+balance;
	}

}
