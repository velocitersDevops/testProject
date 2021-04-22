package com.velociter.training.aalam.chepter6;

public class ListItem
{
	ListItem next;                 // Refers to next item in the list
	ListItem previous;
	Object item;
	
	
	// Constructor
	public ListItem(Object item)
	{
	this.item = item;               // Store the item
	next = null;                    // Set next as end point
	previous = null;
	}
	// Return class name & object
	public String toString() 
	{
	return  " "+item ;
	
	}
	
}
