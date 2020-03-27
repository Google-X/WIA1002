/*
 * 1. Create the ListNode.java and LinkedList.java file (only the methods required based on the lecture notes). Then create a tester class that generate 10 random numbers within 0 – 100. After that, insert the numbers into the linked list as below: 
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
 */
package Lab4;

import java.util.Random;

public class TesterClass {
    public static void main(String[] args) {
        Random r = new Random();
        /**
         * b = addLastNode(); f = addFirstNode(); s = sort the list
         */
        LinkedList<Byte> b = new LinkedList();
        LinkedList<Byte> f = new LinkedList();
        LinkedList<Byte> s = new LinkedList();

        System.out.print("The random numbers are : ");
        for (byte i = 0; i < 10; i++) {
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
    }
}
