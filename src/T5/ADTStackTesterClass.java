/*
 * 2. Create an ADT stack named ArrayStack. The ADT consists of the following method and the maximum size of the ADT is 10. a. Constructor b. isEmpty c. isFull d. getSize e. Push f. Pop g. Peek h. showStack    
Example output: 

Stack implementation using Array
Insert three nodes into the stack
 <-- D <-- N <-- A
Pop one node from the stack
 <-- N <-- A
The element on the top of the stack is N
 <-- N <-- A
The number of elements in the stack is 2

 */
package T5;

public class ADTStackTesterClass {
    public static void main(String[] args) {
        
        System.out.println("Stack implementation using Array");
        char[] chList = "AND".toCharArray();
        
        ArrayStack<Character> st = new ArrayStack<>();
        for(char c : chList) st.push(c);
        
        System.out.println("Insert three nodes into the stack");
        st.showStack();
        
        System.out.println("\nPop one node from the stack");
        st.pop();
        st.showStack();
        
        System.out.println("\nThe element on the top of the stakc is " + st.peek());
        st.showStack();
        
        System.out.println("\nThe number of elements in the stack is " + st.getSize());
        
    }
}
