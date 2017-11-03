package com.vidushi.takshila.concurrency.pattern;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Exchanger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Producer implements Runnable{
	Exchanger exchanger;
	
	
	public Producer(Exchanger exchanger){
		this.exchanger= exchanger;
	
	}

	@Override
	public void run() {
		List<Integer>  producer = new ArrayList<>();
		try {
			 System.out.println("producer size is  before  : "+producer.size());
			 List<Integer> list=	Stream.iterate(0,i->i+1).limit(20).collect(Collectors.toList());

			 producer = (List<Integer>) exchanger.exchange(list);
			 System.out.println("producer size is  after  : "+producer.size());

		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}

	
	
	
}



class Consumer implements Runnable{
	
	Exchanger exchanger;


	public Consumer(Exchanger exchange){
		this.exchanger = exchange;
	}
	
	@Override
	public void run() {
		List<Integer>  consumer = new ArrayList<>() ;
		try {
			    System.out.println("Consumer size before "+consumer.size());
			    consumer = (List<Integer>) exchanger.exchange(new ArrayList());
				System.out.println("Consumer size after "+consumer.size());
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
	}

}


public class ExchangerExample {



	public static void main(String[] args) {
	 
		Exchanger<LinkedList> exchanger = new Exchanger<LinkedList>();
	
		
		Thread thread1 = new Thread(new Producer(exchanger));
		Thread thread2 = new Thread(new Consumer(exchanger));
		thread1.start();
		thread2.start();

	}

}
