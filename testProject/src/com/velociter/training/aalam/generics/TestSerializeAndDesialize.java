/*
 * Modify your Stack<> type to make it serializable. Demonstrate that this is the case by creating
a Stack<String> object and adding 10 strings to it, then serializing and deserializing the
Stack<String> object, and listing the contents of the deserialized stack
 */

package com.velociter.training.aalam.generics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestSerializeAndDesialize 
{

	public static void main(String[] args)
	{
		Stack<String>  stackObjectForWriteAndRead = new Stack<String>();
		String[] stateName = {  "MadhyaPradeshh" ,  "Maharastra " , "Dilhi " , "UttarPradesh" , "HimachalPradesh" , "Bihar" ,"Jharkhand","Asam ","AndhraPradesh","Telanagana"};
		System.out.println(" States Name ");
		System.out.println("=============");
		//push operation
		for(String states  : stateName )
		{
			System.out.print(states+"  ");
			stackObjectForWriteAndRead.push(states);
		}
		System.out.println("");
		//serialization
	    String filePath = "e:/programingExample/serialzation/stackObject.bin"; 
	    try
	    {
			ObjectOutputStream objectOutputStreamObject = new ObjectOutputStream(new FileOutputStream(filePath,true));
			objectOutputStreamObject.writeObject(stackObjectForWriteAndRead);                         
		} catch (IOException e)
	    {
			System.out.println("Have Some Problem .Please Try Again");
			System.exit(0);
		}
	    
	  //Deserialization
	     
	     FileInputStream fileInputStreamObject;
	     Stack<String> stackObject=null;
		try {
			fileInputStreamObject = new FileInputStream(filePath);
	    	while(fileInputStreamObject.available()!= 0)
	    	{
			ObjectInputStream objectInputStreamObject = new ObjectInputStream(fileInputStreamObject);
			stackObject = (Stack<String>)objectInputStreamObject.readObject();
	    	}
	    	
	    	//read back from file
	    	System.out.println("");
	    	System.out.println("Read back stack data from file");
	    	System.out.println("");
	    	stackObject.listAll();
	    }	 
	    catch (ClassNotFoundException e)
	    {
				// TODO Auto-generated catch block
				e.printStackTrace();                        
		}
	    catch (IOException e)
	    {
			System.out.println("Have Some Problem .Please Try Again");
			System.exit(0);
		}
		
	}
}
