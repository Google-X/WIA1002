/*
 * Stack Class
 */
package T5;

public class Stack<T> implements ADTStack<T>{
    
    private ListNode head;
    private int leftParentheses = 0;
    private int rightParentheses = 0;
    private boolean startWithLeftParentheses = false;
    
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
// For question 2
//        if(!isFull()) head = new ListNode(t, head);
        head = new ListNode(t, head);
        
// For question 5
        if(getSize() == 1 && t.equals('(')) startWithLeftParentheses = true;
        if(t.equals('(')) leftParentheses++;
        else if(t.equals(')')) rightParentheses++;
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
    
    public void showStackReverse(){
        if(head == null) System.out.println("Empty Stack");
        else {
            ListNode c = head;
            while(c != null){
                System.out.print(c.toStringReverse());
                c = c.getLink();
            }
        }
    }
    
    @Override
    public boolean isFull() {
        return getSize() >= MAX;
    }
    
    public boolean balanceParentheses(){
        if(startWithLeftParentheses)
            if(peek().equals(')'))
                if(leftParentheses == rightParentheses)
                    return true;
        return false;
    }
}
