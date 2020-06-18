/*
 * 2. Write a program that generates 10 random integers (0-20) and insert into the LinkedList. Then, perform the following using Linear Search (modify the LinkedList.java)  
a. A method that returns true if the element can be found. 
b. A method that returns the number of occurrence for the element. 
c. A method that returns true if the elements can be found. (search by range) 
d. A method that returns the number of occurrence for the elements. (search by range)

Example : BELOW
 */
package Lab9;

import java.util.Random;
import java.util.Scanner;

public class LinkedListSearch {
    public static void main(String[] args) {
        
        LinkedList<Integer> list = new LinkedList<>();
        Random r = new Random();
        Scanner s = new Scanner(System.in);
        
        for(int i = 0; i < 10; i++){
            list.addNode(r.nextInt(21));
        }
        
        System.out.print("The random integers are : ");
        list.showList();
        
        System.out.println("\nLinear Search");
        System.out.print("Enter a number to search: ");
        int search = s.nextInt();
        
        if(list.contains(search)){
            System.out.println(search + " is found");
            System.out.printf("The number of %d is %d\n", search, list.occurenceOf(search));
        } else {
            System.out.println(search + " is not found");
        }
        
        System.out.print("Enter two numbers to search (begin end) : ");
        int begin = s.nextInt();
        int end = s.nextInt();
        
        if(list.containsBetween(begin, end)){
            System.out.printf("The integer can be found in between %d and %d\n", begin, end);
            System.out.printf("The number of the elements in between %d and %d in the data set is %d\n", begin, end, list.occurenceBetween(begin, end));
        } else {
            System.out.printf("No integer can be found in between %d and %d\n", begin, end);
        }
    }
}
/*
Example 1:
The random integers are : 17 --> 16 --> 13 --> 3 --> 5 --> 11 --> 17 --> 18 --> 4 --> 3 --> 

Linear Search
Enter a number to search: 0
0 is not found
Enter two numbers to search (begin end) : 0 1
No integer can be found in between 0 and 1

Example 2:
The random integers are : 19 --> 18 --> 6 --> 8 --> 19 --> 7 --> 14 --> 19 --> 19 --> 4 --> 

Linear Search
Enter a number to search: 19
19 is found
The number of 19 is 4
Enter two numbers to search (begin end) : 5 7
The integer can be found in between 5 and 7
The number of the elements in between 5 and 7 in the data set is 2
*/