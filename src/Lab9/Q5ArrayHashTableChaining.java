/*
 * 5. Modify Q4 by using hash chain. Then, perform the following  
a. A method that returns the value of the element if the element can be found. 
b. A method that returns all the elements in the same location if the element can be found.  
Example output: [BELOW]
 */
package Lab9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Q5ArrayHashTableChaining {
    public static void main(String[] args) throws IOException {
        
        Scanner s = new Scanner(System.in);
        File f = new File("C:/Users/User/Documents/NetBeansProjects/WIA1002/src/Lab9/Files/Lab 9 Data File.txt");
        String str = "";
        
        System.out.println("The data set from the File");
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            for (String line = br.readLine(); line != null; line = br.readLine()) {
                str += line + "\n";
                System.out.println(line);
            }
        }
        
        String[] data = str.split("\\n");
        int[] keys = new int[data.length];
        String[] vals = new String[data.length];
        
        for(int i = 0; i < data.length; i++){
            keys[i] = Integer.parseInt(data[i].substring(0, 5));
            vals[i] = data[i].substring(6);
        }
        
//      START HERE
        Q5ArrayHashTable<Integer, String> HashTable = new Q5ArrayHashTable<>();
        for(int i = 0; i < keys.length; i++){
            HashTable.put(keys[i], vals[i]);
        }
        
        System.out.println("The Hash Table size is " + HashTable.getSize());
        System.out.print("Enter a PID to search : ");
        
        int PID = s.nextInt();
        if(HashTable.containsKey(PID)) {
            System.out.println("Product ID : " + PID + " " + HashTable.get(PID));
            HashTable.getLocation(PID);
        }
        else System.out.println("Product ID " + PID + " cannot be found");
        
//      TEST REMOVING
        int testRemove = 10203;
        System.out.println("\nTest removing key : " + testRemove);
        String name = HashTable.remove(testRemove);
        HashTable.showHashTable();
        
        System.out.println("Test locating key : 10863");
        PID = 10863;
        if(HashTable.containsKey(PID)) {
            System.out.println("Product ID : " + PID + " " + HashTable.get(PID));
            HashTable.getLocation(PID);
        }
        else System.out.println("Product ID " + PID + " cannot be found");
        
//      TEST ADDING BACK
        System.out.println("\nTest adding back key : " + testRemove);
        HashTable.put(testRemove, name);
        HashTable.showHashTable();
        
        System.out.println("Test locating key : 10863");
        PID = 10863;
        if(HashTable.containsKey(PID)) {
            System.out.println("Product ID : " + PID + " " + HashTable.get(PID));
            HashTable.getLocation(PID);
        }
        else System.out.println("Product ID " + PID + " cannot be found");
        
//      TEST AMEND SAME KEY
        System.out.println("\nTest amend value for key : " + testRemove);
        HashTable.put(testRemove, name + " V2");
        HashTable.showHashTable();
        
        System.out.println("Test locating key : 10863");
        PID = 10863;
        if(HashTable.containsKey(PID)) {
            System.out.println("Product ID : " + PID + " " + HashTable.get(PID));
            HashTable.getLocation(PID);
        }
        else System.out.println("Product ID " + PID + " cannot be found");
    }
}
/*
Example output:
The data set from the File
10203 Musang King
10425 Golden Phoenix
10311 XO
10403 D24
10719 Red Prawn
10714 Green Bamboo
10863 Black Pearl
10643 D101
The Hash Table size is 8
Enter a PID to search : 10354
Product ID 10354 cannot be found

The data set from the File
10203 Musang King
10425 Golden Phoenix
10311 XO
10403 D24
10719 Red Prawn
10714 Green Bamboo
10863 Black Pearl
10643 D101
The Hash Table size is 8
Enter a PID to search : 10863
Product ID : 10863 Black Pearl
The elements in the same location are : 
10203 : Musang King --> 10403 : D24 --> 10863 : Black Pearl --> 10643 : D101 --> 

EXAMPLE FOR REMOVING KEY & ADDING BACK
The data set from the File
10203 Musang King
10425 Golden Phoenix
10311 XO
10403 D24
10719 Red Prawn
10714 Green Bamboo
10863 Black Pearl
10643 D101
The Hash Table size is 8
Enter a PID to search : 10863
Product ID : 10863 Black Pearl
The elements in the same location are : 
10203 : Musang King --> 10403 : D24 --> 10863 : Black Pearl --> 10643 : D101 --> 

Test removing key : 10203
10403 : D24
10863 : Black Pearl
10643 : D101
10425 : Golden Phoenix
10311 : XO
10714 : Green Bamboo
10719 : Red Prawn
Test locating key : 10863
Product ID : 10863 Black Pearl
The elements in the same location are : 
10403 : D24 --> 10863 : Black Pearl --> 10643 : D101 --> 

Test adding back key : 10203
10403 : D24
10863 : Black Pearl
10643 : D101
10203 : Musang King
10425 : Golden Phoenix
10311 : XO
10714 : Green Bamboo
10719 : Red Prawn
Test locating key : 10863
Product ID : 10863 Black Pearl
The elements in the same location are : 
10403 : D24 --> 10863 : Black Pearl --> 10643 : D101 --> 10203 : Musang King --> 

Test amend value for key : 10203
10403 : D24
10863 : Black Pearl
10643 : D101
10203 : Musang King V2
10425 : Golden Phoenix
10311 : XO
10714 : Green Bamboo
10719 : Red Prawn
Test locating key : 10863
Product ID : 10863 Black Pearl
The elements in the same location are : 
10403 : D24 --> 10863 : Black Pearl --> 10643 : D101 --> 10203 : Musang King V2 --> 
*/