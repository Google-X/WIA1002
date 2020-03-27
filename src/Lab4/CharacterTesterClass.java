/*
 * 2. Write a program that inserts the characters of a sentence into a linked list. Then, perform the following: 
a. Create a new method splitList in the LinkedList.java. If the number of characters is odd, the extra character is inserted in the first list. 
b. Create a new method alternateList in the LinkedList.java. Split the list into two by alternating the elements from the original list. 
c. Create a new method mergeList in the LinkedList.java. Merge two lists into one by alternating the elements from both of the lists. 
d. Create a recursive method in the LinkedList.java to reverse the list.   
e. Create a static recursive method in the tester class to reverse the list.  
Example output
        
Enter a word : Banking
The original list : B --> a --> n --> k --> i --> n --> g -->

Split the list into two
First List : B --> a --> n --> k -->
Second List : i --> n --> g -->

Split the list by alternating the nodes
First List : B --> n --> i --> g -->
Second List : a --> k --> n -->

Merge First List and Second List by alternating the nodes
B --> a --> n --> k --> i --> n --> g -->

Reverse the list. Recursive method in the LinkedList
g --> n --> i --> k --> n --> a --> B -->

Reverse the list. Recursive method in tester class
B --> a --> n --> k --> i --> n --> g -->

 */
package Lab4;

import static Lab4.TesterClass.reverseBack;
import java.util.Scanner;

public class CharacterTesterClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a word : ");
        String q2temp = sc.nextLine();
        LinkedList<Character> q2 = new LinkedList<>();
        for(char c : q2temp.toCharArray()) q2.addLastNode(c);
        
        System.out.println("The original list : ");
        q2.showList();
        
        // 2a. splitList()
        LinkedList<Character>[] split = q2.splitList();
        System.out.println("\n\nSplit the list into two");
        LinkedList<Character> splitList1 = split[0];
        LinkedList<Character> splitList2 = split[1];
        System.out.print("First List : ");
        splitList1.showList();
        System.out.print("\nSecond List : ");
        splitList2.showList();
        
        // 2b. alternateList()
        LinkedList<Character>[] alternate = q2.alternateList();
        System.out.println("\n\nSplit the list by alternating the nodes");
        LinkedList<Character> alternateList1 = alternate[0];
        LinkedList<Character> alternateList2 = alternate[1];
        System.out.print("First List : ");
        alternateList1.showList();
        System.out.print("\nSecond List : ");
        alternateList2.showList();
        
        // 2c. mergeList()
        System.out.println("\n\nMerge First List and Second List by alternating the nodes");
        alternateList1.mergeList(alternateList2);
        alternateList1.showList();
        
        // 2d. reverse();
        System.out.println("\n\nReverse the list. Recursive method in the LinkedList");
        alternateList1.reverse(alternateList1.length());
        alternateList1.showList();
        
        // 2e. reverse recursive in class
        System.out.println("\n\nReverse the list. Recursive method in tester class");
        reverseBack(alternateList1, alternateList1.length());
        alternateList1.showList();
    }
}
