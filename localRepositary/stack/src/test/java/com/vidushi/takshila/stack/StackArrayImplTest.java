/**
 * 
 */
package com.vidushi.takshila.stack;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;

import com.vidushi.takshila.exception.StackUnderFlowException;
import com.vidushi.takshila.exception.StackOverFlowException;

/**
 * @author cosmi
 *
 */
public class StackArrayImplTest {

	
	private static   int  size ;
	private static int top;
	private static Integer num[];
	private static StackArrayImpl stackArray;
	

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		size = 20;
		top = -1;
		num = new Integer[size];
		stackArray  = mock(StackArrayImpl.class);
	}



	/**
	 * Test method for {@link com.vidushi.takshila.stack.StackArrayImpl#push(java.lang.Integer)}.
	 * @throws StackFullException 
	 */
	@Test
	public void testPush() throws StackOverFlowException {
		
		for(int i=0;i<size-2;i++)
		stackArray.push(i*10);
		verify(stackArray);

		//fail("Not yet implemented");
	}

	
	

	/**
	 * Test method for {@link com.vidushi.takshila.stack.StackArrayImpl#push(java.lang.Integer)}.
	 * @throws StackFullException 
	 */
	 @Test(expected = StackOverFlowException.class)
	public void testPush2() throws StackOverFlowException {
		
		for(int i=0;i<size+10;i++)
		stackArray.push(i*10);
		verify(stackArray);

		//fail("Not yet implemented");
	}

	
	
	/**
	 * Test method for {@link com.vidushi.takshila.stack.StackArrayImpl#pop()}.
	 * @throws StackEmptyException 
	 */
	@Test
	public void testPop() throws StackUnderFlowException {
		stackArray.pop();
		verify(stackArray);
		
	}

	/**
	 * Test method for {@link com.vidushi.takshila.stack.StackArrayImpl#isEmpty()}.
	 */
	@Test
	public void testIsEmpty() {
		verify(stackArray.isEmpty());
	}

	/**
	 * Test method for {@link com.vidushi.takshila.stack.StackArrayImpl#isFull()}.
	 */
	@Test
	public void testIsFull() {
		verify(stackArray.isFull());
	}

}
