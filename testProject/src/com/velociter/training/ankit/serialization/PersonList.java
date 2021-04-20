package com.velociter.training.ankit.serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.StreamCorruptedException;
import java.util.ArrayList;

public class PersonList {
	public static void main(String[] args) {
		String filePath="E:\\New folder\\ObjectSerialization.txt";
		  try {
			FileInputStream istream = new FileInputStream(filePath);
	         while(istream.available()!=0) { 
		     ObjectInputStream objectsIn = new ObjectInputStream(istream);
				    	 
		  System.out.println((Person)(objectsIn.readObject()));  //Problem in this line
				  }
		     istream.close();                                         
				    } catch(IOException e){
				      e.printStackTrace();
				      System.exit(1); 
				    } catch(ClassNotFoundException e){
				      e.printStackTrace();
				      System.exit(1);
				    }
				  }
    }

