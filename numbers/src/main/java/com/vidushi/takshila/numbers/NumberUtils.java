package com.vidushi.takshila.numbers;

/**
 * /*
 * @(#) NumberUtils.java
 *
 * Copyright (c) tvidushi
 * 
 * All rights reserved.
 *
 * This software can be used for learning purpose
 */


/**
 * This class contains contains the common number utility methods for various purposes(work in progress)
 *
 * @author takshila vidushi 
 */

public class NumberUtils 
{

    
	/**
	 * @param num 
	 * calculates factorial of a number
	 */
    public int getFactorial(int num){
    	if(num==0)return 1;
    	return num*getFactorial(num-1);
    }
    
    
    /**
	 * @param num 
	 * validates perfect number
	 * A number is perfect if sum of numbers comes out to be 
	 * 
	 */
    
   public boolean isPerfectNumber(int num){    

		 int len = num/2;
		 int sum = 0;
		for(int i =1;i<=len;i++){
			if(num%i == 0)sum+=i;
		}
		if(sum == num)return false; else return true;
   } 
   
  
   
   /**
	 * @param num 
	 * validates if a number power of two
	 */
    
   public boolean isPowerOfTwo(int num){    
	   if (num ==0) return false; 
	   
	   return false;
   } 
   
   
   
   /**
	 * @param num 
	 * validates if a number is prime number
	 */
    
   public boolean isPrimeNumber(int primeNumber){  
	   if (primeNumber ==0) return false; 
	   for (int i = 2; i < (primeNumber / 2); i++) {
	         if (primeNumber % i == 0) {
	            return false;
	         }
	      }
	      return true;
   } 
   
   
    /**
 	 * @param num 
 	 * provides sum of a digits of a number
 	 */
     
    public int getSumOfDigits(int num){ 
    	if (num ==0) return 0; 
    	 num  = Math.abs(num);
    	 int digit = 0;
    	 int sum = 0;
 	   while(num !=0){
 		   digit = num%10;
 		   sum +=digit;
 		   num /=10;
 	   }
    	return sum;
    } 
    
    
   
   
    /**
  	 * @param num 
  	 * provides product of a digits of a number
  	 */
      
     public int getProductOfDigits(int num){
    	 if (num ==0) return 0; 
       	 num  = Math.abs(num);
       	 int digit = 0;
       	 int product = 0;
    	   while(num !=0){
    		   digit = num%10;
    		   product *=digit;
    		   num /=10;
    	   }
       	return product;
  	   
     } 
     
     
   
     
     /**
   	 * @param num 
   	 * validate if a series fibonnaci
   	 */
       
      public void printFibonnaciSeries(int num){    
    	  int n1=0,n2=1,n3,i,upper=num;    
 		 System.out.print(n1+" "+n2);//printing 0 and 1    
 		    
 		 for(i=2;i<upper;++i)//loop starts from 2 because 0 and 1 are already printed    
 		 {    
 		  n3=n1+n2;    
 		  System.out.print(" "+n3);    
 		  n1=n2;    
 		  n2=n3;    
 		 }

      } 
      
    
      
      /**
    	 * @param num 
    	 * swap the numbers
    	 */
        
       public void swap(int A,int B){   
    	   A = A + B;
    	   B = A - B;
    	   A = A - B;
       } 
       
     
   
       /**
     	 * @param num 
     	 * is ArmStrong's number
     	 */
         
        public void isArmstrongNumber(int num){   
        	//int num = 371;
    		int temp = num;
    		int sum = 0;
    		int rem = 0;
    		while(num>0){
    		  rem = num%10 ;
    		  num = num/10;
    		  sum = sum + rem*rem*rem;
    		}
    		
    		if(temp == sum){
    		     System.out.println("Yes it is");
    		}else{
    			 System.out.println("No it is not");
    		}
    	}
    } 
        
      
