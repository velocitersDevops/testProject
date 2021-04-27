package com.velociter.training.vivek.chapter16;

import java.util.Random;

public class BankOperation {

	public static void main(String[] args)
	{
		int [] initialBalance= {20,30};
		int [] totalCredit=new int[initialBalance.length];
		int [] totalDebit=new int[initialBalance.length];
		int [] nCredits=new int[initialBalance.length];
		int [] nDebits=new int[initialBalance.length];
		
		int transactionCount=20;
		
		Bank theBank= new Bank();

		Clerk clerk1= new Clerk(theBank);
		Clerk clerk2= new Clerk(theBank);
		
		Account account [] = new Account[initialBalance.length];
		
		for(int i=0;i<initialBalance.length;i++)
		{
			account[i]=new Account(i+1,initialBalance[i]);
			totalCredit [i]=totalDebit [i]=0;
			nCredits [i]=nDebits [i]=0;
		}	
			Thread clerk1Thread= new Thread(clerk1);
			Thread clerk2Thread= new Thread(clerk2);
			
			
			
			clerk1Thread.start();
			clerk2Thread.start();
			
			Random rand = new Random();
			Transaction transaction;
			int amount;
			int select;
			
			for(int i=0;i<transactionCount;i++)
			{
				  if(rand.nextInt(2)==1)
				  {
					  select =rand.nextInt(account.length);
					  amount=50+rand.nextInt(20);
					  transaction =new Transaction(account[select],Transaction.CREDIT,amount);
					  totalCredit[select]=totalCredit[select]+amount;
					  nCredits[select]++;
					  clerk1.doTransaction(transaction);
				  }
				  else
				  {  
					  select =rand.nextInt(account.length);
					  amount=30+rand.nextInt(20);
					  transaction =new Transaction(account[select],Transaction.DEBIT,amount);
					  totalDebit[select]=totalDebit[select]+amount;
					  nDebits[select]++;
					  clerk2.doTransaction(transaction);
					  
				  }
			}
			
			clerk1.isBusy();
			clerk2.isBusy();
			
			for(int i=0;i<account.length;i++)
			{
				System.out.println("Account number :"+account[i].getAccountNumber()+"\n"
						+"Number of credits  :"+nCredits[i]+"\n"+
						"Number of debits     :"+nDebits[i]+"\n"+
						 "original Balance     :"+initialBalance[i]+"\n"+
						"Total Credit           :"+totalCredit[i]+"\n"+
						 "Total Debits          :"+totalDebit[i]+"\n"+
						"Final Balance          :"+account[i].getBalance()+"\n"+
						 "Should be             :"+(initialBalance[i]+totalCredit[i]-totalDebit[i])+"\n");
						
						
			}
			
			
		}
	}


