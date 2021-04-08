package com.velociter.training.ankit.readingfiles;
//3rd
import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class ReadPrimeValues
{

	 public static void main(String[] args) 
	 {

Scanner sc = new Scanner(System.in);

int nthPrime=15;
int count=0;
int number=30;
int primenumbers[] = new int[nthPrime];
int index=0;
if(nthPrime>0)
{
//System.out.println("your prime numbers are");
while(count!= nthPrime)
{

      boolean prime = true;
      for (int i = 2; i <= Math.sqrt(number);i++)
      {
          if (number % i == 0)
          {
              prime = false;
              break;
              
          }
          
      }
      if (prime)
      {
       count++;
           //System.out.println(number);
       primenumbers[index]=number;
         //System.out.println(primenumbers[index]);
         index++;
      }
    
      number++;
    }
}

String dirName = "E:\\New folder";   // Directory for the output file
String fileName = "PrimeNumber.txt";// Name of the output file
File newFile=new File(dirName, fileName);
try 
{
FileOutputStream outNewFile=new FileOutputStream(newFile);
System.out.println("File Created");
}
catch(FileNotFoundException ex)
{
	System.out.println("File not Found");
}
try {
   FileWriter myWriter = new FileWriter(newFile);
   for(int  date :primenumbers) { 
   	myWriter.write(date+String.format("%n"));
   	//myWriter.n
   	}
  myWriter.close();
   System.out.println("Successfully wrote to the file.");
 } catch (IOException e) {
   System.out.println("An error occurred.");
   e.printStackTrace();
 }
//reading files
sc=new Scanner(System.in);
int nth=0;
System.out.println("Enter nth possition");
try {
	  nth =sc.nextInt();
	 
}catch(NumberFormatException e)
{
	  System.out.println("Wrong Input..");
}

for(int i=0;i<primenumbers.length;i++)
{
if(primenumbers[i]==nth)
{
	System.out.println("Found At "+(i+1)+"th position");
}
}
}}