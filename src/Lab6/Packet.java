/*
 * 5. Create a program to simulate the processing of network packet. The network devices forward the packet according to the type of packet. The voice packet has highest priority as compared to video packet and data packet. Create a Packet class that consists of the type of packet and the priority. [Continues in PriorityQueue]

Example output: [BOTTOM]
 */
package Lab6;

import java.util.Random;

public class Packet {
    
    private Random r = new Random();
    private String dataType;
    private int priority;
    private int order;
    private String[] packet = {"Data", "Video", "Voice"};
    
    public Packet(int order){
        dataType = packet[r.nextInt(packet.length)];
        this.order = order;
        setPriority();
    }

    public String getDataType() {
        return dataType;
    }
    
    public int getPriority() {
        return priority;
    }
    
    public int getOrder() {
        return order;
    }
    
    private void setPriority() {
        switch(dataType){
            case "Data":
                priority = 0;
                break;
            case "Video":
                priority = 1;
                break;
            case "Voice":
                priority = 2;
                break;
            default:
        }
    }
    
    public String toString(){
        return String.format("%s %d (Priority=%d)", dataType, order, priority);
    }
    
}
