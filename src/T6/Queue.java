/*
 * Queue class
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
    
    // Tutorial Question 3 showQueue
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
    }
    
    // Tutorial Question 4 showQueue
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
}
