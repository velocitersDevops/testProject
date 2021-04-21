package com.velociter.training.vivek.chapter11;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ReadDataWithHexaDecimal
{
    public static void main(String args [])
    {
    	File file = new File("c:\\AvoidFile\\abcdefg.txt");
    	
    	System.out.println("enter the data that you want to write into file");
    	Scanner scanner= new Scanner(System.in);
    	String data= scanner.nextLine();
    	
    	try {
			FileWriter myWriter = new FileWriter(file);
			myWriter.write(data);
			System.out.println("successfully wrote into the fie ");
			myWriter.close();
			System.out.println("do you want to convert this file into hexadecimal[yes/no]");
			String choice=scanner.nextLine();
			if(choice.equalsIgnoreCase("yes")) 
			{
				FileReader fileRead=new FileReader(file);
				int readData =0;
				int count=0;
				int change=0;
				while((readData=fileRead.read())!=-1)
				{
					System.out.printf("%X " ,readData);
					
					System.out.printf("%h",readData);
					System.out.printf(" "+(int)readData);
					System.out.println();
					
				}
				fileRead.close();
			}
			else
				System.out.println("Ok ! successfully written into file");
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
    	
    }
}
