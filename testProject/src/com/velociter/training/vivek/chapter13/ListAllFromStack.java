package com.velociter.training.vivek.chapter13;



class GenericStack <T> 
{
	private final static int INITIAL_SIZE_OF_STACK = 10; 
	private final static int SIZE_INCREMENT = 5;               
	private int itemCount; 								 
	private Object[] items;								
	

	public GenericStack()
	{
		items = new Object[INITIAL_SIZE_OF_STACK];
	}
	
	// Test for empty stack
	  public boolean isEmpty() 
	  {
	    return itemCount == 0;
	  }
	  

	  public void push(T item) 													// pass as a argument generic type parameter
	  {
		    if(itemCount==items.length) 
		    {
		    	Object[] newItems = new Object[items.length + SIZE_INCREMENT];            //when full than increase the size of array
		    	
		    	for(int i = 0 ; i<items.length ; i++) 
		    	{
		    		newItems[i] = items[i];                             // copy all the old array items into new items array
		    	}
		    	items = newItems;
		    }
		    items[itemCount] = item;
		    itemCount++;
	  }
	  
	  public void listAll() 
	  {
		    for(int i = 0 ; i<itemCount ; i++)
		    {
		      System.out.println(items[i]);
		    }
	  }
	  
}

public class ListAllFromStack 
{
	public static void main(String[] args) 
	{
			Integer[] stackInputs = { 2, 1, 3 ,54, 9, 4, 5, 22, 9, 12}; 
			
			GenericStack<Integer> data = new GenericStack<Integer>();
	  
		    
		    // Store the values on the stack
		    System.out.println("Data pushed on to the stack");
		    
		    for(Integer values : stackInputs) 
		    {
		      System.out.println(values);
		      data.push(values);
		    }
		    
		    System.out.println("\nList the contents of the stack:");
		    data.listAll();
	}
}