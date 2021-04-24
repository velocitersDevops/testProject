package com.velociter.training.ankit.CollectionClasses;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EliminateDigit {

	public static void main(String[] args) {
	String copyFilePath = "E:\\New folder\\CopySequenceLine.txt"; //writing files
	String newFilePath = "E:\\New folder\\RemoveDigits.txt";
	StringBuffer sb=new StringBuffer();
	String text="";
	try  
	{  
		FileReader fr=new FileReader(copyFilePath);    
		BufferedReader br=new BufferedReader(fr);   
		         
        String line;
       
        
	while((line=br.readLine())!=null)  
	{  
	text=text+""+line;
	    
	//lineNumber++;
	}  
	fr.close();    //closes the stream and release the resources  
	System.out.println("Contents of File: ");  
	//System.out.println(sb.toString());
	System.out.println(text);
	}  
	catch(IOException e)  
	{  
	e.printStackTrace();  
	} 
	
			
     Pattern pattern = Pattern.compile("\\d");  //this is regulerExpression to file white spaces 
    // String s=" My Name Is ANkit";
	 String s1=null;
	
	Matcher matcher = pattern.matcher(text);
  while(matcher.find())
	{
	s1=matcher.replaceAll("");
	}
	System.out.println("Data without space is  :" +s1);
	
	
	FileWriter fw;
	try {
		fw = new FileWriter(newFilePath, true);
		
	 
	BufferedWriter br1 = new BufferedWriter(fw);
	
     br1.write(s1);
    

    System.out.println("File Created");
    br1.close();
	fw.close();
    }
	catch(Exception e1)
	{
	e1.printStackTrace();
	}
	
}
	
}
