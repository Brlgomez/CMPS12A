import java.util.*;
public class Hand {
	Scanner scan = new Scanner(System.in);
	
	/*
	 * will make an array based on your hand
	 */
	
	public static void yourHand(int card, int where){		
		for(int i = where; i < BlackJack.handArray.length; i++){
			if(i == where){
				BlackJack.handArray[i] = card;
			}
		}
	}
	
	/*
	 * Will add the values of the array to determine the value of your hand.
	 * If it is above 21 and your hand has an Ace, it will convert that Ace to 
	 * a 1.
	 */
	
	public static void valueOfHand(int[] handArray){
		for(int i = 0; i < handArray.length; i++){
			//System.out.print(handArray[i] + " ");
			BlackJack.value = BlackJack.value + handArray[i];
		}
		if(BlackJack.value > 21){
			for(int i = 0; i < handArray.length; i++){
				if(handArray[i] == 11){
					handArray[i] = 1;
					BlackJack.value = BlackJack.value - 10;
				}
			}
		}
		checkHand(BlackJack.value);
	}
	
	/*
	 * Will print out messages corresponding to the value of the 
	 * users hand.
	 */
	
	public static void checkHand(int hand){
		if(hand < 21){
			System.out.println("Value of hand is " + hand);
			if(BlackJack.where > 4){
				System.out.println("Your hand is full");
				System.out.println("Enter [n]ew hand, [q]uit");
			}
			else
				System.out.println("Enter [n]ew hand, [h]it, or [q]uit");
		}
		if(hand == 21){
			BlackJack.numOf21++;
			System.out.println("Value of hand is " + hand);
			System.out.println("BLACKJACK");
			if(BlackJack.where > 4){
				System.out.println("Your hand is full");
				System.out.println("Enter [n]ew hand, [q]uit");
			}
			else
				System.out.println("Enter [n]ew hand, [q]uit");
		}
		if(hand > 21){
			System.out.println("Value of hand is " + hand);
			System.out.println("BUSTED");
			if(BlackJack.where > 4){
				System.out.println("Your hand is full");
				System.out.println("Enter [n]ew hand, [q]uit");
			}
			else
				System.out.println("Enter [n]ew hand, [q]uit");
		}
	}
}
