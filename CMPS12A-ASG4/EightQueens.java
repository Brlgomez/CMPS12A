/**
 * Program: EightQueens
 * Authors: Brandon Gomez (brlgomez@ucsc.edu)  Driving 3 hours. Navigating 3 hours.
 *
 * CMP 12A/L, Fall 2013
 * Programming Assignment #4
 * November 16, 2013
 *
 * The user can interactively place 8 queens on the chessboard.
 * The user wins when all 8 of the queens can not capture any other queens.
 *
 * Input:
 * The positions of the queens. 
 * 
 * Output:
 * The chessboard and the queens the user inputed.
 * Declares if moves are acceptable.
 * Tells the user if they win.
 *
 * Bugs and limitations:
 * None
 */
import java.util.*;
public class EightQueens {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		// sets the size of the chessBoard
		String chessBoard[][] = new String[8][8];
		// the player is automatically playing
		boolean playing = true;
		// counts how many queens are on the screen
		int count = 0;
		// prints a blank chessBoard
		printBlank(chessBoard);
		// if the player has not placed all 8 queens
		while(playing == true){
			System.out.println("please insert a letter for the column of your choice");
			// gets the first letter of the user input
			char column = scan.nextLine().charAt(0);
			// translates the letter into a number for easy array access
			int col = translate(column);
			// if the letter is not on the board it will ask the user to input again
			while(col == 0){
				System.out.println("please insert a CORRECT letter for the column of your choice");
				// gets the first letter of the user input
				column = scan.nextLine().charAt(0);
				// translates the letter into a number for easy array access
				col = translate(column);
			}
			System.out.println("please insert a integer for the row of your choice");
			int row = scan.nextInt();
			// if the input is not on the board it will ask the user to input again
			while(row <= 0 || row >= 9){
				System.out.println("please insert a CORRECT integer for the row of your choice");
				row = scan.nextInt();
			}
			System.out.println(column + "" + row);
			// determines if the position is acceptable
			if(acceptable(chessBoard, col, row, column) == true){
				// if it is, updates the board
				update(chessBoard, col, row);
				count++;
				if(count >= 8){
					System.out.println("Congrats you beat the 8-heart challenge!");
					playing = false;
				}
			}
			scan.nextLine();
		}
	}
	
	/*
	 * Only takes in the chessBoard Array which are currently not initialized.
	 * Prints the boarders and initializes the 2D Arrays to " ".
	 */
	
	public static void printBlank(String[][] chessBoard){
		System.out.println(" a b c d e f g h ");
		for(int i = 0; i < chessBoard.length; i++){
			System.out.print(8-i);
			for(int j = 0; j < chessBoard[i].length; j++){
				chessBoard[8-i-1][j] = " ";
				System.out.print(chessBoard[8-i-1][j] + " ");
			}
			System.out.println(8-i);
		}
		System.out.println(" a b c d e f g h ");
	}
	
	/*
	 * sets the user inputed col and row into the chessBoard
	 * it will then print the board similarly to the printBlank method
	 * int col - inputed column
	 * int row - inputed row
	 * String[][] chessBoard - current 2D array
	 */
	
	public static void update(String[][] chessBoard, int col, int row){
		chessBoard[row-1][col-1] = "Q";
		System.out.println(" a b c d e f g h ");
		for(int i = 0; i < chessBoard.length; i++){
			System.out.print(8-i);
			for(int j = 0; j < chessBoard[8-i-1].length; j++){
				System.out.print(chessBoard[8-i-1][j] + " ");
			}
			System.out.println(8-i);
		}
		System.out.println(" a b c d e f g h ");
	}
	
	/*
	 * the formulas to determine if any queen can capture the inputed position
	 */
	
	public static boolean acceptable(String[][] chessBoard, int col, int row, char column){
		for(int i = 0; i < chessBoard.length; i++){
			for(int j = 0; j < chessBoard[8-i-1].length; j++){
				// goes through the whole array.
				// if it sees a Q it will return a false
				// if the input is left, right, up, or down of the Q
				if(chessBoard[8-i-1][j] == "Q"){
					for(int k = 0; k < chessBoard.length; k++){
						// left and right
						if(row-1 == 8-i-1){
							System.out.println("Not an acceptable spot at " + column + "" + row + ", try again.");
							return false;
						}
						// up and down
						else if(col-1 == j){
							System.out.println("Not an acceptable spot at " + column + "" + row + ", try again.");
							return false;
						}
					}
				}	
				/* 
				 * down left 
				 * goes through the array agian but only until the input
				 * if it sees a Q it will return a false
				 * ex:
				 *   a b c d e f g h 
				 *	8                8
				 *	7                7
				 *	6                6
				 *  5                5
				 *  4      Q         4
				 *	3    X           3
				 *	2  X             2
				 *	1X               1
 				 *	 a b c d e f g h 
				 */
				for(int a = 0; a < chessBoard.length-row-1; a++){
					for(int b = 0; b < chessBoard[a].length-col-1; b++){
						if(a == b){
							if(chessBoard[row-1+a][col-1+b] == "Q"){
								System.out.println("Not an acceptable spot at " + column + "" + row + ", try again.");
								return false;
							}
						}
					}
				}
				/* 
				 * up right 
				 * goes through the array again but only until the input
				 * if it sees a Q it will return a false
				 * ex:
				 *   a b c d e f g h 
				 *	8              X 8
				 *	7            X   7
				 *	6          X     6
				 *  5        X       5
				 *  4      Q         4
				 *	3                3
				 *	2                2
				 *	1                1
 				 *	 a b c d e f g h 
				 */
				for(int a = row-1; a > 0; a--){
					for(int b = col-1; b > 0; b--){
						if(a == b){
							if(chessBoard[row-1-a][col-1-b] == "Q"){
								System.out.println("Not an acceptable spot at " + column + "" + row + ", try again.");
								return false;
							}
						}
					}
				}
				/* 
				 * up left
				 * goes through the array again but only until the input
				 * if it sees a Q it will return a false
				 * ex:
				 *   a b c d e f g h 
				 *	8                8
				 *	7X               7
				 *	6  X             6
				 *  5    X           5
				 *  4      Q         4
				 *	3                3
				 *	2                2
				 *	1                1
 				 *	 a b c d e f g h 
				 */
				for(int a = row-1; a > 0; a--){
					for(int b = 0; b < chessBoard[a].length-col-1; b++){
						if(a == b){
							if(chessBoard[row-1-a][col-1+b] == "Q"){
								System.out.println("Not an acceptable spot at " + column + "" + row + ", try again.");
								return false;
							}
						}
					}
				}
				/* 
				 * down right
				 * goes through the array agian but only until the input
				 * if it sees a Q it will return a false
				 * ex:
				 *   a b c d e f g h 
				 *	8                8
				 *	7                7
				 *	6                6
				 *  5                5
				 *  4      Q         4
				 *	3        X       3
				 *	2          X     2
				 *	1            X   1
 				 *	 a b c d e f g h 
				 */
				for(int a = 0; a < chessBoard.length-row-1; a++){
					for(int b = col-1; b > 0; b--){
						if(a == b){
							if(chessBoard[row-1+a][col-1-b] == "Q"){
								System.out.println("Not an acceptable spot at " + column + "" + row + ", try again.");
								return false;
							}
						}
					}
				}
			}
		}
		return true;
	}
	
	/*
	 * translates the inputed letter into a number for easy array access
	 */
	
	public static int translate(char column){
		if(column == 'a' || column == 'A')
			return 1;
		if(column == 'b' || column == 'B')
			return 2;
		if(column == 'c' || column == 'C')
			return 3;
		if(column == 'd' || column == 'D')
			return 4;
		if(column == 'e' || column == 'E')
			return 5;
		if(column == 'f' || column == 'F')
			return 6;
		if(column == 'g' || column == 'G')
			return 7;
		if(column == 'h' || column == 'H')
			return 8;
		else
			return 0;
	}
}
