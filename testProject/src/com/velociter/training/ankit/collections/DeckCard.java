package com.velociter.training.ankit.collections;
//Problem 2
import java.util.Random;
import java.util.Vector;
import java.util.LinkedList;
import java.util.ListIterator;

public class DeckCard {
	
	public static void main(String[] ar) {
		
		String[] suits = { "C", "D", "S", "H" };
		String[] cardValues = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
		Random random = new Random();
        int numberOfCards = 52;
		Vector<String> deck = new Vector<String>(numberOfCards);
		for (String suit:suits)
		{
		  for (String cardValue : cardValues)
	    	{
		      deck.add(cardValue + suit); 
		    }
		}
//		for(String d : deck) {
//		     System.out.println(d);
//}
		LinkedList<String> shuffledDeck = new LinkedList<String>();
		int selection = 0;
		for (int i = 0; i < numberOfCards; i++)
		{
			//System.out.println(deck.size());
		selection = random.nextInt(deck.size()); 
		shuffledDeck.add(deck.get(selection));   
		//System.out.println(shuffledDeck);
		}
		StringBuffer[] handsOfcard = { new StringBuffer("1st Hand :"), new StringBuffer("2nd Hand :"),new StringBuffer("3rd Hand :"), new StringBuffer("4th Hand :")};
        ListIterator<String> cards = shuffledDeck.listIterator();

		while (cards.hasNext())
		{
		for (StringBuffer hand : handsOfcard) {
		hand.append(" "+(String) (cards.next()));
		}
		}
		// display the cards
		System.out.println("Hands Of Cards :");
		for (StringBuffer hand : handsOfcard) {
		System.out.println(hand);
		}
     }
}

