package com.velociter.training.ankit.serialization;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.StreamCorruptedException;
import java.util.Scanner;

class Name implements Serializable
{
private String name;
public Name(String name)
{
	this.name=name;
}
    public String toString() {
		return name;
	}
}
class Address implements Serializable
{
	private String address;
	public Address(String address)
	{
		this.address=address;
	}
		public String toString() {
		return address;
	}
}
class Person implements Serializable
{
	private Name name;
	private Address address;
	private Index index;
//	public Person(Name name,Index index,Address address)
//	{
//		this.name=name;
//		this.index=index;
//		this.address=address;
//	}
	public Person(Name name,Address address)
	{
		this.name=name;
		this.address=address;
	}
	@Override
	public String toString() {
		//System.out.println(name+" "+address);
     return name+""+address;
     //return name+" "+index+""+address;
	}
}
class Index implements Serializable
{

	private int index;
	private String secondName;
	
	Index(int index ,String secondName)
	{
		this.index=index;
		this.secondName=secondName;
		
	}
	
	public String toString() {
		return index+""+secondName;
	}
	
}
public class PersonIndexFile 
{
	
	   public static void main(String[] args) {
		  // String[] containtObject=new String[];
	   String name=null,address=null,secondName=null;
	   Scanner sc=new Scanner(System.in);
	   //indexing Code
	   int count=count();
	   System.out.println("Enter name");
	   name= sc.nextLine();
//	   System.out.println("Enter Second Name");
//	   secondName=sc.nextLine();
	   System.out.println("Enter Address");
	   address=sc.nextLine();
	   
	   Name nameObj=new Name(name);
	   Index indexObj=new Index(count,secondName);
	   Address addressObj=new Address(address);
	   //Person person=new Person(nameObj,indexObj,addressObj);
	   Person person=new Person(nameObj,addressObj);
	   	   
	ObjectOutputStream objectOut=null;
	String filePath="E:\\New folder\\ObjectIndex.txt";
	try {
		objectOut=new ObjectOutputStream(new FileOutputStream(filePath,true));
		//objectOut=new ObjectOutputStream(new BufferedOutputStream(new  FileOutputStream(filePath)));
		objectOut.writeObject(person+String.format("%n"));
		System.out.println("File Created"); 
	} catch (FileNotFoundException e) 
	{
	  e.printStackTrace();
	}
	catch (StreamCorruptedException e1)
	{
	 e1.printStackTrace();
	}
	catch (IOException e) 
	{
	  e.printStackTrace();
	}
  }
	   public static int count()
		{
			String filePath="E:\\New folder\\ObjectIndex.txt";
			 int count = 0;
	         try {
		      File file = new File(filePath);
	          Scanner sc = new Scanner(file);
		      while(sc.hasNextLine()) {
		        sc.nextLine();
		        count++;
		      }
		      System.out.println("Total Number of Lines: " + count);
		      sc.close();
		    } catch (Exception e) {
		      e.getStackTrace();
		    }
		  return count;
		}
}
