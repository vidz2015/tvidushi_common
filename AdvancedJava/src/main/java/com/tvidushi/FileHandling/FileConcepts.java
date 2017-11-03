package com.vidushi.takshila.advanced_java.FileHandling;

public class FileConcepts {
/**
There are 9 reader classes   
1)	Reader
2)	FilterReader
3)	PushBackReader
4)	InputStreamReader
5)	BufferedReader
6)	LineNumberReader
7)	FileReader
8)	CharArrayReader
9)	StringReader
10)	PipedReader

 */
	
/**
 
  There are 9 writer classes
1.	Writer
2.	FilterWriter
3.	OutputStreamWriter
4.	FileWriter
5.	BufferedWriter
6.	PipedWriter
7.	StringWriter
8.	CharArrayWriter
9.	PrintWriter

  */
	
	
	
/**
There are 9 inputstream classes
1)	InputStream
2)	FileInputStream
3)	ByteArrayInputStream
4)	FilterDataInputStream
5)	DataInputStream
6)	BuffredInputStream
7)	PrintStream
8)	PipedInputStream
9)	ObjectInputStream 

 */	

	
	
/**
There are 9 outputstream classes
a)	OutputStream
b)	FileOutputStream
c)	ByteArrayOutputStream
d)	FilterDataOutputStream
e)	DataOutputStream
f)	BufferedOutputStream
g)	PushedBackOutputStream
h)	PipedOutputStream
i)	ObjectOutputStream


 */	
	
/*
 * 
 STEP1  :READ THE STRING THAT YOU WANT TO WRITE
Byte[] bytes = “This is is example”.getBytes();


STEP2  :DEFINE THE FILE WHERE YOU WANT TO WRITE TEXT
FileOutputStream fos = new FileOutputStream(“c:\text.txt”);
 Or
File filename = new File(“c:\tesxt.txt”);
FileOutputStream fos = new FileOutputStream(filename);

STEP3 : call write[byte[]]  methods 
Fos.write(bytes);
Fos.close();

 * */	
	
	/**
	 * 
CASE 1: If you need to [READ FILE FROM ONE END TO ANOTHER]read a file from one end to the other you can use a 
        a) FileInputStream or a 
        b) FileReader
 depending on whether you want to read the file as binary or textual data.

CASE 2:
        FILE CLASS 
        [FILE AND DIRECTORY INFORMATION  : FILE CLASS


CASE 3:
        PIPEDINPUTSTREAM| PIPED OUTSTREAM
        Pipes in Java IO provides the ability for two threads running in the same JVM to communicate. 
        PIPES CAN NE CONNECTED USING CONNECT METHOD

CASE 4:
        PIPEDINPUTSTREAM| PIPED OUTSTREAM
        Pipes in Java IO provides the ability for two threads running in the same JVM to communicate. 
        PIPES CAN NE CONNECTED USING CONNECT METHOD

CASE 5:
       INPUTSTREAM| OUTSTREAM
       
       INCASE OF  NETWORK CONNECTIONS 
CASE 6:
       -----------------------------
       READING  BYTE ARRAYS 
       ------------------------------
          byte[] byte = new byte[1024];
         InputStream input = new ByteArrayInputStream(bytes);
        
       while(input.read() != -1){
       }
     -------------------------------------------------------------------
       WRITING BYTE ARRAYS 
     --------------------------------------------------------------------
        ByteArrayOutputStream output = new ByteArrayOutputStream();

		output.write("This text is converted to bytes".getBytes("UTF-8"));

		byte[] bytes = output.toByteArray();
     -----------------------------------------------------------------------    
       
  CASE 7 :
	  System.in  :
	  System.out :
	  System.err :
  ---------------------------------------------------------------------------
  CASE 8: use BufferedInput/Output Streams ,when you want to read 
  
  to read a larger block of data from the disk and then iterate through that block byte for byte afterwards. 
 ---------------------------------------------------------------------------      
   
  1) InputStream input = new BufferedInputStream(
                        new FileInputStream("c:\\data\\input-file.txt"));
   
   2) Setting Buffer Size of a BufferedInputStream
   
    int bufferSize = 8 * 1024;
    
	InputStream input = new BufferedInputStream(
	                      new FileInputStream("c:\\data\\input-file.txt"),
	                      bufferSize
	    );
	   
   3)
       OutputStream output = new BufferedOutputStream(
                      new FileOutputStream("c:\\data\\output-file.txt"));	   
   
   4)
   
   
--------------------------------------------------------------------------------------------------------------
 CASE 9 : PUSHBACK STREAM
--------------------------------------------------------------------------------------------------------------

The PushbackInputStream is intended to be used when you parse data from an InputStream. Sometimes you need
to read ahead a few bytes to see what is coming, before you can determine how to interpret the current byte.
The PushbackInputStream allows you to do that. Well, actually it allows you to push the read bytes back into the stream. 
These bytes will then be read again the next time you call read().

PushbackInputStream Example

PushbackInputStream input = new PushbackInputStream(
                                new FileInputStream("c:\\data\\input.txt"));

int data = input.read();

input.unread(data);



int pushbackLimit = 8;
PushbackInputStream input = new PushbackInputStream(
                                new FileInputStream("c:\\data\\input.txt"),
                                pushbackLimit);
                                
                                
 CASE 10 :  The Java DataInputStream class enables you to read Java primitives (int, float, long etc.) from an InputStream 
 instead of only raw bytes. You wrap an InputStream in a DataInputStream and then you can read Java primitives 
 from the DataInputStream. That is why it is called DataInputStream - because it reads data (numbers) instead of just bytes.
 
   
 CASE 11: 
 The Java DataInputStream class enables you to read Java primitives (int, float, long etc.) 
 from an InputStream instead of only raw bytes. You wrap an InputStream in a DataInputStream and 
 then you can read Java primitives from the DataInputStream. That is why it is called DataInputStream - 
 because it reads data (numbers) instead of just bytes.
DataInputStream dataInputStream = new DataInputStream(new FileInputStream("binary.data"));

int    aByte   = input.read();
int    anInt   = input.readInt();
float  aFloat  = input.readFloat();
double aDouble = input.readDouble();
//etc.

input.close();
-------------------------------------------------------------------------------------------------------------
-------------------------------------------------------------------------------------------------------------

CCASE 12:
	

	 *
	 */
	
	
	
/**
 * 
 * ---------------
 case1 :Reader
 
 
 Reader reader = new FileReader("c:\\data\\myfile.txt");

    int data = reader.read();
    while(data != -1){
        char dataChar = (char) data;
        data = reader.read();
    }

 
 
 case 2 : 
 
 Reader reader = new InputStreamReader(inputStream);

 
 case 3 :
 
 
 Writer writer = new OutputStreamWriter(outputStream);
 
-------------------------------------------------------------------------------------
CASE 4 : IMP CASE

Reader reader = new BufferedReader(new FileReader(...));

Writer writer = new BufferedWriter(new FileWriter(...));



------------------------------------------------------------------------------------
CASE 5:

------------------------------------------------------------------------------------


------------------------------------------------------------------------------------


------------------------------------------------------------------------------------


------------------------------------------------------------------------------------


------------------------------------------------------------------------------------


------------------------------------------------------------------------------------


------------------------------------------------------------------------------------


------------------------------------------------------------------------------------


------------------------------------------------------------------------------------



 */
	
	
	
	
	
	
	
	
	
	
	public static void main(String args[]){
		
		
		
	}
	
	
	public static void readFromFile(){
			
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
