package com.velociter.training.aalam.generics;

public class TestStack
{

	public static void main(String[] args)
	{
		/*
		 // Values to be stored in stack and then retrieved
	    double[] values = { 1.0, 1.2 , 1.3 , 1.4, 1.5, 1.6, 1.7, 1.9, 2.1, 2.2 }; 
	    
	    Stack<Double> data = new Stack<Double>();   //here we are giving generic Type Argument as Double
	                                                // it means we will deal stack with Double Type value
	    System.out.println(" start Data pushing onto the stack in one by one:");
	    for(double doubleValue : values)
	    {
	      System.out.println(doubleValue+" , ");
	      data.push(doubleValue);
	    }

	    double back = 0;
	    System.out.println("\nData retrieved from the stack in sequence is:");
	    while(!data.isEmpty()) 
	    {
	       System.out.print(data.pop()+" , ");
	    }

	     System.out.println("finally check Stack status: "+data.pop());

	 */   
	   // Values to be stored in stack and then retrieved
	    String[] values = { "raju" ,  "ajay" , "karan" , "ramesh" , "ajay" ,"vinod" ,"raul" , "arun"  ,"rama"  ,"vivek"}; 
	    
	    Stack<String> data = new Stack<String>();   //here we are giving generic Type Argument as Double
	                                                // it means we will deal stack with Double Type value
	    
	    
	      System.out.println(" start Data pushing onto the stack  one by one:");
	      System.out.println();
	    for(String StringValue : values)
	    {
	      System.out.print(StringValue+" , ");
	      data.push(StringValue);
	    }
	    System.out.println();
	  //  String back = 0;
	    System.out.println("\nData retrieved from the stack one by one:");
	    System.out.println();
	    while(!data.isEmpty()) 
	    {
	      System.out.print(data.pop()+" , ");
	    }

	    System.out.println("finally check Stack status: "+data.pop());

	    
	    
	  
	}

}
