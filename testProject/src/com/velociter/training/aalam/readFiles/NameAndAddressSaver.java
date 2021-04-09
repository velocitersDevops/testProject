/*
 * Write a program that will allow either one or more names and addresses to be entered from the
keyboard and appended to a file, or the contents of the file to be read back and output to the
command line.
 */

package com.velociter.training.aalam.readFiles;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.InputMismatchException;
import java.util.Scanner;

public class NameAndAddressSaver
{

	 private String directory = "e:/uppending";
	 private String fileName = "NamesAndAddresses.bin";
     
	 private String firstName =null;
	 private String secondName =null;
	 private String address=null;
	 
	
	  Scanner sc = new Scanner(System.in);
	
	  //constructor
	  
	   public NameAndAddressSaver()
	   {
		   File dir = new File(directory);
		   if(!dir.isDirectory())          //if directory is not actualy exist directory then create
		   {
			   dir.mkdir();
		   }
	  
	       File file = new File(directory, fileName);   //give complete information about folder and file 
	
	   }//constructor close

	   
	   public void selectOperations(){
		    // Get operation selection from the keyboard
		    while(true) 
		    {  
		      switch(operations()) 
		      {

		        case 1:  // Read and add a new name and address
		                addNameAndAddress();
		                break;

		        case 2:  // Display the contents of the file
		                displayNamesAndAddresses();
		                break;

		        case 3:  // Quit the program, but first close all channels
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
		   System.out.println("\nEnter a Digit to select an opermmmmmmmmmmation:"
                  
                   +"\n 1 or n to enter a new name and address."
                   +"\n 2 or d to display the contents of the file."
		           +"\n 3 to quit the program.");
		      try 
		      {
			     selceteOption =sc.nextInt();
		      }catch(InputMismatchException e)
		      {
		    	  System.err.println("You Not Entered Valid Option.please try again");
		    	  System.exit(0);
		      }
		  

		   return selceteOption;
	   }
	   
	   private void addNameAndAddress() 
	   {
		   System.out.println("Enter how many person Record You Want to insert");
		   int numberOfRecords =sc.nextInt();
		   for(int i=1;i<=numberOfRecords;i++)
		   {
			   
		   
			   
		  
		   System.out.println("Enter first name:");
		   firstName =sc.next();
		   System.out.println("Enter second name:");
		   secondName=sc.next();
		   System.out.println("Enter Your address :");
		   address = sc.next();
		   
		   //Appending data into file
		   try 
		   {
			   
		      File userFile = new File("e:/uppending/NamesAndAddresses.txt");
		      FileWriter fileWriterObject = new FileWriter(userFile,true);
		      BufferedWriter bufferWriterObject = new BufferedWriter(fileWriterObject);  //creating BufferedWriter object by  fileWriterObject
		      
		      //upeending code
		      bufferWriterObject.write("   "+firstName+"          "+secondName+"         "+address+String.format("%n"));
		      
		      bufferWriterObject.close();
		      fileWriterObject.close();
		     
		   }catch(FileNotFoundException fnfException )
		   {
			   System.err.println("File Not Exist . please check");
		   }
		   catch(IOException ioException)
		   {
			   System.err.println("Have Some Issues . please Try Again");
		   }
		  }//loop close here
		   System.out.println("uppend data");
	   }

	   
	   //display method to display file data
	   private void displayNamesAndAddresses() 
	   {
		   System.out.println("  FirstName      SecondName      Address");
		   System.out.println(" ===========    ============    ===========");
		   try 
		   {
		   File fileObject = new File("e:/uppending/NamesAndAddresses.txt");
		   BufferedReader br = new BufferedReader(new FileReader(fileObject)); //fileReader Read files then stored in buffered
		   
		   String personDetails;
		 
			   while ((personDetails = br.readLine()) != null)  //here from buffered to string
			   {
				 
			     System.out.println(personDetails);
			   }
		     } 
		     catch (IOException e) 
		     {
			  e.printStackTrace();
			  System.err.println("ave some Issues.please try again");
			  System.exit(0);
			 }
 
	   }

	   

	public static void main(String[] args) 
	{
		NameAndAddressSaver object = new NameAndAddressSaver();
		object.selectOperations();

	}

}
