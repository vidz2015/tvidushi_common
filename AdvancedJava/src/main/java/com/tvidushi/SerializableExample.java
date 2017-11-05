package com.tvidushi;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;



class Student implements  Serializable {
	
	int id;
	String name;
	String lastname;
	private static final long serialVersionUID = -8000090944414208496L;
	public Student(){}
	
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

public class SerializableExample {
   
	// deserialize to Object from given file
	public static Object deserialize(String fileName) throws IOException,
			ClassNotFoundException {
		FileInputStream fis = new FileInputStream(fileName);
		ObjectInputStream ois = new ObjectInputStream(fis);
		Object obj = ois.readObject();
		ois.close();
		return obj;
	}

	// serialize the given object and save it to file
	public static void serialize(Object obj, String fileName)
			throws IOException {
		FileOutputStream fos = new FileOutputStream(fileName);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(obj);

		fos.close();
	}


	public static void main(String[] args) {
		
		/*	Student student = new Student();
		student.setId(1);
		student.setName("aaaaa");
		student.setLastname("bbbbbbb");
		
		try {
			serialize(student,"student.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	*/	
		String fileName="student.txt";
		Student student = null;
		
		try {
			student = (Student) deserialize(fileName);
			System.out.println(student.getId());
			System.out.println(student.getName());
			System.out.println(student.getLastname());
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}


       
	}

}
