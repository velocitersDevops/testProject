package com.velociter.training.aalam.collectionUseFullClasses;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Blackjack 
{

	public static void main(String[] args)
	{
		
		 String[] pass =new String[1];
		
		System.out.println(" Welcome to Blackjack!");
		System.out.println("=======================");
		//playingDeck will be the deck the dealer holds
		Deck playingDeck = new Deck();
		playingDeck.createFullDeck();
		playingDeck.shuffle();
		
		//playerCards will be the cards the player has in their hand
		Deck playerCards = new Deck();
		Deck dealerCards = new Deck();
		
		//playerMoney holds players cash - we will be lazy and use doubles instead of bigdecimals
		double playerMoney = 100.0;
		
		//Scanner for user input
		Scanner scannerObject = new Scanner(System.in);
		
		//Play the game while the player has money
		//Game loop
   while(playerMoney>0)
   {
	//Take Bet
	System.out.println("You have $" + playerMoney + ", how much would you like to bet?");
	double playerBetAmount =0.0; 
     //bet amount validation
	try
    {
		playerBetAmount = scannerObject.nextDouble();
    	 if(playerBetAmount < 0.0)
    	 {
    		 System.err.println("we can't allow you to play the game ! due to break Blackjack game rules");
    		 //recursion 
    		  main(pass);
    		 //System.exit(0);
    	 }
    }
     catch(InputMismatchException e )
     {
    	 System.err.println("You Not Entered Valid Amount !");
    	 main(pass);
    	// System.exit(0);
     }
	
	boolean endRound = false;
	if(playerBetAmount > playerMoney )
	{
		//Break if they bet too much
		System.out.println("You cannot bet more than you have.");
		break;
	}
	
	System.out.println("Dealing...");
	//Player gets two cards
	playerCards.draw(playingDeck);
	playerCards.draw(playingDeck);
	
	//Dealer gets two cards
	dealerCards.draw(playingDeck);
	dealerCards.draw(playingDeck);
			
			//While loop for drawing new cards
			while(true)
			{
				//Display player cards
				System.out.println("Your Hand:" + playerCards.toString());
				
				//Display Value
				System.out.println("Your hand is currently valued at: " + playerCards.cardsValue());
				
				//Display dealer cards
				System.out.println("Dealer Hand: " + dealerCards.getCard(0).toString() + " and [hidden]");
				
				//What do they want to do
				System.out.println("Would you like to (1)Hit or (2)Stand");
				int response = 0; 	
				//validation for selectedOperation
				try 
				{
					response = scannerObject.nextInt();
					if( (response <1) || (response >2))
					{
						System.err.println("Sorry ! You have to select from given option only ! ");
						 main(pass);
						//System.exit(0);
					}
				}catch(InputMismatchException e)
				{
					System.err.println("Sorry You Not Entered Valid Option !Please Try Again");
					 main(pass);
					// System.exit(0);
				}
				
				//They hit
				if(response == 1)
				{
					playerCards.draw(playingDeck);
					System.out.println("You draw a:" + playerCards.getCard(playerCards.deckSize()-1).toString());
					//Bust if they go over 21
					if(playerCards.cardsValue() > 21)
					{
						System.out.println("Bust. Currently valued at: " + playerCards.cardsValue());
						playerMoney -= playerBetAmount;
						endRound = true;
						break;
					}
				}
				
				//Stand
				if(response == 2)
				{
					break;
				}
				
			}
				
			//Reveal Dealer Cards
			System.out.println("Dealer Cards:" + dealerCards.toString());
			//See if dealer has more points than player
			if((dealerCards.cardsValue() > playerCards.cardsValue())&&endRound == false)
			{
				System.out.println("Dealer beats you By " + dealerCards.cardsValue() + " to " + playerCards.cardsValue());
				playerMoney -= playerBetAmount;
				endRound = true;
			}
			//Dealer hits at 16 stands at 17
			while((dealerCards.cardsValue() < 17) && endRound == false)
			{
				dealerCards.draw(playingDeck);
				System.out.println("Dealer draws: " + dealerCards.getCard(dealerCards.deckSize()-1).toString());
			}
			//Display value of dealer
			System.out.println("Dealers hand value: " + dealerCards.cardsValue());
			//Determine if dealer busted
			if((dealerCards.cardsValue()>21)&& endRound == false)
			{
				System.out.println("Dealer Busts. You win!");
				playerMoney += playerBetAmount;
				endRound = true;
			}
			//Determine if push
			if((dealerCards.cardsValue() == playerCards.cardsValue()) && endRound == false)
			{
				System.out.println("Push.");
				endRound = true;
			}
			// if player wins
			if((playerCards.cardsValue() > dealerCards.cardsValue()) && endRound == false)
			{
				System.out.println("You win the hand.");
				playerMoney += playerBetAmount;
				endRound = true;
			}
			else if(endRound == false) //dealer wins
			{
				System.out.println("Dealer wins.");
				playerMoney -= playerBetAmount;
			}

			//End of hand - put cards back in deck
			playerCards.moveAllToDeck(playingDeck);
			dealerCards.moveAllToDeck(playingDeck);
			System.out.println("End of Hand.");
			
		}
		//Game is over
		System.out.println("Game over! You lost all your money. :(");
		
		//Close Scanner
		scannerObject.close();
		
	}
}
