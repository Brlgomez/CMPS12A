
/**
 * Program: Sums
 * Authors: Brandon Gomez (brlgomez@ucsc.edu)  Driving 90 minutes. Navigating 90 minutes.
 *
 * CMP 12L, Fall 2013
 * Lab Assignment #4
 * October 23, 2013
 *
 * This program does the summation problem of 1 + .... + 1/n.
 * Then with that result it does another summation problem of 1 +...+ 2*result.
 * The program then prints out the result.
 *
 * Input:
 * Any positive number to be calculated and 1 or 2 to play again.
 *
 * Output:
 * The instructions, the result and the option to play again.
 *
 * Bugs and limitations:
 * The program will not take in anything other than an int.
 */

import java.util.*;
import java.math.*;
public class sums {
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		// instructions
		System.out.println("Welcome to the sum of sums!");
		System.out.println("Please insert a poistive number!");
		// user input to be calculated
		int n = scan.nextInt();	
		// to play again
		int yesOrNo;
		// to know if user wants to play 
		boolean playing = true;
		// if playing == true game continues else game ends
		while(playing == true){
			// test to make sure the input is positive
			while(n<0){
				System.out.println("Please insert a positive number!");
				n = scan.nextInt();
			}
			double sum = (summation(n));
			// for testing purposes
			// System.out.println(sum);
			// rounds sum
			int sumRounded = (int) (Math.round(sum));
			// for testing purposes
			// System.out.println(sumRounded);
			double sums = (sumOfSums(sumRounded));
			// for testing purposes
			// System.out.println(sums);
			// rounds sums
			int sumsRounded = (int) (Math.round(sums));
			// final number
			System.out.println(sumsRounded);
			
			System.out.println("Play again? 1:yes  /  2:no");
			yesOrNo = scan.nextInt();
			// makes sure the input is 1 or 2
			while(yesOrNo != 1 &&yesOrNo != 2){
				System.out.println("Please insert the correct values!");
				yesOrNo = scan.nextInt();
			}
			// if 2 game ends
			if (yesOrNo == 2){
				playing = false;
			}
			// if 1 play again
			else{
				System.out.println("Welcome to the sum of sums!");
				System.out.println("Please insert a poistive number!");
				n=scan.nextInt();
			}
		}
	}
	/*
	 * the summation problem of 1 + .... + 1/num.
	 */
	public static double summation (int num){
		if(num == 0){
			return 0;
		}
		else{
			double s = (summation(num-1));
			return (1.0/num) + s;
		}
	}
	/*
	 * summation problem of 1 +...+ 2*num
	 * returns 1 if num == 1 instead of 2
	 */
	public static double sumOfSums (double num){
		if(num == 1){
			return 1;
		}
		else{
			double s = (sumOfSums(num-1));
			return (2*num) + s;
		}	
	}
}
