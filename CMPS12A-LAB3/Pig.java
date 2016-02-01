/**
 * Program: Pig Latin
 * Authors: Brandon Gomez (brlgomez@ucsc.edu)  Driving 120 minutes. Navigating 120 minutes.
 *          David Aguirre (dgaguirr)  Driving 120 minutes. Navigating 120 minutes.
 *
 * CMP 12L, Fall 2013
 * Programming Lab #3
 * October 16, 2013
 *
 * This program changes your sentence into pig-latin.
 *
 * Input:
 * Any word or sentence, then yes or no if you want to play again. If yes repeat.
 *
 * Output:
 * The sentence or word in pig-latin.
 * Redo message if wrong input is inserted.
 *
 * Bugs and limitations:
 * ! . ? / and other non-letter may make the translator have unintended results
 */

import java.util.*;
public class Pig {
	public static void main(String[] args){
		// input scanner
		Scanner scan = new Scanner(System.in);
		// this boolean will determine if the program should run
		boolean playing = true; 
		// if the program does not pass this test, it will not turn the phrase into pig-latin
		boolean test = false;
		// char that will determine if the user wants to play again
		char newGame;
		// these ints will determine the start and end of a word so the program can subString the words
		int startOfWord = 0;
		int endOfWord = 0;
		// intro
		System.out.println("This application turns your words and sentences into pig latin!");
		
		/*
		 *  
		 *  The whole program is in this while statement.
		 *  If the user does not want to play again the while loop and program will end.
		 * 
		 */
		
		while(playing == true){
			// these ints will determine the start and end of a word so the program can subString the words
			// these will restart if loop runs again.
			startOfWord = 0;
			endOfWord = 0;
			// determines the number of separate words in a sentence
			int nextWord =0;
			// instructions
			System.out.println("Insert a word or sentence:");
			// user input
			String input = scan.nextLine();
			// changes the input to all lower case and add a blank for bug purposes
			String inputLower = input.toLowerCase()+ ' ';
			
			/*
			 * 
			 * This will loop will look at the users input and it will determine if it will be translated to pig-latin
			 * This is so because of out of range purposes
			 * 
			 */
			
			while(test == false){
				/*
				 * 
				 * This section determines if there is a space in the beginning or end of the sentence
				 * If there is then the program will ask to rewrite the sentence coorectly
				 * 
				 */
				while(input.charAt(0) == ' ' || input.charAt(input.length()-1) == ' '){
					System.out.println("Please begin and end a sentence or word with a letter");
					input = scan.nextLine();
					inputLower = input.toLowerCase()+ ' ';
				}
				/*
				 * 
				 * This section will determine if there is two spaces together.
				 * It will ask for a rewrite if there is so it can avoid out of range errors.
				 * If corrected it will continue with the rest of the program.
				 * 
				 */
				for(int first=0; first<input.length()-1; first++){
					if(input.charAt(first)==' '){
						if(input.charAt(first+1)==' '){
							System.out.println("Please do not have multiple spaces in a row.");
							input = scan.nextLine();
							inputLower = input.toLowerCase()+ ' ';
						}
						else{
							test = true;
						}
					}
					else{
						test = true;
					}
				}
			}

			/*
			 * 
			 * The main three rules for pig-latin are inside this for loop.
			 * The for loop keeps on going until the end of the sentence.
			 * 
			 */

			for(int i = 0; i < inputLower.length(); i++){ 
				if(inputLower.charAt(i) == ' '){
					endOfWord = i;
					nextWord++;
					// this if is for words after the first word
					// this is so because the program will only capitalize the first word
					if(nextWord>1){
						/*
						 * 
						 * the vowel rule.
						 * will add "way" to the end of each word if the first letter is a vowel.
						 * 
						 */
						if(inputLower.charAt(startOfWord) == 'a' || inputLower.charAt(startOfWord) == 'e' || inputLower.charAt(startOfWord) == 'i' || inputLower.charAt(startOfWord) == 'o'|| inputLower.charAt(startOfWord) == 'u'){
							endOfWord = i;
							System.out.print(inputLower.substring(startOfWord,endOfWord) + "way ");
							startOfWord = endOfWord + 1;

						}
						/*
						 * 
						 * the special case rule.
						 * if the first letter is a consonant and the next two are vowels
						 * it will move the first two letters to the end and add "ay"
						 * 
						 */
						else if(inputLower.charAt(startOfWord) != 'a' || inputLower.charAt(startOfWord) != 'e' || inputLower.charAt(startOfWord) != 'i' || inputLower.charAt(startOfWord) != 'o'|| inputLower.charAt(startOfWord) != 'u'){
							if((inputLower.charAt(startOfWord+1) == 'a' || inputLower.charAt(startOfWord+1) == 'e' || inputLower.charAt(startOfWord+1) == 'i' || inputLower.charAt(startOfWord+1) == 'o'|| inputLower.charAt(startOfWord+1) == 'u' )
									&&(inputLower.charAt(startOfWord+2) == 'a' || inputLower.charAt(startOfWord+2) == 'e' || inputLower.charAt(startOfWord+2) == 'i' || inputLower.charAt(startOfWord+2) == 'o'|| inputLower.charAt(startOfWord+2) == 'u')){
								endOfWord = i;
								System.out.print(inputLower.substring(startOfWord+2,endOfWord)+inputLower.charAt(startOfWord)+inputLower.charAt(startOfWord+1)+"ay ");
								startOfWord = endOfWord + 1;
							}
							/*
							 * 
							 * consonant rule.
							 * if the first letter and second letter is a consonant
							 * then it will move the first letter to the end and add "ay"
							 * 
							 */
							else{
								endOfWord = i;
								System.out.print(inputLower.substring(startOfWord+1,endOfWord)+inputLower.charAt(startOfWord)+"ay ");
								startOfWord = endOfWord + 1;
							}
						}
					}
					// this is for the first word
					// this is so because the program will only capitalize the first word
					else if(nextWord<=1){	
						/*
						 * 
						 * the vowel rule.
						 * will add "way" to the end of each word if the first letter is a vowel.
						 * upper cases first letter
						 * 
						 */
						if(inputLower.charAt(startOfWord) == 'a' || inputLower.charAt(startOfWord) == 'e' || inputLower.charAt(startOfWord) == 'i' || inputLower.charAt(startOfWord) == 'o'|| inputLower.charAt(startOfWord) == 'u'){
						endOfWord = i;
						char capLet = inputLower.charAt(0);
						String capLetter = capLet+"";
						String cap = capLetter.toUpperCase();
						System.out.print(cap+(inputLower.substring(startOfWord+1,endOfWord) + "way "));
						startOfWord = endOfWord + 1;

					}
					/*
					 * 
					 * the special case rule.
					 * if the first letter is a consonant and the next two are vowels
					 * it will move the first two letters to the end and add "ay"
					 * upper cases first letter
					 * 
					 */
					else if(inputLower.charAt(startOfWord) != 'a' || inputLower.charAt(startOfWord) != 'e' || inputLower.charAt(startOfWord) != 'i' || inputLower.charAt(startOfWord) != 'o'|| inputLower.charAt(startOfWord) != 'u'){
						if((inputLower.charAt(startOfWord+1) == 'a' || inputLower.charAt(startOfWord+1) == 'e' || inputLower.charAt(startOfWord+1) == 'i' || inputLower.charAt(startOfWord+1) == 'o'|| inputLower.charAt(startOfWord+1) == 'u' )
								&&(inputLower.charAt(startOfWord+2) == 'a' || inputLower.charAt(startOfWord+2) == 'e' || inputLower.charAt(startOfWord+2) == 'i' || inputLower.charAt(startOfWord+2) == 'o'|| inputLower.charAt(startOfWord+2) == 'u')){
							char capLet = inputLower.charAt(2);
							String capLetter = capLet+"";
							String cap = capLetter.toUpperCase();
							endOfWord = i;
							System.out.print(cap+(inputLower.substring(startOfWord+3,endOfWord)+inputLower.charAt(startOfWord)+inputLower.charAt(startOfWord+1)+"ay "));
							startOfWord = endOfWord + 1;
						}
						/*
						 * 
						 * consonant rule.
						 * if the first letter and second letter is a consonant
						 * then it will move the first letter to the end and add "ay"
						 * upper cases first letter
						 * 
						 */
						else{
							endOfWord = i;
							char capLet = inputLower.charAt(1);
							String capLetter = capLet+"";
							String cap = capLetter.toUpperCase();
							System.out.print(cap+(inputLower.substring(startOfWord+2,endOfWord)+inputLower.charAt(startOfWord)+"ay "));
							startOfWord = endOfWord + 1;
						}
					}
					}
				}
			}
			/*
			 * 
			 * This section of the program determine if the user would like the play or not
			 * if the user inserts no or No the program will end
			 * if the program sees yes or Yes then the program will start again from the top of the loop
			 * else it will ask you to insert yes or no.
			 * 
			 */
			System.out.println();
			System.out.println("Do you want to insert another word? no/yes");
			newGame = scan.nextLine().charAt(0);
			while(newGame != 'n' && newGame != 'N' && newGame != 'y' && newGame != 'Y'){
				System.out.println ("Please answer yes or no");
				newGame = scan.nextLine().charAt(0);
			}
			if(newGame == 'n' || newGame == 'N'){
				playing = false;
			}
			else{
				System.out.println("Back to main.");
				test = false;
			}
		}
	}
}