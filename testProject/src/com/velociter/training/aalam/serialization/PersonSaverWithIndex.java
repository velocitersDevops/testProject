/*
 * Extend the previous example to add an index based on the person’s name for each person
entered at the keyboard to locate the corresponding Person object in the object file. The index
file will contain entries of type IndexEntry, each of which encapsulates a name and a file position
in the object file. The index file should be a separate file from the original file containing
Person objects.
Note: You will probably find it easiest to delete the previous file before you run this example so
that the object file can be reconstructed along with the index file. You can’t get the file position in
an object stream in the same way as you can with a channel. However, you can use the sequence
number for an object as the index—the first object being 1, the second being 2, and so on.
 */
package com.velociter.training.aalam.serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.velociter.training.aalam.serialization.Address;
import com.velociter.training.aalam.serialization.Name;
import com.velociter.training.aalam.serialization.Person;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.IOException;

public class PersonSaverWithIndex 
{
	
		
		    final String filePath = "e:/programingExample/serialzation/IndexedPersons.bin";
		    final String indexFilePath = "e:/programingExample/serialzation/Index.bin";
		    final String lastindexFilePath ="e:/programingExample/serialzation/lastIndex.bin";
		    Scanner scan = new Scanner(System.in);
		    String name=null;
		    String address=null;
		    int index=0;
			int lastindex=0;
		    
		    public void selectOperations() throws IOException{
			    // Get operation selection from the keyboard
			    while(true) 
			    {  
			      switch(operations()) 
			      {

			        case 1:  // Read and add a new name and address
			                writePersonNameAndAddress();
			                break;

			        case 2:  // Display the contents of the file
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
		                  
		                   +"\n 1  to enter a  name and address with index."
		                   +"\n 2  to display the contents of the file."
				           +"\n 3  to quit the program.");
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
//----------------------------------------------------------//
		    
		    private void writePersonNameAndAddress() throws IOException 
			   {
				   System.out.println("Enter how many person Record You Want to save into a file");
				   int numberOfRecords=0;
				   try 
				   {
					    numberOfRecords =scan.nextInt();
				   }
				   catch(InputMismatchException inputMisMatchException)
				   {
					   System.err.println("You Not Entered Number.please check then try again.");
					   System.exit(0);
				   }
				 	
				   for(int i=1;i<=numberOfRecords;i++)
				   {
					
				   System.out.println("Enter Your name:");
				   name =scan.next();
				   Name nameObject = new Name(name);
				   System.out.println("Enter Your address :");
				   address = scan.next();
				   Address addressObject = new Address(address);
				 
				   
				   Person personObject = new Person(nameObject,addressObject);
				   System.out.print("person details   "+personObject.toString()+"    ");
				   
		
			 	//=======================================================================================================================//
				 
				   //Appending data into file
				   ObjectOutputStream objectOutPutStreamObject =null;
					try 
					{
						objectOutPutStreamObject = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(filePath,true)));
						objectOutPutStreamObject.writeObject(personObject);  //we can't use String.format("%n) bescauase it will throws java.lang.ClassCastException
					} catch (IOException e) 
					{
				       e.printStackTrace();
					}
					System.out.println("object Written into .bin file");
					objectOutPutStreamObject.close();
					
					//indexEntry object create here	
					index++;
					IndexEntry indexObject  = new IndexEntry(name,index);
					
					//Appending data into file
					   ObjectOutputStream objectOutPutStreamIndexObject =null;
						try 
						{
							objectOutPutStreamIndexObject = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(indexFilePath,true)));
							objectOutPutStreamIndexObject.writeObject(indexObject);  //+String.format("%n")
							String.format("%n");
						} catch (IOException e) 
						{
					       e.printStackTrace();
						}
						//System.out.println("indexEntry object Written into .bin file");
						objectOutPutStreamIndexObject.close();
				   }
				   }//loop close
			   
	//=================================================================================================================================================//
		    //read object data and display  
			   private void displayNamesAndAddresses() 
			   {
				   
				   try {
						
					    //reading data from index file
					 	FileInputStream isStreamPersonIndex = new FileInputStream(indexFilePath);
					 	 FileInputStream isStreamPerson = new FileInputStream(filePath);
					     while(isStreamPersonIndex.available()!=0  &&  isStreamPerson.available()!=0)                         // While there are bytes in the underlying stream
				         { 
					       ObjectInputStream IndexobjectsIn = new ObjectInputStream(isStreamPersonIndex);
						   System.out.print((IndexEntry)(IndexobjectsIn.readObject()));  // Read and display an object
						   ObjectInputStream personobjectsInputStream = new ObjectInputStream(isStreamPerson);
						   System.out.print((Person)(personobjectsInputStream.readObject()));  // Read and dis
						   System.out.println();
					     
						 }
					     isStreamPersonIndex.close();  // Close the stream  
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
		    
				// method to get last index from file
				public int getlastIndex(String filepath, int numberOfRecords) {
					// reading last index from file

					try {

						FileInputStream fileObject = new FileInputStream(filePath);
						// int j=0;

						lastindex = fileObject.read();
						System.out.println("last index get from file  " + lastindex);
						fileObject.close();
					} catch (Exception e) {
						System.out.println(e);
					}
					int startingIndex = numberOfRecords;
					lastindex = lastindex + numberOfRecords;

					return lastindex;
				}

				// method to write last index into file
				public boolean writeLastIndex(String filePath, int numberOfRecords) {

					File userFile = new File(filePath);
					FileOutputStream outputStream = null;
					try {
						outputStream = new FileOutputStream(userFile, true);
					} catch (FileNotFoundException e) {
						System.out.println("File not found");
						System.exit(1);
					}

					try {
						FileWriter fileWriterObject = new FileWriter(userFile);// .write(numberOfRecords);
						fileWriterObject.write(numberOfRecords);
						fileWriterObject.close();
						System.out.println("Successfully wroted to the file.");
					} catch (IOException e) {
						System.out.println("Have some issues related to IO.please try again");
						System.exit(0);
					}
					return true;
				}
				
				
	 public static void main(String args[]) throws IOException 
 {	  
    PersonSaverWithIndex personObject  = new PersonSaverWithIndex();
    personObject.selectOperations();
  }
}
