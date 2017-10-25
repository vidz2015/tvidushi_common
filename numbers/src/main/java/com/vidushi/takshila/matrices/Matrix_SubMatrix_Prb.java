package com.vidushi.takshila.matrices;

public class Matrix_SubMatrix_Prb {
	
	/*
	Given is a matrix arr[n][n] ,find a sub matrix sub[m][n] such summation of  all the elements  in sub matrix is maximum
	Given condition 
	1. m<= n
	2.m>=2
	3. consider positive,negative 
	 * */
	public static void main(String[] args) {
		
		int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		/*
	 {1,2,3,4},
	 {5,6,7,8},
	 {9,10,11,12},
	 {13,14,15,16}
		 * */
		
		int  top =0;
		int bottom = matrix.length-1 ;// This gives height 
		int left = 0;
		int right = matrix[0].length-1;  //This gives length
	    int dir = 0;  
        int i = 0;
        System.out.println("1 2 3 4 8 12 16 15 14  13 9 5 6  7 11 10");
		while(top<= bottom && left <= right){
			if(dir==0){  // left to right
				for( i = left;i<=right;i++ ){
					System.out.print("  "+matrix[top][i]);
				}
				top++;//setting up 
				//dir = 1;

			    }else if(dir == 1){
			    	for( i = top ;i<=bottom;i++){
			    		System.out.print("  "+matrix[i][right]);

			    	}
			    	right--;
			    	//dir = 2;
			    	
			    }else if(dir == 2){
			    	for( i = right ;i>=left;i--){
			    		System.out.print("  "+matrix[bottom][i]);
			    		bottom--;
			    	}
			    }else if(dir == 3){
			    	for( i = bottom ;i>=top;i--){
			    		System.out.print("  "+matrix[i][left]);
			    		left++;
			    		//dir = 0;
			    	}
			    		
			    }
			    dir = (dir+1)%4;
			    //System.out.println(" direction is"+dir );
			}	
		}
	}


