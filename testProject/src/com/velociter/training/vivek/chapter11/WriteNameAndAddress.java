package com.velociter.training.vivek.chapter11;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class WriteNameAndAddress
{
	//to take input as a character create BufferedReader object
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		//method to get character input from keyboard and return character
		public char selectOperation() throws IOException
		{
			String chooseInput=null;
			System.out.println("Enter a character to perform operation:");
			System.out.println("Enter N or n for name and address");
			System.out.println("Enter D or d for Display data from files");
			chooseInput=input.readLine();
			return chooseInput.trim().charAt(0);
		}
		
		public void operate() throws IOException
		{
				while(true)
				{
					switch(selectOperation())
					{
					  case 'N': case 'n':
						  addNameAndAddress();
						  break;
					   case 'D': case 'd':
						  displayNameAndAddress();
						  break;
						
					  default:
						  System.out.println("Invalid Input ! try again");
						  break;
					}
				}
			}		

		public void addNameAndAddress() throws IOException
		{
			Scanner scanner= new Scanner(System.in);
			System.out.println("Enter Name:");
			String name=scanner.nextLine();
			System.out.println("Enter Surname:");
			String surName=scanner.nextLine();
			
			
			System.out.println("Enter address in one line");
			String address=scanner.nextLine();
		
			
			
			File file = new File("c:\\AvoidFile\\abc.txt");
			
		
			FileWriter myWriter = new FileWriter(file, true); 
			
				myWriter.write(name+" ");
				myWriter.write(surName+" ");
				myWriter.write(address+" "+"\n");
				System.out.println();
				System.out.println("Successfully wrote to the file.");
				myWriter.close();
				
			
		}
		
		
		
		public void displayNameAndAddress() throws IOException
		{
			
			
					File file = new File("c:\\AvoidFile\\abc.txt");
					FileInputStream fisObject = new FileInputStream(file);
					int readData=0;
					while((readData=fisObject.read())!=-1)
					{
						System.out.print((char)readData);
						
					}
					
					System.out.println();
			
		}
		
		
		public static void main(String[] args)
		{
			   	
			       WriteNameAndAddress object= new WriteNameAndAddress();
			    	try {
						object.operate();
					} catch (IOException e) {
						
						e.printStackTrace();
					}
			
		}
}
