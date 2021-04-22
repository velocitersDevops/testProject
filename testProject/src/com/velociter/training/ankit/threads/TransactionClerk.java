package com.velociter.training.ankit.threads;
import java.util.Scanner;
 public class TransactionClerk {
	public static void main(String ar[])
	{
		new Clerk1();
		new Clerk2();
	 //m1.start();
	}
   }
  class Clerk1
   {
	Clerk1()
	{
		System.out.println("For Clerk One");
		Debit m1=new Debit();
		m1.balanceInBank(50000);
		Credit m2=new Credit();
		m1.start();
		m2.start();
		
	}
}
  class Clerk2
  {
	Clerk2()
	{
		System.out.println("For Clerk two");
		Debit m1=new Debit();
		m1.balanceInBank(100000);
		Credit m2=new Credit();
		m1.start();
		m2.start();
	}
}
