package com.velociter.training.mukesh.chapter15;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RemoveSpaceFromString {

	

	public static void main(String[] args)
	{
		
		File file = new File("E:\\newfolder\\stringFile.txt");
		
		String string =null;
		FileReader fileRead=null;
		try 
		{
			fileRead = new FileReader(file);

			char[] chars = new char[100];
			fileRead.read(chars, 0, chars.length);

			string = new String(chars);	
			
			System.out.println("String before removing spaces="+string);
		} 
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		String regex="[\\s]";
		Pattern pattern = Pattern.compile(regex);   
		Matcher matcher = pattern.matcher(string);

		string= matcher.replaceAll("");
		
		
		System.out.println("string after removing spaces="+string);
		
		//writing into the same file
		FileWriter writer;
		try
		{
			writer = new FileWriter(file);
			writer.write(string);
			writer.flush();
			writer.close();
	      
		} 
		catch (IOException e) 
		{
			
			e.printStackTrace();
		}
	}

}
