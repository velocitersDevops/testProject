package com.velociter.training.ankit.readingfiles;
//1st
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.BufferUnderflowException;
import java.nio.channels.FileChannel;

public class ReadingBack {

	public static void main(String[] args)throws Exception
	  {
		String filePath = "E:\\New folder\\WriteDates.txt";
		FileInputStream fileInputStram=null;
		 try{    
			 
			 fileInputStram=new FileInputStream(filePath);   
	            int i=0;
	            while((i=fileInputStram.read())!=-1)   //last character of file
	            {    
	                System.out.print((char)i);    
	            }    
	            fileInputStram.close();    
	          }
		 catch(Exception e)
		 {
	          System.out.println(e);
	          e.printStackTrace();}    
	      }    
	  }
	
 
