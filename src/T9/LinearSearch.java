/*
 * 1. Write a program that generates 10 random characters. Then, perform the following using Linear Search: 
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

public class LinearSearch {
    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        SearchTest<Character> searcher = new SearchTest<>('A', 10, 0);
        
        System.out.print("The Character data set are : ");
        searcher.showValue();
        
        System.out.println("\nLinear Search");
        System.out.print("Enter a letter to search: ");
        char c = s.next().charAt(0);
        
        if(searcher.linearSearch(c)){
            System.out.printf("%c is found\n", c);
            int count = searcher.linearSearchCount(c);
            System.out.printf("The number of %c in the data set is %d\n", c, count);
            System.out.printf("The location(s) of the %c is/are : ", c);
            for(int i : searcher.getLinearSearchIndex(c)) System.out.print(i + " ");
            System.out.println();
        } else {
            System.out.printf("%c is not found\n", c);
        }
        
        System.out.print("\nEnter two letters to search (begin end) : ");
        char c1 = s.next().charAt(0);
        char c2 = s.next().charAt(0);
        
        if(searcher.linearSearchBetween(c1, c2)){
            System.out.printf("The character can be found in between %c and %c\n", c1, c2);
            int count = searcher.linearSearchCountBetween(c1, c2);
            System.out.printf("The number of the elements in between %c and %c in the data set is %d\n", c1, c2, count);
            System.out.printf("The location(s) of the elements in between %c and %c is/are : ", c1, c2);
            for(int i : searcher.getLinearSearchIndexBetween(c1, c2)) System.out.print(i + " ");
            System.out.println();
        } else {
            System.out.printf("No character can be found in between %c and %c\n", c1, c2);
        }
    }
}

/*
Example output 1:
The Character data set are : M X O M L U B X D T 

Linear Search
Enter a letter to search: A
A is not found

Enter two letters to search (begin end) : E J
No character can be found in between E and J

Example output 2:
The Character data set are : Q H R W C R T U N W 

Linear Search
Enter a letter to search: W
W is found
The number of W in the data set is 2
The location(s) of the W is/are : 3 9 

Enter two letters to search (begin end) : C N
The character can be found in between C and N
The number of the elements in between C and N in the data set is 3
The location(s) of the elements in between C and N is/are : 1 4 8 
*/