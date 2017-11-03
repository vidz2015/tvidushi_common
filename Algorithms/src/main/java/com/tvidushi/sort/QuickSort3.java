package com.vidushi.takshila.datastructure.sorting;

public class QuickSort3 {
	
	
	private int array[]; 
	private int length; 

	public void sort(int[] inputArr) { 

				if (inputArr == null || inputArr.length == 0) { 
				       return; 
				} 
				this.array = inputArr; 
				length = inputArr.length; 
				quickSort(0, length - 1); 
	} 

	private void quickSort(int lowerIndex, int higherIndex) { 

	int l = lowerIndex; 
	int h = higherIndex; 
	
	
	// calculate pivot number, I am taking pivot as middle index number 
	int pivot = array[lowerIndex+(higherIndex-lowerIndex)/2]; 
	// Divide into two arrays 
	while (l <= h) { 

		
   /** 
	* In each iteration, we will identify a number from left side which 
	* is greater then the pivot value, and also we will identify a number 
	* from right side which is less then the pivot value. Once the search 
	* is done, then we exchange both numbers. 
	*/ 
		
	while (array[l] < pivot) { 
	    l++; 
	} 
	
	while (array[h] > pivot) { 
	     h--; 
	} 
	if (l <= h) { 
			exchangeNumbers(l, h); 
			//move index to next position on both sides 
			l++; 
			h--; 
	} 
	} 
	// call quickSort() method recursively 
	if (lowerIndex < h) 
			quickSort(lowerIndex, h); 
	if (l < higherIndex) 
			quickSort(l, higherIndex); 
	} 

	private void exchangeNumbers(int l, int h) { 
		int temp = array[l]; 
		array[l] = array[h]; 
		array[l] = temp; 
	} 

	
	
	
	
	
	public static void main(String a[]){ 

			QuickSort3 sorter = new QuickSort3(); 
			//int[] input = {24,2,45,20,56,75,2,56,99,53,12}; 
			
		     int[] input = {2,3,31,24,5,6,61,7,8,92};
			sorter.sort(input); 
			for(int ip:input){ 
					System.out.print(ip); 
					System.out.print(" "); 
			} 
	} 	
	}

