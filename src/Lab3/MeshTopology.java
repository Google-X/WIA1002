/*
 * 1. There are n switches in the campus. You are required to create a mesh topology for the switches. Write a recursive method to returns the total number of connections required for n switches in the campus. 

Mesh Topology
There are 4 switches in the campus.
The total number of connections required is 6
There are 7 switches in the campus.
The total number of connections required is 21

n(n-1)/2 cable link are required for mesh, n for ring, n-1 cable link for bus, and n cable link for star topology
 */
package Lab3;


public class MeshTopology {
    public static void main(String[] args) {
        
        System.out.println("Simple formula: n(n-1)/2");
        int[] s = new int[10];
        for(int i = 0; i < s.length; i++) s[i] = i;
        for(int i = 1; i < s.length; i++) System.out.printf("%d switch(es) requires %d connections.\n", s[i], s[i]*(s[i]-1)/2);
        
        
    // Using recursion
        System.out.println("\nUsing Recursion\n===============");
        
        int[] switches = {4, 7};
        for(int i = 0; i < switches.length; i++){
            System.out.printf("There are %d switches in the campus.\n", switches[i]);
            System.out.printf("The total number of connections required in %d\n", connection(switches[i]));
        }
    }
    
    public static int connection(int N){
        if(N <= 1) return 0;
        if(N == 2) return 1;
        return (N-1) + connection(N-1);
    }
}
