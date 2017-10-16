package com.vidushi.takshila.stack;


import com.vidushi.takshila.exception.StackOverFlowException;
import com.vidushi.takshila.exception.StackUnderFlowException;

class Node<T> {
	
	Node next;
	T data;
	
	Node(T data, Node node){
			this.next = node;
			this.data = data;
    }
}

public class StackLlistImpl<T> implements IStack{
	     Node head;
	

	public StackLlistImpl(Node node) {
		this.head = node;
	}
	
	


	public void push(Object num) throws StackOverFlowException {
		if(head == null){
			head = new Node(num,null);
			return;
		}
		
		Node previous = head;
		head = new Node(num,previous);

		}
		 



	public T peek() throws StackUnderFlowException {
		if(head == null) throw new StackUnderFlowException("Message ");
		return (T) head.data;
	}


	public T pop() throws StackUnderFlowException {
		if(isEmpty()) throw new StackUnderFlowException("") ;
		T value = (T) head.data;
		head = head.next;
		return value;
	}




	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}




	public boolean isFull() {
		// TODO Auto-generated method stub
		return false;
	}





	

}
