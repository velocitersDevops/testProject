/*
 * Extend the previous example to optionally list all the names and addresses contained within the
file on the command line.
 */

package com.velociter.training.aalam.serialization;

import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class DeserializeObjects 
{

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException
	{
	
		
		String path = "e:/programingExample/serialzation/ObjectData.bin";
	
		try {
			FileInputStream istream = new FileInputStream(path);
	         while(istream.available()!=0)                         // While there are bytes in the underlying stream
	         { 
		     ObjectInputStream objectsIn = new ObjectInputStream(istream);
				    	 
		     System.out.print((Person)(objectsIn.readObject()));  // Read and display an object
		     System.out.println();
				  }
		     istream.close();                                         // Close the stream
				    } catch(IOException e){
				      e.printStackTrace();
				      System.exit(1); 
				    } catch(ClassNotFoundException e){
				      e.printStackTrace();
				      System.exit(1);
				    }
	}
}
		
	


