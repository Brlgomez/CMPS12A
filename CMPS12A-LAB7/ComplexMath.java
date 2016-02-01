/**
 * Program: ComplexMath
 * Authors: Brandon Gomez (judgejudy@cats)  Driving 60 minutes. Navigating 60 minutes.
 *
 * CMP 12A/L, Fall 2013
 * Lab Assignment #7
 * November 25, 2013
 *
 * This program takes in two complex numbers and adds and multiplies them.
 * It will also find the absolute value of the two complex numbers.
 *
 * Input:
 * Two complex numbers.
 *
 * Output:
 * Instructions, values of adding and multiplying the complex numbers.
 * Absolute value of the two numbers.
 *
 * Bugs and limitations:
 * Will only take in numbers.
 */

import java.util.*;
public class ComplexMath {
	public static void main(String[] args){
		//declaring variables
		double num1Real, num1Imag, num2Real, num2Imag;
		Scanner scan = new Scanner(System.in);
		
		//sets value
		System.out.println("please enter a real and imaginary component");
		num1Real = scan.nextDouble();
		num1Imag = scan.nextDouble();
	    System.out.println("please enter another real and imaginary component");
	    num2Real = scan.nextDouble();
	    num2Imag = scan.nextDouble();
	    
	    //creates complex numbers
		Complex compNum1 = new Complex(num1Real, num1Imag);
		Complex compNum2 = new Complex(num2Real, num2Imag);
		
		//methods from the complex class.
		compNum1.add(compNum2);
		compNum1.mulitply(compNum2);
		//prints absolute values.
		System.out.println("Absolute value of the first complex number: " + compNum1.absValue());
		System.out.println("Absolute value of the second complex number: " + compNum2.absValue());
	}
}
