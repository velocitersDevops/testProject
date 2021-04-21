package com.velociter.training.aalam.collectionUseFullClasses;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RemoveSpaces {

	public static String removeWhite(String s) {

		
		Pattern patt = Pattern.compile("[\\s]");  //this is regulerExpression to file white spaces 

		// Searching patt in s.
		Matcher mat = patt.matcher(s);

		// Replacing with nothing
		return mat.replaceAll("");
	}

	public static void main(String[] args)
	{
		// read a file data by using FileInputStream (in a simple way)
		File file = new File("e:/programingExample/serialzation/regulerExpression.txt");
		BufferedReader bufferReaderObject = null;
		String st;
		String contents =null;
		
		try {
			FileReader in = new FileReader("e:/programingExample/serialzation/regulerExpression.txt");

			char[] chars = new char[500];
			int n = in.read(chars, 0, chars.length);

			 contents = new String(chars);	//read file data
			System.out.println(contents);
		} catch (FileNotFoundException e)
		{
			
			e.printStackTrace();
		}catch (IOException e) 
		{
		
			e.printStackTrace();
		}

		String afterRemoveWhiteSpace = removeWhite(contents);
		System.out.println(afterRemoveWhiteSpace);
		
		//writing in a same file
		FileWriter writer;
		try {
			writer = new FileWriter("e:/programingExample/serialzation/regulerExpression.txt");
			writer.write(afterRemoveWhiteSpace);
			writer.flush();
			writer.close();
	      
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	
			
	}

}
