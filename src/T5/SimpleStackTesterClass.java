/*
 * 1. Create the ListNode.java and Stack.java file (only the methods required based on the lecture notes).  Then, perform the following: a. Insert three characters A, N, and D into the stack b. Remove one character from the stack c. Print the element on top of the stack d. Print the number of elements in the stack  

Example output:

Stack implementation using Stack
Insert three nodes into the stack
 <-- D <-- N <-- A
Pop one node from the stack
 <-- N <-- A
The element on the top of the stack is N
 <-- N <-- A
The number of elements in the stack is 2

 */
package T5;

public class SimpleStackTesterClass {
    public static void main(String[] args) {
        
        System.out.println("Stack implementation using Stack");
        
        Stack<Character> st = new Stack<>();
        
        st.push('A');
        st.push('N');
        st.push('D');
        
        System.out.println("Insert three nodes into the stack");
        st.showStack();
        
        System.out.println("\nPop one node from the stack.");
        st.pop();
        st.showStack();
        
        System.out.println("\nThe element on the top of the stack is " + st.peek());
        st.showStack();
        
        System.out.println("\nThe number of elements in the stack is " + st.getSize());
        
    }
}
