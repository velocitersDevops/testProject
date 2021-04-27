//Write a program that defines a floating-point variable initialized with a dollar value for your
//income and a second floating-point variable initialized with a value corresponding to a tax rate
//of 35 percent. Calculate and output the amount of tax you must pay with the dollars and cents
//stored as separate integer values (use two variables of type int to hold the tax, perhaps
//taxDollars and taxCents).

package com.velociter.training.ankit.chapter2;
class problem3
{
   public static void main(String args[])
   {
 double dollarsallery,intrestrate,rs;
 int taxrs,taxpaisa;
 dollarsallery=138.88;
 intrestrate=((35.00*dollarsallery)/100.00);
 rs=(intrestrate*72.79);
 taxrs=(int) rs;
 taxpaisa=(int)((rs-taxrs)*100);
 System.out.println("Tax Rate in Dollars="+intrestrate);
 System.out.println("Tax Rate in Rs="+taxrs);
 System.out.println("Tax Rate in Paisa="+taxpaisa);
   }
}
