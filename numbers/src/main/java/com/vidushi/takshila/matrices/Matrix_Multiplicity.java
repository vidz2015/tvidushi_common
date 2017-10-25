package com.vidushi.takshila.matrices;

import java.util.Scanner;

/*
 * 
Java Program to Check Multiplicability of Two Matrices

This is the java program to check the multiplication of the two matrices. Two matrices are multiplicable if and only if the number 
of rows of the left hand side matrix is equal to the number of columns of the right hand side matrix.
Here is the source code of the Java Program to Check Multiplicability of Two Matrices. The Java program is successfully 
compiled and run on a Windows system. The program output is also shown below.
 * 
 * */

public class Matrix_Multiplicity {

	public static void main(String[] args) {
		
		    Scanner sc = new Scanner(System.in);
	        System.out.println("Enter the dimension of the matrix:\n ");
	        int rowA = sc.nextInt();
	        int colA = sc.nextInt();
	 
	        System.out.println("Enter the dimension of the other matrix:\n ");
	        int rowB = sc.nextInt();
	        int colB = sc.nextInt();
	        
	        if(colA == rowB) System.out.println("Yes , they are");
	        else System.out.println("No ,They are ");
		sc.close();

	}

}
