/* VER 2
 * 1. Create a class that used to generate N number of non-duplicate integer in between 0 – 100. The class must display the number in sorted list. The class must be generic to support array and linked-list implementation. Example output:  
Generate 20 non-duplicate integer within 0-100
Linked List Implementation
0 10 14 18 27 31 35 43 49 50 52 54 55 61 67 76 81 84 97 100
Array Implementation
1 5 6 15 17 20 33 39 44 47 49 52 53 69 744 78 82 85 96 98
 */
package Lab2;

import java.util.LinkedList;

public class NonDuplicateGeneratorV2TesterClass {
    public static void main(String[] args) throws Exception {
        
        int N = 20;
        System.out.printf("Generate %d non-duplicate integer within 0-100\n", N);
        
        LinkedList<Integer> l = new LinkedList<>();
        NonDuplicateGeneratorV2<LinkedList> link = new NonDuplicateGeneratorV2<>(l, N);
        System.out.println(link.toString());
        
        int[] a = {};
        NonDuplicateGeneratorV2<int[]> arr = new NonDuplicateGeneratorV2<>(a, N);
        System.out.println(arr.toString());
        
    }
}
