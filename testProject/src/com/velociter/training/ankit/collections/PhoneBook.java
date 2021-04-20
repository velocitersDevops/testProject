package com.velociter.training.ankit.collections;
//Problem 4
import java.util.HashMap;
import java.util.Scanner;

public class PhoneBook {

	public static void main(String[] ar) {
		
			HashMap hashMap=new HashMap();
			String[]  telephone= {"9977919092","8855996524","8545652586","9000214586","7258654242","7698547562","8965245236","7452568510"};
			String[] name= {"Ankit","Aman","Sonu","Shubham","Hemu","Ratan","Vishal","Golu"};
	        String[] surname={"parmar","patel","arora","vishwa","patidar","chigore","saini","shukla"};
	        Scanner scanner=new Scanner(System.in);
	      for(int i=0;i<name.length;i++)
		   
	      {
			hashMap.put(surname[i], name[i]+"  "+telephone[i]);
		  
	      }
		/*	System.out.println("Enter Name and Telephone number");
			String name,telephone,surname;
			
			for(int i=0;i<3;i++)
			{
				
				System.out.println("Name");
				name=c.nextLine();
				System.out.println("Surname");
				surname=c.nextLine();
				System.out.println("Telephone");
				
				telephone=c.nextLine();
				
				if(telephone.length()==10)
				{
				hashMap.put(surname,name+"   "+telephone);
				}
				else
					System.out.println("Enter Valid MObile number");
		      }
	      */
	      System.out.println(hashMap);
	      System.out.println("Enter Surname");
	      
	        
	      String ans=scanner.nextLine();
		if(hashMap.containsKey(ans))
		{
			System.out.println(" Result Found");
			//System.out.println("Name"+"    "+"Telephone");
			System.out.println(hashMap.get(ans));
			
		}
		else
			System.err.println(" Result Not Found");
		
	}
}
