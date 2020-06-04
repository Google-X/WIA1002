/*
 * 4. Write a program that generates 10 random integers (0-100) and insert into the LinkedList. Then, sort the integers using Bubble Sort in descending order (Modify the LinkedList.java).  
Example output:
 */
package T8;

import java.util.Random;

public class LinkedListBubbleSort {
    public static void main(String[] args) {
        
        Random r = new Random();
        
        LinkedList<Integer> list = new LinkedList<>(false);
        for(int i = 0; i < 10; i++) list.addLastNode(r.nextInt(101));
        
        System.out.print("The random integers are : ");
        list.showList();
        
        System.out.println("\nBubble Sort - Descending Order");
        list.bubbleSort();
        list.showList();
        
    }
}
