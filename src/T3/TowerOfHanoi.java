/*
 * Some basic recursive coding - Tower of Hanoi
 */
package T3;

public class TowerOfHanoi {
    
    private static String indent = "";
    
    public static void completeWalkthrough(int n, String start, String temp, String end){
        
        if(n > 0){
            indent += "  ";
            System.out.printf("%sGet %d ring(s) from %s to %s\n", indent, n, start, end);
            completeWalkthrough(n-1, start, end, temp);
            System.out.printf("%sMove ring %d from %s to %s\n", indent, n, start, end);
            completeWalkthrough(n-1, temp, start, end);
            indent = indent.substring(2);
//            System.out.print("Done\n\n");
        }
    }
    
    public static void simpleWalktrough(int n, String start, String temp, String end){
        
        if(n > 0){
            simpleWalktrough(n-1, start, end, temp);
            System.out.printf("Move ring %d from %s to %s\n", n, start, end);
            simpleWalktrough(n-1, temp, start, end);
        }
        
    }
    
    public static void main(String[] args) {
        
        int N = 3;
        System.out.println("Complete walkthrough");
        System.out.println("========================================");
        completeWalkthrough(N, "A", "B", "C");
        
        System.out.println("Simple walkthrough");
        System.out.println("========================================");
        simpleWalktrough(N, "A", "B", "C");
        
    }
    
}
