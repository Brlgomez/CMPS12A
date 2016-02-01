/**
 * Program: Program 2: Triangle
 * Authors: Brandon Gomez (brlgomez@ucsc.edu)  Driving 90 minutes. Navigating 90 minutes.
 *
 * CMP 12A, Fall 2013
 * Programming Assignment #2
 * October 20, 2013
 *
 * This program draws an equalateral triangle based on the number you input.
 * The number inputed will be the length of the side.
 * Then the program will display a bigger version of the triangle.
 *
 * Input:
 * The length of the sides of the triangle. Must be greater than 2.
 *
 * Output:
 * The equalateral triangle and the bigger version of it.
 *
 * Bugs and limitations:
 * A limitation is that the program will not display the bigger triangle properly.
 */

import java.util.*;
public class triangle {
	public static void main(String[] args){
		// Scanner
		Scanner scan = new Scanner(System.in);
		// Instructions
		System.out.println("Please insert the length of the triangle sides");
		// Input
		int side = scan.nextInt();
		// Method to print out both triangles
		tri(side);
	}
	/*
	 * Below is the entire method to print out the entire output.
	 * Takes in a int and returns nothing.
	 */
	public static void tri(int side){
		// Size of the super triangle
		int num = 4;
		// test to make sure the input is greater than 2
		while(side<=2){
			System.out.println("please insert correct numbers");
			Scanner scan = new Scanner(System.in);
			System.out.println("Please insert the length of the triangle sides");
			side = scan.nextInt();
		}
		/*
		 * Draws the first triangle:
		 * Decrements the length int so there is one less "*" on each line after the second loop is done.
		 * If length gets to 0 then it will make a " " so that it will make an even triangle.
		 */
		if(side > 0){
			int length = side;
			for(int i = 0; i < side; i++){
				for(int j = 0; j <= side-i; j++){
					if (length <= 0){
						System.out.println();
						length = side-i;
						for(int k = 0; k <= i; k++){
							System.out.print(" ");
						}
					}
					else{
						System.out.print("* ");
					}	
					length--;
				}
			}	
		}
		/*
		 * A failed attempt to make the super triangle with the same smaller triangle
		 */
		System.out.println();
		System.out.println("This is how it would look like if the triangle is bigger");
		if(side > 0){
			System.out.println();
			int length = side*num;
			for(int i = 0; i < side*num; i++){
				for(int j = 1; j <= (side*num)-i+1; j++){
					if (length <= 0){
						System.out.println();
						length = (side*num)-i;
						for(int k = 0; k <= i; k++){
							System.out.print(" ");	
						}
					}
					if(((i%2 != 0 && j%2 != 0) || (j == (side*num)-i) || (i == (side*num)-1)) && i != 0 && j != side*4) {
						System.out.print("  ");
						// for testing
						//System.out.print(i+" "+j);

					}
					else{
						System.out.print("* ");
						// for testing
						//System.out.print(i+" "+j);
					}
					length--;
				}
			}	
		}
	}
}
