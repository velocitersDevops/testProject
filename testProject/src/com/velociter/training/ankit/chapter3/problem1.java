//Write a program to display a random choice from a set of six choices for breakfast (you could
//use any set; for example, scrambled eggs, waffles, fruit, cereal, toast, or yogurt).
package com.velociter.training.ankit.chapter3;
public class problem1 {
public static void main(String sr[])
{
String sets[] ={"scrambled eggs", "waffles", "fruit", "cereal", "toast", "yogurt"};
int choice=(int) (Math.random()*6);
System.out.println(sets[choice]);
}
}