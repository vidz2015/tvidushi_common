package com.vidushi.takshila.matrices;

import java.util.Scanner;
import java.util.stream.Stream;

/**
 * /*
 * @(#) Matrix_Transpose.java
 *
 * Copyright (c) tvidushi
 *
 * This software can be used for learning purpose
 */


/**
 * This class contains contains the common number utility methods for various purposes(work in progress)
 *
 * @author takshila vidushi 
 */




public class Matrix_Transpose {

	public static void main(String[] args) {

	      int row,col;
	      Scanner scan = new Scanner(System.in);
	      System.out.println("Enter the number of rows in the  matrix");
	       row = scan.nextInt();
	       System.out.println("Enter the number of columns of the matrix");
	       col = scan.nextInt();
	       Integer[][] original = new Integer[row][col];
	       Integer[][] trans = new Integer[col][row];
	       System.out.println("Enter the elements of first matrix"); 
	       
	       for(int i=0;i<row;i++){
	    	    for(int j=0;j<col;j++){
	    	    	original[i][j]= scan.nextInt();
	    	    }
	    	 
	       }

	       for(int i=0;i<row;i++){
	    	    for(int j=0;j<col;j++){
	    	        trans[j][i] =	original[i][j];
	    	        System.out.print("  "+original[i][j]);
	    	    }
	    	    System.out.println("  ");
	       }
	
	       
	       System.out.println("----------------------");
	       for(int i=0;i<col;i++){
	    	    for(int j=0;j<row;j++){
	    	    System.out.print("  "+trans[i][j]);
	    	    }
	    	  System.out.println(" ");
	       }
	
	} 

}

