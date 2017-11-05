/**
 * 
 */
package com.tvidushi;



/**
 * /*
 * @(#) StringUtils.java
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



public class StringUtils {

	

	public static final String ASIAN = "Asian";
	public static final String AFRICAN_AMERICAN = "African American";
	public static final String LATINO = "LATIN";	
	
	

     public static <T> boolean isPalindrome(T t) {
   
    	 if(t == null) return false;
    	 String temp = t.toString();
    	 int length = temp.length()-1;// Always remember length of string is -1
    	
    	 for(int i =0;i<length/2;i++){
    		 if(temp.charAt(i)!=temp.charAt(length-i)) return false;
    	 }
		return true;

	  }
	
     
     

 	
     private  Integer checkEthinicity(String ethinicity) {
    	 Integer gcWaitTime = 30;
    	 
      switch (ethinicity) {
 		case ASIAN:
	 			System.out.println("Asian");
	 			gcWaitTime = 10;
	 			break;
	 			//return "check";
 		case AFRICAN_AMERICAN:
	 			System.out.println("African American");
	 			gcWaitTime= 8;
	 			break;
 		case LATINO:
	 			System.out.println("Latin");
	 			gcWaitTime =9;
	 			break;	
 	
 		default:
 			     gcWaitTime =0;
 		}
		return gcWaitTime;
 	}



	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		System.out.println(" AAAAAB  is  palindrome   "+isPalindrome("AAAAAB")); 
		System.out.println(" BAAAAAB  is  palindrome   "+isPalindrome("BAAAAAB"));
		System.out.println(" 1234 is  palindrome   "+isPalindrome("1234")); 
		System.out.println(" 1234321  is  palindrome   "+isPalindrome("234321 "));

	}

}
