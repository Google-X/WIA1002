/*
 * 5. [Continues] After that, create a PriorityQueue class that consists of all the methods from the Queue class. Then, modify the enqueue method to allow the highest priority packet to queue first and the dequeue method to allow the highest priority packet to process first.
 */
package Lab6;

public class PriorityQueue<T extends Packet>{
    private PriorityQListNode head;

    public PriorityQueue() {
        head = null;
    }

    public boolean isEmpty(){
        return head == null;
    }
    
    public int getSize(){
        int i = 0;
        PriorityQListNode c = head;
        while(c != null){
            i++;
            c = c.getLink();
        }
        return i;
    }
    
    public void enqueuePriority(T t){
        PriorityQListNode n = new PriorityQListNode(t, null);
        if(head == null) head = n;
        else {
            PriorityQueue<T> tmp = new PriorityQueue<>();
            PriorityQListNode c = head;
            
            // Comparing the queue priority
            // compareTo() here or at the Packet Class(need to extend Comparable)
            while(!isEmpty() && peek().getPriority() >= t.getPriority()) {
                tmp.enqueue(dequeue());
            }
            
            tmp.enqueue(t); // Inserting the VIP queuer
            while(!isEmpty()) tmp.enqueue(dequeue()); // move the remaining queuer to the new Queue
            while(!tmp.isEmpty()) enqueue(tmp.dequeue()); // move all the sorted Queue back into the original Queue
        }
    }
    
    private void enqueue(T t){
        PriorityQListNode n = new PriorityQListNode(t, null);
        if(head == null) head = n;
        else {
            PriorityQListNode c = head;
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
    
    public T peek(){
        if(head == null) return null;
        return (T) head.getData();
    }
    
    public void showQueue(){
        if(head == null) System.err.println("EmptyQueueException");
        else {
            PriorityQListNode c = head;
            while(c != null){
                System.out.println(c.getData().getDataType() + " " + c.getData().getOrder() + " (Priority=" + c.getData().getPriority() + ')');
                c = c.getLink();
            }
        }
    }
}
