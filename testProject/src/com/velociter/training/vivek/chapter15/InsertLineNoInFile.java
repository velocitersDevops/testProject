package com.velociter.training.vivek.chapter15;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class InsertLineNoInFile
{
	public static void main(String[] args) {
		int ctr = 0;
		try {

			BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\AvoidFile\\abc.txt"));
			PrintWriter printWriter = new PrintWriter(new FileWriter("C:\\AvoidFile\\abc.txt"));
			
			String str;

			while ((str = bufferedReader.readLine()) != null) {

				ctr++;
				
				printWriter.println(ctr + " " + str);
				//System.out.println(ctr + " " + str);
				Thread.sleep(500);
				//System.out.println("line no are mention in the given file");
			}
			
			printWriter.close();
			bufferedReader.close();
			System.out.println("line no are mention in file");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
