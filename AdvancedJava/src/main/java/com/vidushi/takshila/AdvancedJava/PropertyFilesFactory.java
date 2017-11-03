/*
 * @(#)Constants.java
 *
 * Copyright (c) 2000-2005 IntelliGroup
 * 499 Thornall Street, NJ, U.S.A.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of IntelliGroup
 * Inc. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with IntelliGroup.
 */
package com.enterprisehorizons.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Properties;

import com.enterprisehorizons.constants.CommonConstants;
import com.enterprisehorizons.exception.EHRuntimeException;

/**
 * This class has methods related to getting property values from a property
 * file
 * 
 * @author M V J Kumar
 * @version 1.0
 */
public final class PropertyFilesFactory {
	/** instance -to maintain a single instance of Constants */
	private static PropertyFilesFactory instance = new PropertyFilesFactory();

	// private static PropertyFilesFactory instance = null;

	/** holds the properties of all the files */
	private Hashtable propertiesHash = new Hashtable();

	private static final String ZIP_EXT = ".zip";

	private static final String JAR_EXT = ".jar";

	private static final String FILE_PREPENDER = "file:";

	/** make the class as private */
	private PropertyFilesFactory() {
	}

	/**
	 * The method getInstance maintains a single live instance of Constants
	 * 
	 * @return static Constants to return maintain a single live instance
	 */
	public static PropertyFilesFactory getInstance() {
		/*
		public synchronized static PropertyFilesFactory getInstance() {
		if (instance == null) {
		    try {
		        String commonJar = "D:/eclipse 3.0/eclipse/workspace/com.enterprisehorizons.abm";
		        commonJar += "/lib/com.enterprisehorizons.common.jar";
		        addFile(commonJar);
		        ClassLoader parentClassLoader = ClassLoader
		                .getSystemClassLoader();
		        //Class cls =
		        // ClassLoader.getSystemClassLoader().loadClass(PropertyFilesFactory.class.getName());

		        // And get the other version of our current class
		        Class otherClassInstance = parentClassLoader
		                .loadClass(PropertyFilesFactory.class.getName());
		        // And call its getInstance method - this gives the correct
		        // instance of ourself
		        Method getInstanceMethod = otherClassInstance
		                .getDeclaredMethod("getInstance", new Class[] {});
		        Object otherAbsoluteSingleton = getInstanceMethod.invoke(null,
		                new Object[] {});
		        // But, we can't cast it to our own interface directly because
		        // classes loaded from// different classloaders implement
		        // different versions of an interface.// So instead, we use
		        // java.lang.reflect.Proxy to wrap it in an object that *does*
		        // support our interface, and the proxy will use reflection to
		        // pass through all calls// to the object.
		        instance = (PropertyFilesFactory) Proxy.newProxyInstance(
		                PropertyFilesFactory.class.getClassLoader(),
		                new Class[] { PropertyFilesFactory.class },
		                new PassThroughProxyHandler(otherAbsoluteSingleton));
		        ;

		        //	            if(instance == null) {
		        //	                instance = (PropertyFilesFactory)cls.newInstance();
		        //	            }

		        if (instance == null) {
		            instance = new PropertyFilesFactory();
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		}
		*/

		return instance;
	}

	/*
	    class PassThroughProxyHandler implements InvocationHandler {
	        private final Object delegate;

	        public PassThroughProxyHandler(Object delegate) {
	            this.delegate = delegate;
	        }

	        public Object invoke(Object proxy, Method method, Object[] args)
	                throws Throwable {
	            Method delegateMethod = delegate.getClass().getMethod(
	                    method.getName(), method.getParameterTypes());
	            return delegateMethod.invoke(delegate, args);
	        }
	    }

	    //	------------------------
	    private static final Class[] parameters = new Class[] { URL.class };

	    public static void addFile(String s) throws IOException {
	        File f = new File(s);
	        addFile(f);
	    }//end method

	    public static void addFile(File f) throws IOException {
	        addURL(f.toURL());
	    }//end method

	    public static void addURL(URL u) throws IOException {

	        URLClassLoader sysloader = (URLClassLoader) ClassLoader
	                .getSystemClassLoader();
	        Class sysclass = URLClassLoader.class;

	        try {
	            Method method = sysclass.getDeclaredMethod("addURL", parameters);
	            method.setAccessible(true);
	            method.invoke(sysloader, new Object[] { u });
	        } catch (Throwable t) {
	            t.printStackTrace();
	            throw new IOException(
	                    "Error, could not add URL to system classloader");
	        }//end try catch

	    }//end method

	    //------------------------
	*/
	/**
	 * The method getProperty gets the specified property value from the
	 * specified properties file.
	 * 
	 * @param propertyFileName
	 *            file name
	 * @param key
	 *            whose value is needed
	 * @return returns the value of the property as String
	 * @throws EHRuntimeException
	 *             if there is an error while loading the properties file
	 */
	public String getProperty(String propertyFileName, String key) {
		Properties properties = getProperties(propertyFileName, false);

		return properties != null ? properties.getProperty(key) : null;
	}

	public String getProperty(String propertyFileName, String key, boolean reload) {
		Properties properties = getProperties(propertyFileName, reload);

		return properties != null ? properties.getProperty(key) : null;
	}

	/**
	 * Returns all the keys in the property file
	 * 
	 * @param propertyFileName
	 * @return
	 */
	public String[] getAllKeys(String propertyFileName) {
		Properties properties = getProperties(propertyFileName, false);

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

	/**
	 * Gets the properties for the file
	 * 
	 * @param fileName
	 * @return
	 */
	public Properties getProperties(String fileName) {
		return getProperties(fileName, false);
	}

	/**
	 * Gets the properties for the file
	 * 
	 * @param fileName
	 * @return
	 */
	public Properties getProperties(String fileName, boolean reload) {
		Properties properties = (Properties) propertiesHash.get(fileName);
		if (reload || properties == null) {
			properties = loadProperties(fileName);
		}

		return properties;
	}

	/**
	 * 
	 * @param fileName
	 * @param key
	 * @param value
	 */
	public synchronized void setProperty(String fileName, String key, String value) {
		Properties properties = getProperties(fileName, false);
		properties.setProperty(key, value);
		saveProperties(properties, fileName);
	}

	/**
	 * loads the properties file from the given name and puts in the hashtable
	 * 
	 * @param fileName
	 *            properties file name
	 * @return returns the properties object
	 * @throws EHRuntimeException
	 */
	private Properties loadProperties(String fileName) {
		Properties properties = null;
		InputStream iStream = null;
		try {
			properties = new Properties();
			//if the user has passed the full path
			File f = null;
			if (FileUtils.isSafePath(fileName)) {
				f = new File(fileName);
			} 
			if (f.exists()) {
				if (FileUtils.isSafePath(fileName)) {
					iStream = new FileInputStream(fileName);
				} 
			} else { //otherwise check for the file in the classpath
				iStream = FileUtils.getResourceStream(fileName);
			}
			if (iStream == null) {
				throw new EHRuntimeException(fileName + " not found");
			}
			properties.load(iStream);
			propertiesHash.put(fileName, properties);
		} catch (Exception e) {
			throw new EHRuntimeException("Error occurred while loading the properties file " + fileName, e);
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

	/**
	 * 
	 * @param properties
	 * @param fileName
	 */
	public synchronized void saveProperties(Properties properties, String fileName) {
		FileOutputStream fOut = null;
		try {
			String filePath = null;
			boolean insideJar = false;
			if (fileName != null && fileName.indexOf(CommonConstants.DRIVE_SEPARATOR) >= 0) {
				filePath = fileName;
			} else {
				URL fileURL = this.getClass().getClassLoader().getResource(fileName);
				filePath = fileURL.getFile();
				int tmpIndex = filePath.indexOf(FILE_PREPENDER);
				if (tmpIndex >= 0) {
					filePath = filePath.substring(tmpIndex + FILE_PREPENDER.length());
				}
				if (fileName != null) {
					int index = filePath.indexOf(ZIP_EXT);
					if (index < 0) {
						index = filePath.indexOf(JAR_EXT);
					}
					insideJar = index >= 0 ? true : false;
				}
			}
			if (!insideJar) {
				fOut = new FileOutputStream(filePath);
				properties.store(fOut, null);
			} else {
				updateJarFile(properties, filePath);
			}
			propertiesHash.put(fileName, properties);
		} catch (Exception e) {
			throw new EHRuntimeException("Unable to save the properties file ", e);
		} finally {
			if (fOut != null) {
				try {
					fOut.close();
				} catch (Exception ex) {
					Logger.error("Exception [" + ex.getLocalizedMessage() + "] occurred while closing the file", PropertyFilesFactory.class);
				}
			}
		}
	}

	/**
	 * 
	 * @param properties
	 * @param filePath
	 * @throws IOException
	 */
	private synchronized void updateJarFile(Properties properties, String filePath) throws IOException {
		int index = filePath.indexOf(ZIP_EXT);
		if (index < 0) {
			index = filePath.indexOf(JAR_EXT);
		}
		String jarFilePath = filePath.substring(0, index + ZIP_EXT.length());
		int filePathIndex = jarFilePath.lastIndexOf(CommonConstants.FORWARD_SLASH);
		if (filePathIndex < 0) {
			filePathIndex = jarFilePath.lastIndexOf(CommonConstants.BACKWARD_SLASH);
		}
		if (filePathIndex > 0) {
			filePathIndex++;
		}
		String parentDirectory = filePath.substring(0, filePathIndex);
		int tmpFilePathIndex = filePath.lastIndexOf(CommonConstants.FORWARD_SLASH);
		if (tmpFilePathIndex < 0) {
			tmpFilePathIndex = filePath.lastIndexOf(CommonConstants.BACKWARD_SLASH);
		}
		String fileName = filePath.substring(tmpFilePathIndex);

		String tmpFilePath = parentDirectory + fileName;
		File tmpFile = new File(tmpFilePath);
		if (!tmpFile.createNewFile()) {
			Logger.error("updateJarFile(Properties properties, String filePath) Failed to create new temporary jar file [" + tmpFilePath + "]",
					PropertyFilesFactory.class);
		}

		parentDirectory = filePath.substring(0, filePathIndex - 1);
		if (tmpFile.exists()) {
			//store the properties file in a temporrary file
			FileOutputStream fout = new FileOutputStream(tmpFile);
			properties.store(fout, null);
			fout.close();

			JarWriterUtils.writeJar(parentDirectory, jarFilePath, new String[] { tmpFilePath }, true, false);
			//delete the temp file
		}
	}
}