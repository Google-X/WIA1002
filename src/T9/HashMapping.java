/*
 * 3. Create the MapNode.java and HashTable.java file (only the methods required based on the lecture notes).
Then, insert the table below into the HashTable.  
Code (Key)      Name (Value) 
100-101         ICND 1 
200-101         ICND 2 
200-120         CCNA Routing and Switching 
210-260         CCNA Security  
After that, enter a code to search.   
Example output: [BELOW]
 */
package T9;

import java.util.Scanner;

public class HashMapping {
    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        HashTable<String, String> hasher = new HashTable<>();
        String[] code = {"100-101", "200-101", "200-120", "210-260"};
        String[] name = {"ICND 1", "ICND 2", "CCNA Routing and Switching", "CCNA Security"};
        
        for(int i = 0; i < code.length; i++){
            hasher.put(code[i], name[i]);
        }
        
        System.out.println("HashTable");
        System.out.println("The number of the elements in the Hash Table : " + hasher.getSize());
        hasher.showHashTable();
        
        System.out.print("\nEnter a code to search : ");
        String c = s.nextLine();
        
        if(hasher.containsKey(c)){
            System.out.printf("Course %s : %s\n", c, hasher.get(c));
        } else {
            System.out.printf("The course %s cannot be found\n", c);
        }
    }
}
/*
Example Output 1:
HashTable
The number of the elements in the Hash Table : 4
100-101:ICND 1 --> 200-101:ICND 2 --> 200-120:CCNA Routing and Switching --> 210-260:CCNA Security --> 
Enter a code to search : 123-456
The course 123-456 cannot be found

Example Output 2:
HashTable
The number of the elements in the Hash Table : 4
100-101:ICND 1 --> 200-101:ICND 2 --> 200-120:CCNA Routing and Switching --> 210-260:CCNA Security --> 
Enter a code to search : 200-120
Course 200-120 : CCNA Routing and Switching
*/