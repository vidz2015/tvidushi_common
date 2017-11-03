package com.vidushi.takshila.sorting;

public class InsertionSort {

	public static void main(String[] args) {
		  int[] numbers = {2,3,31,24,5,6,61,7,8,92};
		  for (int i = 0; i < numbers.length; i++) {
		        int copyNumber = numbers[i]; 
		        int j = i;
		        while (j > 0 && copyNumber < numbers[j-1]) {
		            numbers[j] = numbers[j-1];
		            j--;
		        }
		        numbers[j] = copyNumber;
	    }
		   for(int k=0;k<numbers.length;k++){
			    	   System.out.print("   "+numbers[k]);
			       }	
			}
	

	}


