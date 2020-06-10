/*
 * 2. Write a program that generates 10 random integers. Then, perform the following using Binary Search: 
a. A method that returns true if the element can be found. 
b. A method that returns the number of occurrence for the element. 
c. A method that returns a list of index for the element. 
d. A method that returns true if the elements can be found. (search by range) 
e. A method that returns the number of occurrence for the elements. (search by range) 
f. A method that returns a list of index for the elements. (search by range)  
Example output: [BELOW]
 */
package T9;

import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        SearchTest<Integer> searcher = new SearchTest<>(1, 10, 20, true);
        
        System.out.print("The Integer data set are : ");
        searcher.showValue();
        
        System.out.println("\nBinary Search");
        System.out.print("Enter a number to search: ");
        int n = s.nextInt();
        
        if(searcher.binarySearch(n)){
            System.out.printf("%d is found\n", n);
            int count = searcher.binarySearchCount(n);
            System.out.printf("The number of %d in the data set is %d\n", n, count);
            System.out.printf("The location(s) of %d is/are : ", n);
            for(int i : searcher.binarySearchList(n)) System.out.print(i + " ");
            System.out.println();
        } else {
            System.out.printf("%d is not found\n", n);
        }
        
        System.out.print("\nEnter two number to search (begin end) : ");
        int n1 = s.nextInt();
        int n2 = s.nextInt();
        
        if(searcher.linearSearchBetween(n1, n2)){
            System.out.printf("The integer can be found in between %d and %d\n", n1, n2);
            int count = searcher.binarySearchCountBetween(n1, n2);
            System.out.printf("The number of the elements in between %d and %d in the data set is %d\n", n1, n2, count);
            System.out.printf("The location(s) of the elements in between %d and %d is/are : ", n1, n2);
            for(int i : searcher.binarySearchListBetween(n1, n2)) System.out.print(i + " ");
            System.out.println();
        } else {
            System.out.printf("No integer can be found in between %d and %d\n", n1, n2);
        }
    }
}
/*
Example Output 1:
The Integer data set are : 1 2 2 3 4 4 5 9 10 12 

Binary Search
Enter a number to search: 0
0 is not found

Enter two number to search (begin end) : 15 19
No integer can be found in between 15 and 19

Example Output 2:
The Integer data set are : 2 5 7 9 13 13 17 18 18 18 

Binary Search
Enter a number to search: 13
13 is found
The number of 13 in the data set is 2
The location(s) of 13 is/are : 4 5 

Enter two number to search (begin end) : 7 16
The integer can be found in between 7 and 16
The number of the elements in between 7 and 16 in the data set is 4
The location(s) of the elements in between 7 and 16 is/are : 2 3 4 5 
*/