/*
 * 4. Create a program to read the products from a text file (lab9Q4.txt). The product consists of PID and Description. Store the products in a class Q4ArrayHashTableHashing. (Modify the ArrayHashTable created in Q3). Create the hash method that hashes the key by modulus the array size. Use linear probing if Collision occurs. Then, perform the following 
a. A method that returns the value of the element if the element can be found. 
b. A method that returns the location of the element if the element can be found.  
Example output: [BELOW]
 */
package Lab9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Q4ArrayHashTableHashing {
    public static void main(String[] args) throws IOException {
        
        Scanner s = new Scanner(System.in);
        File f = new File("C:/Users/User/Documents/NetBeansProjects/WIA1002/src/Lab9/Files/Lab 9 Data File.txt");
        String str = "";
        
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            for (String line = br.readLine(); line != null; line = br.readLine()) {
                str += line + "\n";
            }
        }
        
        String[] data = str.split("\\n");
        int[] keys = new int[data.length];
        String[] vals = new String[data.length];
        
        for(int i = 0; i < data.length; i++){
            keys[i] = Integer.parseInt(data[i].substring(0, 5));
            vals[i] = data[i].substring(6);
        }
        
        Q4ArrayHashTable<Integer, String> HashTable = new Q4ArrayHashTable<>();
        for(int i = 0; i < keys.length; i++){
            HashTable.put(keys[i], vals[i]);
        }
        
        System.out.println("The data set from the File");
        HashTable.showHashTable();
        
        System.out.println("The Hash Table size is " + HashTable.getSize());
        System.out.print("Enter a PID to search : ");
        
        int PID = s.nextInt();
        if(HashTable.containsKey(PID)) {
            System.out.println("Product ID : " + PID + " " + HashTable.get(PID));
            System.out.println("Location : " + HashTable.getLocation(PID));
        }
        else System.out.println("Product ID " + PID + " cannot be found");
        
        // Test to get linear probing to index 0
        int testAdding = 10739;
        System.out.println("\nAdding new limited durian : 10739 % 20 == 19 --> same as Red Prawn");
        HashTable.put(testAdding, "Zero-To-Hero");
        HashTable.showHashTable();
        System.out.println("The Hash Table size is " + HashTable.getSize());
        System.out.println("Product ID : " + testAdding + " " + HashTable.get(testAdding));
        System.out.println("Location : " + HashTable.getLocation(testAdding));
        
        // Test removing
        int testRemove = 10643;
        System.out.println("\nRemoving key : " + testRemove);
        HashTable.remove(testRemove);
        HashTable.showHashTable();
        System.out.println("The Hash Table size is " + HashTable.getSize());
        
        // Test amending
        int testAmend = testAdding;
        System.out.println("\nAmending new limited durian : 10739 % 20 == 19 --> same as Red Prawn");
        HashTable.put(testAmend, "Zero-To-Hero v2");
        HashTable.showHashTable();
        System.out.println("The Hash Table size is " + HashTable.getSize());
        System.out.println("Product ID : " + testAmend + " " + HashTable.get(testAmend));
        System.out.println("Location : " + HashTable.getLocation(testAmend));
    }
}
/*
Example output:
run:
The data set from the File
10203 : Musang King
10403 : D24
10425 : Golden Phoenix
10863 : Black Pearl
10643 : D101
10311 : XO
10714 : Green Bamboo
10719 : Red Prawn
The Hash Table size is 8
Enter a PID to search : 10544
Product ID 10544 cannot be found

The data set from the File
10203 : Musang King
10403 : D24
10425 : Golden Phoenix
10863 : Black Pearl
10643 : D101
10311 : XO
10714 : Green Bamboo
10719 : Red Prawn
The Hash Table size is 8
Enter a PID to search : 10863
Product ID : 10863 Black Pearl
Location : 6

Example of adding and removing key
Adding new limited durian : 10739 % 20 == 19 --> same as Red Prawn
10739 : Zero-To-Hero
10203 : Musang King
10403 : D24
10425 : Golden Phoenix
10863 : Black Pearl
10643 : D101
10311 : XO
10714 : Green Bamboo
10719 : Red Prawn
The Hash Table size is 9
Product ID : 10739 Zero-To-Hero
Location : 0

Removing key : 10643
10739 : Zero-To-Hero
10203 : Musang King
10403 : D24
10425 : Golden Phoenix
10863 : Black Pearl
10311 : XO
10714 : Green Bamboo
10719 : Red Prawn
The Hash Table size is 8

Example of amending the value of a key
Amending new limited durian : 10739 % 20 == 19 --> same as Red Prawn
10739 : Zero-To-Hero v2
10203 : Musang King
10403 : D24
10425 : Golden Phoenix
10863 : Black Pearl
10311 : XO
10714 : Green Bamboo
10719 : Red Prawn
The Hash Table size is 8
Product ID : 10739 Zero-To-Hero v2
Location : 0
*/