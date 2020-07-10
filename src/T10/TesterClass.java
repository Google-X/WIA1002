/*
 * 1. Create the graph based on the figure below. Then, remove the edge from vertex B to C and get the weight from Vertex C to F and get the adjacent list of B. [Figure in pdf file]

Example output: [BELOW]

 */
package T10;

import java.util.ArrayList;

public class TesterClass {
    public static void main(String[] args) {
        
        ArrayGraph<Character, Double> GRAPH = new ArrayGraph<>(20);
        System.out.println("Creating a graph with 7 vertices and 7 edges");
        
        // Add vertices
        for(char a = 'A'; a < 'H'; a++){
            GRAPH.addVertice(a);
        }
        
        // Add edges and weight
        GRAPH.addEdge('A', 'B', 0.4);
        GRAPH.addEdge('A', 'C', 0.3);
        GRAPH.addEdge('B', 'C', 0.1);
        GRAPH.addEdge('B', 'D', 0.2);
        GRAPH.addEdge('B', 'E', 0.7);
        GRAPH.addEdge('C', 'F', 0.3);
        GRAPH.addEdge('F', 'G', 0.4);
        GRAPH.showGraph();
        
        // Remove edge
        System.out.println("Remove edge from B to C");
        GRAPH.deleteEdge('B', 'C');
        GRAPH.showGraph();
        
        // Get the weightage
        System.out.println("The weightage from C to F: " + GRAPH.getWeight('C', 'F'));
        System.out.println("The adjacent of B : ");
        ArrayList<Character> list = GRAPH.getAdjadent('B');
        for(char c : list) System.out.print(c + " ");
        
    }
}
/*
Example output:
Creating a graph with 7 vertices and 7 edges
A --> 
 -> B : 0.4 -> C : 0.3
B --> 
 -> C : 0.1 -> D : 0.2 -> E : 0.7
C --> 
 -> F : 0.3
D --> 

E --> 

F --> 
 -> G : 0.4
G --> 

Remove edge from B to C
A --> 
 -> B : 0.4 -> C : 0.3
B --> 
 -> D : 0.2 -> E : 0.7
C --> 
 -> F : 0.3
D --> 

E --> 

F --> 
 -> G : 0.4
G --> 

The weightage from C to F: 0.3
The adjacent of B : D E
*/