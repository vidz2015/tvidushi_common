/**
 * 
 */
package com.vidushi.takshila.advanced_java.FileHandling;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author cosmi
 *
 */
public class BufferedStreamExample {



	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(new File("/advanced_java/src/userstory.txt")),1024);
		while(bufferedInputStream.read()!= -1){
			Byte[] b = new Byte[];
		}

	}

}
