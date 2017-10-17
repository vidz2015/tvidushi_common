package com.vidushi.takshila.queues;

public class QueueListImpl implements IQueue{
	
	
	
private 	class Node<T>{
		
		Node front;
		Node rear;
		T data;
		
		Node(Node front,Node rear,T data){
			this.front = front;
			this.rear = rear;
			this.data = data;
		}
		
		
		
	}
	
	
	int size ;
	int front;
	int rear;

	public QueueListImpl() {
		
	}

	public boolean isEmpty() {
	
		return false;
	}

	public boolean isFull() {
	
		return false;
	}

	public Object peek() {
	
		return null;
	}

	public void offer() {
	
		
	}

	public Object poll() {
	
		return null;
	}
	
	
	
	

}
