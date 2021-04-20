package com.velociter.training.aalam.readFiles;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class NameAndAddressSaverWithIndex
{

	 private String directory = "e:/record";
	 private String fileName = "personRecord.bin";
     static int index=1;
	 private String firstName =null;
	 private String secondName =null;
	 private String address=null;
	 
	 private String pathindexFile ="e:/record/indexRecord.bin";
	 private String pathRecordFile ="e:/record/personRecord.bin";
	 
	  Scanner scan = new Scanner(System.in);
	
	  //constructor
	  
	   public NameAndAddressSaverWithIndex()
	   {
		   File dir = new File(directory);
		   if(!dir.isDirectory())          //if directory is not actually exist directory then create
		   {
			   dir.mkdir();
		   }
	   
	  
	       File file = new File(directory, fileName);   //give complete information about folder and file 
	
	   }
	   
	   public void selectOperations() throws IOException{
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

		        case 3: 
		                 fetchingRecordsFromFile();
		                 break;
		          
		          
		        case 4:  // Quit the program, but first close all channels
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
                  
                   +"\n 1 or n to enter a new name and address."
                   +"\n 2 or d to display the contents of the file."
                   +"\n 3 to fetch Record Corresponding to sirName."
		           +"\n 4 to quit the program.");
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
	   
	   private void addNameAndAddress() 
	   {
		   System.out.println("Enter how many person Record You Want to insert");
		   int numberOfRecords=1;
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
			
		   System.out.println("Enter first name:");
		   firstName =scan.next();
		   System.out.println("Enter second name:");
		   secondName=scan.next();
		   System.out.println("Enter Your address :");
		   address = scan.next();
		   
		   //Appending data into file
		   try 
		   {
		      File indexNameRecord = new File(pathindexFile);  //taking index and first name
		      FileWriter fileWriterObjectforindex = new FileWriter(indexNameRecord,true);
		      BufferedWriter bufferWriterObjectForIndex = new BufferedWriter(fileWriterObjectforindex);
		      //read only last index from
		      index =getlastIndex();
		      index++;
		      bufferWriterObjectForIndex.write("        "+index+"       "+secondName+String.format("%n"));
		      bufferWriterObjectForIndex.close();
		      fileWriterObjectforindex.close();
		      
		      
		      //writing second name and address
		      File userFile = new File(pathRecordFile);        //taking secondName and address
		      FileWriter fileWriterObject = new FileWriter(userFile,true);
		      BufferedWriter bufferWriterObject = new BufferedWriter(fileWriterObject);  //creating BufferedWriter object by  fileWriterObject
		      
		      //upeending code
		      bufferWriterObject.write("         "+firstName+"         "+address+String.format("%n"));		     
		      bufferWriterObject.close();
		      fileWriterObject.close();
		      
		   }
		   catch(FileNotFoundException fnfException )
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
		   System.out.println("     index   SecondName    ");
		   System.out.println("    =======  ===========   ");
		   try 
		   { 
		       File fileindexRecord = new File(pathindexFile);
			   BufferedReader bufferedReaderObjectForIndexRecord = new BufferedReader(new FileReader(fileindexRecord)); //fileReader Read files then stored in buffered
			   
			   String takingIndexData;
				   while ((takingIndexData = bufferedReaderObjectForIndexRecord.readLine()) != null)  //here from buffered to string
				   {
					 
				     System.out.println(takingIndexData);
				   }	      
				   bufferedReaderObjectForIndexRecord.close();
		     } 
		     catch(IOException e) 
		     {
			  e.printStackTrace();
			  System.err.println("have some Issues.please try again");
			  System.exit(0);
			 }
	   }
	  
		public  int getlastIndex()
		{
			 
			int indexValue=0;
			try 
			{
				File fileindexRecord = new File(pathindexFile);
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
		
		//method to fetch record based on secondName
		public void fetchingRecordsFromFile() 
		{
			int indexx = getlastIndex();
			String[] indexRecord = new String[indexx];
			String[] nameRecord = new String[indexx];
			
			//read data form pathRecordfile
			File RecordFile = new File(pathRecordFile);
		    Scanner scannerObject=null;
		   
			try 
			{
				scannerObject = new Scanner(RecordFile);
			} 
			catch (FileNotFoundException e) 
			{
			  e.printStackTrace();
			}
			int i=0;
		    while(scannerObject.hasNextLine())
		    {
		    	nameRecord[i]= scannerObject.nextLine();
		     	i++;
			}  
		   
		  
		    //read data form pathindexfile
			File fileindexRecord = new File(pathindexFile);
		    Scanner scannerObjectindex=null;
		  
			try 
			{
				scannerObjectindex = new Scanner(fileindexRecord);
			} 
			catch (FileNotFoundException e) 
			{
			  e.printStackTrace();
			}
			  int j=0;
		    while(scannerObjectindex.hasNextLine())
		    {
		    	indexRecord[j]= scannerObjectindex.nextLine();
		     	j++;
			}
		    scannerObjectindex.close();
	
		    System.out.println("Enter sir Name to get corresponding records");
		    String sirName =scan.next();
	        
		    for(int k=0;k < indexRecord.length;k++)
		    {
		    	 
	    	if(indexRecord[k].contains(sirName))
	    	{
	    		System.out.println("index records "+	nameRecord[k]);
	    		  //System.out.println("index records "+	nameRecord[k]); 
		    	
	    	  }
		    }
	   }

		
		
	public static void main(String[] args) throws IOException 
	{
		 NameAndAddressSaverWithIndex object= new NameAndAddressSaverWithIndex();
		 object.selectOperations();

	}



}
