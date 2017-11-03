package com.vidushi.takshila.sorting;

public class QuickSort {
	private int[] array;
	private  int length;
	
	
	
	public void sort(int[] inputArray){
		this.length = length;
		this.array = inputArray;
		quickSort(0,array.length-1);
	}
	
	
	
	public void quickSort(int lowerIndex,int higherIndex){

		//find pivot 
		int pivot = array[lowerIndex+(higherIndex-lowerIndex)/2]; 
		int lower= lowerIndex;
		int higher = higherIndex;
		while(lower<=higher){
			while(array[lower]<pivot){
				lower++;
				
			}
			while(array[higher]>pivot){
				higher--;
				
			}
			
			if(lower<=higher){
				swap(lower,higher);
				lower++;
				higher--;
			}
			
		}
		
		if(lowerIndex<higher){
			quickSort(lowerIndex,higher);
		}
		if(higherIndex>lower){
			quickSort(lower,higherIndex);
		}
		
	}
	
	
	
	public void swap(int lower,int higher){
		
		int temp = array[lower];
		array[lower] = array[higher];
		array [higher] = temp;

	}
	
	
	public static void main(String args[]){
		
	    int[] inputArray = {2,3,31,24,5,6,61,7,8,92};
	    QuickSort  sort = new QuickSort();
	    sort.sort(inputArray);
		for(int ip:inputArray){
			
			System.out.print(ip);
			System.out.print(" ");
		}
		
	}
	
}