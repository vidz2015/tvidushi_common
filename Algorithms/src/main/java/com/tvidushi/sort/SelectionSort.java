package com.vidushi.takshila.sorting;

import java.util.stream.Stream;

public class SelectionSort {

	public static void main(String[] args) {
		
    Integer[] arr = {3,2,4,5,6,7,8,19,20};
    int len = arr.length-1;
   /*
     Step 1 − Set MIN to location 0
	Step 2 − Search the minimum element in the list
	Step 3 − Swap with value at location MIN
	Step 4 − Increment MIN to point to next element
	Step 5 − Repeat until list is sorted
    */
       int min = 0;
	    for(int i=0;i<len;i++){
	    	 min = i;
	        for(int j=i+1;j<len;j++){  //by the end of higher loop elements till ith position will be sorted
	        	if(arr[j]<arr[min]){
                    min  = j;
		    	}   
	    	}
  
	      if(min != i){
	    	 int temp = arr[i];
	    	  arr[i] = arr[min];
	    	  arr[min] = temp;
	    	  
	      }  }
	    
	Stream.of(arr).forEach(x->System.out.print(" "+x));
	}
}

