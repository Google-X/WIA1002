/*
 * To test which methokd of deleting is faster
 */
package T4;

public class TestTime {

    public static void main(String[] args) {
// ADDING ADDING ADDING ADDING ADDING ADDING ADDING ADDING ADDING ADDING ADDING ADDING ADDING ADDING ADDING
// SHORTER SHORTER SHORTER SHORTER SHORTER SHORTER SHORTER SHORTER SHORTER SHORTER SHORTER
        LinkedList<Integer> b = new LinkedList<>();
        b.addNode(1);
        b.addNode(2);
        b.addNode(3);
        b.addNode(4);
        b.addNode(5);
        long tshorter = System.nanoTime();
        b.addNodeByPositionShorter(-5, 2);
        tshorter = System.nanoTime() - tshorter;
        System.out.println("\nShorter Algorithm");
        b.showList();
        System.out.println("Time taken(ns): " + tshorter);
        
//// LONGER LONGER LONGER LONGER LONGER LONGER LONGER LONGER LONGER LONGER LONGER LONGER LONGER
        LinkedList<Integer> a = new LinkedList<>();
        a.addNode(1);
        a.addNode(2);
        a.addNode(3);
        a.addNode(4);
        a.addNode(5);
        long tlonger = System.nanoTime();
        a.addNodeByPosition(-5, 2);
        tlonger = System.nanoTime() - tlonger;
        System.out.println("\nLonger Algorithm");
        a.showList();
        System.out.println("Time taken(ns): " + tlonger);
        
        
// REMOVE REMOVE REMOVE REMOVE REMOVE REMOVE REMOVE REMOVE REMOVE REMOVE REMOVE REMOVE REMOVE REMOVE
// SHORTER SHORTER SHORTER SHORTER SHORTER SHORTER SHORTER SHORTER SHORTER SHORTER SHORTER
        long deleteNodeShort = 0l;
        LinkedList<Integer> c = new LinkedList<>();
        for(int i = 0; i < 50; i++){
            c.addNode(i);
        }
        System.out.println("\nShorter Algorithm");
        c.showList();
        for(int i = 0; i < 50; i++){
            long t = System.nanoTime();
            c.deleteNodeShorter();
            t = System.nanoTime() - t;
            deleteNodeShort += t;
        }
        System.out.println("50 Loop time taken(ns): " + deleteNodeShort);
        System.out.println("Average time taken(ns): " + (Double)(deleteNodeShort/50.0));
        
//// LONGER LONGER LONGER LONGER LONGER LONGER LONGER LONGER LONGER LONGER LONGER LONGER LONGER
        long deleteNode = 0l;
        LinkedList<Integer> d = new LinkedList<>();
        for(int i = 0; i < 50; i++){
            d.addNode(i);
        }
        System.out.println("\nLonger Algorithm");
        d.showList();
        for(int i = 0; i < 50; i++){
            long t = System.nanoTime();
            d.deleteNode();
            t = System.nanoTime() - t;
            deleteNode += t;
        }
        System.out.println("50 Loop time taken(ns): " + deleteNode);
        System.out.println("Average time taken(ns): " + (Double)(deleteNode/50.0));
    }
}
