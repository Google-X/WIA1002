/*
 * 3. Insert the table below into the ArrayMap  
Code        Name 
100-101     ICND 1 
200-101     ICND 2 
200-120     CCNA Routing and Switching 
210-260     CCNA Security  

After that, 
1. insert a new map entry 300-101 ROUTE
2. modify the 210-260 as CCNA RS Security
3. remove the 200-101
4. enter a code to search.   
Example output: [BELOW]
 */
package Lab9;

import java.util.Scanner;

public class ArrayHashTableTesterClass {
    
    static ArrayHashTable<String, String> ArrayMap;
    static Scanner s = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        String[] code = {"100-101", "200-101", "200-120", "210-260"};
        String[] name = {"ICND 1", "ICND 2", "CCNA Routing and Switching", "CCNA Security"};
        
        ArrayMap = new ArrayHashTable<>();
        for(int i = 0; i < code.length; i++){
            ArrayMap.put(code[i], name[i]);
        }
        display();
        
        System.out.println("Adding a new course");
        ArrayMap.put("300-101", "ROUTE");
        display();
        
        System.out.println("Modifying 210-260");
        ArrayMap.put("210-260", "CCNA RS Security");
        display();
        
        System.out.println("Remove the course 200-101");
        ArrayMap.remove("200-101");
        display();
        
        System.out.print("Enter a code to search : ");
        ArrayMap.search(s.nextLine());
        
    }
    
    public static void display(){
        System.out.println("The number of course is " + ArrayMap.getSize());
        ArrayMap.showHashTable();
        System.out.println();
    }
}
/*
Example output:
The number of course is 4
100-101 : ICND 1 | 200-101 : ICND 2 | 200-120 : CCNA Routing and Switching | 210-260 : CCNA Security | 
Adding a new course
The number of course is 5
100-101 : ICND 1 | 200-101 : ICND 2 | 200-120 : CCNA Routing and Switching | 210-260 : CCNA Security | 300-101 : ROUTE | 
Modifying 210-260
The number of course is 5
100-101 : ICND 1 | 200-101 : ICND 2 | 200-120 : CCNA Routing and Switching | 210-260 : CCNA RS Security | 300-101 : ROUTE | 
Remove the course 200-101
The number of course is 4
100-101 : ICND 1 | 300-101 : ROUTE | 200-120 : CCNA Routing and Switching | 210-260 : CCNA RS Security | 
Enter a code to search : 210-260
Course 210-260 : CCNA RS Security
*/