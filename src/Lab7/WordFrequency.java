/*
 * 2. Create a word frequency generator program. The program will read a text file (lab7Q2.txt) and generate an alphabetical listing of the unique words that the file contains, along with a count of how many times each word occurs.   
Example output: 



 */
package Lab7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class WordFrequency {

    public static void main(String[] args) throws IOException {

        File file = new File("C:/Users/User/Documents/NetBeansProjects/WIA1002/src/Lab7/Source/lab7Q2.txt");
        String str = "";

        try (BufferedReader s = new BufferedReader(new FileReader(file))) {
            for (String line = s.readLine(); line != null; line = s.readLine()) {
                str += line + "\n";
            }
        }
        
        str = str.replaceAll("[^a-zA-Z0-9\\s+]", "").replaceAll("\\n", "");
        System.out.println(str);

        String[] word = str.split(" ");
        BST<String> bst = new BST<>();
        for(String w : word) bst.addNode(w);
        bst.wordCounter();
        
    }
}
