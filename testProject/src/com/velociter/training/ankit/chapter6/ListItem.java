package com.velociter.training.ankit.chapter6;

public class ListItem {

	ListItem next;// Refers to next item in the list
	ListItem previous;// Refers to last item in the list
	Object item; // The item for this ListItem
	public ListItem(Object item) {
		this.item = item; // Store the item
		next =previous= null; // Set next and previous as end point
		//previous=next //
   }
		// Return class name & object
		public String toString() {
		return "ListItem" +item;
		}
		
		
	}
