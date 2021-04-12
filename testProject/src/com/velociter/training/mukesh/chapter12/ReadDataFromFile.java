package com.velociter.training.mukesh.chapter12;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.StreamCorruptedException;
import java.util.ArrayList;

public class ReadDataFromFile 
{
	public static void main(String[] args)
	{
		
				//to read data from file 
		
				File file = new File("E:\\Dataset\\person.txt");
				ObjectInputStream objectIn = null;
				FileInputStream fileInput=null;
				
				try 
				{
					fileInput= new FileInputStream(file);
					
					while(fileInput.available()!=0)
					{
						objectIn = new ObjectInputStream(fileInput);
						System.out.println((Person)objectIn.readObject());
					}
					
					
				} catch(EOFException e)
				{
					e.printStackTrace();
					System.exit(1);
				}
				                                        
				catch(IOException e)
				{
			      e.printStackTrace();
			      System.exit(1); 
				}
				catch(ClassNotFoundException e)
				{
			      e.printStackTrace();
			      System.exit(1);
				} 
	
	}

}
