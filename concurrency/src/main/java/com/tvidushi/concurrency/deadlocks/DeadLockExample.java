package com.vidushi.takshila.concurrency.deadlocks;

import com.vidushi.takshila.concurrency.data.Department;
import com.vidushi.takshila.concurrency.data.Employee;


class EmployeeDtls implements Runnable{
	Employee employee;
	Department dept;
	
	
	public EmployeeDtls(){
		
	}
	public EmployeeDtls(Employee employee,Department dept){
		
		this.employee  = employee;
		this.dept = dept;
	}

	@Override
	public void run() {
		
		
		 try {
			 System.out.println(Thread.currentThread().getName()+"Employee name is :"+employee.getName());
			 System.out.println(Thread.currentThread().getName()+" aquiring lock ");
			 synchronized (employee) {
				      System.out.println("_________________________________________________");
				      System.out.println(Thread.currentThread().getName()+" aquired  lock ");
					  Thread.sleep(10000);
					  synchronized (dept){
					         System.out.println(Thread.currentThread().getName()+"Department name is :"+dept.getDept_name());
					  }
					  System.out.println("**************************************************");
			}
			 System.out.println(Thread.currentThread().getName()+" released lock ");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}	





public class DeadLockExample {
	


	
	
		public static void main(String[] args){
			
			
			Employee employee1 = new Employee("AAA", "BBBB", "Operations", 32);
			Employee employee2 = new Employee("PPP", "QQQQ", "HR", 34);
			Employee employee3 = new Employee("AAA", "BBBB", "Operations", 32);
			Employee employee4 = new Employee("PPP", "QQQQ", "Operations", 34);
			
			Department dept = new Department(1, "HR") ;
			Department dept2 = new Department(2, "Operations") ;
			Thread thread1 = new Thread(new EmployeeDtls(employee1,dept));
			thread1.start();
			Thread thread2 = new Thread(new EmployeeDtls(employee1,dept));
			thread2.start();
			Thread thread3 = new Thread(new EmployeeDtls(employee1,dept));
	        thread3.start();
		
		
		}   
		

}
