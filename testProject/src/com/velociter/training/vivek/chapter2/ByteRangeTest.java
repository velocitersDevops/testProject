package com.velociter.training.vivek.chapter2;

public class ByteRangeTest
{
	 public static void main(String args[]) 
	  {
	   
	    byte data = 1;

	    data *= 2; 
	    System.out.println("data = " + data);       //1 time
	    data *= 2; 
	    System.out.println("data = " + data);		//2 time
	    data *= 2; 
	    System.out.println("data = " + data);		//3 time
	    data *= 2; 
	    System.out.println("data = " + data);		//4 time
	    data *= 2; 
	    System.out.println("data = " + data);		//5 time
	    data *= 2; 
	    System.out.println("data = " + data);		//6 time
	    data *= 2; 
	    System.out.println("data = " + data);		//7 time
	 
	    // Value of data is now out of the byte range, which is -128 to +127
	    //-2^(n-1) to +(2^(n-1))-1      here n=8 bits
	    //whenever put the 9th bit then out of range and print 0
	    // At this point we have stored 128 in data - in binary 1000 0000
	    data *= 2; 
	    System.out.println("data = " + data);
	 
	    
	  }
}
