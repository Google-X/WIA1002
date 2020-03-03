/*
 * 2. Create a TextFile based implementation named TextFileLog that implements the SimpleLog interface. 
The interface contains the following specifications: 
 A method to insert item to the log 
 A method to check whether the log is full 
 A method to get the size of the log 
 A method to check whether the item exists in the log 
 A method to delete the log 
 A method to display all items in the log  
Create a Tester class to test the program, given output below. 

Create a text file log with maximum record equal to 5
Text File Log Size 5
James
Ahmad
Siti
Ramesh
John

Adding another record
The log is full
Searching for Siti in the file
Text File Log contains Siti
Clear the text file log
Text File Log Size 0
 */
package Lab2;

// What is textFile based Implementation meant here?
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TextFileLog<T extends Comparable<T>> implements SimpleLog<T> {

    private int maxSize;
    private File f = new File("Names.txt");

    public TextFileLog(int maxSize) {
        this.maxSize = maxSize;
        System.out.println("Create a text file log with maximum record equal to " + maxSize);
        System.out.println("Text File Log Size " + maxSize);
    }

    public void insert(T t) {
        if (!isFull()) {

            try {
                PrintWriter pw = new PrintWriter(new FileOutputStream(f, true));

                pw.println(t);

                pw.close();
            } catch (IOException ioe) {
                System.err.println("Problem with files");
            }

        } else {
            System.out.println("\nAdding another record\nThe log is full");
        }
    }

    public boolean isFull() {
        return getSize() == maxSize;
    }

    public int getSize() {
        int size = 0;

        try {
            Scanner s = new Scanner(new FileInputStream(f));

            while (s.hasNextLine()) {
                size++;
                s.nextLine();
            }

            s.close();
        } catch (FileNotFoundException fnf) {
            System.err.println("File not found!");
        }

        return size;
    }

    public boolean search(T t) {
        
        System.out.printf("Searching for %s in the file\n", t);
        
        try {
            Scanner s = new Scanner(new FileInputStream(f));
            
            while(s.hasNextLine()){
                if (s.nextLine().equals(t)) {
                    s.close();
                    return true;
                }
            }
            // OR
            /*
            if (s.nextLine().compareTo(String.valueOf(t)) == 0) {
                s.close();
                return true;
            }
            */

            s.close();
        } catch (FileNotFoundException fnf) {
            System.err.println("File not found!");
        }

        return false;
    }

    public void clear() {
        System.out.println("Clear the text file log");
        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream(f));

            pw.write("");

            pw.close();
        } catch (IOException ioe) {
            System.err.println("Problem with files");
        }
        System.out.println("Text File Log Size " + getSize());
    }

    public void read() {
        try {
            Scanner s = new Scanner(new FileInputStream(f));

            while (s.hasNextLine()) {
                System.out.println(s.nextLine());
            }

            s.close();
        } catch (FileNotFoundException fnf) {
            System.err.println("File not found!");
        }
    }
}
