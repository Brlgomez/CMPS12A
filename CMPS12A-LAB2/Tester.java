
/**
 * Program: Tester
 * Authors: Brandon Gomez (brlgomez@ucsc.edu)  Driving 40 minutes. Navigating 40 minutes.
 *          David Aguirre (dgaguirr@ucsc.edu)  Driving 40 minutes. Navigating 40 minutes.
 *
 * CMP 12L, Fall 2013
 * Lab #2
 * October 9, 2013
 *
 * This Program displays addition, subtraction, multiplication and division questions
 * based on the input of the user. The program then show the number of correct
 * answers out of total questions. The user can play as many times as he/she wants.
 *
 * Input:
 * 1 for 1st grade
 * 2 for 2nd grade
 * 3 to quit
 * When inside the a selection the user can input the answer to the question.
 *
 * Output:
 * Instructions, questions corresponding to the selection and results.
 *
 * Bugs and limitations:
 * The program should always work if the user follows the instructions.
 * Also the user should not insert an incredibly large number for the answer.
 */

import java.util.*;

public class Tester {
	public static void main(String[] args){
		//determines what option the user wants. 
		//1==1st grade, 2==2nd grade, 3==quit, else==repeats instructions.
		int selection;
		//number of correct answers when doing a test. Resets back when given results.
		int correct = 0;
		//boolean to know if the player wants to keep on playing. program shuts down if false.
		boolean playing = true;
		Scanner scan = new Scanner(System.in);
		//You can name this anything you want.
		//You can play with the values. But, when you submit, make sure the value is 5.
		final int numberOfQuestions = 5;
		//takes numberOfQuestions from above and return an integer value.
		//You can store this into an integer variable.
		SuperRandom randomNumberGenerator = new SuperRandom();
		
		/*The main program is inside the while loop so if the player wants to quit, it will
		 * quit the entire program. */
		while (playing == true){
			/*Instructions*/
			System.out.println("Welcome to the math tester!");
			System.out.println("Take your math skills to the next level");
			System.out.println("Choose your grade level:");
			System.out.println("1. First Grade");
			System.out.println("2. Second Grade");
			System.out.println("3. Quit tester");
			System.out.println("Your selection is:");
			/*Input*/
			selection = scan.nextInt();
			
			/*If the instructions is 1 then the program will go to 1st grade section*/
			if(selection == 1){
				//increments to the numberOfQuestions so it can print the right number of questions inside the while
				int questNum = 0;
				while(questNum < numberOfQuestions){
					//random numbers put into a simple ints num1 and num2 for easy access.
					int num1 = randomNumberGenerator.getNextRandom(numberOfQuestions);
					int num2 = randomNumberGenerator.getNextRandom(numberOfQuestions);
					/*Determines if the question will positive or a negative question
					 * This is a positive question*/

					/*prints question and determines if you got it right*/
					System.out.println("What is ");
					if((questNum % 2) == 0){
						/*If num2 is a negative it will correct the sign for the question*/
						if (num2 < 0){
							System.out.println(num1 + "" + num2);
						}
						else{
							System.out.println(num1 +  "+" + num2 + "?");
						}
						/*user input for answer*/
						int answer = scan.nextInt();
						/*determines the correct answer and adds to correct*/
						if(answer == (num1 + num2)){
							correct++;
						}
					}

					/*This is a negative question*/
					else{
						/*prints question and determines if you got it right*/
						/*If num2 is a negative it will correct the sign for the question*/
						if (num2 < 0){
							System.out.println (num1 + "+" + (-1*num2));
						}
						else{
							System.out.println(num1 +  "-" + num2 + "?");
						}
						int answer = scan.nextInt();
						/*determines the correct answer and adds to correct*/
						if(answer == (num1 - num2)){
							correct++;
						}
					}
					questNum++;
				}
				/*Displays number of correct answers and asks if you want top play again*/
				System.out.println("You got " + correct + "/" + numberOfQuestions + " correct!");
				correct = 0;
				System.out.println("Would you like to play again?");
				System.out.println("1. Yes");
				System.out.println("2. No");
				int again = scan.nextInt();
				if(again == 1){
				}
				if(again == 2){
					System.out.println("GoodBye!");
					playing = false;
				}    
			}

			/*If the instructions is 2 then the program will display 2nd grade questions*/
			if(selection == 2){
				//increments to the numberOfQuestions so it can print the right number of questions inside the while
				int questNum = 0;
				while(questNum < numberOfQuestions){
					//random numbers put into a simple ints num1 and num2 for easy access.
					int num1 = randomNumberGenerator.getNextRandom(numberOfQuestions);
					int num2 = randomNumberGenerator.getNextRandom(numberOfQuestions);
					/*Determines if the question will be multiplication or division
					 * This is a multiplication question*/
					if((questNum % 2) == 0){
						/*prints question and determines if you got it right*/
						System.out.println("What is ");
						System.out.println(num1 +  " * " + num2 + "?");
						int answer = scan.nextInt();
						/*determines the correct answer and adds to correct*/
						if(answer == (num1 * num2)){
							correct++;
						}
					}
					/*This is a division question*/
					else{
						/*prints question and determines if you got it right*/
						System.out.println("What is ");
						System.out.println(num1 +  " / " + num2 + "?");
						int answer = scan.nextInt();
						/*determines the correct answer and adds to correct*/
						if(answer == (num1 / num2)){
							correct++;
						}
					}
					questNum++;
				}
				/*Displays number of correct answers and asks if you want top play again*/
				System.out.println("You got " + correct + "/" + numberOfQuestions + " correct");
				correct = 0; 
				System.out.println("Would you like to play again?");
				System.out.println("1. Yes");
				System.out.println("2. No");
				//input
				int again = scan.nextInt();
				//replays game
				if(again == 1){
				}
				//ends game
				if(again == 2){
					System.out.println("GoodBye!");
					playing = false;
				} 
			}
			
			/*If the input is 3 then the player quits the program*/
			if(selection == 3){
				System.out.println("GoodBye!");
				playing = false;
			}
		} 
	}
}
