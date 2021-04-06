package com.velociter.training.ankit.accessfile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class AvoidOverwritingFileThreeDigit {

public static void main(String[] args) {
    String filepath = "E:\\New folder\\newFile.txt";
    if(args.length>0) {                            
      filepath = args[0];  
      }                      
      
    File aFile = new File(filepath);
    FileOutputStream outputFile = null;        
    if (aFile.isFile()) {
      File newFile = aFile;                      
      do {
        String name = newFile.getName();         
        int period =  name.indexOf('.');         
        if(period == -1){                         
          newFile = new File(newFile.getParent(),extendName(name));    
          } else {
          newFile = new File(newFile.getParent(),extendName(name.substring(0, period)) + name.substring(period));
        }
      } while(!aFile.renameTo(newFile));         // 
    } 
    try {
      outputFile = new FileOutputStream(aFile);
      System.out.println(aFile.getName()+" output stream created");
    } catch (FileNotFoundException e) {
      e.printStackTrace(System.err);
    } 
    System.exit(0);
  }
  private static String extendName(String name) 
   {
    StringBuffer newBufferName = new StringBuffer(name);              
    String digits = newBufferName.substring(newBufferName.length()-3,newBufferName.length()); // return last 3 character
    int number=0;
    try {
      number=Integer.parseInt(digits);                                     
      ++number;                                                               
      newBufferName.delete(newBufferName.length()-3,newBufferName.length());
    } 
    catch(NumberFormatException nfe) 
    {}                                       
    
    digits=String.valueOf(number);            
    assert digits.length() < 4;                    
    return newBufferName.append("000").replace(newBufferName.length()-digits.length(),newBufferName.length(), digits).toString();    
  }
}
