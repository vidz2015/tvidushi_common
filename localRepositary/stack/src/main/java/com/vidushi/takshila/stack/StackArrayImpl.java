
package com.vidushi.takshila.stack;

import com.vidushi.takshila.exception.StackUnderFlowException;
import com.vidushi.takshila.exception.StackOverFlowException;
import com.vidushi.takshila.exception.StackOverFlowException;

public class StackArrayImpl implements IStack {
	
	int top;
	Integer[] num ;
	int size;
	//STEP 1: initialize the array
	public StackArrayImpl(int top,int size,Integer[] num) {
		this.size =size;
		this.top = top;
		this.num = num;
	}
	
	public void push(Integer number) throws StackOverFlowException {
		if(isFull()){
			throw new StackOverFlowException("Stack over flow");
		}
		num[top++] = number;
		System.out.println(" Element pushed    "+num[top]);
	}
	
	public Integer pop() throws StackUnderFlowException {
		if(isEmpty()) throw new StackUnderFlowException("");
		int currentElement = top;
		top--;
		System.out.println(" Element pop    "+num[currentElement]);
		return  num[currentElement];
	}
	
	
	
	public Integer peek() throws StackUnderFlowException {
		if(isEmpty()) throw new StackUnderFlowException("");
		return  num[top];
	}
	
	public boolean isEmpty(){
		return (top==-1);
	}
	
	public boolean isFull(){
		return (top==size-1);
	}

	public void push(Object num) throws StackOverFlowException {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
