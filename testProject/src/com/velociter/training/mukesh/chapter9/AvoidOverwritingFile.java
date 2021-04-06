package com.velociter.training.mukesh.chapter9;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;

public class AvoidOverwritingFile 
{
  public static void main(String[] args) 
  {
    
    File file = new File("E:\\mukeshFile\\myFile1.txt");
  
    if (file.isFile()) 
    {
      File newFile = file;  
      // Start with the original file

             
      // We will append "_old" to the file
      // name repeatedly until it is unique
      do {
        String name = newFile.getName();         // Get the name of the file
        int dotIndex =  name.indexOf('.');         // Find the separator for the extension
        if(dotIndex == -1) {                                                              
          newFile = new File(newFile.getParent(), name + "_old");                       
         }else {                                                                               
          newFile = new File(newFile.getParent(), 
                           name.substring(0, dotIndex) + "_old" 
                           + name.substring(dotIndex));
         }
      } while (!file.renameTo(newFile));        // Stop when renaming works
    } 

    // Now we can create the new file
    try {

      // Create the stream opened to append data
    	FileOutputStream   outputFile = new FileOutputStream(file);
      System.out.println(file.getName()+" output stream created");
    } catch (FileNotFoundException e) 
    {
      e.printStackTrace(System.err);
    } 
    System.exit(0);
  }
}
