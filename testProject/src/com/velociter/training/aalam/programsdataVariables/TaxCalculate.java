package com.velociter.training.aalam.programsdataVariables;

public class TaxCalculate
{
   public static void main(String[] args) 
   {
		double income = 10000.34;
		double taxRate =  0.35;   
        double tax = income * taxRate ;
        
        System.out.println("Befor calculation");
        System.out.println("");
        System.out.println("income is    :"+income);
        System.out.println("taxRate is   :"+taxRate);
        System.out.println("tax    is    :"+tax);
       
        
        int taxInDollers = (int)tax; 
        int taxCents = (int)Math.round((tax - taxInDollers)*Math.pow(10.0, 2.0)); 
        System.out.println("tax In Doller    :"+taxInDollers);
        System.out.println("taxCents    :"+taxCents);
        
        // Output the results:
        System.out.println("Gross income is $" + (int)income +"."+ (int)Math.round((income - (int)income)*Math.pow(10.0, 2.0)));
        System.out.println("Tax to pay is " + taxInDollers + " dollars and "+taxCents+" cents.");

	}

}
