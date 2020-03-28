/*
 * 6. Create the DoubleListNode.java and DoubleLinkedList.java file (only the methods required based on the lecture notes). Then create a tester class that generate 10 random numbers within 0 – 100. After that, insert the numbers into the doubly linked list and perform the following actions:  
a. Remove a random number from third position. 
b. Replace the number in seventh position with 999. 
c. Remove all even number from the doubly linked list  

Example output:

The random numbers are : 100 13 48 52 13 14 55 86 76 28 
Insert the random numbers into the doubly linked list
 <-- 100 --> <-- 13 --> <-- 48 --> <-- 52 --> <-- 13 --> <-- 14 --> <-- 55 --> <-- 86 --> <-- 76 --> <-- 28 -->

Remove a random number from third position
 <-- 100 --> <-- 13 --> <-- 52 --> <-- 13 --> <-- 14 --> <-- 55 --> <-- 86 --> <-- 76 --> <-- 28 -->

Replace the number in seventh position with 999
 <-- 100 --> <-- 13 --> <-- 52 --> <-- 13 --> <-- 14 --> <-- 55 --> <-- 999 --> <-- 76 --> <-- 28 -->

Remove all even number from the doubly linked list 
 <-- 13 --> <-- 13 --> <-- 55 --> <-- 999 --> 

*/
package Lab4;

import java.util.Random;

public class NumberGenerator {
    public static void main(String[] args) {
        
        Random r = new Random();
        DoubleLinkedList<Integer> li = new DoubleLinkedList<>();
        
        System.out.print("The random numbers are : ");
        int tmp;
        for(int i=0;i<10;i++){
            tmp = r.nextInt(101);
            System.out.print(tmp + " ");
            li.addRightNode(tmp);
        }
        
        System.out.println("Insert the random numbers into the doubly linked list");
        li.showList();
        
        System.out.println("\nRemove a random number from third position");
        li.deleteNodeByPosition(2);
        li.showList();
        
        System.out.println("\nReplace the number in seventh position with 999");
        // Set method will be construct later
        li.addNodeByPosition(999, 6);
        li.deleteNodeByPosition(7);
        li.showList();
        
        System.out.println("\nRemove all even number from the doubly linked list");
        li.deleteEven();
        li.showList();
    }
}
