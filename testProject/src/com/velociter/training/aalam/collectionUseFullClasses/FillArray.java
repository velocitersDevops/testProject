/*
 * Define a static method to fill an array of type char[] with a given value passed as an argument
to the method.
 */

package com.velociter.training.aalam.collectionUseFullClasses;

import java.util.Arrays;

public class FillArray
{

	public static char[] fillCharacterToArray(char[] array, char fillCharacter)
	{
		Arrays.fill(array, fillCharacter); 
		return array;
	}

	public static void main(String[] args)
	{
		char[] chars = new char[10];
		char value = 'A';
		chars = fillCharacterToArray(chars, value); // calling static method to fill array with given character then
													// return back to main
		System.out.print("after fill the array: ");
		for (char ch : chars) {
			System.out.print(ch);
		}
	}

}
