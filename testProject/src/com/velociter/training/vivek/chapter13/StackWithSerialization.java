package com.velociter.training.vivek.chapter13;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


class MyStack<T> implements Serializable
{
	  private final static int INITIAL_SIZE = 10; 
	  private final static int INCREMENT = 5; 
	  private Object[] items;                        
	  private int itemCount; 
	  
	  public MyStack() 
	  {
	    items = new Object[INITIAL_SIZE];
	  }

	  public void push(T item)
	  {
		    if(itemCount==items.length) 
		    {
		      Object[] newItems = new Object[items.length + INCREMENT];
		      
		      for(int i = 0 ; i<items.length ; i++) 
		      {
		        newItems[i] = items[i];
		      }
		      items = newItems;
		    }
		    items[itemCount] = item;
		    itemCount++;
	  }

  
		  public void listAll()
		  {
		    for(int i = 0 ; i<itemCount ; i++) 
		    {
		      System.out.println((items[i]));
		    }
		  }

         
}

public class StackWithSerialization 
{
		  public static void main(String[] args) 
		  {
		    
			  String[] stackInputs = { "abc", "mno", "dgh", "rwr", "sea", "cat", "dog", "vivek", "thui", "fgh"}; 
		    
			  MyStack<String> data = new MyStack<String>();
		    
			  	System.out.println("Strings pushed onto the stack ");
			    
			  	for(String value : stackInputs) 
			    {
			      System.out.println(value);
			      data.push(value);
			    }
		  
			  	
		    File file = new File("c:\\AvoidFile\\abc.txt");             
		
		    try 
		    {
		    	FileOutputStream fileOut = new FileOutputStream(file);
		    	ObjectOutputStream out = new ObjectOutputStream(fileOut);
		      
		    	out.writeObject(data);
		    	
		    	out.close();
		    } 
		    catch(Exception e) 
		    {     
		      e.printStackTrace();
		      System.exit(1);
		    } 
		
		    //  read the Stack object 
		    
		    MyStack<String> stackValue = null;
		    try 
		    {
		    	FileInputStream fileIn=	new FileInputStream(file);
		    	ObjectInputStream objectIn = new ObjectInputStream(fileIn);
		     
		    	stackValue = (MyStack<String>)objectIn.readObject();
		    	
		    	objectIn.close();
		    }
		    catch(Exception e) 
		    {     
		      e.printStackTrace();
		      System.exit(1);
		    }
		    // List the contents of the new stack
		    System.out.println("\nContents of stack read from file:"); 
		    stackValue.listAll();
		  }
}
