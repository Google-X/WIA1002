/*
 * Queue class change commit
 */
package T6;

public class Queue<T> {

    private ListNode head;

    public Queue() {
        head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int getSize() {
        int i = 0;
        ListNode c = head;
        while (c != null) {
            i++;
            c = c.getLink();
        }
        return i;
    }
    
    public void enqueue(T t){
        ListNode n = new ListNode(t, null);
        if(head == null) head = n;
        else {
            ListNode c = head;
            while(c.getLink() != null){
                c = c.getLink();
            }
            c.setLink(n);
        }
    }
    
    public T dequeue(){
        if(head == null) return null;
        T t = (T) head.getData();
        head = head.getLink();
        return t;
    }
    
    public T peek(){
        if(head == null) return null;
        return (T) head.getData();
    }
    
    public void showQueue(){
        if(head == null) System.out.println("EmptyQueueException");
        else {
            ListNode c = head;
            while(c != null){
                System.out.print(c.toString());
                c = c.getLink();
            }
        }   
    }
    
    // Question 3 showQueue
    /*
    public void showQueueCustomer(){
        if(head == null) System.out.println("EmptyQueueException");
        else {
            ListNode c = head;
            int count = 0;
            while(c != null){
                System.out.printf("Customer %d : %s", (count+1), c.toStringCustomer());
                c = c.getLink();
                count++;
            }
            System.out.println("Number of customer : " + count);
        }   
    }*/
    
    // Question 4 showQueue
    public String showQueuePalindrome(){
        if(head == null) return null;
        else {
            String tmp = "";
            ListNode c = head;
            while(c != null){
                tmp += c.toStringPalindrome();
                c = c.getLink();
            }
            return tmp;
        }
    }
    
    // Question 6 methods for reversing
    public void switchLastQueuer(T t){
        if(head != null){
            ListNode c = head;
            while(c.getLink() != null) c = c.getLink();
            c.setData(t);
        } else System.err.println("EmptyLinkedList Exception");
    }
    
    public T getLastQueuer(){
        if(head != null){
            ListNode c = head;
            while(c.getLink() != null) c = c.getLink();
            return (T) c.getData();
        } else {
            System.err.println("EmptyLinkedList Exception");
            return null;
        }
    }
    
    public void set(T t, int i){
        if(i == 0) head.setData(t);
        else if(i == getSize()-1) switchLastQueuer(t);
        else if(i >= getSize()) System.err.println("IndexOutOfBound Exception");
        else {
            ListNode c = head;
            for(int j=1;j<=i;j++) c = c.getLink();
            c.setData(t);
        }
    }
    
    public T get(int i){
        if(i == 0) return (T) head.getData();
        else if(i == getSize()-1) return getLastQueuer();
        else if(i >= getSize()){
            System.err.println("IndexOutOfBound Exception");
            return null;
        } else {
            ListNode c = head;
            for(int j=1;j<=i;j++) c = c.getLink();
            return (T) c.getData();
        }
    }
    
    // Another way is simply dequeue the first queue and enqueue the dequeued item to the new queue. [EASIER] NEED CHANGE
    public void reverse(int size){
        if(getSize()%2 == 0){
            if(size >= getSize()/2 + 1){
                T tmp = get(size-1);
                set(get(getSize()-size), size-1);
                set(tmp, getSize()-size);
                reverse(size-1);
            }
        } else {
            if(size > getSize()/2){
                T tmp = get(size-1);
                set(get(getSize()-size), size-1);
                set(tmp, getSize()-size);
                reverse(size-1);
            }
        }
    }
}
