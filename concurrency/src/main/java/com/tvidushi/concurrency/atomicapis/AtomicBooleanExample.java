package com.vidushi.takshila.concurrency.atomicapis;

import java.util.concurrent.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
/**
 * /*
 * @(#) AtomicBooleanExample.java
 *
 * Copyright (c) tvidushi
 * 
 * All rights reserved.
 *
 * This software can be used for learning purpose
 */


/**
 * This class contains  purposes(work in progress)
 *
 * @author takshila vidushi 
 */






public class AtomicBooleanExample
{

	public static void main(String args[]){
		
	final AtomicBoolean atomicboolean = new AtomicBoolean(false);
	
	//starting thread one
	new Thread(new Runnable(){

		@Override
		public void run() {
			while(true){
				
				if(atomicboolean.compareAndSet(true, false)){
					System.out.println("done !!!");
					break;
				}
			}
		}
	}).start();
	
	
	new Thread(new Runnable(){

		@Override
		public void run() {
			try {
				Thread.sleep(10000);
				atomicboolean.set(true);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			
		}
		
	
	
	}).start();
	
	
	
	
	
	}
	
	
	
	
	

	}