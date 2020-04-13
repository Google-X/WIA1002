/*
 * 5. An XML document contains XML Elements. An XML element begins with <elementName> and ends with </elementName>. An element can contain text and other elements. The element name is case sensitive. (Note: an XML document can only have one root element) Write a program to validate whether an XML document is valid; assume that the element name is valid. Create the xml document using notepad and save as test.xml.   
 */
package Lab5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class XML {
    public static void main(String[] args) {
        
        File folder = new File("C:/Users/User/Documents/NetBeansProjects/WIA1002/src/Lab5/XML Source");
        File[] files = folder.listFiles();
        String[] notes = new String[files.length];
        
        Scanner s;
        
        for(int i=0;i<files.length;i++){
            notes[i] = "";
            try{
                s = new Scanner(new FileInputStream(files[i]));
                
                while(s.hasNextLine()) notes[i] += s.nextLine() + "\n";
                
                s.close();
            } catch(FileNotFoundException fnf){
                System.err.println("File not found!");
            }
        }
        
        for(String n : notes){
            Stack<String> st = new Stack<>();
            System.out.println("Contents of XML file");
            System.out.print(n);
            check(n, st);
        }
    }
    
    public static void check(String notes, Stack<String> st){
        char[] c = notes.toCharArray();
        for(int i=0;i<c.length;i++){
            if(c[i] == '<'){
                String tag = "";
                if(c[i+1] == '/'){
                    while(c[i] != '>') {
                        tag += c[i];
                        i++;
                    }
                    tag += '>';
                    if(!st.peek().equals(tag.replace("/", ""))){
                        System.out.printf("Begin Element : %s Invalid ending element : %s\n\n", st.peek(), tag);
                        return;
                    } else {
                        st.pop();
                    }
                } else {
                    while(c[i] != '>'){
                        tag += c[i];
                        i++;
                    }
                    tag += '>';
                    if(!st.isEmpty() && st.peek().equals(tag)){
                        System.out.println("Duplicate root element " + tag + "\n");
                        return;
                    } 
                    st.push(tag);
                }
            }
        }
        System.out.println("The xml document 1s valid.");
    }
    
}
/*
Example output:
Contents of XML file 
<note> 
<test>Sample</test> 
<note>Data</note> 
</note> 
Duplicate root element <note> 

Contents of XML file 
<note> 
<ID>1002</ID> 
<Name>Data Structure</name> 
</note> 
Begin Element : <Name> Invalid ending element : </name> 

Contents of XML file 
<note> 
<ID>1002</ID> 
<Name>Data Structure</Name> 
</Lecturer>Ang<Lecturer> 
</note> 
Begin Element : <note> Invalid ending element : </Lecturer> 

Contents of XML file 
<note> 
<ID>1002</ID> 
<Name>Data Structure</Name> 
<Day>Tuesday</Day> 
</note> 
The xml document is valid.
*/