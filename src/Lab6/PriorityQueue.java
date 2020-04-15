/*
 * 5. [Continues] After that, create a PriorityQueue class that consists of all the methods from the Queue class. Then, modify the enqueue method to allow the highest priority packet to queue first and the dequeue method to allow the highest priority packet to process first.
 */
package Lab6;

public class PriorityQueue<T> {
    private ListNode head;

    public PriorityQueue() {
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
    
    public void enqueue(T t, int priority){
        ListNode n = new ListNode(t, null);
        if(head == null) head = n;
        else {
            PriorityQueue<String> tmp = new PriorityQueue<>();
            ListNode c = head;
            
            // Comparing the queue priority
            while(!isEmpty() && Integer.parseInt(String.valueOf((peek().charAt(peek().length()-2)))) >= priority) {
                tmp.enqueue((String)dequeue());
            }
            
            tmp.enqueue((String)t); // Inserting the VIP queuer
            while(!isEmpty()) tmp.enqueue((String)dequeue()); // move the remaining queuer to the new Queue
            while(!tmp.isEmpty()) enqueue((T)tmp.dequeue()); // move all the sorted Queue back into the original Queue
        }
    }
    
    public void enqueue(T t){
        ListNode n = new ListNode(t, null);
        if(head == null) head = n;
        else {
            ListNode c = head;
            while(c.getLink() != null) c = c.getLink();
            c.setLink(n);
        }
    }
    
    public T dequeue(){
        if(head == null) return null;
        T t = (T) head.getData();
        head = head.getLink();
        return t;
    }
    
    public String peek(){
        if(head == null) return null;
        return (String) head.getData();
    }
    
    public void showQueue(){
        if(head == null) System.err.println("EmptyQueueException");
        else {
            ListNode c = head;
            while(c != null){
                System.out.print(c.toStringNetwork());
                c = c.getLink();
            }
        }
    }
}
