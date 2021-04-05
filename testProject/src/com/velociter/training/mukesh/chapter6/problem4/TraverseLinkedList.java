package com.velociter.training.mukesh.chapter6.problem4;

public class TraverseLinkedList extends LinkedList
{
	public static void main(String[] args)
	{
		
		System.out.println("input items in which wants to traverse");
		System.out.println("======================================");
		String[] input= {"mukesh","vivek","alam","ankit","karan","rahul"};
		Object[] object =new Object[input.length];
		for(int i=0;i<object.length;i++)
		{
			object[i]=input[i];
		}
		LinkedList linkedListObject = new LinkedList(object);
		System.out.println();
		System.out.println("forward traversing of items");
		System.out.println("============================");
		
		System.out.println(linkedListObject.getFirst() );
		for(int i=0;i<object.length;i++)
		{
			System.out.println(linkedListObject.getNext());
		}
		
		System.out.println();
		
		System.out.println("============================");
		System.out.println("reverse traversing of items");
		System.out.println(linkedListObject.getLast() );
		for(int i=object.length-1;i>0;i--)
		{
			System.out.println(linkedListObject.getPrevious());
		}
		
		
	   
	}
}
