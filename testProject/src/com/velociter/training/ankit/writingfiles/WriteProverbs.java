package com.velociter.training.ankit.writingfiles;
import java.io.*;
import java.nio.*;
import java.nio.channels.FileChannel;

public class WriteProverbs {
  public static void main(String[] args) {
    String dirName = "E:\\New folder";   // Directory for the output file
    String fileName = "Proverbs.txt";// Name of the output file
    char separator = '*';
    String[] sayings = {
      "I am Ankit \n",
      "Things will be better for a while.",
      "A little knowledge is a dangerous thing.",
      "but a littil knowledge can increase our knowledge",
      "Who begins too much achieves little.",
      "Who knows most says least.",
      "A wise man sits on the hole in his carpet.",
      "Modify the example that writes proverbs to a file to separate the proverbs"
    };
    File newFile=new File(dirName, fileName);
    try 
    {
    FileOutputStream outNewFile=new FileOutputStream(newFile);
    System.out.println("File Created");
    }
    catch(FileNotFoundException ex)
    {
    	System.out.println("File not Found");
    }
    try {
        FileWriter myWriter = new FileWriter(newFile);
        for (String saying : sayings) { 
        	myWriter.write(saying+String.format("%n")+separator);
        	//myWriter.n
        	}
       myWriter.close();
        System.out.println("Successfully wrote to the file.");
      } catch (IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
      }
}
}

