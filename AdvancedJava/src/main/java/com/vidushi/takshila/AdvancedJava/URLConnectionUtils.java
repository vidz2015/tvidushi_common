package com.vidushi.takshila.advanced_java;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionUtils {
/**
 The Java API provides the URL class which can be used to represent the URL address. You can create the URL object if you
  have the URL address string. The URL class provides getter methods to get the components 
 of the URL such as host name, port, path, query parameters etc.
 
 
		 1. Create the URL object
		 2. Create URLConnection object
		 3. Open connection to URL
         4. Get input stream from connection
         5. Read from input stream
         6. Close input stream

 
		String urlString = 'http://www.codinggrid.com';
		URL myUrl = new URL(urlString);
		URLConnection myUrlConnection = myUrl.openConnection();
		myUrlConnection.connect();
 * @throws IOException 

 
 
 */

	public static void main(String[] args) throws IOException {
	
		String urlString = "http://www.codinggrid.com";
		URL myUrl = new URL(urlString);
		URLConnection myUrlConnection = myUrl.openConnection();
		myUrlConnection.connect();

	}

}
