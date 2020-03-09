/*
 * 5. 5. Write a program that creates an integer array with 5 elements. The program accepts user input for the elements of the array. Use exception handling to detect improper inputs. The user needs to enter the correct input to continue. The program will stop if ArrayIndexOutOfBoundsException is encountered. The program will display all integers entered by the user. Example output:

Enter an Integer: 12
Enter an Integer: hello
Invalid input type
Enter an Integer: 23
Enter an Integer: 86.7
Invalid input type
Enter an Integer: 32
Enter an Integer: 10
Enter an Integer: 92
Enter an Integer: 2
The array of integers is:
12 23 32 10 92
 */
package Lab3;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;


public class ArrayIndexOutOfBoundsExceptionClass {
    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        int[] arr = new int[5];
        int i = 0;
        
        while(true){
            
            try{
                System.out.print("Enter an Integer: ");
                arr[i] = s.nextInt();
                i++;
            
            } catch (InputMismatchException ime){
                System.out.println("Invalid input type");
                s.next();
            } catch (ArrayIndexOutOfBoundsException ofb){
                System.out.println(Arrays.toString(arr).replace("[^0-9\\s+]", ""));
                break;
            }
            
        }
        
    }
}
