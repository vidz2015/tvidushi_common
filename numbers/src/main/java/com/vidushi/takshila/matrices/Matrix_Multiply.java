package com.vidushi.takshila.matrices;

public class Matrix_Multiply {

	public static void main(String[] args) {
	
  int row = 3;
  
  int col = 3;	
  
  int[][] first = {{1,1,1},{1,1,1},{1,1,1} };
  int[][] second = {{2,2,2},{2,2,2},{2,2,2} };
  int[][] product = new int[row][col];
 
  for(int i =0;i<row;i++){
	  for(int j =0;j<col;j++){
		  
		  product[i][j] = first[i][j]+ second[i][j] ;
		  System.out.print(" "+product[i][j] );
	  }
	  System.out.println(" ");
	  
  }
	}

}
