
package com.tvidushi;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Properties;



public final class PropertyFilesUtils {
	
	

	private static PropertyFilesUtils instance = new PropertyFilesUtils();

	private Hashtable propsMap = new Hashtable();


	private PropertyFilesUtils() {}


	public static PropertyFilesUtils getInstance() {
		return instance;
	}


	private Properties loadProperties(String fileName) {
		Properties properties = null;
		InputStream iStream = null;
		try {
			properties = new Properties();
			File file = new File(fileName);
 
			if (file.exists()) {
					iStream = new FileInputStream(fileName);
					properties.load(iStream);
					propsMap.put(fileName, properties);
			}   
			// can throw npe here 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (iStream != null) {
				try {
					iStream.close();
				} catch (IOException e) {
					//ignore
				}
			}
		}

		return properties;
	}



	public String getProperty(String propertyFileName, String key) {
		Properties properties = getProperties(propertyFileName);
		return properties != null ? properties.getProperty(key) : null;
	}



	
	public String[] getAllKeys(String propertyFileName) {
		Properties properties = getProperties(propertyFileName);
		String[] keys = null;
		int size = properties == null ? 0 : properties.size();
		if (size > 0) {
			keys = new String[size];
			Enumeration enumKeys = properties.keys();
			int i = 0;
			while (enumKeys.hasMoreElements()) {
				keys[i++] = (String) enumKeys.nextElement();
			}
		}

		return keys;
	}



	public Properties getProperties(String fileName) {
		Properties properties = (Properties) propsMap.get(fileName);
		if (properties == null) {
			properties = loadProperties(fileName);
		}

		return properties;
	}





}