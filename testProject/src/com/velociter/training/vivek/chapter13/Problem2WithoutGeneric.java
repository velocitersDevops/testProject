package com.velociter.training.vivek.chapter13;

 class MyData<T>
{
  T i;
   public void add(T i)
   {
	   this.i=i;
	  
   }
   public T get() 
   {
	   return i;
   }
   
}
public class Problem2WithoutGeneric
{
	public static void main(String args [])
	{
		MyData<Object> m=new MyData<Object>();
		//MyData<String>s=new MyData<String>();
		Integer k=new Integer(5);
		m.add(k);
		m.add("rahul");
	}
	
	}
