/*
 * 5. Version 2 of answering the packet question using compareTo() instead of modifying the enqueue() method
 */
package Lab6;

public class PacketV2TesterClass {
    public static void main(String[] args) {
        
        Queue<PacketV2> incoming = new Queue<>();
        int packetNum = 10;
        
        System.out.println(packetNum + " packets arrived");
        for(int i = 0; i < packetNum; i++){
            PacketV2 temp = new PacketV2(i+1);
            System.out.println(temp.toString());
            incoming.enqueue(temp);
        }
        
        System.out.printf("\nProcessing %d network packets\n", packetNum);
        Queue<PacketV2> sorted = new Queue<>();
        for(int i = 0; i < packetNum; i++){
            if(i == 0) sorted.enqueue(incoming.dequeue());
            else {
                
                Queue<PacketV2> tmpList = new Queue();
                while(!sorted.isEmpty() && sorted.peek().getPriority() >= incoming.peek().getPriority()) tmpList.enqueue(sorted.dequeue());
            
                tmpList.enqueue(incoming.dequeue()); // Inserting the VIP queuer
                while(!sorted.isEmpty()) tmpList.enqueue(sorted.dequeue()); // move the remaining queuer to the new Queue
                while(!tmpList.isEmpty()) sorted.enqueue(tmpList.dequeue()); // move all the sorted Queue back into the original Queue
                
            }
        }
        while(!sorted.isEmpty()) System.out.println(sorted.dequeue());
    }
}
