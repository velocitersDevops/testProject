// Chapter 12 Exercise 3
package com.velociter.training.aalam.serialization;

/*
  Here we will add a file of objects that are indexes to the object file. Each IndexEntry will encapsulate
  a second name plus the sequence number of the object corresponding to that name, starting at 0.
  To make the file containing the IndexEntry objects easier to work with, we will write
  a count of the number of objects in the file at the beginning. That way we will know
  how big an array we need to hold them.
  
  Clearly using an index to a file of objects would be a lot more useful if we could
  use a channel to write the object file. Then we could set the file position for a
  particular object and avoid having to read through the objects in the file to get
  to the one we want.
*/

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

import com.velociter.training.aalam.serialization.Address;
import com.velociter.training.aalam.serialization.Name;
import com.velociter.training.aalam.serialization.Person;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.IOException;

public class RandomAccess
{	
		
		    final String filePath = "e:/programingExample/serialzation/IndexedPersons.bin";
		    final String indexFilePath = "e:/programingExample/serialzation/Index.bin";
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

			        case 3: 
		                 System.out.println("Program going to be shutDown..");
		                 System.exit(0);
		          break;

			        default:
			          System.out.println("Invalid Input. Try again.");
			          break;
			        }
			     }
		       }
		    public int operations()
			   {
				   int selceteOption=0;
				   System.out.println("\nEnter a Digit to select an operation:"
		                   +"\n 1  to display the contents of the file."
				           +"\n 2  to quit the program.");
				      try 
				      {
					     selceteOption =scan.nextInt();
				      }catch(InputMismatchException e)
				      {
				    	  System.err.println("You Not Entered Number.please try again");
				    	  System.exit(0);
				      }
				  

				   return selceteOption;
			   }
//-------------------------------------------------------------------------------//
		    
		    private void writePersonNameAndAddress() throws IOException 
			   {
				
				 
				
			   }
	//==================================================================//
		    //read object data and display  
			   private void displayNamesAndAddresses() 
			   {
				   IndexEntry[] entry = null;
				   Person[] personObject = new Person[5];
				   System.out.println("Enter Your name to get its address:");
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
					     
					/*   ArrayList<Person> arrlist = new ArrayList<>();
					     arrlist.add(personObject);
					     Iterator itr = arrlist.iterator();
					     while(itr.hasNext())
					     {
					    	 System.out.println(itr.next());
					     }
					 */    
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
