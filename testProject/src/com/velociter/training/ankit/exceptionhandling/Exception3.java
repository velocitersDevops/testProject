package com.velociter.training.ankit.exceptionhandling;

public class Exception3 {
public static void main(String args[]) {
 try {
   Iteration();
 } catch(ArrithmeticIteration exception) {
   System.out.println("Total Iteration is "+exception.getIteration());
 }
}

static void Iteration() throws ArrithmeticIteration {
 int iteration=0;                           
  for(iteration=0;;iteration++)
   try {
    int  divisor = (int)(100*Math.random()); 
     int result = 1000/divisor;                   		
   } catch(ArithmeticException exception) {
     throw new ArrithmeticIteration(iteration);
   }
}
}
