package com.velociter.training.aalam.collectionFramework;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Random;
import java.util.Vector;

public class DeakCards {
	public static void main(String[] args) {
		// define array for making cards Numbers
		String[] suits = { "C", "D", "S", "H" };
		String[] cardValues = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
		Random randomObject = new Random();

		// preparing object for making and store the cardValues
		int numberOfCards = 52;
		Vector<String> deck = new Vector<String>(numberOfCards); 
		// System.out.println(deck.capacity());
		

		

		// Load the deck
		for (String suit : suits) 
		{
			for (String cardValue : cardValues)
			{
				deck.add(cardValue + suit); // concatination // making number combination (concatinate bath strings number)
			}
		}

		// randomly select the card from deck and add to the suffleDeck
		LinkedList<String> shuffledDeck = new LinkedList<String>();
		int selection = 0;
		for (int i = 0; i < numberOfCards; i++) 
		{
			selection = randomObject.nextInt(deck.size()); //from here genrate the random number
			shuffledDeck.add(deck.get(selection));       //adding deckCards to the LinkedList Object (shuffledDeck)
		}

		// System.out.println("now deck is empty :"+deck.size());

		
		// now we crate StringBuffer object to hold four hands to hold numbercard
		StringBuffer[] hands = { new StringBuffer("Hand 1 :"), new StringBuffer("Hand 2 :"),
				new StringBuffer("Hand 3 :"), new StringBuffer("Hand 4 :"), };

		
		
		// dump all the suffledDeck into listIterator object
		ListIterator<String> cards = shuffledDeck.listIterator();

		
		// appending all cards to hands
		while (cards.hasNext())
		{
			for (StringBuffer hand : hands) {
				hand.append(' ').append((String) (cards.next()));
			}
		}
         
		// display the cards
		for (StringBuffer hand : hands) {
			System.out.println(hand.toString());
		}

	}
}
