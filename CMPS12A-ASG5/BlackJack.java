import java.util.*;

/**
 *  Play Solitaire BlackJack
 *  Simple test for Deck class
 *
 *  Written by: Alex Pang
 *  Date: Feb 21, 2011
 *
 *  Edited by Tom Austin (Replaced tio package with Scanner)
 *  Edited By Brandon Gomez (brlgomez@ucsc.edu) 
 */
class BlackJack {
	// variable to know where to insert a card in the handArray
	public static int where = 0;
	// creates an array that has the players card
	// it cannot go over 5 cards
	static int[] handArray = new int[5];
	// value of the players hand
	static int value = 0;
	// boolean of the game
	// if false the game will end
	static boolean playing = true;
	static int numOf21 = 0;

	/*
	 *  The entire BlackJAck game is inside the main
	 *  Creates a new deck and the player decides if
	 *  they want it shuffled.
	 *  The playing while loop is inside and if it is false
	 *  the game will end.
	 *  If the game ends the program will print how many times the user 
	 *  got Blackjack.
	 */
	
	public static void main (String[] arg) {
		Deck.instructions();
		Deck  d = new Deck();
		Scanner scan = new Scanner(System.in);
		char  c;
		
		// prints out all 52 cards for testing purposes
		//d.print();
		
		// player decides if they want the cards shuffled
		while(true) {
			System.out.print("Shuffle deck y/n: ");
			c = scan.next().charAt(0);
			if (c == 'y') {
				d.shuffle();
				//d.print();
			}
			else if (c == 'n') {
				break;
			}
		}
		
		// Immediately deal two cards
		d.dealTwo();
		// Prints out the value of the cards
		Hand.valueOfHand(BlackJack.handArray);
		
		// if the user still has cards or did not quit
		// will either deal a new card
		// or have two cards with a reseted value
		while(playing == true){
			char next = scan.next().charAt(0);
			if(next == 'n' || next == 'N'){
				BlackJack.value = 0;
				BlackJack.where = 0;
				for(int i = 0; i < BlackJack.handArray.length; i++){
					BlackJack.handArray[i] = 0;
				}
				d.dealTwo();
				Hand.valueOfHand(BlackJack.handArray);
			}
			if(next == 'h' || next == 'H'){
				d.dealOne();
				BlackJack.value = 0;
				Hand.valueOfHand(BlackJack.handArray);
			}
			if(next == 'q' || next == 'Q'){
				playing = false;
			}
		}
		// prints out how many Blackjacks the user got
		System.out.println("You got "+ numOf21 + " Blackjack(s)!");
	}
}

