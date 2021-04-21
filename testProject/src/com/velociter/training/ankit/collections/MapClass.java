package com.velociter.training.ankit.collections;
//Problem 3
import java.util.*;
public class MapClass {

	public static void main(String ar[])
	{
		HashMap hashMap=new HashMap();
		//String[]  telephone= {"9977919092","8855996524","8545652586","9000214586","7258654242","7698547562","8965245236","7452568510"};
		//String[] name= {"Ankit","Aman","Sonu","Shubham","Hemu","Ratan","Vishal","Golu"};
 
		//h.put(id, ae);
        //System.out.println(h);
//      for(int i=0;i<name.length;i++)
//	  
//      {
//		h.put(telephone[i],name[i]);
//	  
//      }
		System.out.println("Enter Name and Telephone number");
		String name,telephone;
		Scanner scanner=new Scanner(System.in);
		for(int i=0;i<3;i++)
		{
			
			System.out.println("Name");
			name=scanner.nextLine();
			System.out.println("Telephone");
			
			telephone=scanner.nextLine();
			if(telephone.length()==10)
			{
			hashMap.put(telephone,name);               //(Key,Value)
			}
			else
				System.out.println("Enter Valid MObile number");
	      }
      System.out.println(hashMap);
      System.out.println("Enter a number");
      
        
      String findResult=scanner.nextLine();
	if(hashMap.containsKey(findResult))
	{
		System.out.println("Result Found");
		System.out.println("Name is :"+hashMap.get(findResult));
		
	}
	else
		System.out.println("Not Found");
	}
}
