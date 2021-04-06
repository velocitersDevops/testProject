package com.velociter.training.ankit.accessfile;
<<<<<<< HEAD
//Problem 1
=======

>>>>>>> 9654a939c1a979e2437d3d4e367aa774316b0f07
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;

public class AvoidOverwritingFile {
  public static void main(String[] args) {
<<<<<<< HEAD
    String filepath = "E:\\New folder\\newCreation.java";
    File aFile = new File(filepath);
    FileOutputStream outputFile = null;         
    if (aFile.isFile()) {
      File newFile = aFile;                     
      do {
        String name = newFile.getName();       
        int period =  name.indexOf('.');       
        if(period == -1) {                                                             
          newFile = new File(newFile.getParent(), name + "_old");                      
         }else {                                                                               
          newFile = new File(newFile.getParent(),name.substring(0, period) + "_old" + name.substring(period));
         }
      } while (!aFile.renameTo(newFile));        
    } 

    try {

=======
    String filepath = "E:\\New folder\\myFile.txt";

    if(args.length>0) {                                                                 // ***
      filepath = args[0];                                                               // ***
    }
      
    File aFile = new File(filepath);
    FileOutputStream outputFile = null;          // Stores the stream reference
    if (aFile.isFile()) {
      File newFile = aFile;                      // Start with the original file

      // We will append "_old" to the file
      // name repeatedly until it is unique
      do {
        String name = newFile.getName();         // Get the name of the file
        int period =  name.indexOf('.');         // Find the separator for the extension
        if(period == -1) {                                                              // ***
          newFile = new File(newFile.getParent(), name + "_old");                       // ***
         }else {                                                                        // ***        
          newFile = new File(newFile.getParent(), 
                           name.substring(0, period) + "_old" 
                           + name.substring(period));
         }
      } while (!aFile.renameTo(newFile));        // Stop when renaming works
    } 

    // Now we can create the new file
    try {

      // Create the stream opened to append data
>>>>>>> 9654a939c1a979e2437d3d4e367aa774316b0f07
      outputFile = new FileOutputStream(aFile);
      System.out.println(aFile.getName()+" output stream created");
    } catch (FileNotFoundException e) {
      e.printStackTrace(System.err);
    } 
    System.exit(0);
  }
}
