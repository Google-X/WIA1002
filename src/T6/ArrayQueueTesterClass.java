/*
 * 2. Tester Class for ArrayQueue

Example output:
Queue Implementation using Array
Enqueue three nodes
B --> M --> W -->
Dequeue one node
M --> W -->
The front node of the queue is M
The queue size is 2
 */
package T6;

public class ArrayQueueTesterClass {
    public static void main(String[] args) {
        
        String str = "BMW";
        
        System.out.println("Queue Implementation using Array");
        ArrayQueue<Character> ArrQ = new ArrayQueue<>();
        
        System.out.println("Enqueue three nodes");
        for(char c : str.toCharArray()) ArrQ.enqueue(c);
        ArrQ.showQueue();
        
        System.out.println("\nDequeue one node");
        ArrQ.dequeue();
        ArrQ.showQueue();
        
        System.out.println("\nThe front node of the queue is " + ArrQ.peek());
        System.out.println("The queue size is " + ArrQ.getSize());
        
        ArrQ.enqueue(' ');
        ArrQ.enqueue('I');
        ArrQ.enqueue('S');
        ArrQ.enqueue(' ');
        ArrQ.enqueue('E');
        ArrQ.enqueue('X');
        ArrQ.enqueue('P');
        ArrQ.enqueue('E');
        ArrQ.enqueue('N');
        ArrQ.enqueue('S');
        ArrQ.enqueue('I');
        ArrQ.enqueue('V');
        ArrQ.enqueue('E');
        
        ArrQ.showQueue();
        System.out.println("");
        ArrQ.showQueueV2();
    }
}
