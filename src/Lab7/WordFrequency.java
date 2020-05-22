/*
 * 2. Create a word frequency generator program. The program will read a text file (lab7Q2.txt) and generate an alphabetical listing of the unique words that the file contains, along with a count of how many times each word occurs.   
Example output: [BELOW]
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
/*
Example output: 
0001 BST -->
0001 In -->
0001 They -->
0001 a -->
0001 addition -->
0002 allow -->
0001 an -->
0002 and -->
0001 are -->
0001 as -->
0001 be -->
0002 binary -->
0001 by -->
0001 called -->
0001 can -->
0001 computer -->
0001 containers -->
0001 data -->
0001 dynamic -->
0001 either -->
0001 etc -->
0001 fast -->
0001 finding -->
0001 implement -->
0001 in -->
0001 item -->
0003 items -->
0001 its -->
0001 key -->
0002 lookup -->
0001 memory -->
0001 names -->
0001 numbers -->
0003 of -->
0002 or -->
0001 ordered -->
0001 particular -->
0001 removal -->
0001 science -->
0001 search -->
0001 sets -->
0001 sometimes -->
0001 sorted -->
0001 store -->
0001 structures -->
0001 such -->
0001 tables -->
0002 that -->
0001 to -->
0002 trees -->
0001 type -->
*/