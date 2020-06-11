/* Method by Muhamad Azri
 * 1. Create a program to sort N random numbers within 0-100 using merge sort in ascending order. However this number is special where the odd number is always smaller than the even number.

Example output: 
Enter N Special Random Number within 0-100: 10
The Special Number are : 87 84 14 24 93 74 10 11 81 70 
After Merge Sort : 11 81 87 93 10 14 24 70 74 84 
 */
package Lab8;

import java.util.Scanner;

public class OddEvenSort {
    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        
        System.out.print("Enter N Special Random Number within 0-100: ");
        int n = s.nextInt();
        
        SortTest<Integer> sorter = new SortTest(1, n, 101, true);
        
        System.out.printf("The Special Number are : ");
        sorter.showValue();
        
        sorter.mergeSortV3();
        System.out.print("After Merge Sort : ");
        sorter.showValue();
    }
}
