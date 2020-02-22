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

import java.io.File;

public class FileIOTesterClass {
    public static void main(String[] args) {
        
        File t = new File("C:/Users/User/Documents/NetBeansProjects/WIA1002/src/Lab1/Files/FileIOText.txt");
        File b = new File("C:/Users/User/Documents/NetBeansProjects/WIA1002/src/Lab1/Files/FileIOBinary.dat");
        String str = "Welcome to FSKTM!\nPlease register your matric number.\nPlease register your UMMail account.";
        
        FileIOTextFile text = new FileIOTextFile(t);
        text.write(str);
        text.read();
        
        FileIOBinaryFile binary = new FileIOBinaryFile(b);
        binary.write(str);
        binary.read();
    }
}
