package com.vidushi.takshila.matrices;

import java.util.Scanner;
import java.util.stream.Stream;

public class Matrix_Addition {

	public static void main(String[] args) {
		
      int row,col;
      Scanner scan = new Scanner(System.in);
      System.out.println("Enter the number of rows in the  matrix");
       row = scan.nextInt();
       System.out.println("Enter the number of columns of the matrix");
       col = scan.nextInt();
       
       Integer[][] first = new Integer[row][col];
       Integer[][] second = new Integer[row][col];
       Integer[][] sum = new Integer[row][col];
       
       System.out.println("Enter the elements of first matrix");
       
       for(int i=0;i<row;i++){
    	    for(int j=0;j<col;j++){
    	    first[i][j] =	scan.nextInt();
    	    }
    	    scan.nextLine();
          }
 
       System.out.println("Enter the elements of second matrix");
	   for(int i=0;i<row;i++){
   	    for(int j=0;j<col;j++){
   	         second[i][j] =	scan.nextInt();
   	    }
   	        scan.nextLine();
         }
	   System.out.println("sum  is :");
	
	   for(int i=0;i<row;i++){
	   	    for(int j=0;j<col;j++){
	   	         sum[i][j] =	first[i][j]+ second[i][j];
	   	         System.out.print(" "+sum[i][j]);
	   	    }
	   	       System.out.println("");
	         }
	      }

}

