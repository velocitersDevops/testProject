package com.velociter.training.ankit.CollectionClasses;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class SequencialLine {
	
	public static void main(String[] args) {
		String filePath = "E:\\New folder\\SequenceLine.txt";//reading files
		String copyFilePath = "E:\\New folder\\CopySequenceLine.txt"; //writing files
		StringBuffer sb=new StringBuffer();
		try  
		{  
			FileReader fr=new FileReader(filePath);    
			BufferedReader br=new BufferedReader(fr);   
			         
	        String line;  
	        int lineNumber=000;
		while((line=br.readLine())!=null)  
		{  
		sb.append(String.format("%04d ",++lineNumber)+""+line);
		sb.append("\n");     
		//lineNumber++;
		}  
		fr.close();    //closes the stream and release the resources  
		System.out.println("Contents of File: ");  
		//System.out.println(sb.toString());
		//System.out.println(sb);
		}  
		catch(IOException e)  
		{  
		e.printStackTrace();  
		} 
		
		
		
		
		FileWriter fw;
		try {
			fw = new FileWriter(copyFilePath, true);
			
		 
		BufferedWriter br1 = new BufferedWriter(fw);
		
         br1.write(sb.toString()+String.format("%n"));
        
   
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
