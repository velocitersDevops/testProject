package com.velociter.training.ankit.serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

import com.velociter.training.ankit.serialization.Address;
import com.velociter.training.ankit.serialization.Name;
import com.velociter.training.ankit.serialization.Person;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.IOException;

public class RandomAccess 
{	
		
		    final String filePath="E:\\New folder\\ObjectSerialization.txt";
			final String indexFilePath="E:\\New folder\\ObjectIndex.txt";
		    Scanner scan = new Scanner(System.in);
		    String name=null;
		    String address=null;
		    int index=0;
		    Scanner sc = new Scanner(System.in);
		    public void selectOperations() throws IOException
		    {
			    // Get operation selection from the keyboard
			    while(true) 
			    {  
			      switch(operations()) 
			      {
			        case 1:  // Display the contents of the file
			                displayNamesAndAddresses();
			                break;

			        case 2: 
		                 System.out.println("shutingDown..");
		                 System.exit(0);
		          break;

			        default:
			          System.err.println("Invalid Input. Try again.");
			          break;
			        }
			     }
		       }
		    public int operations()
			   {
				   int selceteOption=0;
				   System.out.println("\nEnter Choice:"
		                   +"\n 1  to display file."
				           +"\n 2  to quit the program.");
				      try 
				      {
					     selceteOption =scan.nextInt();
				      }catch(InputMismatchException e)
				      {
				    	  System.err.println("Invalid !!!.please try again");
				    	  System.exit(0);
				      }
				  

				   return selceteOption;
			   }

		    
		  private void displayNamesAndAddresses() 
			   {
				   
				   Person[] personObject = new Person[5];
				   System.out.println("Enter Your name ");
				   name =scan.next();
				   int i=0;
				   try {
						
					    //reading data from index file
					 	FileInputStream isStreamPersonIndex = new FileInputStream(indexFilePath);
					 	 FileInputStream isStreamPerson = new FileInputStream(filePath);
					     while(isStreamPersonIndex.available()!=0  &&  isStreamPerson.available()!=0)                         // While there are bytes in the underlying stream
				         { 
					       ObjectInputStream IndexobjectsIn = new ObjectInputStream(isStreamPersonIndex);
					      // entry = (IndexEntry)  IndexobjectsIn.readObject();  // Read and display an object
						  
					       ObjectInputStream personobjectsInputStream = new ObjectInputStream(isStreamPerson);
						   personObject[i]  = (Person)  personobjectsInputStream.readObject();  // Read and dis
						   System.out.println();
					     i++;
						 }
					     isStreamPersonIndex.close();  // Close the stream  
					     isStreamPerson.close();       // Close the stream
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
		    
			   //method to get last index from file
				public  int getlastIndex()
				{
					 
					int indexValue=0;
					try 
					{
						File fileindexRecord = new File(indexFilePath);
					    Scanner scannerObject = new Scanner(fileindexRecord);
					 while(scannerObject.hasNextLine())
					 {
						 scannerObject.nextLine();
						 indexValue++;
					 }
				      System.out.println("last index:"+indexValue);
				      scannerObject.close();
					} catch (Exception e) {
					  System.err.println("HAVE some isssues");
					}

					return indexValue;
				}


	 public static void main(String args[]) throws IOException 
 {	  
    RandomAccess personObject  = new RandomAccess();
    personObject.selectOperations();
  }
}
