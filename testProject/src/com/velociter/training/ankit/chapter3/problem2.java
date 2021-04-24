//A lottery requires that you select six different numbers from the integers 1 to 49. Write a program
//to do this for you and generate five sets of entries.
package com.velociter.training.ankit.chapter3;
public class problem2 {
public static void main(String sr[]) {
 int lucky=0;
 int lottry[]=new int[6];
 for(int i=0;i<6;i++)
 {
	 lottry[i]=(int) (Math.random()*50);
	 System.out.println(lottry[i]);
 }
 lucky=(int)(Math.random()*50);
 System.out.println("Lucky number is="+lucky);
 for(int i=0;i<6;i++)
 {
	 if(lucky==lottry[i])
	 {
		 System.out.println("Hurrey your lucky number is="+lottry[i]);
	 }
	 else
	 {
		 System.out.println("Better Luck next time..");
	 }
 }
}
	
}
