package com.vidushi.takshila.concurrency.timer;

import java.util.Timer;
import java.util.TimerTask;


/**
 * 
 * 1)Create a class that extends timer task
 * 2)Pass it as argument 
 * 3) start timer
 */

/**
 * This class shows a simple way to create scheduled tasks (work in progress)
 *
 * @author takshila vidushi 
 */
public class TimerExample extends TimerTask{



	@Override
	public void run() {
           	System.out.println("Task starts");
		
			try { sumtask();
			} catch (InterruptedException e) {
				
			}
			System.out.println("finsihed !!!!");
		
	}
	
	

	public void sumtask() throws InterruptedException {
				System.out.println(" entered");
				Thread.sleep(1000);
				System.out.println("exiting!!!!");
	}
	
	
	
	
	
	public static void main(String[] args) {
		


       Timer timer = new Timer(true);
       timer.scheduleAtFixedRate(new TimerExample(), 0, 10*100);
       System.out.println("job started");

       try {
           Thread.sleep(120000);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
       timer.cancel();
       System.out.println("job halted");
       try {
           Thread.sleep(30000);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
   }


}
