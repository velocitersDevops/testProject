package com.velociter.training.ankit.generics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;



public class StackSerialize {
	     public static void main(String ar[])
	     {StackClass<String> stringStack = new StackClass<String>(10);
	     StackClass<Double> doubleStack = new StackClass<Double>(10);
	        //StackClass<Double> doubleStack = new StackClass<Double>(10);
	        double[] values = { 1.0, 1.1 , 1.2 , 2.0, 2.1, 2.2, 3.0, 3.1, 3.2 }; 
	        String[] stringValues= {"one","two", "three", "four", "five","six","seven","eight","Nine","ten"};
	//String filePath="E:\\New folder\\stackSerialization.txt";
//	ObjectOutputStream objectOut=null;
	  for(double v : values) {
		  doubleStack.push(v);
}
	  // stringStack.serialize();
	  doubleStack.serialize();
	  
	  String filePath="E:\\New folder\\stackSerialization.txt";
	  try
	  {
	  FileInputStream istream = new FileInputStream(filePath);
	  
	  while(istream.available()!=0) { 
		  ObjectInputStream objectsIn = new ObjectInputStream(istream);  
		 // System.out.println((T)(objectsIn.readObject()));  //Problem in this line
	  System.out.println((Double)(objectsIn.readObject()));  //Problem in this line
			  }
	     istream.close();                                         
			    } catch(IOException e3){
			      e3.printStackTrace();
			      System.exit(1); 
			    } catch(ClassNotFoundException e){
			      e.printStackTrace();
			      System.exit(1);
			    }
	     }
}
