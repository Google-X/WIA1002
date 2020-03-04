/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
