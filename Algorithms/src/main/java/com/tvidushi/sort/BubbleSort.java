package com.vidushi.takshila.sorting;

import java.util.stream.Stream;

public class BubbleSort {

	public static void main(String[] args) {
		
      Integer[] arr = {2,3,31,24,5,6,61,7,8,92};
      int len = arr.length-1;
      
       for(int i=0;i<len;i++){
    	   for(int j=0;j<len-i;j++){   //by the end of inner loop elements till ith position will be sorted
    		  if( arr[j]> arr[j+1]){
    			  int temp = arr[j];
    			  arr[j] = arr[j+1];
    			  arr[j+1] = temp;
    		  }   
    	   } 
       }
       
       for(int k:arr) System.out.print(" "+k);

	}
}
