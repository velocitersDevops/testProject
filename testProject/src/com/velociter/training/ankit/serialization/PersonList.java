package com.velociter.training.ankit.serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.StreamCorruptedException;
import java.util.ArrayList;

import com.velociter.training.aalam.serialization.IndexEntry;
import com.velociter.training.aalam.serialization.Person;

public class PersonList {
	public static void main(String[] args) {
         String filePath="E:\\New folder\\ObjectSerialization.txt";
		//String filePath="E:\\New folder\\ObjectIndex.txt";
		int count=PersonIndexFile.count();
		System.out.println(count);
		try {
			
		    //reading data from index file
		 	//FileInputStream isStreamPersonIndex = new FileInputStream(filePath);
		 	 FileInputStream isStreamPerson = new FileInputStream(filePath);
		     while(isStreamPerson.available()!=0)                         // While there are bytes in the underlying stream
	         { 
		       ObjectInputStream personobjectsInputStream = new ObjectInputStream(isStreamPerson);
			   //System.out.print((PersonIndexFile)(personobjectsInputStream.readObject()));  //Error 
			   System.out.print((personobjectsInputStream.readObject()));  // Reading error
				  
			   System.out.println();
		     
			 }
		       // Close the stream  
		     isStreamPerson.close();      // Close the stream
		                                         
		     
		} 
	   catch(IOException e)
	   {
		e.printStackTrace();
		System.exit(1); 
	   }
	   catch(ClassNotFoundException e)
	   {
	     e.printStackTrace();
		 System.exit(1);
	  }
   }
				  }
    

