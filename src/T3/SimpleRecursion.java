/*
 * 1. Write statements for each of the following 
a. Write a recursive method to find the smallest element in an array. 
b. Write a recursive method to compute the sum of the elements in an array.  
c. Write a recursive method that find the greatest common divisor of two given integers. The GCD of x and y is defined recursively as follows. If y is equal to 0, then gcd(x, y) is x. Otherwise, gcd(x, y) is gcd(y, x%y). 
d. Write a recursive method that convert decimal to binary.
e. Write a recursive method that computes the sum of the first n cubes. 
 */
package T3;

public class SimpleRecursion {
    public static void main(String[] args) {
        
    // Q1A
        System.out.println("Question 1a");
        int[] q1a = {100, -55, 25};
        System.out.printf("The smallest element: %d\n\n", findMin(q1a, q1a.length));
        
    // Q1B
        System.out.println("Question 1b");
        int[] q1b = {1, 2, 3};
        System.out.printf("The sum of the elements: %d\n\n", sum(q1b, q1b.length));
        
    // Q1C
        System.out.println("Question 1c");
        int num1 = 99, num2 = 46;
        System.out.printf("The GCD of %d & %d: %d\n\n", num1, num2, GCD(num1, num2));
        
    // Q1D
        System.out.println("Question 1d");
        int numToConvert = 14;
        System.out.printf("%d to binary without returning value: ", numToConvert);
        DEC_TO_BIN(numToConvert);
        System.out.printf("\n%d to binary returned value: %d\n\n", numToConvert, DEC_TO_BIN_V2(numToConvert));
        
    // Q1E
        System.out.println("Question 1e");
        int N = 3;
        System.out.printf("Sum of first %d cube(s): %d\n", N, sumOfFirstNCube(N));
    }
    
// METHODS METHODS METHODS METHODS METHODS METHODS METHODS METHODS METHODS METHODS METHODS METHODS METHODS 
// a. Write a recursive method to find the smallest element in an array. 
    public static int findMin(int[] a, int N){
        if(N == 1) return a[0];
        return Math.min(a[N - 1], findMin(a, N - 1));
    }
    
// b. Write a recursive method to compute the sum of the elements in an array.
    public static int sum(int[] a, int N){
        if(N == 1) return a[0];
        return (a[N-1] + sum(a, N-1));
    }
    
// c. Write a recursive method that find the greatest common divisor of two given integers. The GCD of x and y is defined recursively as follows. If y is equal to 0, then gcd(x, y) is x. Otherwise, gcd(x, y) is gcd(y, x%y). 
    public static int GCD(int x, int y){
        if(y == 0) return x;
        return GCD(y, x%y);
    }
    
// d. Write a recursive method that convert decimal to binary.
    // Do not return value
    public static void DEC_TO_BIN(int dec){
        if(dec != 0){
            DEC_TO_BIN(dec / 2);
            System.out.print(dec % 2);
        }
    }
    
    // Return value
    public static int DEC_TO_BIN_V2(int dec){
        if(dec == 0) return 0;
        return ( (dec % 2) + (10 * DEC_TO_BIN_V2(dec / 2)) );
    }
    
// e. Write a recursive method that computes the sum of the first n cubes.
    public static int sumOfFirstNCube(int N){
        if(N == 1) return 1;
        return ((int) (Math.pow(N, 3) + sumOfFirstNCube(N - 1)));
    }
}
