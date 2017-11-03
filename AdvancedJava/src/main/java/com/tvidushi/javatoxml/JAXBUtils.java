/**
 * 
 */
package com.vidushi.takshila.advanced_java.javatoxml;

/**
 * 
 * CREATE  JAXBContext obj
			Create Unmarshaller object out of JAXBCONEXT
			Pass xml to (Unmarshallerobject).unmarshall("***.xml”)
 
  
  ----------------------------------------------------------------------------------------------------------------
1.@XmlRootElement	This is a must have annotation for the Object to be used in JAXB. It defines the root element 
for the XML content.
	
2.@XmlType	It is used to define the order of the elements
	
3.@XmlTransient	To make sure Object property is not written in xml
	
4.@XmlAttribute	Attribute of property
	
5.@XmlElement(name=”abc”)	If we want name of xml element
  ----------------------------------------------------------------------------------------------------------------
 * 
 * @author takshila vidushi
 *
 */
public class JAXBUtils {

	/**
	 * 
	 */
	public JAXBUtils() {
	
	}
	
	
	/**
	 * @param args
	 */
	public static void marshall(String classname) {
		JAXBContext ctx =   initialize(classname);

	}
	
	/**
	 * @param args
	 */
	public static void unMarshall() {
		JAXBContext ctx =   initialize(classname);

	}
	
	
	
	/**
	 * @param args
	 */
	public static JAXBContext initialize(String classname) {
		return  JAXBContext.newInstance(classname+".class");  

	}
	
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String classname =

	}

}
