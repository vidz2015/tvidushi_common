/**
 * 
 */
package com.vidushi.takshila.advanced_java.schedulingFramework;

/**
 * @author cosmi
 *
 */
public class JobUtils {

	/**  core concepts
	1.	Create & start scheduler
	2.	Create job instance
	3.	Create trigger instance
	4.	Pass job & trigger to scheduler.schedule method
 
	 */
	
	public static SchedulerFactory schedFactory;
	public static Scheduler schedular; 
	public JobUtils() {
	
	}


	
	public void instantiateSchedule() {
		
		SchedulerFactory schedFact = new org.quartz.impl.StdSchedulerFactory();
		Scheduler sched = schedFact.getScheduler();
		sched.start();

		
	}

	
	
	
	
	public static void main(String[] args) {
	

	}

}
