package com.velociter.training.ankit.accessfile;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class Directories implements FileFilter
{

	 static StringBuffer stringBufferObj = new StringBuffer();
	 
	 void listDirectories(File rootDirectory) 
	  {
	    String directoryName = rootDirectory.getName();
	    if(directoryName.length()==0)                              // Drive Name Null
	    {
	    	directoryName = rootDirectory.getPath();               // Path add
	    }
	    System.out.println(stringBufferObj.toString()+directoryName);        // Output the directory name following the indent
	    stringBufferObj.append("  ");                               // Increase indent for next level
	    File[] allFileList = rootDirectory.listFiles((this));   // list all sub Directories and files.
	    if(allFileList != null)                                 // traverse  till last directory
	    	{
	      for(File file : allFileList)                        // list the contents
	      {
	        listDirectories(file);     //it will check subdirectory of perticular directory
	      }
	    }

	    stringBufferObj.delete(stringBufferObj.length()-2, stringBufferObj.length()); // remove 2 spaces from buffer 
	    return;                                            
	  }

	  public boolean accept(File file) // Filter method to only accept directories abstract method of fileFilter Interface.
	  
	  {
	    return file.isDirectory();
	  }  
	  
	  public static void main(String[] args) 
	  {
	    File[] fileObject = null;

	   	fileObject = File.listRoots();                          // return systems roots drives.
	   	Directories myDirectory = new Directories();     
	    for(File root : fileObject) //4times c d e f
	    {                                                              
	    	myDirectory.listDirectories(root);
	    }
	  }

}
