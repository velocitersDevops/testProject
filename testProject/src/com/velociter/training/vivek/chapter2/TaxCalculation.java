package com.velociter.training.vivek.chapter2;

public class TaxCalculation
{
	public static void main(String args[]) 
	  {
	    double income = 87562.34;   
	    double taxRate = 0.35;   // 35%  corresponds to 0.35
	    double tax = income*taxRate;             
	    System.out.println(tax);
	    
	    int taxDollars = (int)tax;
	    System.out.println(taxDollars);
	    
	    int taxCents = (int)Math.round((tax - taxDollars)*Math.pow(10.0, 2.0)); 
	    System.out.println(taxCents);
	    
	    // Output the results:
	    System.out.println("Gross income is $" + income );
	    System.out.println("Tax to pay is " + taxDollars + " dollars and "+taxCents+" percents.");

	  }
}
