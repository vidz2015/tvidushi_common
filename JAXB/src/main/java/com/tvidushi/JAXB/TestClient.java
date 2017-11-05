package com.tvidushi.JAXB;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class TestClient {



	public static void main(String[] args) {
	   Employee employee = new Employee();
	   employee.setId(1);
	   employee.setName("Vidushi");
	   //objectToXML( employee);
	   xmlToObject();
	}
	
	public static Employee objectToXML(Employee employee){
		
		try {
			JAXBContext context = JAXBContext.newInstance(Employee.class);
			Marshaller marshal = context.createMarshaller();
			marshal.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
			marshal.marshal(employee, System.out);

		
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
		
		return null;
	

	}
	
	
	
	public static Employee  xmlToObject(){
		Employee emp = null ;

		try {
			JAXBContext context = JAXBContext.newInstance(Employee.class);
			Unmarshaller un = context.createUnmarshaller();
			 emp = (Employee)un.unmarshal(new File("employee.xml"));
			 System.out.println(" id :  "+emp.getId());
			 System.out.println(" name :  "+emp.getName());
		} catch (JAXBException e) {
		     	e.printStackTrace();
		}
		
		
		return emp; 

	}
}
