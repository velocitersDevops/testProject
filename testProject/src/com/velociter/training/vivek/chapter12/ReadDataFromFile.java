package com.velociter.training.vivek.chapter12;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadDataFromFile
{

	public static void main(String[] args) throws ClassNotFoundException, IOException
	{
		File file= new File("c:\\AvoidFile\\abc.txt");
		
		 FileInputStream fin=null;
		try 
		{
			fin = new FileInputStream(file);
		} catch (FileNotFoundException e)
		{
			
			e.printStackTrace();
		}
	     ObjectInputStream oit=null;
		try
		{
			oit = new ObjectInputStream(fin);
		} catch (IOException e) 
		{
			
			e.printStackTrace();
		}
	     System.out.print(oit.readObject());
	     oit.close();

	}

}
