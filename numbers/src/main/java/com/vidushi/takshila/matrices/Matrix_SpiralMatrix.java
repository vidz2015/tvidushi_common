package com.vidushi.takshila.matrices;

public class Matrix_SpiralMatrix {
	
	
	
	/*
	 * {1  2  3}
	 * {4  5  6}
	 * {7  8  9}
       Obtain the following
       1.k == starting row index == 0;
       2.m == ending row index  matrix[0].length -1;
       3.l== starting column index  0;
       4.n == ending column index  matrix.length -1 ;
       5.i == iterator
	 * */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         int[][] spiralMatrix =  {{ 1, 2, 3 },{ 4, 5, 6 },{ 7, 8, 9 }};
         /*
          *  {1, 2, 3 }
          * { 4, 5, 6 }
          * { 7, 8, 9 }
          * */
         /*int[][] sample =  {{ 1, 2 },{ 4, 5 },{ 7, 8 },{9,10}};
         System.out.println("get row length"+sample[0].length);
         System.out.println(" get height  "+sample.length); */
         
         System.out.println("expected output [1,2,3,6,9,8,7,4,5]");
         spiralOrder(spiralMatrix);
	}
	
	
	static void spiralOrder(int[][] matrix)
	{
	     if(matrix.length == 0)
	         return;
	     // Initialize our four indexes
	     int top = 0;
	     int height = matrix.length - 1;
	     int left = 0;
	     int rowlen = matrix[0].length - 1;
	 
	     while(true)
	     {
	         // Print top row
	         for(int j = left; j <= rowlen; ++j) System.out.print(matrix[top][j] + "   ##  ");
	         top++;
	         if(top > height || left > rowlen) break;

	         //Print the rowlen most column
	         for(int i = top; i <= height; ++i) System.out.print(matrix[i][rowlen] + "    $$ ");
	         rowlen--;
	         if(top > height || left > rowlen) break;
	         //Print the bottom row
	         for(int j = rowlen; j >= left; --j) System.out.print(matrix[height][j] + "    ~~    ");
	         height--;
	         if(top > height || left > rowlen) break;
	         //Print the leftmost column
	         for(int i = height; i >= top; --i) System.out.print(matrix[i][left] + "    !!   ");
	         left++;
	         if(top > height || left > rowlen) break;
	     }
	 }

}
