package com.velociter.training.mukesh.chapter6.problem6;

public class ListItem 
{
		ListItem next;                       
		ListItem previous;                   
		Object item;                         
	
		public ListItem(Object item) 
		{
			this.item = item;                  // Store the item
			previous = next = null;            // Set next as end point
		}
		
		// Return class name & object
		public String toString() 
		{
		return "ListItem " + item ;
		}
		
}
