package com.velociter.training.mukesh.chapter13;

class Stack <T> 											//stack of generic type 
{
		private final static int SIZE = 10; 
		private final static int SIZE_INCREMENT = 5;               // size increment when full
		private int noOfItemsCount; 								 // count number of item
		private Object[] items;								// to store items in the stack
		
		public Stack() 
		{
			items = new Object[SIZE];
		}
		
		// Test for empty stack
		  public boolean isEmpty() 
		  {
		    return noOfItemsCount == 0;
		  }

		  
		  public void push(T item) 
		  {
			    if(noOfItemsCount==items.length) 
			    {
			    	Object[] newItems = new Object[items.length + SIZE_INCREMENT];            //wwhen full than increase the size of array
			    	
			    	for(int i = 0 ; i<items.length ; i++) 
			    	{
			    		newItems[i] = items[i];                             // copy all the old array items into new items array
			    	}
			    	items = newItems;
			    }
			    items[noOfItemsCount] = item;
			    
			    noOfItemsCount++;
		  }

  
		  public T pop()
		  {
			    if(noOfItemsCount == 0)
			    {
			      return null;
			    }
		    T item = (T)items[--noOfItemsCount];                 //pop item one by one
		    
		    items[noOfItemsCount] = null;             // Erase the object from the stack
		    
		    return item;
		  }

}

public class StackPushPop 
{
	public static void main(String[] args) 
	{
		double[] inputs = { 2.2, 1.01, 3.0 ,23.1, 9.7, 4.9, 5.5, 3.4, 9.0, 12.0}; 
		
    
    Stack<Double> data = new Stack<Double>();
  
    
    // Store the values on the stack
    System.out.println("Data pushed");
    
    for(double values : inputs) 
    {
      System.out.println(values);
      data.push(values);
    }
    
    System.out.println("\nData poped");
    
    while(!data.isEmpty()) 
    {
      System.out.println(data.pop());
    }

    
  }
}