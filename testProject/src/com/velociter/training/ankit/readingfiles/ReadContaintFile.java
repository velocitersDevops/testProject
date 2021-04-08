package com.velociter.training.ankit.readingfiles;
//5th
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Scanner;
public class ReadContaintFile {

	public static void main(String[] ar)
	{
		//Path path = Paths.get("E:\\New folder\\WriteDates.txt");
		Path path= Paths.get("E:\\New folder\\Address.txt");
		Scanner input= new Scanner(System.in);
		System.out.println("Enter name and address");
		String containt[]=new String[2];
		for(int i=0;i<containt.length;i++)
		{
		containt[i] =input.nextLine();
		}
		for(int i=0;i<containt.length;i++)
		try {
			Files.write(path, containt[i].getBytes(),StandardOpenOption.APPEND);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("data written");
			try
			{
			List<String> data=Files.readAllLines(path);
			for(String result:data)
			{
				System.out.println(" "+result);
			}
			
		} catch (Exception e1) {
		
			e1.printStackTrace();
		}
	}
	}

