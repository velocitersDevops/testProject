package com.velociter.training.mukesh.chapter16;

public class ClientTest 
{

		public static void main(String[] args)
		{
			
			AccountBallance account = new AccountBallance();
			AccountHolder accountHolder = new AccountHolder(account);
			
			Thread t1 = new Thread(accountHolder);
			Thread t2 = new Thread(accountHolder);
			
			t1.setName("mukesh");
			t2.setName("vivek");
			
			t1.start();
			t2.start();
		}
}

