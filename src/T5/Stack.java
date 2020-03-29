/*
 * Stack Class
 */
package T5;

public class Stack<T> {
    
    private ListNode head;

    public Stack() {
        head = null;
    }
    
    public boolean isEmpty(){
        return head == null;
    }
    
    public int getSize(){
        int i = 0;
        ListNode c = head;
        while(c != null){
            i++;
            c = c.getLink();
        }
        return i;
    }
    
    public void push(T t){
        head = new ListNode(t, head);
    }
    
    public T pop(){
        if(head == null) return null;
        T tmp = (T) head.getData();
        head = head.getLink();
        return tmp;
    }
    
    public T peek(){
        return (T) head.getData();
    }
    
    public void showStack(){
        if(head == null) System.out.println("Empty Stack");
        else {
            ListNode c = head;
            while(c != null){
                System.out.print(c.toString());
                c = c.getLink();
            }
        }
    }
}
