package com.velociter.training.aalam.readFiles;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.BufferUnderflowException;
import java.nio.channels.FileChannel;

public class ReadProverbs {

	public static void main(String[] args)throws Exception
	  {
	  // We need to provide file path as the parameter:
	  // double backquote is to avoid compiler interpret words
	  // like \test as \t (ie. as a escape sequence)
	 
	/*	
	 * read a file data by using BufferReader Object
		File file = new File("E:\\proverbs\\proverbs.txt");
	  FileInputStream fisObject = new FileInputStream(file);
	  BufferedReader br = new BufferedReader(new FileReader(file));
	  
	  String st;
	  while ((st = br.readLine()) != null)
	    System.out.println(st);
		
   */
		//read a file data by using FileInputStream (in a simple way)
		 try{    
			 String filePath = "E:\\proverbs\\proverbs.txt";
	            FileInputStream fileObject=new FileInputStream(filePath);   
	            int i=0;
	            while((i=fileObject.read())!=-1)   //getting till last character of file
	            {    
	                System.out.print((char)i);    
	            }    
	            fileObject.close();    
	          }catch(Exception e){System.out.println(e);}    
	         }    
	  }
	
 
