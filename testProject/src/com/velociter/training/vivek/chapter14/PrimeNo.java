package com.velociter.training.vivek.chapter14;

import java.util.Vector;

public class PrimeNo
 {
	
	int primeNo(int no)
	{
	
		int count=0;
		
		for(int i=2;i<Math.sqrt(no);i++)
		{
			if(no%i ==0)
			{
				count=count+1;	
			}
		}
		
		
		return count;
	}
	
	
	
	
	
	
	

	public static void main(String[] args) throws Exception
	
	{
		Vector<Integer> vl=new Vector<Integer>();
		
		int n=36;
		
		PrimeNo prime=new PrimeNo();
		
		for(int j=2;j<n;j++)
		{
		 if(prime.primeNo(j)==0)
		 {
			 vl.add(j);
			// System.out.println("given no. is prime no. :   "+vl);
		 }
		}
		 for(int p:vl)
		 {
			 System.out.println(p);
		 }
		 

	}

}
