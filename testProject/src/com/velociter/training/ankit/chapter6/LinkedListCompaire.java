package com.velociter.training.ankit.chapter6;

public class LinkedListCompaire {

	public static void main(String ar[])
	{
		SinglyLinkedList llist = new SinglyLinkedList();
		  String[] input= {"Ankit","vishnu","Jayesh","Rahul","jay"};
	for(String item : input) {
	    
		llist.addNode(item);
	 }
	System.out.println("After First Adddition List is");
	llist.printList();
	System.out.println();
	for(int i=1;i<=10;i++)
	{
		llist.addNode(""+i);
	}
	System.out.println("After First Adddition List is");
   llist.printList();
   System.out.println();
   
   String check="9";
   System.out.println("Object to check is  "+check);	
   boolean checkResult=llist.compareNode(check);
   if(checkResult==true)
	   System.out.println("Result is Founded");
   else
	   System.out.println("Not Present");
   
	}
}
