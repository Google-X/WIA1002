/*
 * 5. Version 2 of answering the packet question using compareTo() instead of modifying the enqueue() method
 */
package Lab6;

import java.util.Random;

public class PacketV2{
    
    final String[] dataList = {"Data", "Video", "Voice"};
    private Random r = new Random();
    
    private String dataType;
    private int order;
    private int priority;

    public PacketV2(int order) {
        dataType = dataList[r.nextInt(dataList.length)];
        this.order = order;
        priority = getPriority();
    }
    
    public int getPriority(){
        switch(dataType){
            case "Data": return 0;
            case "Video": return 1;
            case "Voice": return 2;
            default: return -1;
        }
    }
    
    public boolean compareTo(PacketV2 p){
        return priority >= p.getPriority();
    }
    
    public String toString(){
        return String.format("%s %d (Priority=%d)", dataType, order, priority);
    }
}
