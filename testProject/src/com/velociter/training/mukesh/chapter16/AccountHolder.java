package com.velociter.training.mukesh.chapter16;


public class AccountHolder implements Runnable 
{
		private AccountBallance account;
	
		public AccountHolder(AccountBallance account) 
		{
			this.account = account;
		}

			
			public void run() 
			{
				for (int i = 1; i <= 3; i++) 
				{
					makeWithdrawal(2000);
					
					if (account.getBalance() < 0)
					{
						System.out.println("account is overdrawn!");
					}
				}
			}

			private synchronized void makeWithdrawal(int withdrawAmount) 
			{
				if (account.getBalance() >= withdrawAmount)
				{
					System.out.println(Thread.currentThread().getName()	+ " is going to withdraw $"+withdrawAmount);
					try
					{
						Thread.sleep(3000);
					} 
					catch (InterruptedException ex) 
					{
						System.out.println(ex);
					}
					account.withdraw(withdrawAmount);
					
					System.out.println(Thread.currentThread().getName()	+ " completes the withdrawal of $"+withdrawAmount);
				} 
				else 
				{
					System.out.println("Not enough balance in account for "	+ Thread.currentThread().getName() + " to withdraw "+ account.getBalance());
				}
			}
}