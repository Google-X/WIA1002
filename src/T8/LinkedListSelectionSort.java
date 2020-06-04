/*
 * 3. Write a program that generates 10 random integers (0-100) and insert into the LinkedList. Then, sort the integers using Selection Sort in ascending order (Modify the LinkedList.java).  
Example output:

The random integers are : 83 --> 22 --> 96 --> 68 --> 12 --> 96 --> 95 --> 12 --> 57 --> 90 --> 
Selection Sort - Ascending Order
12 --> 12 --> 22 --> 57 --> 68 --> 83 --> 90 --> 95 --> 96 --> 96 --> 
 */
package T8;

import java.util.Random;

public class LinkedListSelectionSort {
    public static void main(String[] args) {

        Random r = new Random();
        
        LinkedList<Integer> list = new LinkedList<>(true);
        for(int i = 0; i < 10; i++) list.addLastNode(r.nextInt(101));
        
        System.out.print("The random integers are : ");
        list.showList();
        
        System.out.println("\nSelection Sort - Ascending Order");
        list.selectionSort();
        list.showList();
        
    }
}
