package com.velociter.training.ankit.readingfiles;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ReadIndexFile {
	
	static String filePath = "E:\\New folder\\Address.txt";
	static String filePathIndex = "E:\\New folder\\AddressIndex.txt";
	
	public static int count()
	{
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
	
	public static void  readIndex()
	{
		
		File file = new File(filePath);
		File file1 = new File(filePathIndex);
		int count=count();
		FileWriter fileWriter,fileWriter1;
		Scanner inputData= new Scanner(System.in);
		System.out.println("How many nput You want to Enter");
        Scanner numberOfInput=new Scanner(System.in);
        final int person=numberOfInput.nextInt();
        String containt[]=new String[person];
         String firstName[]=new  String[person];
         String surName[]=new  String[person];
         String address[]=new  String[person];
         for(int i=0;i<containt.length;i++)
         {
        	 System.out.println((i+1)+" Input...........");
        	 System.out.println("Enter Name");
             firstName[i] =inputData.nextLine();
             System.out.println("Enter Surname");
             surName[i] =inputData.nextLine();
             System.out.println("Enter Address");
              address[i] =inputData.nextLine();
        	 
         }
         
        try {
			fileWriter = new FileWriter(file, true);
			fileWriter1 = new FileWriter(file1, true);
		 
		BufferedWriter br = new BufferedWriter(fileWriter);
		BufferedWriter br1 = new BufferedWriter(fileWriter1);
        for(int i=0;i<containt.length;i++)
       {
        	//surName[count]=surName[i];
       containt[i] =firstName[i]+"  "+address[i];
        br.write(containt[i]+String.format("%n"));
        br1.write(surName[i]+String.format("%n"));
        count++;
       }		
        System.out.println("File Created");
        br.close();
		fileWriter.close();
		br1.close();
		fileWriter1.close();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Reading File
        System.out.println("File Reading Data");
        FileInputStream fileInputStram=null;
		 try{    
			 fileInputStram=new FileInputStream(filePath);   
	         Scanner  sc=new Scanner(System.in);
			 String  surname = null;
			 System.out.println("Enter Surname");
			  try {
			 	  surname =sc.nextLine();
			 	 
			  }catch(NumberFormatException e)
			  {
			 	  System.out.println("Wrong Input..");
			  }
			  surName(count,surname);

 }
	 catch(Exception e1)
		 {
			 e1.printStackTrace();
		 }
		
	}
	public static void surName(int value,String surname)
	{
	    String[] surNameIndex=new String[value];
	    String[] surName=new String[value];
	   
		try {
			int i=0;
		      File file = new File(filePath);
	          Scanner sc = new Scanner(file);
		      while(sc.hasNextLine()) {
		        surNameIndex[i]=sc.nextLine();
		        i++;
		        
		      }
		    
		      File file1 = new File(filePathIndex);
	          Scanner sc1 = new Scanner(file1);
		      int checkValue=0;
	          while(sc1.hasNextLine()) {
		    	surName[checkValue]=sc1.nextLine();
		    	checkValue++;
		      }
		      
		      
		      sc.close();
		    } catch (Exception e) {
		      e.getStackTrace();
		    }
		   for(int i=0;i<surNameIndex.length;i++)
			 {
			 if(surName[i].equals(surname))
			 {
			 	System.out.println("Found At "+(i+1)+" position "+surNameIndex[i]);
			 }
			 }
		
	}
	public static void main(String ar[])
	{
		
	readIndex();	
	//surName();
	}
}