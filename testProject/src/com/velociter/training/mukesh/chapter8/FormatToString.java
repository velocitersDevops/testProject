package com.velociter.training.mukesh.chapter8;

import java.util.Formatter;
import static java.lang.Math.random;

public class FormatToString 
{
  public static void main(String[] args) 
  {
    double[] data = new double[20];
    
    for (int i = 0 ; i<data.length ; i++) 
    {
      data[i] = 100.0*random()-50.0;
    }

    StringBuilder builder = new StringBuilder();          // Buffer to hold output
    Formatter formatter = new Formatter(builder);         // Formatter to format data into buf
    int i = 0;
    for(double value : data) {
      formatter.format("%2d)%+7.2f", ++i, value);
      if(i%5 == 0) {
        formatter.format("%n");
      }
    }
    System.out.println(builder);                          // Output all the values in one go
  }
}