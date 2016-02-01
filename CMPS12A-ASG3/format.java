

/**
 * Program: Format
 * Authors: Brandon Gomez (brlgomez@ucsc.edu)  Driving 4 hours. Navigating 4 hours.
 *          David Aguirre (dgaguirr@ucsc.edu)  Driving 4 hours. Navigating 4 hours.
 *
 * CMP 12A/L, Fall 2013
 * Programming Assignment #3
 * November 4, 2013
 *
 * This programs formats your sentence to be justified to the
 * left, center or right.
 *
 * Input:
 * Sentence and the width of the desired length of each line.
 *
 * Output:
 * The Formated sentence, ruler and instructions.
 *
 * Bugs and limitations:
 * 
 */
import java.util.Scanner;
public class format {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to the simple text formatter!");
		while(true){
			System.out.println("Please insert a sentence.");
			String sentence = scan.nextLine();
			// gets rid of any extra spaces
			String newSentence = sentence.replaceAll("\\s{2,}"," ") + " ";
			System.out.println("Please insert the length of the width.");
			int width = scan.nextInt();
			// keeps track of the original width.
			int addToWidth = width;
			int endOfWord = 0;
			int startOfWord = 0;
			System.out.println("Select a format: (L)eft-justified, (R)ight-justified, (C)entered, or (Q)uit");
			char selection = scan.next().charAt(0);
			/* Makes sure the user's selection is valid */
			while (selection != 'l' && selection != 'L' && selection != 'r'
					&& selection != 'R' && selection != 'c' && selection != 'C'
					&& selection != 'q' && selection != 'Q'){
				System.out.println("Please make a valid choice");
				selection = scan.next().charAt(0);
			}
			printNumbers(width);
			if (selection == 'l' || selection == 'L'){
				left(newSentence, width, addToWidth, startOfWord, endOfWord);
			}
			else if (selection == 'r' || selection == 'R'){		
				right(newSentence, width, addToWidth, startOfWord, endOfWord);
			}
			else if (selection == 'c' || selection == 'C'){
				center(newSentence, width, addToWidth, startOfWord, endOfWord);
			}
			else if (selection == 'q' || selection == 'Q'){
				System.exit(1);
			}
			playAgain(selection);
			sentence = scan.nextLine();
		}
	}
	/*
	 * Prints out the ruler based on the user width
	 */
	public static void printNumbers(int w){
		int k = 0;
		for(int j = 1; j <= w; j++){
			if(j % 10 == 0){
				k = k + 10;
			}
			System.out.print(j-k);
		}
		System.out.println();
	}
	/*
	 * Prints out the left format if the user picks it.
	 * Runs through whole text.
	 * endOfWord - keeps track of the last word and the position of it.
	 * width - user inputed for the length of each line.
	 * addToWidth - remembers the original width to add to the width for each new line.
	 * startOfWord - starts at 0 but is added once the first line is printed.
	 */
	public static void left(String newSentence, int width, int addToWidth, int startOfWord, int endOfWord){
		for(int i = 0; i < newSentence.length(); i++){
			//if the length is small than the final width. The width will become length.
			if(newSentence.length() <= width){
				width = newSentence.length()-1;
			}
			//keeps track of the last letter in each word.
			if(newSentence.charAt(i) == ' '){
				endOfWord = i;
			}
			//if each reaches the end of the width it will determine where to make a new line.
			if(newSentence.charAt(width) == ' ' && i == width || newSentence.charAt(width) != ' ' && i == width){
				System.out.println(newSentence.substring(startOfWord,endOfWord));
				startOfWord = endOfWord+1;
				width = width + addToWidth;
				if (width > newSentence.length()){
					width = newSentence.length()-1;
				}
			}
		}
	}
	/*
	 * Prints out the right format if the user picks it.
	 * Runs through whole text.
	 * endOfWord - keeps track of the last word and the position of it.
	 * width - user inputed for the length of each line.
	 * addToWidth - remembers the original width to add to the width for each new line.
	 * startOfWord - starts at 0 but is added once the first line is printed.
	 * count - how much to change the original width.
	 * lastLine - used to determine how to affect the last line.
	 */
	public static void right(String newSentence, int width, int addToWidth, int startOfWord, int endOfWord){
		// if the length is smaller than the width it will print out 
		// one line with the text to the right.
		if(newSentence.length() <= width){
			for(int l = newSentence.length(); width >= l; l++){
				System.out.print(" ");
			}
			System.out.println(newSentence);
		}
		else{
			for(int i = 0; i < newSentence.length(); i++){
				int count = -1;
				int lastLine = 0;
				// keeps track of the end of each word.
				if(newSentence.charAt(i) == ' '){
					endOfWord = i;
				}
				// determines how many spaces to put before the text.
				// if each reaches the end of the width it will determine where to make a new line.
				if(newSentence.charAt(width) != ' ' && i == width || newSentence.charAt(width) == ' ' && i == width){
					for(int a = endOfWord; a < width; a++){
						System.out.print(" ");
						count++;
					}
					System.out.println(newSentence.substring(startOfWord, endOfWord));
					startOfWord = endOfWord + 1;
					width = width + addToWidth - count;
					if(width > newSentence.length()){
						lastLine = width - newSentence.length();
						for(int b = 0; b <= lastLine; b++){
							System.out.print(" ");
						}
						width = newSentence.length()-1;
					}
				}
				// resets count;
				count = 0;
			}
		}
	}
	/*
	 * Prints out the center format if the user picks it.
	 * Runs through whole text.
	 * endOfWord - keeps track of the last word and the position of it.
	 * width - user inputed for the length of each line.
	 * addToWidth - remembers the original width to add to the width for each new line.
	 * startOfWord - starts at 0 but is added once the first line is printed.
	 * count - how much to change the original width.
	 * lastLine - used to determine how to affect the last line.
	 */
	public static void center(String newSentence, int width, int addToWidth, int startOfWord, int endOfWord){
		// if the length is smaller than the width it will print out 
		// one line with the text to the right.
		if(newSentence.length() <= width){
			for(int l = newSentence.length(); width >= l; l=l+2){
				System.out.print(" ");
			}
			System.out.println(newSentence);
		}
		else{
			for(int i = 0; i < newSentence.length(); i++){
				int count=-1;
				int lastLine=0;
				// keeps track of the end of each word.
				if(newSentence.charAt(i) == ' '){
					endOfWord = i;
				}
				// determines how many spaces to put before the text.
				// if each reaches the end of the width it will determine where to make a new line.
				if(newSentence.charAt(width) != ' ' && i == width || newSentence.charAt(width) == ' ' && i == width){
					for(int a = endOfWord; a < width; a=a+2){
						System.out.print(" ");
						count++;
					}
					System.out.println(newSentence.substring(startOfWord, endOfWord));
					startOfWord = endOfWord + 1;
					width = width + addToWidth - count;
					if(width > newSentence.length()){
						lastLine = width - newSentence.length();
						for(int b = 0; b <= lastLine; b=b+3){
							System.out.print(" ");
						}
						width = newSentence.length()-1;
					}
				}
				// resets count.
				count = 0;
			}
		}
	}
	/*
	 * asks the user if he/she wants to play again.
	 */
	public static void playAgain(char selection){
		Scanner scan = new Scanner(System.in);
		/* Following the main section of code of the program, the user is asked to restart the program or not */
		System.out.println();
		System.out.println("Would you like to format another line of text? [y/n]");
		selection = scan.next().charAt(0);
		/* Makes sure the user inputs a valid choice (yes or no) */
		while(selection != 'y' && selection != 'Y' && selection != 'n' && selection != 'N'){
			System.out.println("Please choose yes or no");
			selection = scan.next().charAt(0);
		}
		/* The program is restarted if user selects yes, stops if user selects no */ 
		if (selection == 'y' || selection == 'Y'){
		}
		else if (selection == 'n' || selection == 'N'){
			System.out.println("Goodbye! Have a wonderful day!");
			System.exit(1);
		}
	}
}
