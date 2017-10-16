package com.vidushi.takshila.stack;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.vidushi.takshila.exception.StackOverFlowException;
import com.vidushi.takshila.exception.StackUnderFlowException;

public class StackLlistImplTest {

     private static StackLlistImpl list;

	@Before
	public void setUp() throws Exception {
		
		list = mock(StackLlistImpl.class);
		list.push(1);
		list.push("Takshila");
		list.push(3);
		list.push(4);
	
		
		
	}



	@Test
	public void testPush() throws StackOverFlowException {
         list.push("vidushi");
         verify(list);
	}

	@Test
	public void testPeek() {

	}

	@Test
	public void testPop() throws StackUnderFlowException {
		list.pop();	
		verify(list);
	}

}
