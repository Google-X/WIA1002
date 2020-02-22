/*
 * 5. Output
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

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileIOBinaryFile implements FIleIO{
    private File f;

    public FileIOBinaryFile(File f) {
        this.f = f;
    }
    
    public void write(String str) {
        try{
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f));
            
            System.out.println("Write to binary file");
            out.writeUTF(str);
            System.out.println(str);
            
            out.close();
        } catch (IOException io){
            System.err.println("Problem with file!");
        }
    }

    public void read() {
        try{
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));
            
            System.out.println("Read from binary file");
            try{
                while(true){
                    System.out.println(in.readUTF());
                }
            } catch (EOFException eof){   
            }
            
            in.close();
        } catch(FileNotFoundException fnf){
            System.err.println("File not found!");
        } catch (IOException ex) {
            System.out.println("Problem with file!");
        }
    }    
}
