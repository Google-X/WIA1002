/*
 * 5. Create a program to simulate the processing of network packet. The network devices forward the packet according to the type of packet. The voice packet has highest priority as compared to video packet and data packet. Create a Packet class that consists of the type of packet and the priority. [Continues in PriorityQueue]

Example output: [BOTTOM]
 */
package Lab6;

import java.util.Random;

public class PacketTesterClass {
    public static void main(String[] args) {
        
        Random r = new Random();
        
        int num = 10;
        Packet[] list = new Packet[num];
        
        System.out.println(num + " packet(s) arrived");
        for(int i = 0; i < list.length; i++) {
            list[i] = new Packet(i+1);
            System.out.println(list[i].toString());
        }
        
        PriorityQueue<Packet> Q = new PriorityQueue<>();
        for(int i = 0; i < num; i++){
            Q.enqueuePriority(list[i]);
        }
        
        System.out.printf("\nProcessing %d network packets\n", num);
        Q.showQueue();
    }
}
/*
Example output:
10 packets arrived
Video 1 (Priority=1)
Voice 2 (Priority=2)
Data 3 (Priority=0)
Data 4 (Priority=0)
Voice 5 (Priority=2)
Video 6 (Priority=1)
Voice 7 (Priority=2)
Voice 8 (Priority=2)
Data 9 (Priority=0)
Video 10 (Priority=1)

Processing 10 network packets
Voice 2 (Priority=2)
Voice 5 (Priority=2)
Voice 6 (Priority=2)
Voice 7 (Priority=2)
Video 1 (Priority=1)
Video 6 (Priority=1)
Video 10 (Priority=1)
Data 3 (Priority=0)
Data 4 (Priority=0)
Data 9 (Priority=0)
*/