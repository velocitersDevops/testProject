package com.velociter.training.mukesh.chapter12;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class SavePersonName {

	public static void main(String[] args) 
	{
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter person First name");
		String name=scanner.nextLine();
		System.out.println("Enter person surname ");
		String surname=scanner.nextLine();
		System.out.println("Enter person address ");
		String address=scanner.nextLine();
		
		Name nameObject= new Name(name,surname);
		Address addressObject= new Address(address);
		Person personObject= new Person(nameObject,addressObject);
		
		File file = new File("E:\\Dataset\\person.txt");
		
		ObjectOutputStream objectOut = null;
		try 
		{
			objectOut = new ObjectOutputStream(new FileOutputStream(file, true));
			objectOut.writeObject(personObject);
		} 
		
		catch (IOException e)
		{
			e.printStackTrace();
		}
		try
		{
			objectOut.flush();
			objectOut.close();
		} 
		catch (IOException e) 
		{
			
			e.printStackTrace();
		}
		System.out.println("successfully wrote into the file");
		
	}
		
		
}


