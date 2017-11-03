package com.vidushi.takshila.concurrency;

/**
 * /*
 * @(#) CreatngThreads.java
 *
 * Copyright (c) tvidushi
 * 
 * All rights reserved.
 *
 * This software can be used for learning purpose
 */


/**
 * There are multiple ways to create threads   (work in progress)
 *1) using runnable
 *   a) using anonymous class
 *   b) using actual class |inner or seperate that implements runnable 
 *   c)lamda expression 
 *2)Extending Thread
 *Y
 * @author takshila vidushi 
 */


public class ConcurrencySummary {
	
	public ConcurrencySummary(){}


	public static void main(String[] args) {
		simpleThread();
		threadUsingLamda() ;
	}

	
	public static void simpleThread() {
		Thread th = new Thread(new Runnable(){

			@Override
			public void run() {
				System.out.println(" Using Anonymous Class");
				
			}
			
		});
	}
	
	
	
	
	public static void  threadUsingLamda() {
		Thread th = new Thread(()->{System.out.println(" Using Lamda");});
	}
	
	
	
	
}
