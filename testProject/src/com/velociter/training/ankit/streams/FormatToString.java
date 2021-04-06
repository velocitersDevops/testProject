package com.velociter.training.ankit.streams;

import static java.lang.Math.random;

import java.util.Formatter;

public class FormatToString {
  public static void main(String[] args) {
    double[] data = new double[20];
    
    for (int i = 0 ; i<data.length ; i++) {
      data[i] = 100.0*random()-50.0;
    }

    StringBuilder buf = new StringBuilder();          // Buffer to hold output
    Formatter formatter = new Formatter(buf);         // Formatter to format data into buf
    int i = 0;
    for(double x : data) {
      formatter.format("%4d)%+7.2f", ++i, x);
      if(i%5 == 0) {
        formatter.format("%n");
      }
    }
    System.out.println(buf);                          // Output all the values in one go
  }
}