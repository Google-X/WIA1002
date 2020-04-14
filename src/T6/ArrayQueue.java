/*
 * ArrayQueue Queue class
 */
package T6;

public class ArrayQueue<T> implements ArrayQueueADT<T>{

    private ListNode head;

    public ArrayQueue() {
        head = null;
    }
    
    public boolean isEmpty() {
        return head == null;
    }
    
    public boolean isFull() {
        return getSize() == MAX;
    }
    
    public int getSize() {
        int i = 0;
        ListNode c = head;
        while(c != null){
            i++;
            c = c.getLink();
        }
        return i;
    }
    
    public void enqueue(T t) {
        if(!isFull()){
            ListNode n = new ListNode(t, null);
            if(head == null) head = n;
            else {
                ListNode c = head;
                while(c.getLink() != null) c = c.getLink();
                c.setLink(n);
            }
        } else {
            System.out.println("Cannot queue currently. Queue is full.");
        }
    }
    
    public T dequeue() {
        if(head == null) return null;
        T t = (T) head.getData();
        head = head.getLink();
        return t;
    }
    
    public T peek() {
        if(head == null) return null;
        return (T) head.getData();
    }
    
    public void showQueue() {
        if(head == null) System.out.println("EmptyQueueException");
        else {
            ListNode c = head;
            while(c != null){
                System.out.print(c.toString());
                c = c.getLink();
            }
        }
    }
}
