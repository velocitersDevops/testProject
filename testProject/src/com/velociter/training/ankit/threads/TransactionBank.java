package com.velociter.training.ankit.threads;
import java.util.Scanner;
 public class TransactionBank 
 {
	int count=0;
	public static void main(String ar[])
	{
		Operation a=new Operation();
	}
 }
  class Operation
   {
	  Operation()
	{
		Debit m1=new Debit();
		m1.balanceInBank(50000);
		Credit m2=new Credit();
		m1.start();
		m2.start();
		
	}
}

class Debit extends Thread
{

	Scanner sc= new Scanner(System.in);
	

	static  double balance;

// Constructor to initialize the account balance.
   public void balanceInBank (double start_balance) {
   balance = start_balance;
   System.out.println("Initial Balance in Account :"+balance);
}

      synchronized  public void debit (int amount) {
         if(amount<balance) {
        	 
	      balance = balance - amount;
	      System.out.println("Debited Amount is "+amount +"  New Balance is"+balance);
		
		}else
			   System.out.println("Debited Amount is too high \n Please Enter valid Amount");
	   }
    //  static DecimalFormat decimalFormat = new DecimalFormat("0.00");
      synchronized public void run()
	{
//		System.out.println("Enter Amount Debited");
		for(int i=0;i<5;i++)
		{
		int debitAmount=(int)(Math.random()*(balance%1000000));
		debit(debitAmount);
	}
	}
      synchronized public double remainBalance()
	{
		//System.out.println("balance Method"+balance);
		return balance;
	}
	
}

class Credit extends Thread
{
	Scanner sc= new Scanner(System.in);
	static double balance=new Debit().remainBalance();
	
	synchronized public void credit (int amount) {
         if(amount>0) {
	      balance = balance + amount;
	      System.out.println("Credited Amount is "+amount +"  New Balance is"+balance);
		
		}else
			   System.out.println("Please Enter valid Amount");
	   }
	synchronized public void run()
	{
	    //System.out.println("Enter Amount Credit");
		for(int i=0;i<5;i++)
		{
		int creditAmount=(int)(Math.random()*(balance));
		credit(creditAmount);
	}
	}
	synchronized public double remainBalance()
	{
		return balance;
	}
}




