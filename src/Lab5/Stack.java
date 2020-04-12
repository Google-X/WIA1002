/*
 * Lab 5: Stack Class
 */
package Lab5;

public class Stack<E> {
    
    private ListNode head;
    
    public Stack() {
        head = null;
    }
    
    public boolean isEmpty(){
        return head == null;
    }
    
    public int getSize(){
        int count = 0;
        ListNode c = head;
        while(c != null) {
            count++;
            c = c.getLink();
        }
        return count;
    }
    
    public void push(E e){
        head = new ListNode(e, head);
    }
    
    public E pop(){
        if(head == null) return null;
        E tmp = (E) head.getData();
        head = head.getLink();
        return tmp;
    }
    
    public E peek(){
        if(head == null) return null;
        return (E) head.getData();
    }
    
    public void showStack(){
        if(isEmpty()) System.out.println("The stack is empty");
        else {
            ListNode c = head;
            while(c != null){
                System.out.print(c.toString());
                c = c.getLink();
            }
        }
    }
}
