package com.vidushi.takshila.matrices;

import java.util.Scanner;

public class Matrix_Prb_Micrsoft {
	
	/*
   In given array find zero and the replace the entire row and col
   E.g.
     1    2    3    4
     5    6    7    8
     9    10   0    11
     12   13  14   15   
 
     output
     
     1  2   0   4
     5  6   0   8
     0  0   0   0
     12 13  0   15
	 * */
	public static void main(String[] args) {
	
	//	Scanner scan = new Scanner(System.in);
    // System.out.println(" Enter the num");
		
	int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,0,11},{12,13,14,15}};
     boolean[] row = new boolean[4];
     boolean[] col = new boolean[4];
		for(int i = 0;i<4;i++){
			for(int j = 0;j<4;j++){
				if(matrix[i][j]==0){
					
					row[i] = true;
					col[j] = true;
				}
			}	
		}

	
		for(int i = 0;i<4;i++){
			for(int j = 0;j<4;j++){
				if(row[i] || col[j]){
					matrix[i][j] = 0;
      
				}
				System.out.print(" "+matrix[i][j]);
			}	
			System.out.println(" ");
		}
	
	}

}
