package com.velociter.training.mukesh.chapter11;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ReadNameWithAddressFromSecondName {

	public static void main(String[] args) 
	{
		
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter name");
		String name=scanner.next();
		
		System.out.println("Enter surname");
		String surName=scanner.next();
		
		System.out.println("Enter address in one line");
		String address=scanner.next();
		
		
		File file= new File("E:\\Dataset\\index.txt");
		
		try {
			FileOutputStream fos = new FileOutputStream(file, true);
		} catch (FileNotFoundException e1) {
			
			e1.printStackTrace();
		}
		try {
			
			
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
