/*
1. Write a Java program to generate N*N matrix. The matrix contains the random number (10-19).  Then, perform the following using Linear Search (modify the SortTest.java): 
a. A method that returns true if the element can be found. 
b. A method that returns the number of occurrence for the element. 
c. A method that returns a list of (row and column) for the element.  

Example output: BELOW
 */
package Lab9;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class MatrixSearch {

    static int[][] matrix;

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        Random r = new Random();

        System.out.print("Enter N : ");
        int N = s.nextInt();

        matrix = new int[N][N];
        System.out.println("The matrix are : ");

        // Generate & Display
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = r.nextInt(10) + 10;
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        
        System.out.println("\nLinear Search");
        System.out.print("Enter a number to search: ");
        int search = s.nextInt();
        
        if(linearSearch(search)){
            System.out.println(search + " is found");
            System.out.printf("The number of %d in the matrix is %d\n", search, occurenceOf(search));
            System.out.printf("The location of %d are : ", search);
            List<String> li = getList(search);
            for(String po : li) System.out.print(po);
            System.out.println();
        }
        
    }

    public static boolean linearSearch(int num) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == num) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int occurenceOf(int num) {
        int counter = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == num) {
                    counter++;
                }
            }
        }
        return counter;
    }
    
    public static List getList(int num){
        List<String> re = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == num) {
                    String tmp = String.format("[%d,%d]", i, j);
                    re.add(tmp);
                }
            }
        }
        return re;
    }
}
/*
Example output:

Enter N : 3
The matrix are : 
12 13 14 
16 16 14 
13 12 17 

Linear Search
Enter a number to search: 10

Enter N : 5
The matrix are : 
18 14 17 15 12 
10 10 11 17 10 
14 18 16 15 13 
17 13 10 12 10 
11 19 10 13 16 

Linear Search
Enter a number to search: 10
10 is found
The number of 10 in the matrix is 6
The location of 10 are : [1,0][1,1][1,4][3,2][3,4][4,2]
*/