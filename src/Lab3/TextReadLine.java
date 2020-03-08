/*
 * 2. Define a recursive method that read lines of text from one file and then output the lines in reserve order in another file. 
 */
package Lab3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TextReadLine {
    public static void main(String[] args) {
        
        File source = new File("C:/Users/User/Documents/NetBeansProjects/WIA1002/src/Lab3/Files/TextReadLineFile.txt");
        int line = getLine(source);
        String str = readLine(source, line, 1);
//        System.out.println(str);
        String reverse = reverse(str, str.length());
//        System.out.println(reverse);
        
        File destination = new File("C:/Users/User/Documents/NetBeansProjects/WIA1002/src/Lab3/Files/TextReadLineReverse.txt");
        String[] reversed = reverse.split("\\n");
//        System.out.println(reversed.length);
        writeLine(destination, 1, reversed);
        
    }
    
    public static int getLine(File f){
        int line = 0;
        
        try{
            Scanner s = new Scanner(new FileInputStream(f));
            
            while(s.hasNextLine()){
                line++;
                s.nextLine();
            }
            
            s.close();
        } catch (FileNotFoundException fnf){
            System.err.println("File not found!");
        }
        
        return line;
    }
    
    public static String readLine(File f, int lineNumber, int current){
        if(current == lineNumber+1) return "";
        String fileText = "";
        
        try{
            Scanner s = new Scanner(new FileInputStream(f));
            
            for(int i = 0; i < current-1; i++) s.nextLine();
            fileText += s.nextLine() + "\n";
            
            s.close();
        } catch (FileNotFoundException fnf){
            System.err.println("File not found!");
        } 
        return fileText + readLine(f, lineNumber, current+1);
    }
    
    public static String reverse(String s, int index){
        
        if(index == 1) return "" + s.charAt(index - 1);
        return s.charAt(index - 1) + reverse(s, --index);
        
    }
    
    public static void writeLine(File f, int lineNumber, String[] text){
        if(lineNumber == text.length) System.out.println("Done writing reverse text.");
        
        if (lineNumber < text.length){
            try{
                PrintWriter pw = new PrintWriter(new FileOutputStream(f, true));

                pw.println(text[lineNumber]);

                pw.close();
            } catch (IOException ioe){
                System.err.println("");
            }

            writeLine(f, lineNumber+1, text);
        }
        
    }
    
}
