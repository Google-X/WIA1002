/*
 * Lab 4 Questions are at below
 */
package Lab4;

import java.util.Random;
import java.util.Scanner;

public class TesterClass {
    public static void main(String[] args) {
        /*
//Question 1
        System.out.println("Question 1");
        Random r = new Random();
        /**
         * b = addLastNode()
         * f = addFirstNode();
         * s = sort the list
         */
        /*
        LinkedList<Byte> b = new LinkedList();
        LinkedList<Byte> f = new LinkedList();
        LinkedList<Byte> s = new LinkedList();
        
        System.out.print("The random numbers are : ");
        for(byte i = 0; i < 10; i++){
            byte num = (byte) r.nextInt(101);
            System.out.print(num + " ");
            b.addLastNode(num);
            f.addFirstNode(num);
            s.addSortNode(num);
        }
        
        System.out.println("\nInsert the random numbers at the back of the linked list");
        b.showList();
        
        System.out.println("\nInsert the random numbers at the front of the linked list");
        f.showList();
        
        System.out.println("\nInsert the random numbers in a sorted linked list");
        s.showList();
        System.out.println();
        */
// Question 2
        Scanner sc = new Scanner(System.in);
        System.out.println("\nQuestion 2");
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
        
// Question 3
    }
    
    public static void reverseBack(LinkedList list, int size){
        if(list.length()%2 == 0){
            if(size >= list.length()/2 + 1){
                Comparable tmp = list.get(size-1);
                list.set(list.get(list.length()-size), size-1);
                list.set(tmp, list.length()-size);
                reverseBack(list, size-1);
            }
        } else {
            if(size > list.length()/2){
                Comparable tmp = list.get(size-1);
                list.set(list.get(list.length()-size), size-1);
                list.set(tmp, list.length()-size);
                reverseBack(list, size-1);
            }
        }
    }
}

/*
1. Create the ListNode.java and LinkedList.java file (only the methods required based on the lecture notes). Then create a tester class that generate 10 random numbers within 0 – 100. After that, insert the numbers into the linked list as below: 
a. Insert the random number at the back of the linked list. 
b. Insert the random number in front of the linked list.  
c. Insert the random number in a sorted linked list. You need to create a new method addSortNode in the LinkedList.java.  
Example output:

The random numbers are : 34 82 7 40 84 28 14 4 61 17

Insert the random numbers at the back of the linked list
34 --> 82 --> 7 --> 40 --> 84 --> 28 --> 14 --> 4 --> 61 --> 17

Insert the random numbers at the front of the linked list
17 --> 61 --> 4 --> 14 --> 28 --> 84 --> 40 --> 7 --> 82 --> 34

Insert the random numbers in a sorted linked list
4 --> 7 --> 14 --> 17 --> 28 --> 34 --> 40 --> 61 --> 82 --> 84


2. Write a program that inserts the characters of a sentence into a linked list. Then, perform the following: 
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