/*
 * 5. Output 
Write to text file
Welcome to FSKTM!
Please register your matric number.
Please register your UMMail account.
Read from text file
Welcome to FSKTM!
Please register your matric number.
Please register your UMMail account.
 */
package Lab1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileIOTextFile implements FIleIO{
    private File f;

    public FileIOTextFile(File f) {
        this.f = f;
    }
    
    public void write(String str) {
        try{
            PrintWriter pw = new PrintWriter(new FileOutputStream(f));
            
            System.out.println("Write to text file");
            pw.print(str);
            System.out.println(str);
            
            pw.close();
        } catch (IOException io){
            System.err.println("Problem with file!");
        }
    }

    public void read() {
        try{
            Scanner s = new Scanner(new FileInputStream(f));
            
            System.out.println("Read from text file");
            while(s.hasNextLine()){
                System.out.println(s.nextLine());
            }
            
            s.close();
        } catch(FileNotFoundException fnf){
            System.err.println("File not found!");
        }
    }
}
