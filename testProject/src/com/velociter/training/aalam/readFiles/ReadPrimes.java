package com.velociter.training.aalam.readFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadPrimes
{

	 public static void main(String[] args) throws FileNotFoundException 
	 {
			 		   
		
			//input from user
		
		    int start = 2;
			int end = 71;
			 int[] primenumbers  = new int[20];
			 int index=0;
			System.out.println("20 Prime numbers stored in file  : ");
			int count;
			//loop for finding and printing all prime numbers between given range
			for(int i = start ; i <= end ; i++)
			{
				//logic for checking number is prime or not
				count = 0;
				for(int j = 1 ; j <= i ; j++)	
				{
					if(i % j == 0)
						count = count+1;
				}
				if(count == 2)
				{
					
					//System.out.println(i);
					
					
						primenumbers[index] =i;
						index++;
				}
			}
			
			for(int i=0;i<primenumbers.length;i++)
			{
				//System.out.println(primenumbers[i]);
			}
			//closing scanner class(not mandatory but good practice)
		   
			String filePath = "E:\\primedata\\prime.txt";
			File userFile = new File(filePath); 
			FileOutputStream outputStream = null;
	 			
			//creating file at location
			try
			{
				outputStream = new FileOutputStream(userFile,true);
			}catch(FileNotFoundException e)
			{
				System.out.println("File not found");
			      System.exit(1);
			}
		
			//writing data into a file
			try
			{
				FileWriter fileWriterObject = new FileWriter(userFile);
				for(int prime  : primenumbers)
				{
					fileWriterObject.write(prime +" ");
				}
				fileWriterObject.close();
				System.out.println("Successfully wroted to the file.");
			}catch(IOException e)
				    {
				    	System.out.println("Have some issues related to IO.please try again");
				    	System.exit(0);
				    }
		    
		   		//=========================write is complete===========================
			     
			    //======================== file read operation start===================
				          
			 int[] myIntArray = new int[20];
			 File fileLocation = new File ("E:\\primedata\\prime.txt");

		        try {
		            Scanner sc = new Scanner(fileLocation);    //Scanner
		             for (int i=0; i < myIntArray.length; i++) {
		                 myIntArray[i] = sc.nextInt();
		            }
		            // Closing the file
		            sc.close();

		       } catch (IOException e) {
		            System.out.println("have some input output issues");      
		       }

				Scanner sc = new Scanner(System.in);
				int nth = 0;
				System.out.println("Enter nth possition to get data");
				try {
					nth = sc.nextInt();
					nth = nth - 1;
				} catch (NumberFormatException e) {
					System.out.println("You not Enterd Number");
				}

				// getting nth element
				for (int i = 1; i < myIntArray.length; i++) {
					if (i == nth) {
						System.out.println(myIntArray[i]);
					}
				}

			}

		}

	 
	