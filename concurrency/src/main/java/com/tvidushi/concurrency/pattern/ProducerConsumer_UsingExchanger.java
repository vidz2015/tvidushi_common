package com.vidushi.takshila.concurrency.pattern;

import java.util.LinkedList;
import java.util.concurrent.Exchanger;

/**
 * /*
 * @(#) ProducerConsumer.java
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


public class ProducerConsumer_UsingExchanger {
	
	/*
	 The Exchanger Class provides a sort of rendezvous point for two threads, where the threads can exchange their respective Objects 
	 with the other thread.Whenever a thread arrives at the exchange point, it must wait for the other thread to arrive. When the 
	 other pairing thread arrives the two threads proceed to exchange their objects.

	 * */
	static Exchanger exchange = new Exchanger(); 
	
	static class Producer implements Runnable{
        Object queueStatus ;
		@Override
		public void run() {
			
			try {
				LinkedList queue = new LinkedList();
				queue.add("AA");
				queue.add("BB");
				queue.add("CC");
				queue.add("DD");
				queue.add("EE");
				queue.add("FF");
				queue.add("GG");
				queue.add("HH");

				queueStatus =  exchange.exchange(queue);
				System.out.println(Thread.currentThread().getName()+" now has "+queue);
				System.out.println(queueStatus);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
	
	static class Consumer implements Runnable{
		 Object queueStatus ;
		@Override
		public void run() {
			LinkedList queue = new LinkedList();
			try {
				queueStatus = exchange.exchange(queue);
				System.out.println(Thread.currentThread().getName()+" now has "+queue);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}



	public static void main(String[] args) {
		 new Thread(new Producer(),"Producer").start();
		 new Thread(new Consumer(),"Consumer").start();
	}

}
