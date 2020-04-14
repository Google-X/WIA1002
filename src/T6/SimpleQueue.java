/*
 * 1. Create the ListNode.java and Queue.java file (only the methods required based on the lecture notes).  Then, perform the following: 
a. Insert three characters B, M, and W into the queue 
b. Remove one character from the queue 
c. Print the front element of the queue  
d. Print the number of elements in the queue  
Example output:

Queue Implementation using Linked List
Enqueue three nodes
B --> M --> W -->
Dequeue one node
M --> W -->
The front node of the queue is M
The queue size is 2

 */
package T6;

import T4.LinkedList;

public class SimpleQueue {
    public static void main(String[] args) {
        
        LinkedList<Character> list = new LinkedList<>();
        list.addNode('B');
        list.addNode('M');
        list.addNode('W');
        
        Queue<Character> Q = new Queue<>();
        for(int i = 0; i < list.length(); i++) Q.enqueue(list.get(i));
        
        System.out.println("Queue Implementation using Linked List");
        System.out.println("Enqueue three nodes");
        Q.showQueue();
        
        System.out.println("\nDequeue one node");
        Q.dequeue();
        Q.showQueue();
        
        System.out.println("\nThe front node of the queue is " + Q.peek());
        System.out.println("The queue size is " + Q.getSize());
        
    }
}
