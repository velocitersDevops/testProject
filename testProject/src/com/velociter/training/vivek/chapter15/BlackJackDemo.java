package com.velociter.training.vivek.chapter15;

import java.util.Scanner;

public class BlackJackDemo
{
  public static void main(String args[])
  {
	  //welcome message
	  System.out.println("Welcome to Blackjack");
	  
	  //create our playing deck
	  
	  Deck playingDeck= new Deck();
	  playingDeck.createFullDeck();
	  playingDeck.shuffle();
	  
	  //create deck for player
	  
	  Deck playerCards= new Deck();
	  
	  Deck dealerCards  = new Deck();
	  
	  double playerMoney=100.00;
	  
	  Scanner userInput = new Scanner(System.in);
	  
	  //game loop
	  
	  while(playerMoney>0)
	  {
		  //play on
		  //take the player bet
		  
		  System.out.println("You have :"+playerMoney+","+"how much would like to bet");
		  
		  double playerBet =userInput.nextDouble();
		   
		  if(playerBet>playerMoney)
		  {
			  System.out.println("you can not bet more than you have .Please leave");
			  break;
		  }
		  
		  boolean endRound=false;
		  
		  //start dealing
		  //player gets two cards
		  playerCards.draw(playingDeck);
		  playerCards.draw(playingDeck);
		  
		  //dealer gets two cards
		  
		  dealerCards.draw(playingDeck);
		  dealerCards.draw(playingDeck);
		  
		  while(true)
		  {
			  System.out.println("Your Hand");
			  System.out.println(playerCards.toString());
			  System.out.println("your hand is values at :"+playerCards.cardsValue());
			  
			     //display dealer
			     System.out.println("Dealer Hand :"+dealerCards.getCard(0).toString()+"and [hidden]");
			     
			     //what does the player want to do 
			     System.out.println("would you like to hit (1) or (2) stands");
			     int response = userInput.nextInt();
			     
			     //They hit
			     
			     if(response==1)
			     {
			    	 playerCards.draw(playingDeck);
			    	 System.out.println("You draw a :"+playerCards.getCard(playerCards.deckSize()-1).toString());
			    	 //bust if >21
			    	 
			    	 if(playerCards.cardsValue()>21)
			    	 {
			    		 System.out.println("Bust currently values at :"+playerCards.cardsValue());
			    		 playerMoney=playerMoney-playerBet;
			    		 endRound=true;
			    	 }
			     }
			     
			     if(response==2)
			     {
			    	 break;
			     }
			     
		  }
		  
		  //Reveal Dealer Cards
		  
		  System.out.println("Dealer Cards :"+dealerCards.toString());
		  
		  //see if dealer has more points than player
		  
		  if((dealerCards.cardsValue()>playerCards.cardsValue())&&endRound==false)
		  {
			  System.out.println("Dealer Beats you");
			  playerMoney=playerMoney-playerBet;
			  endRound=true;
		  }
		  
		  if((dealerCards.cardsValue()<17)&&endRound==false)
		  {
			  dealerCards.draw(playingDeck);
			  System.out.println("Dealer Draws :"+dealerCards.getCard(dealerCards.deckSize()-1).toString());
			  endRound=true;
		  }
		  //display total value for dealer
		  
		  System.out.println("Dealer hand is values at :"+dealerCards.cardsValue());
		  
		  //deatermine if dealer is busted
		  
		  if((dealerCards.cardsValue()>21)&&endRound==false)
		  {
			  System.out.println("Dealer busts ! you win");
			  playerMoney=playerMoney+playerBet;
			  endRound=true;
					  
		  }
		  //Determine if push
		  
		  if((playerCards.cardsValue()==dealerCards.cardsValue()) && endRound==false)
		  {
			  System.out.println("push");
			  endRound=true;
		  }
		  
		  if((playerCards.cardsValue()>dealerCards.cardsValue())&& endRound==false)
		  {
			  System.out.println("you win the hand");
			  playerMoney=playerMoney+playerBet;
			  endRound=true;
		  }
		  
		  else if(endRound==false)
		  { 
			  System.out.println("You lose the hand");
			  playerMoney=playerMoney-playerBet;
			  endRound=true;
		  }
		  
		  playerCards.moveAllToDeck(playingDeck);
		  dealerCards.moveAllToDeck(playingDeck);
		  System.out.println("END OF HAND");
		  
	  }
	  
	  System.out.println(playingDeck);
	  System.out.println("GAME OVER YOU ARE OUT OF MONEY :");
  }
}
