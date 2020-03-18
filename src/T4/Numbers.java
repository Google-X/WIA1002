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
        
// Q4
        LinkedList<Integer> q4List = new LinkedList<>();
        int[] q4Arr = {23, 15, 17, 28, 12, 40};
        for(int i : q4Arr) q4List.addNode(i);
        System.out.println("\nQuestion 4:");
        q4List.showList();
        System.out.printf("Linked List has %d node(s)\n", q4List.length());
        System.out.printf("Total is %d\n", q4List.sum());
        System.out.printf("Total even number is %d\n", q4List.even());
    
// Q5
        System.out.println("\nQuestion 5:");
        LinkedList<Integer> q5List = new LinkedList<>();
        q5List.generateList(15, 0, 10);
        q5List.deleteAll(4);
        
// Q6
        System.out.println("\nQuestion 6:");
        int[] q6Arr = {78, 45, 34, 23, 17, 10, 8};
        LinkedList<Integer> q6List = new LinkedList<>();
        for(int i : q6Arr) q6List.addFrontNode(i);
        q6List.showList();
        q6List.showMedian();
        
    } 
}

/* QUESTIONS
 * 1. Create the ListNode.java and LinkedList.java file (only the methods required based on the lecture notes). Then, create a tester class that insert the following numbers into a linked list. (23.1, 36.5, 12.8, 42.6, 32.8).   
Example output:

The number in the linked list
23.1 --> 36.5 --> 12.8 --> 42.6 --> 32.8 -->

2. After that, add 10.5 for each number in the list that is more than 20. You need to add the required methods to the LinkedList.java file  
Example output:

The number in the linked list after update
33.6 --> 47.0 --> 12.8 --> 53.1 --> 43.3 -->

4. Modified the LinkedList.java file to include the following methods: 
a. Create a method that returns the sum of all Integers.  
b. Create a method that returns the number of even number. 
c. Write a program in the tester class that insert the following numbers into a linked list (23, 15, 17, 28, 12, 40). Then, display the sum of the numbers and the number of even number.  
Example output: 

23 --> 15 --> 17 --> 28 --> 12 --> 40 -->
Linked List has 6 node(s)
Total is 95
Total even number is 2

5. Modified the LinkedList.java file to include the following methods:  
a. Create a method that generates random number based on arguments. 
b. Create a method that deletes the nodes that match the integer value given.   
c. Write a program in the tester class that generate 15 random numbers within 0 - 10. Then, delete all the nodes where the number is equal to 4. 

Example output:
Linked List has 15 node(s)
10 --> 5 --> 5 --> 4 --> 3 --> 10 --> 2 --> 10 --> 9 --> 4 --> 8 --> 6 --> 10 --> 1 --> 9 -->
Delete the number 4 from the list.

Linked List has 13 node(s)
10 --> 5 --> 5 --> 3 --> 10 --> 2 --> 10 --> 9 --> 8 --> 6 --> 10 --> 1 --> 9 -->

6. Modified the LinkedList.java file to include the following methods: 
a. Create a method to insert node at the front. 
b. Create a method that returns the value of the middle element of a linked list. 
c. Write a program in the tester class that insert the following numbers into a linked list (78, 45, 34, 23, 17, 10, 8). Each number is added to the front position. Then, display the median.  
Example output:
8 --> 10 --> 17 --> 23 --> 34 --> 45 --> 78 --> 
The median is 23
 */