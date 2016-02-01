
/**
 * Program: Distance (Program 1)
 * Authors: Brandon Gomez (brlgomez@ucsc.edu) Driving and writing for 50 min.
 *
 * CMPS 12A, Fall 2013
 * Programming Assignment #1
 * October 2, 2013
 *
 * This program calculates the distance of two points using the Euclidean and Manhattan formula
 * using points from the user.
 *
 * Input:
 * Four numbers that can be decimals. These will be the two points. ex: (x,y) (x,y).
 *
 * Output:
 * Two numbers that will be the distance between the two points.
 *
 * Bugs and limitations:
 * Success rate 100 percent.
 */

import java.util.*;
import java.math.*;
public class Distance {
	public static void main (String[] args) {
		Scanner scan = new Scanner (System.in);
		System.out.println("Euclidean and Manhattan Distance");
		
		
		/* The two distances */
		double euclidean, manhattan;
		
		/* The two points (x1,y1) and (x2,y2) */
		System.out.println("Please insert the coordinates for the first point");
		double x1 = scan.nextDouble();
		double y1 = scan.nextDouble();
		System.out.println("Please inset the coordinates for the second point");
		double x2 = scan.nextDouble();
		double y2 = scan.nextDouble();
		
		/* Finds the Euclidean distance of the two points */
		euclidean = Math.sqrt(((x1-x2)*(x1-x2)) + ((y1-y2)*(y1-y2)));
		/* Finds the Manhattan Distance of the two points */
		manhattan = Math.abs(x1-x2) + Math.abs(y1-y2);
		/* These prints will limit the number to the hundreths */
		System.out.printf("The Euclidean distance is " + "%.2f%n", euclidean);
		System.out.println();
		System.out.printf("The Manhattan distance is " + "%.2f%n", manhattan);

	}
}
