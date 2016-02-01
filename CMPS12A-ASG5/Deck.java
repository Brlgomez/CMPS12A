/**
 *  The Deck class is a new type that represents a deck
 *  of cards.  A constructor and a
 *  shuffle method are provided to get you started.
 *
 *  You should extend this class with additional methods for managing a deck of cards.  
 *
 *  Written by:  Alex Pang
 *  Edited by:   Tom Austin
 *       (replacing tio package with java.util.Scanner and some updates to formatting.)
 *  Date: Feb 21, 2011
 */

import java.util.*;
class Deck{
	// initial card count
	public static int NUMCARDS = 52;
	// array for the cards
	public int[] deck;
	// boolean to know to print out dealed cards
	boolean dealCard = true;
	// int to know which card to deal for the deal method
	int cardNum = 0;
	// int to know which card to deal for the dealOne and dealTwo methods
	static int onCard = 0;
	// int to know whether to deal one or two cards
	int oneOrTwo = 0;
	
	/* Constructor: creates a new full deck of cards. */
	public Deck(){
		deck = new int[NUMCARDS];
		for(int i=0; i<NUMCARDS; i++) { 
			deck[i] = i;
		}
	}
	
	/* Prints instructions*/
	public static void instructions(){
		System.out.println("Welcome to single player Blackjack!");
		System.out.println("The game will end when you use all 52 cards.");
	}
	
	/* Prints out the deck of cards. */
	public void print(){
		for(int i=0; i<NUMCARDS; i++) {
			System.out.printf( "%3d", deck[i] );
		}
		System.out.println();
	}

	/* Shuffles the deck of cards. */
	public void shuffle(){
		System.out.print( "Enter your lucky number: " );
		Scanner scan = new Scanner(System.in);
		int seed = scan.nextInt();
		Random r = new Random(seed); // initialize random number generator

		for(int i=0; i<NUMCARDS; i++ ) { // shuffle deck of cards
			int j = r.nextInt(NUMCARDS);  // randomly pick a card
			int tmp = deck[j];      // swap with i-th card
			deck[j] = deck[i];
			deck[i] = tmp;
		}
	}
	
	/*
	 * deals two cards
	 * prints out the cards
	 * increments onCard to two
	 */
	
	public void dealTwo(){
		dealCard = true;
		deal(onCard, 2);
		card();
		onCard = onCard + 2;
	}
	
	/*
	 * deals one card
	 * prints the card
	 * increments onCard to one
	 */
	
	public void dealOne(){
		dealCard = true;
		deal(onCard, 1);
		card();
		onCard = onCard + 1;
	}

	/*
	 * sets cardNum and oneOrTwo
	 * to determine where to deal the cards
	 * cardNum will be the start
	 * and oneOrTwo will determine whether to deal
	 * one or two cards
	 */
	
	public void deal(int cards, int howMany){
		cardNum = cards;
		oneOrTwo = howMany;
	}
	
	/*
	 * dealOne() and dealTwo() made dealCard true so
	 * this method will work.
	 * i will be cardNum(SEE ABOVE) and i will increment one or two,
	 * depending on oneOrTwo (SEE ABOVE).
	 * It will then set dealCard back to false.
	 */
	
	public void card(){
		while(dealCard == true){
			for(int i = cardNum; i < cardNum + oneOrTwo; i++){
				print(i);
			}
			dealCard = false;
		}
	}
	
	/*
	 * If onCard is less than NUMCARDS
	 * it will convert the cards to face value
	 * 
	 * else the game will end.
	 */
	
	public void print(int onCard){
		if(onCard < NUMCARDS){
			//System.out.printf( "%3d", deck[onCard]);
		    convertCard(deck[onCard]);
		    Hand.yourHand(convertCardValue(deck[onCard]), BlackJack.where);
		    BlackJack.where++;
		}
		else{
			System.out.println("No more cards!");
			BlackJack.playing = false;
		}	
	}
	
	/*
	 * Converts cards to face value
	 */
	
	public void convertCard(int card){
		if (card >= 0 && card <=12){
			System.out.print("Club ");
			if(card == 0){
				System.out.println("Ace");
			}
			if(card >= 1 && card <= 9){
				System.out.println(card + 1);
			}
			if(card == 10){
				System.out.println("Jack");
			}
			if(card == 11){
				System.out.println("Queen");
			}
			if(card == 12){
				System.out.println("King");
			}
			
		}
		if (card >= 13 && card <= 25){
			System.out.print("Diamond ");
			if(card == 13){
				System.out.println("Ace");
			}
			if(card >= 14 && card <= 22){
				System.out.println(card + 1 - 13);
			}
			if(card == 23){
				System.out.println("Jack");
			}
			if(card == 24){
				System.out.println("Queen");
			}
			if(card == 25){
				System.out.println("King");
			}
		}
		if (card >= 26 && card <= 38){
			System.out.print("Heart ");
			if(card == 26){
				System.out.println("Ace");
			}
			if(card >= 27 && card <= 35){
				System.out.println(card + 1 - 26);
			}
			if(card == 36){
				System.out.println("Jack");
			}
			if(card == 37){
				System.out.println("Queen");
			}
			if(card == 38){
				System.out.println("King");
			}
		}
		if (card >= 39 && card <= 51){
			System.out.print("Spade ");
			if(card == 39){
				System.out.println("Ace");
			}
			if(card >= 40 && card <= 48){
				System.out.println(card + 1 - 39);
			}
			if(card == 49){
				System.out.println("Jack");
			}
			if(card == 50){
				System.out.println("Queen");
			}
			if(card == 51){
				System.out.println("King");
			}
		}
	}
	
	/*
	 * converts cards to thier value
	 */
	
	public int convertCardValue(int card){
		if (card >= 0 && card <=12){
			if(card == 0){
				return 11;
			}
			if(card >= 1 && card <= 9){
				return (card + 1);
			}
			if(card == 10 || card == 11 || card == 12){
				return 10;
			}
		}
		if (card >= 13 && card <= 25){
			if(card == 13){
				return 11;
			}
			if(card >= 14 && card <= 22){
				return (card + 1 - 13);
			}
			if(card == 23 || card == 24 || card == 25){
				return 10;
			}
		}
		if (card >= 26 && card <= 38){
			if(card == 26){
				return 11;
			}
			if(card >= 27 && card <= 35){
				return (card + 1 - 26);
			}
			if(card == 36 || card == 37 || card == 38){
				return 10;
			}
		}
		if (card >= 39 && card <= 51){
			if(card == 39){
				return 11;
			}
			if(card >= 40 && card <= 48){
				return (card + 1 - 39);
			}
			if(card == 49 || card == 50 || card == 51){
				return 10;
			}
		}
		return 0;
	}
}