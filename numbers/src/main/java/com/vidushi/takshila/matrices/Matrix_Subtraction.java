package com.vidushi.takshila.matrices;

import java.util.Scanner;

public class Matrix_Subtraction {

	public static void main(String[] args) {
	
    Scanner scan = new Scanner(System.in);
    
		System.out.println("Enter the number of rows");
		   int row = scan.nextInt();
		System.out.println("Enter the number of column");
		   int col = scan.nextInt();
		int[][] first = new int[row][col];
		int[][] second = new int[row][col];
		
		int[][] third = new int[row][col];
		
		for(int i =0;i<row;i++){
			for(int j =0;j<col;j++){
				third[i][j] = first[i][j] - second[i][j];
				System.out.print" "+third[i][j]);
			}
			System.out.println(" ");
		}
		
		

	}

}
