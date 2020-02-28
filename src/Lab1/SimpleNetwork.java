/*
 * 3. Create a class SimpleNetwork to simulate ping command. The class consists of the name, IP address, subnet mask and status (on/off) of a host. The host can only ping each other if the hosts are from the same network. The host is from same network if the (host IP address AND host Subnet Mask) is equal to (destination IP address AND host Subnet Mask). Create a Tester class to test the program, given output below. 

Host Name: Host 1 IP: 10.1.1.1 Subnet Mask: 255.255.255.224 Status: UP
Host Name: Host 2 IP: 10.1.1.2 Subnet Mask: 255.255.255.224 Status: DOWN
Host Name: Host 3 IP: 10.1.1.70 Subnet Mask: 255.255.255.224 Status: UP
Host Name: Host 4 IP: 10.1.1.15 Subnet Mask: 255.255.255.224 Status: UP
Host 1 cannot ping Host 2 because the destination Host 2 is down.
Host 1 cannot ping Host 3 because the destination Host 3 is located in different network.
Host 1 can ping Host 4.

 */
package Lab1;

import java.util.regex.Pattern;

public class SimpleNetwork {
    private String name, IP, subnetMask;
    private boolean status;

    public SimpleNetwork(String name, String IP, String subnetMask, boolean status) {
        this.name = name;
        this.IP = IP;
        this.subnetMask = subnetMask;
        this.status = status;
    }

    public String getName() {
        return name;
    }
    
    public String getIP() {
        return IP;
    }

    public String getSubnetMask() {
        return subnetMask;
    }

    public boolean isStatus() {
        return status;
    }
    
    public void ping(SimpleNetwork n1){
        
        // Status
        if(this.isStatus() == false){
            System.out.printf("%s cannot ping %s because the destination %s is down.\n", this.getName(), n1.getName(), this.getName());
        } else if (n1.isStatus() == false){
            System.out.printf("%s cannot ping %s because the destination %s is down.\n", this.getName(), n1.getName(), n1.getName());
        } else {
            
            // IP and Subnet Mask
            if(ipANDsm(n1)){
                System.out.printf("%s can ping %s.\n", this.getName(), n1.getName());
            } else {
                System.out.printf("%s cannot ping %s because the destination %s is located in different network.\n", this.getName(), n1.getName(), n1.getName());
            }
        }
        
    }
    
    public boolean ipANDsm(SimpleNetwork n1){
        
        for(int i = 3; i >= 0; i--){
            
            int[] ip1 = new int[8];
            int[] ip2 = new int[8];
            int[] sn1 = new int[8];
            int[] sn2 = new int[8];
            String AND1 = "";
            String AND2 = "";
            
            // First IP and Subnet Mask
            String ip1TempStr = String.format("%08d", Integer.parseInt(Integer.toBinaryString(Integer.parseInt(this.IP.split(Pattern.quote("."))[i]))));
            String sn1TempStr = String.format("%08d", Integer.parseInt(Integer.toBinaryString(Integer.parseInt(this.subnetMask.split(Pattern.quote("."))[i]))));
            
            // Second IP and Subnet Mask
            String ip2TempStr = String.format("%08d", Integer.parseInt(Integer.toBinaryString(Integer.parseInt(n1.getIP().split(Pattern.quote("."))[i]))));
            String sn2TempStr = String.format("%08d", Integer.parseInt(Integer.toBinaryString(Integer.parseInt(n1.getSubnetMask().split(Pattern.quote("."))[i]))));
            
            
            for(int j = 0; j < 8; j++){
                ip1[j] = Integer.parseInt(String.valueOf(ip1TempStr.charAt(j)));
                ip2[j] = Integer.parseInt(String.valueOf(ip2TempStr.charAt(j)));
                sn1[j] = Integer.parseInt(String.valueOf(sn1TempStr.charAt(j)));
                sn2[j] = Integer.parseInt(String.valueOf(sn2TempStr.charAt(j)));
            }
            
//            System.out.println("IP1: " + ip1TempStr);
//            for(int z : ip1) System.out.print(z);
//            System.out.println("\nSN1: " + sn1TempStr);
//            for(int z : sn1) System.out.print(z);
//            System.out.println("\nIP2: " + ip2TempStr);
//            for(int z : ip2) System.out.print(z);
//            System.out.println("\nSN2: " + sn2TempStr);
//            for(int z : sn1) System.out.print(z);
            
            
            for(int k = 0; k < 8; k++){
                AND1 += ip1[k] & sn1[k];
                AND2 += ip2[k] & sn2[k];
                
//                if(k == 7){
//                    System.out.println("AND 1: " + AND1);
//                    System.out.println("AND 2: " + AND2);
//                    System.out.println("DONE\n");
//                }
            }
            
            if(!AND1.equals(AND2)) return false;
            
        }
        
        return true;
    }
    
    public String toString() {
        return "Host Name: " + name + " IP: " + IP + " Subnet Mask: " + subnetMask + " Status: " + status;
    }
    
}
