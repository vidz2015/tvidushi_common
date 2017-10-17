package com.vidushi.takshila.queues;

public interface IQueue<T> {
	
	public boolean isEmpty();
	
	public boolean isFull();
	
	public T peek();
	
	public void offer();
	
	public T poll();
	
	

}
