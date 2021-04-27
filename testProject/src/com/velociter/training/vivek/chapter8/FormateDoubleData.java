package com.velociter.training.vivek.chapter8;

import static java.lang.Math.random;

public class FormateDoubleData 
{

	  public static void main(String[] args) 
	  {
	    double[] data = new double[20];
	    
	    for (int i = 0 ; i<data.length ; i++)
	    {
	      data[i] = 100.0*random()-50.0;
	    }
	    int i = 0;
	    for(double value : data) {
	      System.out.printf("%4d)%+7.2f", ++i, value);
	      if(i%5 == 0) 
	      {
	        System.out.println();
	      }
	    }
	  }

}
