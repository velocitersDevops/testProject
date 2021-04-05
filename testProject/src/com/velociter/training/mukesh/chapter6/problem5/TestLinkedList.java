package com.velociter.training.mukesh.chapter6.problem5;

public class TestLinkedList extends LinkedListOperation
{
		  public static void main(String args[]) 
		  {
					  LinkedListOperation myList = new LinkedListOperation();
					 							
					  String[] words = {" mukesh", " vivek", " alam", " ankit", " rahul"};
				     
				   
				  // Append 5 Integers to the list
				  for(int i=0 ; i<5 ; i++)
					  myList.addItem(i);
			
			    // Output the length and contents of the list:
			   System.out.println("The list contains " + myList.size() + " items.");
			    System.out.println("List is:\n" + myList);
			
			    //insert string 
			    myList.getFirst();
			    for(int i = 0 ; i<4 ; i++)
			    {
			      myList.getNext();
			    } 
			    for(String word : words) 
			    {
			      myList.insertItem(word);
			    }
			    // Output the length and contents of the list:
			    System.out.println("\nThe list contains " + myList.size() + " items.");
			    System.out.println("List is now:\n" + myList);
			
			    // Delete all the strings from the list:
			    Object item = myList.getFirst() ;
			    do {
			      // If it's a string:
			      if(item instanceof String) 
			      {
			        myList.deleteItem();                         // delete it,
			      } 
			      item = myList.getNext();
			    }while(item != null);
			
			    // Output the length and contents of the list:
			    System.out.println("\nThe list contains " + myList.size() + " items.");
			    System.out.println("After deletions the list is:\n" + myList);
		  }
}
