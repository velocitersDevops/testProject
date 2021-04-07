package com.velociter.training.ankit.chapter6;
public class LinkedList {
	
	private boolean forwards = true;       // Indicator for list scan direction  ***
	  static ListItem start = null;         // First ListItem in the list
	  private ListItem end = null;           // Last ListItem in the list
	  private ListItem current = null;       // The current item for iterating
	  private int count = 0;                 // Number of items in the list        ***
  // Default constructor - creates an empty list
  public LinkedList() {}

  // Constructor to create a list containing one object
  public LinkedList(Object item) {
    if(item != null) {
      current=end=start=new ListItem(item);      // item is the start and end
      ++count;                                   // Increment count of list items  ***
    }
  }

  // Construct a linked list from an array of objects
  public LinkedList(Object[] items) {
    if(items != null) {
      // Add the items to the list
      for(int i = 0; i < items.length; i++) {
        addItem(items[i]);
      }
      current = start;
      count = items.length;                      // Increment count of list items  ***
    }
  }

  // Add an item object to the list
  public void addItem(Object item) {
    ListItem newEnd = new ListItem(item);        // Create a new ListItem
    if(start == null) {                          // Is the list empty?
      start = end = newEnd;                      // Yes, so new element is start and end
    } else {                                     // No, so append new element
      end.next = newEnd;                         // Set next variable for old end
      newEnd.previous = end;                     // Set previous as old end item  ***
      end = newEnd;                              // Store new item as end 
    }
    ++count;                                     // Increment count of list items  ***
  }

  // Get the first object in the list
  public Object getFirst() {
    forwards = true;                             // Going forwards then  ***
    current = start;
    return start == null ? null : start.item;
  }

  // Get the next object in the list
  public Object getNext() {
    forwards = true;                             // Going forwards  ***
    if(current != null) {
      current = current.next;                    // Get the reference to the next item
    }
    return current == null ? null : current.item;
  }
  
  public ListItem backTracking(ListItem node) {
	   ListItem previous = null;
      ListItem current = node;
      ListItem next = null;
      while (current != null) 
      {
          next = current.next;
          current.next = previous;
          previous = current;
          current = next;
      }
      node = previous;
      return node;
	}
 
 void printList(ListItem listitem)
	 {
		 while(listitem != null)
		 {
			 System.out.println("     "+listitem.item+" ");
			 listitem = listitem.next;
		 }
	 }
 
  public Object getLast() {
    forwards = false;                              
    current = end;
    return end == null ? null : end.item;
  }

  public Object getPrevious() {
    forwards = false;                            
    if(current != null) {
      current = current.previous;                
    }
    return current == null ? null : current.item;
  }


  public Object deleteItem() {
    if(current == null) {                   
      if(start == null) {   
        return null;                        
      } else {        
        current = end;                      
      }
    }

    if(current.previous != null) {
      current.previous.next = current.next;
    }
    if(current.next != null) {
      current.next.previous = current.previous;
    }
    Object item = current.item;
    current = forwards ? current.previous : current.next;
    --count;                                // Decrement count of list items
    return item;           
  }
  public void insertPosition(Object item) {
    ListItem newItem = new ListItem(item);
    if(start == null) {                  
      start = end = current = newItem;   
      ++count;
      return;
    }
    if(current == null) {               
      current = end;                    
    }
    if(current.previous == null) {
      start = current.previous = newItem;
      newItem.next = current;
      current.previous = newItem;
    } else {
      current.previous.next = newItem;
      newItem.previous = current.previous;
      newItem.next = current;
      current.previous = newItem;
    }    
    current = newItem;
    ++count;
  }
  public boolean insertItem(Object inserted, Object position) {
    if(start==null)          
      return false;

    // Search for position
    ListItem theItem = start;
    while(theItem != null) {
      if(theItem.item.equals(position)) {    
        current = theItem;    
        insertPosition(inserted);
        return true;
      } else {
        theItem = theItem.next;
      }
    }
    return false;    
  }

  public int  size() {
    return count;
  }

    
    public String toString() {
      StringBuffer str = new StringBuffer();   
      current = start;                         
      while(current != null) {                 
       str.append(current.item.toString() + "\t");   // 
        current = current.next;
      }
      return str.toString(); 
    }                                        

  
}
