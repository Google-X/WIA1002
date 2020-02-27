/*
 * 3. Create a class SimpleNetwork to simulate ping command. The class consists of the name, IP address, subnet mask and status (on/off) of a host. The host can only ping each other if the hosts are from the same network. The host is from same network if the (host IP address AND host Subnet Mask) is equal to (destination IP address AND host Subnet Mask). Create a Tester class to test the program, given output below. 

Host Name: Host 1 IP: 10.1.1.1 Subnet Mask: 255.255.255.224 Status: UP
Host Name: Host 2 IP: 10.1.1.2 Subnet Mask: 255.255.255.224 Status: DOWN
Host Name: Host 3 IP: 10.1.1.70 Subnet Mask: 255.255.255.224 Status: UP
Host Name: Host 4 IP: 10.1.1.1 Subnet Mask: 255.255.255.224 Status: UP
Host 1 cannot ping Host 2 because the destination Host 2 is down.
Host 1 cannot ping Host 3 because the destination Host 3 is located in different network.
Host 1 can ping Host 4.

 */
package Lab1;

public class SimpleNetworkTesterClass {
    public static void main(String[] args) {
        
        SimpleNetwork[] s = new SimpleNetwork[4];
        s[0] = new SimpleNetwork("Host 1", "10.1.1.1", "255.255.255.224", true);
        s[1] = new SimpleNetwork("Host 2", "10.1.1.2", "255.255.255.224", false);
        s[2] = new SimpleNetwork("Host 3", "10.1.1.70", "255.255.255.224", true);
        s[3] = new SimpleNetwork("Host 4", "10.1.1.1", "255.255.255.224", true);
        
        for(int i = 0; i < s.length; i++){
            System.out.println(s[i].toString());
        }
        
        ping(s[0], s[1]);
        ping(s[0], s[2]);
        ping(s[0], s[3]);
    }
    
    public static void ping(SimpleNetwork n1, SimpleNetwork n2){
        
        // Status
        if(n1.isStatus() == false){
            System.out.printf("%s cannot ping %s because the destination %s is down.\n", n1.getName(), n2.getName(), n1.getName());
        } else if (n2.isStatus() == false){
            System.out.printf("%s cannot ping %s because the destination %s is down.\n", n1.getName(), n2.getName(), n2.getName());
        } else {
            
            // IP and Subnet Mask
            if(n1.getIP().equals(n2.getIP()) && n1.getSubnetMask().equals(n2.getSubnetMask())){
                System.out.printf("%s can ping %s.\n", n1.getName(), n2.getName());
            } else {
                System.out.printf("%s cannot ping %s because the destination %s is located in different network.\n", n1.getName(), n2.getName(), n2.getName());
            }
        }
        
    }
}
