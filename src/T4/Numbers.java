/*
 * 1. Create the ListNode.java and LinkedList.java file (only the methods required based on the lecture notes). Then, create a tester class that insert the following numbers into a linked list. (23.1, 36.5, 12.8, 42.6, 32.8).   
Example output:

The number in the linked list
23.1 --> 36.5 --> 12.8 --> 42.6 --> 32.8 -->

2. After that, add 10.5 for each number in the list that is more than 20. You need to add the required methods to the LinkedList.java file  
Example output:

The number in the linked list after update
33.6 --> 47.0 --> 12.8 --> 53.1 --> 43.3 -->
 */
package T4;

public class Numbers {
    public static void main(String[] args) {
        
        LinkedList<Double> numLinkedList = new LinkedList<>();
        Double[] list = {23.1, 36.5, 12.8, 42.6, 32.8};
        
// Q1
        for(double i : list) numLinkedList.addNode(i);
        System.out.println("The number in the linked list");
        numLinkedList.showList();
        
// Q2
        numLinkedList.additionNode();
        System.out.println("The number in the linked list after update");
        numLinkedList.showList();
    }
}
