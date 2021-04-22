package com.velociter.training.aalam.chepter6;



public class LinkedList 
{
		  private boolean forwards = true;       
		  private ListItem start = null;         
		  private ListItem end = null;          
		  private ListItem current = null;       
		  private int count = 0;                 
	
		public LinkedList() 
		{}
		
		public LinkedList(Object item) 
		{
		    if(item != null)
		    {
		      current=end=start=new ListItem(item);   // item is the start and end
		      ++count;                                // Increment count of list items  
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
				      }
				      current = start;
				      count += items.length;                 
			    }
		  }

		  // Add an item object to the list
		  public void addItem(Object item) 
		  {
			    ListItem newEnd = new ListItem(item);   // Create a new ListItem
			    if(start == null) 
			    {                     					// Is the list empty?
			      start = end = newEnd;                 // Yes, so new element is start and end
			    } 
			    else 
			    {                                		
			      end.next = newEnd;                  
			      newEnd.previous = end;               
			      end = newEnd;                         // Store new item as end 
			    }
			    ++count;                                
		  }

		  // Get the first object in the list
		  public Object getFirst() 
		  {
			    forwards = true;                 
			    current = start;
			    return start == null ? null : start.item;
		  }
	
		  // Get the next object in the list
		  public Object getNext() 
		  {
			    forwards = true;                 
			    if(current != null)
			    {
			      current = current.next;        				// Get the reference to the next item
			    }
			    return current == null ? null : current.item;
		  }

		  // Method to get the last object in the list
		  public Object getLast() 
		  {
			    forwards = false;                     
			    current = end;
			    return end == null ? null : end.item;
		  }

		  // Method to get the previous object in the list
		  public Object getPrevious() 
		  {
			    forwards = false;                    // Going backwards  
			    if(current != null) 
			    {
			      current = current.previous;        // Get the reference to the next item
			    }
			    return current == null ? null : current.item;
		  }

	  // New method to delete an item at the current position  
	  public Object deleteItem() 
	  {
		    if(current == null) 
		    {                   					// If no object is defined by current to delete:
			      if(start == null) 
			      {   
			    	  return null;                        // If the list is empty: can't delete non-existent objects.
			      } 
			      else 
			      {        
			    	  current = end;                      // Otherwise: delete the end object if none specified.
			      }
		    }

		    if(current.previous != null) 
		    {
		    		current.previous.next = current.next;
		    }
		    if(current.next != null) 
		    {
		    		current.next.previous = current.previous;
		    }
		    Object item = current.item;
		    current = forwards ? current.previous : current.next;
		    --count;                               					 // Decrement count of list items
		    return item;           
	  }

	  // New method to insert new item preceding the current item  
	  public void insertItem(Object item) 
	  {
		    ListItem newItem = new ListItem(item);
		    if(start == null)
		    {                   										 		// If list is empty...
			      start = end = current = newItem;    	 						// ...make new item the start and end.
			      ++count;
			      return;
		    }
		    if(current == null) 
		    {                										// If no current item...
		      current = end;                     					// ...make the end current.
		    }
		    if(current.previous == null) 
		    {
			      start = current.previous = newItem;
			      newItem.next = current;
			      current.previous = newItem;
			} 
		    else
			{
			      current.previous.next = newItem;
			      newItem.previous = current.previous;
			      newItem.next = current;
			      current.previous = newItem;
		    }    
		    current = newItem;
		    ++count;
	  }

	    
		  public int  size() 
		  {
		    return count;
		  }

	    // Convert the entire list to a string    
	    public String toString() 
	    {
		      StringBuffer stringBuffer = new StringBuffer();   // Use StringBuffer as list is of variable length.
		      current = start;                         // Set current to first.
		      while(current != null) 
		      {                 						// While there are still elements in the list,
		    	  										// append their string representations to  str separated by tabs.
		    	  stringBuffer.append(current.item.toString() + "\t");   // 
		    	  current = current.next;
		      }
	      return stringBuffer.toString();                   // Return the StringBuffer as a String 
	    }                                        

	                        
	  
	

}
