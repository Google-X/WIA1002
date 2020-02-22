/*
 * 5. Create FileIO Interface. The interface consists of two methods that write to the file and read from the file. Create two classes that implement the interface. The TextFile class read and writes sentences to the text file while the BinaryFile class read and writes sentences to the binary file. Create a Tester class to test the program, given output below

Write to text file
Welcome to FSKTM!
Please register your matric number.
Please register your UMMail account.

Read from text file
Welcome to FSKTM!
Please register your matric number.
Please register your UMMail account.

Write to binary file
Welcome to FSKTM!
Please register your matric number.
Please register your UMMail account.

Read from binary file
Welcome to FSKTM!
Please register your matric number.
Please register your UMMail account.

 */
package Lab1;

public interface FIleIO {
    public void write(String str);
    public void read();
}
