/**
 * Program: Doubles
 * Authors: Brandon Gomez (brlgomez@ucsc.edu)  Driving 40 minutes. Navigating 40 minutes.
 *
 * CMP 12L, Fall 2013
 * Lab #5
 * October 28, 2013
 *
 * This program displays a 4X4 matrix based on the inputed txt file.
 * Then the program displays the transposed version of the file.
 *
 * Input:
 * A txt file of 16 ints
 * 
 * Output:
 * The matrix, the sum of the necessary diagonal, the transpose matrix and that necessary diagonal sum.
 *
 * Bugs and limitations:
 * Success rate is 99.99% unless the txt file is incorrect.
 */
import java.io.File;
import java.util.*;
public class doubles {
	public static void main(String[] args) throws Exception {
		// to open the file "input.txt"
		Scanner scan = new Scanner(new File("input.txt"));
		// sum to keep track of the necessary diagonal sum
		int sum = 0;
		// 2d array for the 4X4 matrix
		int [][]data = new int [4][4];
		System.out.println("Here is the matrix:");
		/*
		 * scan.length = 16
		 * data[0].length = 4
		 * each int gets put into the array
		 * after every 4, the int is put into a new row.
		 * The array is then printed.
		 * Sum is also added
		 */
		for(int i = 0; scan.hasNext(); i++){
			for(int j = 0; j < data[0].length; j++){
				data[i][j] = scan.nextInt();
				System.out.print(data[i][j] + " ");
				if(i == j){
					sum = sum + data[i][j];
				}
			}
			System.out.println();
		}
		// closes the file
		scan.close();
		System.out.println("The sum of the necessary diagonal: "+ sum);
		System.out.println("Here is the transpose of the matrix");
		// sum is restarted
		sum = 0;
		/*
		 * restarts the matrix again and transposes the new matrix.
		 * The new sum is also added.
		 */
		scan = new Scanner(new File("input.txt"));
		for(int i = 0; i < data.length; i++){
			for(int j = 0; j < data[0].length; j++){
				System.out.print(data[j][i]+" ");
				if(i == j){
					sum = sum + data[i][j];
				}
			}
			System.out.println();
		}
		// closes the file
		scan.close();
		System.out.println("The sum of the necessary diagonal: "+ sum);
	}
}