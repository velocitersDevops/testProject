package com.velociter.training.vivek.chapter11;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ReadNameAndAddressFromSecondName
{
   public static void main(String args[])
   {
	   Scanner scanner = new Scanner(System.in);

	    System.out.println("enter first Name");
	    String name=scanner.nextLine();
	    System.out.println("enter second Name");
	    String surName=scanner.nextLine();
	    System.out.println("enter address");
	    String address=scanner.nextLine();
	    
try {
			File file=new File("c:\\AvoidFile\\abc.txt");
			
			FileWriter myWriter = new FileWriter(file, true);
			myWriter.write(name+String.format(" ")+surName+String.format(" "));
			myWriter.write(address+String.format("%n"));
			
			System.out.println("successfully wrote into the file ");
			myWriter.close();
			
			System.out.println("Enter surname to find that name and address");
			String choice=scanner.next();
			
			FileReader reader=new FileReader(file);
			BufferedReader buffer=new BufferedReader(reader);
			
				String data;
				String stringWord[];
				
				while((data=buffer.readLine())!=null)
				{
					stringWord=data.split(" ");
					for(String string :stringWord)
					{
						if(choice.equals(string))
						{
							if(stringWord.length==3)
							{
								System.out.print(data+""+String.format("%n"));
							}
						}
						
					}
				}
				
		} catch (IOException e) {
			
			e.printStackTrace();
		}
   }
}
