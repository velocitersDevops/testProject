package com.velociter.training.ankit.chapter6;
//Problem 1
public class TraverseLinkedList
{
		static String[] input= {"Ankit","alam","Jayesh","Rahul"};
		public static void main(String ar[])
		{
		SinglyLinkedList llist = new SinglyLinkedList();
			  String[] input= {"Ankit","alam","Jayesh","Rahul","jay"};
		 for(String item : input) {
		      llist.addNode(item);
		   }
	System.out.println("ForwardTraversing is....");
	llist.printList();
	System.out.println();
	System.out.println("BackTraversing is....");	
	llist.BackprintList();  

	}
}
