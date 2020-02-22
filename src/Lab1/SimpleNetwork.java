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
    
    public String toString() {
        return "Host Name: " + name + " IP: " + IP + " Subnet Mask: " + subnetMask + " Status: " + status;
    }
    
}
