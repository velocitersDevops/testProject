package com.velociter.training.ankit.chapter6;
//Problem 5
public class LinkedListOperation  {
	
	public static void main(String ar[])
	{
		String[] input= {"Ankit","alam","Jayesh","Rahul","jay"};
		  SinglyLinkedList llist = new SinglyLinkedList();
		 for(String item : input) {
		      llist.addNode(item);
		   }
		 llist.printList();
		 System.out.println();
		 System.out.println();
		 System.out.println("After position");
		llist.insertNth(255, 2);
		llist.printList();
		llist.deleteNode(4);
		System.out.println();
		System.out.println("After position");
		llist.printList();
}
}
