/*
 * To test which methokd of deleting is faster
 */
package T4;

public class TestTime {

    public static void main(String[] args) {

        long deleteNode = 0l;
        LinkedList<Integer> a = new LinkedList<>();
        for(int i = 0; i < 50; i++){
            a.addNode(i);
        }
        a.showList();
        for(int i = 0; i < 50; i++){
            long t = System.nanoTime();
            a.deleteNode();
            t = System.nanoTime() - t;
            deleteNode += t;
        }
        System.out.println("50 Loop time taken(ns): " + deleteNode);
        System.out.println("Average time taken(ns): " + (Double)(deleteNode/50.0));
        
        
// SHORTER SHORTER SHORTER SHORTER SHORTER SHORTER SHORTER SHORTER SHORTER SHORTER SHORTER
        long deleteNodeShort = 0l;
        LinkedList<Integer> b = new LinkedList<>();
        for(int i = 0; i < 50; i++){
            b.addNode(i);
        }
        System.out.println("");
        b.showList();
        for(int i = 0; i < 50; i++){
            long t = System.nanoTime();
            b.deleteNode();
            t = System.nanoTime() - t;
            deleteNodeShort += t;
        }
        System.out.println("50 Loop time taken(ns): " + deleteNodeShort);
        System.out.println("Average time taken(ns): " + (Double)(deleteNodeShort/50.0));

    }
}
