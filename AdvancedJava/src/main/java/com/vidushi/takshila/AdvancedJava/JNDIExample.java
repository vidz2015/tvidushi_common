package com.vidushi.takshila.advanced_java;

public class JNDIExample {
	/**
	 * /*
	 * @(#) JNDIExample.java
	 *
	 * Copyright (c) tvidushi
	 * 
	 * All rights reserved.
	 *
	 * This software can be used for learning purpose
	 */


	/**
	 * This class contains JNDI utils methods
	 *
	 * @author takshila vidushi 
	 */

	/**
	    The JNDI API enables applications to look up objects such as 
		
		a) DataSources, 
		c) MailSessions, 
		d) JMS connection factories and 
		destinations (Topics/Queues) by name. The Objects can be loaded into the JNDI tree using a J2EE application server�s administration 
		console. 
		(a)	To load an object in a JNDI tree, choose a name under which you want the object to appear in a JNDI tree. 
		J2EE deployment descriptors indicate the placement of J2EE components in a JNDI tree. 
		
		(b)	The parameters you have to define for JNDI service are as follows:

		Hashtable env = new Hashtable();
		
		env.put(Context.INITIAL_CONTEXT_FACTORY,"com.ibm.websphere.naming.WsnInitialContextFactory"); 		
		
		env.put(Context.PROVIDER_URL, " iiop://localhost:1050");
		
		
		/**
		All naming operations are relative to a context. 
		The InitalContext implements the Context interface and provides an entry point for the resolution of names.
		 * 		
		Context ctx = new InitialContext(env); 

	 */


	public static void main(String[] args) {



	}
	
}
