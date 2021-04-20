package com.velociter.training.mukesh.chapter14;

import java.util.Vector;
import java.util.LinkedList;
import java.util.Random;
import java.util.ListIterator;

public class PlyingCards 
{
	  public static void main(String[] args) 
	  {
	    String[] shape = {"C", "D", "H", "S"};     //club, Diamond, Heart , Spade
	    
	    String[] NumbersInCard = { "1","2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
	    
	    int cardsInDeck = 52;
	    
	    Vector<String> deck = new Vector<String>(cardsInDeck);
	    LinkedList<String> shuffledDeck = new LinkedList<String>();
	    Random chooser = new Random();            

	   
	    //add all card in deck
	    for(String cardShape : shape) 
		{
		      for(String cardValue : NumbersInCard) 
		      {
		        deck.add(cardValue+cardShape);
		      }
		  }
	     System.out.println(deck);            //print all cards in vector
	    
	     // Select cards at random from the deck 
	    
	    int select = 0;
	    
	    for(int i = 0 ; i<cardsInDeck ; i++) 
	    {
	      select = chooser.nextInt(deck.size());
	      shuffledDeck.add(deck.remove(select));
	    }
	    
	    
    //  shuffled deck into four hands
    StringBuffer[] fourHands = { new StringBuffer("Hand 1:"), new StringBuffer("Hand 2:"),
                                 new StringBuffer("Hand 3:"), new StringBuffer("Hand 4:") };
   
    ListIterator cards = shuffledDeck.listIterator();
   
	    while(cards.hasNext()) 
	    { 
	      for(StringBuffer value : fourHands) 
	      {
	    	  value.append(' ').append((String)(cards.next()));
	      }
	    }

		    // Display the hands
		    for(StringBuffer hand : fourHands) 
		    {
		      System.out.println(hand.toString());
		    }
  }
}
