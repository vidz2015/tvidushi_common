package com.tvidushi;



 class Employee implements Cloneable{

	String name;
	String lastname;
	String Dept;
	int age ;
	
	public Employee(String name,String lastname,String dept,int age ) {
		this.name  = name;
		this.lastname = lastname;
		this.Dept = dept ;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getDept() {
		return Dept;
	}

	public void setDept(String dept) {
		Dept = dept;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	int id;
	
	public Employee() {}
	
	
	 @Override
	 public Object clone() throws CloneNotSupportedException {
	 return super.clone();
	 }

}



public class CloningExample {



	public static void main(String[] args) throws CloneNotSupportedException {
	      Employee employee = new Employee();
	      employee.setAge(10);
	      employee.setName("aaaa");
	      employee.setLastname("bbbbb");
	      employee.setDept("HR");
	      
	      Employee employee2 = (Employee) employee.clone();
	      System.out.println("Employee 1"+employee.getName());
	      System.out.println("Employee 2"+employee2.getName());


	}

}
