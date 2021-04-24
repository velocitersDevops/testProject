package com.velociter.training.ankit.CollectionClasses;
import java.util.*;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class RemoveSpaces {
	public static void main(String[] args) {
		String filePath = "E:\\New folder\\RemoveSpaces.txt";
		
        Vector<Character> character = new Vector<Character>();
		System.out.println("File Reading Data");
        FileInputStream fileInputStram=null;
		 try{    
			 
			 fileInputStram=new FileInputStream(filePath);   
	            int i=0;
	            while((i=fileInputStram.read())!=-1)   //last character of file
	            {    
//	                System.out.print((char)i);
	            	character.add((char)i);
	            }    
	            fileInputStram.close();    
	          }
		 catch(Exception e)
		 {
	          System.out.println(e);
	          e.printStackTrace();
	          }
		String s2="";
		 for(int c=0;c<character.size();c++)
		 {
			 s2=s2+""+character.get(c);
			// System.out.print(s2);
        //  System.out.println(chars[c]);
		 }

				 
		 
		 Pattern pattern = Pattern.compile("[\\s]");  //this is regulerExpression to file white spaces 
	        // String s=" My Name Is ANkit";
			String s1=null;
			
			Matcher matcher = pattern.matcher(s2);
		  while(matcher.find())
			{
			s1=matcher.replaceAll("");
			}
			System.out.println("Data without space is  :" +s1);
			
			//Write
			FileWriter fr;
			try {
				fr = new FileWriter(filePath, true);
				
			 
			BufferedWriter br = new BufferedWriter(fr);
			
	         br.write(s1);
	        
	   
	        System.out.println("File Created");
	        br.close();
			fr.close();
	}
			catch(Exception e)
			{
			e.printStackTrace();
			}
	}
}

