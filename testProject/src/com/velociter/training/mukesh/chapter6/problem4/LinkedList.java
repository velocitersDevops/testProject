package com.velociter.training.mukesh.chapter6.problem4;

public class LinkedList 
{
	private ListItem start = null;         // First ListItem in the list
	private ListItem end = null;           // Last ListItem in the list
	private ListItem current = null;       // The current item for iterating

	public LinkedList() 
	{}
	
	public LinkedList(Object item) 
	{
		if(item != null) 
		{
		current=end=start=new ListItem(item); // item is the start and end
		}
	}

	// Construct a linked list from an array of objects
	public LinkedList(Object[] items)
	{
		if(items != null) 
		{
			// Add the items to the list
			for(int i = 0; i < items.length; i++)
			{
				addItem(items[i]);
				System.out.println(items[i]);
			}
			current = start;
		}
	}

		// Add an item object to the list
	public void addItem(Object item) 
	{
		ListItem newEnd = new ListItem(item);   	  // Create a new ListItem
		if(start == null) 
		{                     						  // Is the list empty?
			start = end = newEnd;                 	  // Yes, so new element is start and end
		}
		else 
		{                                			 // No, so append new element
			   end.next = newEnd;                    // Set next variable for old end
			   newEnd.previous = end;                // Set previous as old end item  
			   end = newEnd;                         // Store new item as end 
		}
	}

	// method to Get the first object in the list
	public Object getFirst()
	{
	 current = start;
	 return start == null ? null : start.item;
	}

	// Get the next object in the list
	public Object getNext() 
	{
		 if(current != null) 
		 {
		   current = current.next;        // Get the reference to the next item
		 }
		 return current == null ? null : current.item;
	}
	// method to get the last object in the list
	public Object getLast() 
	{   
		current = end;
		return end == null ? null : end.item;
	}

		// method to get the previous object in the list
	public Object getPrevious() 
	{
		 if(current != null) 
		 {
		   current = current.previous;        // Get the reference to the next item
		 }
		 return current == null ? null : current.item;
	}

	

	
}
