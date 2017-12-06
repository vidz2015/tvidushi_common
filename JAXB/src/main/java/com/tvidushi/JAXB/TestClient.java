package com.tvidushi.JAXB;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class TestClient {



	public static void main(String[] args) {
	   Person person = new Person();
	   person.setId(1);
	   person.setName("Vidushi");
	   objectToXML( person);
	  // xmlToObject();
	}
	
	public static Person objectToXML(Person Person){
		
		try {
			JAXBContext context = JAXBContext.newInstance(Person.class);
			Marshaller marshal = context.createMarshaller();
			marshal.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
			marshal.marshal(Person, System.out);

		
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
		
		return null;
	

	}
	
	
	
	public static Person  xmlToObject(){
		Person emp = null ;

		try {
			JAXBContext context = JAXBContext.newInstance(Person.class);
			Unmarshaller un = context.createUnmarshaller();
			 emp = (Person)un.unmarshal(new File("person.xml"));
			 System.out.println(" id :  "+emp.getId());
			 System.out.println(" name :  "+emp.getName());
		} catch (JAXBException e) {
		     	e.printStackTrace();
		}
		
		
		return emp; 

	}
}
