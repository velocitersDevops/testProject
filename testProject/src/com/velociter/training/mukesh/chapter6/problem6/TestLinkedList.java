package com.velociter.training.mukesh.chapter6.problem6;

public class TestLinkedList extends LinkedListOperation
{
		  public static void main(String args[]) 
		  {
					  LinkedListOperation myList = new LinkedListOperation();
					 							
					  
				      
				   
				 // Append 5 Integers to the list
			   for(int i=0 ; i<5 ; i++)
				myList.addItem(i);
			
			    // Output the length and contents of the list:
			   System.out.println("The list contains " + myList.size() + " items.");
			    System.out.println("List is:\n" + myList);
			
			   
			   
			
			    Object data=20;
			    int position=3;
			    myList.insertItem(data , position );
			    System.out.println("insert item " +position +" position in  the list is:\n" + myList);
			    
			    
		  }
}
