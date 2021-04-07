package com.velociter.training.vivek.chapter6;



public class TraversLinkedList
{

	public static void main(String[] args) 
	{
//		Object object ="ankit";
//		ListItem listItemObject = new ListItem(object);
//		System.out.println(listItemObject);
		
		System.out.println("===============");
		
		Object objects[] = new Object[4];
	    String[] input = {"ankit","vivek","ramasir","mukes"};
	    for(int i=0 ; i< objects.length; i++)
	    {
	    	objects[i] = input[i];
	    }
		LinkedList linkiedListObject = new LinkedList(objects);

		//Forward Traversing
		System.out.println("");
		System.out.println("");
		System.out.println("forward traversing ");
		System.out.println("==================");
		System.out.print(linkiedListObject.getFirst()+" , ");
		for(int i=0;i<objects.length;i++)
		{
			System.out.print(linkiedListObject.getNext()+" , ");
		}
		System.out.println("");
		
		System.out.println("");
		System.out.println("Backward traversing ");
		System.out.println("==================");
		System.out.println("get last:"+linkiedListObject.getLast());
		for(int i=objects.length-1;i>=0;i--)
		{
			
			System.out.print(linkiedListObject.getPrevious()+" , ");
		}
	}

}
