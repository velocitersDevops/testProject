package com.velociter.training.vivek.chapter11;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ReadDataFromFile {

	public static void main(String[] args)
	
	{
	  	//String path="C:\\AvoidFile\\abcef.txt";
	  	
	  	try
	  	{
	  		String path="C:\\AvoidFile\\abcdefg.txt";
	  		int i=0;
			FileInputStream fisObject = new FileInputStream(path);
			while((i=fisObject.read())!=-1)
			{
				System.out.print((char)i);
			}
			fisObject.close();
		}
	  	catch (Exception e)
	  	{
			
			e.printStackTrace();
		}

	}

}
