package com.velociter.training.mukesh.chapter11;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ReadDataWithHexadecimal {

	public static void main(String[] args) 
	{
		File file = new File("E:\\Dataset\\hexafile.txt");
		System.out.println("Enter your data which you want to write into file");
		Scanner scanner = new Scanner(System.in); 
		
		String data= scanner.nextLine();
		
		try {
			FileOutputStream fosObject = new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			System.out.println("file not found please check");
			e.printStackTrace();
		}
		
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
					count++;
					if (count ==8) {
	                	
				        System.out.print("    ");
				        count = 0;
				        change++;
				    }
					if (change==5) {
				        System.out.println();
				        change = 0;
				    }
				}
				fileRead.close();
			}else
				System.out.println("Ok ! successfully written into file");
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	
	
}
