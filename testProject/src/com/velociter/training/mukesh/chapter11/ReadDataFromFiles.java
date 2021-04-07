package com.velociter.training.mukesh.chapter11;
import java.io.FileInputStream;

public class ReadDataFromFiles 
{
	public static void main(String[] args)throws Exception
	  {
	  
			 try
			 {    
				 	String filePath = "E:\\newfolder\\proverbs.txt";
		            FileInputStream fileObject=new FileInputStream(filePath);   //to read data from file
		            int i=0;
		            while((i=fileObject.read())!=-1)   //till last character of file
		            {    
		                System.out.print((char)i);    
		            }    
		            fileObject.close();    
		      }
			 catch(Exception e)
			 {
				 System.out.println(e);
			 }    
	         
	  	}    
	
}
	
 
