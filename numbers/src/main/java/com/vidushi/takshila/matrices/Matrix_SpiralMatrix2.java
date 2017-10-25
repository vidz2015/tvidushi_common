package com.vidushi.takshila.matrices;

public class Matrix_SpiralMatrix2 {
	
	/*
	 * {1  2  3}
	 * {4  5  6}
	 * {7  8  9}
       Obtain the following
       1.a == starting row index == 0;
       2.b == ending row index  matrix[0].length -1;
       3.c== starting column index  0;
       4.d == ending column index  matrix.length -1 ;
       5.i == iterator
	 * */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         int[][] spiralMatrix =  {{ 1, 2, 3 },{ 4, 5, 6 },{ 7, 8, 9 }};
         int row_starting_index = 0;
         int row_ending_index = spiralMatrix[0].length-1;
         
         System.out.println("row_ending_index :"+row_ending_index);
         int col_starting_index = 0;
         int col_ending_index = spiralMatrix.length-1;
         System.out.println("col_ending_index :"+col_ending_index);
         int i =0;

         while(row_starting_index< col_starting_index && col_starting_index< row_ending_index){
        	// Step 1: Print first row  
        	 for(i =col_starting_index;i<=col_ending_index;++i){ 
        		 System.out.print ("~  "+spiralMatrix[row_starting_index][i]);
        	 }
        	 row_starting_index++;
        	// Step 2: Print the last column
        	 for(i =row_starting_index;i<row_ending_index;++i){ 
        		 System.out.print ("@  "+spiralMatrix[i][col_ending_index]);
        	 } 
        	 col_ending_index--;
           // Step 3: Print last row backwards from the remaining rows
        	 if(row_starting_index<row_ending_index){
        		 for(i =col_ending_index -1;i>col_starting_index;--i){ 
            		 System.out.print ("$  "+spiralMatrix[i][col_ending_index]);
            	 }  
        		 row_ending_index --;
        	 }
        	
          
          //Step 4: Print the first row column from the remaining  columns
        	    if(col_starting_index<col_ending_index){
        	    	 for(i =row_ending_index -1;i>row_starting_index;--i){ 
                		 System.out.print ("&  "+spiralMatrix[i][col_ending_index]);
                	 }  
        	    	 col_starting_index++; 
           	 }
        	 
         }
   
	}
	
}
	