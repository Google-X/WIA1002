/*
 * 1. Write a program that generate 10 random numbers within 0 – 20. Insert the number into the BST. Then, print the number of elements in the BST and display the BST elements (PREORDER, INORDER, POSTORDER).  Then, perform the following: 
a. A method in BST to get minimum value 
b. A method in BST to get maximum value 
c. A method in BST to get the total value 
d. A method to count the number of occurrence of a given number  
Example output: 

The random numbers are 5 16 19 18 16 17 9 0 1 9
The number of elements in the tree : 10
The tree elements - PREORDER : 5 --> 0 --> 1 --> 16 --> 16 --> 9 --> 9 --> 19 --> 18 --> 17 --> 
The tree elements - INORDER : 0 --> 1 --> 5 --> 9 --> 9 --> 16 --> 16 --> 17 --> 18 --> 19 --> 
The tree elements - POSTORDER : 1 --> 0 --> 9 --> 9 --> 16 --> 17 --> 18 --> 19 --> 16 --> 5 --> 

The minimum number is : 0
The maximum number is : 19
The total number is : 110
Enter a number to search : 16
The number of occurance of 16 is 2
*/
package Lab7;

import java.util.Random;
import java.util.Scanner;

public class RandomNumber {
    public static void main(String[] args) {
        
        Random r = new Random();
        Scanner s = new Scanner(System.in);
        
        BST<Integer> bst = new BST<>();
        System.out.print("The random number are ");
        
        for(int i = 0; i < 10; i++){
            int temp = r.nextInt(21);
            System.out.print(temp + " ");
            bst.addNode(temp);
        }
        
        System.out.println("\nThe number of elements in the tree : " + bst.getSize());
        
        System.out.println("The minimum number is : " + bst.getMin());
        System.out.println("The maximum number is : " + bst.getMax());
        System.out.println("The total number is : " + bst.total());
        System.out.print("Enter a number to search : ");
        int num = s.nextInt();
        System.out.printf("The number of occurance of %d is %d\n", num, bst.numberCount(num));
        
    }
}
