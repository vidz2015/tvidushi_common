package com.vidushi.takshila.stack;

import com.vidushi.takshila.exception.StackOverFlowException;
import com.vidushi.takshila.exception.StackUnderFlowException;

public interface IStack<T> {
	
	public void push(T num) throws StackOverFlowException;
	public T peek() throws StackUnderFlowException ;
	public T pop() throws StackUnderFlowException;
	public boolean isEmpty();
	public boolean isFull();
	
}
