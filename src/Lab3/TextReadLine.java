/*
 * 2. Define a recursive method that read lines of text from one file and then output the lines in reserve order in another file. 
 */
package Lab3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TextReadLine {
//    public static void main(String[] args) {
//        
//        File source = new File("C:/Users/User/Documents/NetBeansProjects/WIA1002/src/Lab3/Files/TextReadLineFile.txt");
//        File destination = new File("C:/Users/User/Documents/NetBeansProjects/WIA1002/src/Lab3/Files/TextReadLineReverse.txt");
//        
//        try{
//            Scanner s = new Scanner(new FileInputStream(source));
//            PrintWriter pw = new PrintWriter(new FileOutputStream(destination));
//            
//            WriteReverse(s, pw);
//            
//            pw.close();
//            s.close();
//        } catch (FileNotFoundException fnf){
//            System.err.println("File not found!");
//        }
//         
//    }
//    
//    public static void WriteReverse(Scanner s, PrintWriter pw){
//        String text = "";
//        if(s.hasNextLine()){
//            text = s.nextLine();
//            text = reverse(text, text.length()) + "\n";
//            WriteReverse(s, pw);
//            pw.write(text);
//        }    
//    }
//    
//    public static String reverse(String text, int index){
//        if(index == 1) return "" + text.charAt(0);
//        return text.charAt(index - 1) + reverse(text, --index);
//    }
    
    public static void main(String[] args) throws IOException {
        try (BufferedReader in = new BufferedReader(new FileReader("in.txt")); 
                PrintWriter out = new PrintWriter(new FileWriter("out.txt"))) {
            printReverse(in, out); 
        }
    }
    
    private static void printReverse(BufferedReader in, PrintWriter out) throws IOException { 
        String line = in.readLine(); 
        if (line != null) { 
            printReverse(in, out); 
            out.println(line); 
        } 
    }
}
