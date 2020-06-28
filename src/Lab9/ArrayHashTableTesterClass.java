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
        
        System.out.println("Remove 200-101");
        ArrayMap.remove("200-101");
        display();
        
        System.out.print("Enter a code to search : ");
        String search = s.nextLine();
        if(!ArrayMap.containsKey(search)){
            System.out.println("There is not key : " + search);
        }
        
    }
    
    public static void display(){
        System.out.println("The number of course is " + ArrayMap.getSize());
        ArrayMap.showHashTable();
        System.out.println();
    }
}
