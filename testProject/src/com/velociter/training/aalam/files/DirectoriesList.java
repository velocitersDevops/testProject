package com.velociter.training.aalam.files;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class DirectoriesList implements FileFilter
{
	  private static StringBuffer indent = new StringBuffer();

	  public static void main(String[] args) 
	  {
	    File[] fileObject = null;

	   	fileObject = File.listRoots();                                 // get the sytem roots
	    DirectoriesList myDirectoryObject = new DirectoriesList();     // Create object to do the listing
	    for(File root : fileObject) 
	    {                                                              // and list all the directories
	    	myDirectoryObject.listDirectories(root);
	    }
	  }

	  // Lists directories recursively with each sub directory level indented two spaces
	  private void listDirectories(File rootDirectory) 
	  {
	    String name = rootDirectory.getName();
	    if(name.length()==0)                              // For system roots under windows the name is empty
	    {
	    	name = rootDirectory.getPath();               // so get the path instead
	    }
	    System.out.println(indent.toString()+name);        // Output the directory name following the indent
	    indent.append("  ");                               // Increase indent for next level
	    File[] fileList = rootDirectory.listFiles(this);   // Get subdirectories of current directory
	    if(fileList != null)                               // As long as we have a subdirectory list
	    	{
	      for(File file : fileList)                        // list the contents
	      {
	        listDirectories(file);
	      }
	    }

	    indent.delete(indent.length()-2, indent.length()); // reduce the indent 
	    return;                                            // before returning 
	  }

	  // Filter method to only accept directories
	  public boolean accept(File file) 
	  {
	    return file.isDirectory();
	  }  

	}
