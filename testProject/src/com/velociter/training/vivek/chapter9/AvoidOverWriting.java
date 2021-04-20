package com.velociter.training.vivek.chapter9;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class AvoidOverWriting {

	public static void main(String[] args)
	{
		
     String s="c://AvoidFile/abc.txt";      //file to be checked 
     File file=new File(s);
     FileOutputStream fout=null;            
     
     if(file.isFile())
     {
    	File newFile=file;
    	int i;
    	do
    	{
    		String name= newFile.getName(); 
    		 i=name.indexOf(".");              //value of i  index of .
    		
    		if(i==-1)
    		{
    			newFile = new File(newFile.getParent()+"name"+"_old");
    		}
    		else
    		{
    			newFile=new File(newFile.getParentFile(),name.substring(0, i)+"_old"+name.substring(i));
    		}
    	}
    	while(!file.renameTo(newFile));
     }
     else      //new file will be created if given file is not exist
     { 	 
     try
     {
    	 fout=new FileOutputStream(file);
    	 System.out.println("new file is created :"+file.getName());
     }
     catch(FileNotFoundException e)
     {
    	 e.printStackTrace(System.err);
     }
     }
     System.exit(0);
     
	}

}
