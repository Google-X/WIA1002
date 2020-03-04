/*
 * 1. Create a class that used to generate N number of non-duplicate integer in between 0 – 100. The class must display the number in sorted list. The class must be generic to support array and linked-list implementation. Example output:  
Generate 20 non-duplicate integer within 0-100
Linked List Implementation
0 10 14 18 27 31 35 43 49 50 52 54 55 61 67 76 81 84 97 100
Array Implementation
1 5 6 15 17 20 33 39 44 47 49 52 53 69 744 78 82 85 96 98
 */
package Lab2;

public class NonDuplicateGeneratorTesterClass {
        public static void main(String[] args) {
        int N = 20;
        System.out.printf("Generate %d non-duplicate integer within 0-100\n", N);

        NonDuplicateGenerator<Integer> arr = new NonDuplicateGenerator<>(N, "Array");
        NonDuplicateGenerator<Integer> list = new NonDuplicateGenerator<>(N, "LinkedList");
        
        System.out.println(arr.toString());
        System.out.println(list.toString());
        
    }
}
