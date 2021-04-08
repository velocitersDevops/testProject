package com.velociter.training.mukesh.chapter11;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PrimeNumber {

	public static void main(String [] args) throws IOException ,FileNotFoundException
	{
		//scanner object to take input from keyboard
		System.out.println("enter number:");
		Scanner input = new Scanner(System.in);
		int nthPrime= input.nextInt();
		
		//initialize some variable
		int count=0;
		int startNumber=2;			
		int primeArray[]=new int[nthPrime];
		int index=0;
		if(nthPrime>0)
		{
				while(count!=nthPrime)
				{
						boolean prime= true;
						for(int i=2;i<=Math.sqrt(startNumber);i++)     //starting from number 2 
						{
							if(startNumber%i==0)
							{
								prime= false;
								break;
							}
						}
						if(prime)
						{
							count++;
							
							primeArray[index]=startNumber;				//store prime number into array
							
							index++;
						}
						startNumber++;
				}
		}
		else
			System.out.println("invalid number");
		
			File file= new File("E:\\Dataset\\Prime.txt");
		
			FileOutputStream fosObject = new FileOutputStream(file);					//to create file
			
			FileWriter writer=new FileWriter(file);										//to write data into files
			for(int value:primeArray)
			{
				 writer.write(" "+value+String.format("%n"));
			}
			writer.close();
			System.out.println("successFully wrote into the file ");
			
			System.out.println("do you want to read this file [yes/no]");
			String choice=input.next();
			if(choice.equalsIgnoreCase("yes")) {
				
				FileInputStream fisObject = new FileInputStream(file);						//to read data from file 
				int data =0;
				while((data=fisObject.read())!=-1)
				{
					System.out.print((char)data);
				}
				fisObject.close();
			}else
				System.out.println("Thanks ! to write data");
		
	}
}
