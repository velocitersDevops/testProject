package com.velociter.training.ankit.accessfile;
//Problem 1
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;

public class AvoidOverwritingFile {
  public static void main(String[] args) {
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

      outputFile = new FileOutputStream(aFile);
      System.out.println(aFile.getName()+" output stream created");
    } catch (FileNotFoundException e) {
      e.printStackTrace(System.err);
    } 
    System.exit(0);
  }
}
