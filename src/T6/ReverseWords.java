/*
 * 6. Write a program to reverse the words in a sentence. (Only Queue is allowed for this question)  
Example output: 

Enter a sentence : A queue is a First In First Out (FIFO) data structure.
The original queue : A --> queue --> is --> a --> First --> In --> First --> Out --> (FIFO) --> data --> structure.
Reverse all the elements in the queue : structure. --> data --> (FIFO) --> Out --> First --> In --> First --> a --> is --> queue --> A --> 

 */
package T6;

import java.util.Scanner;

public class ReverseWords {
    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        
        System.out.print("Enter a sentence : ");
        String[] tmp = s.nextLine().split(" ");
        
        Queue<String> Q = new Queue<>();
        for(String t : tmp) Q.enqueue(t);
        
        System.out.print("The original queue : ");
        Q.showQueue();
        
//        Q.reverse(Q.getSize());
        Q.reverseQueue();
        System.out.print("\nReverse all the elements in the queue : ");
        Q.showQueue();
        System.out.println();
        
    }
}
