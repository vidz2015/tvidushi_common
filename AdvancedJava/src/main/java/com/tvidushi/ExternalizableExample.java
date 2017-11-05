package com.tvidushi;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;



class Employee implements Externalizable{
	
	int id;
	String name;
	String lastname;
	public Employee(){}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeInt(id);
		out.writeObject("aa"+name);


	}
	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

		id = in.readInt();
		if(name!=null){
			name = (String) in.readObject();
			//if(!name.startsWith("aa"))throw  new IOException("curropt data");
		//	name = name.substring(2);
	          }
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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
	
	
}

public class ExternalizableExample {

			public static void main(String args[]){
				
				Employee employee = new Employee();
				employee.setId(1);
				employee.setName("aaaaa");

				//serializeObject( employee);
				deSerializeObject("");
				
			}
			
			
			public static void serializeObject(Employee employee){

				try {
						FileOutputStream output = new FileOutputStream("employee.txt");
						ObjectOutputStream oos = new ObjectOutputStream(output);
					    oos.writeObject(employee);
					    oos.close();
				} catch (IOException e) {
						e.printStackTrace();
				}
				
				
			}
			
			public static void deSerializeObject(String filename){
				filename = "employee.txt";
				FileInputStream input;
				try {
					input = new FileInputStream(filename);
					ObjectInputStream ois = new ObjectInputStream(input);
				    Employee employee = (Employee)ois.readObject();
				    ois.close();
				    System.out.println("Employee id ="+employee.getId());
				    System.out.println("Employee name is  ="+employee.getName());
				} catch (IOException | ClassNotFoundException e) {
					e.printStackTrace();
				}
			    
				
				
				
			}
			
			
			
			
			
			
			

}
