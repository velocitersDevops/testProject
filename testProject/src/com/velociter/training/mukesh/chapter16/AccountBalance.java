package com.velociter.training.mukesh.chapter16;

class AccountBallance 
{
	private int balance = 6000;

	public int getBalance() 
	{
		return balance;
	}
	public void withdraw(int amount) 
	{
		balance = balance - amount;
	}
}