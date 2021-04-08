package com.velociter.training.ankit.readingfiles;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class ReadContaintFile {

	public static void main(String[] ar)
	{
		String filePath = "E:\\New folder\\AddressPeople.txt";
		
		File file = new File(filePath);
		FileWriter fr;
		Scanner inputData= new Scanner(System.in);
        
        System.out.println("How many address name and address");
        Scanner numberOfdata=new Scanner(System.in);
        final int person=numberOfdata.nextInt();
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
			fr = new FileWriter(file, true);
			
		 
		BufferedWriter br = new BufferedWriter(fr);
		
        for(int i=0;i<containt.length;i++)
       {
        	//surName[count]=surName[i];
       containt[i] =firstName[i]+"  "+address[i];
        br.write(containt[i]+String.format("%n"));
        
       }		
        System.out.println("File Created");
        br.close();
		fr.close();
		
		
		
		
//.......................................................................................
		//Reading File
        System.out.println("File Reading Data");
        FileInputStream fileInputStram=null;
		 try{    
			 
			 fileInputStram=new FileInputStream(filePath);   
	            int i=0;
	            while((i=fileInputStram.read())!=-1)   //last character of file
	            {    
	                System.out.print((char)i);    
	            }    
	            fileInputStram.close();    
	          }
		 catch(Exception e)
		 {
	          System.out.println(e);
	          e.printStackTrace();}
        }
        catch(Exception e)
		 {
	          System.out.println(e);
	          e.printStackTrace();}
       }

        
	}

