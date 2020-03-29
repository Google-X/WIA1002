/*
 * 6. Create a program that generates 10 random number within 1 – 100 and store in an array. Iterate the array and insert the number into the stack according to this rule; the first number must be an odd number. Then, push the even number and odd number alternate into the stack. Iterate the array until the rule cannot be satisfied. Example output:

The random numbers are : 22 83 85 100 63 23 35 9 82 16
The numbers in the stack :  <-- 35 <-- 22 <-- 23 <-- 16 <-- 85 <-- 82 <-- 63 <-- 100 <-- 83
The numbers remain in the array : 9
 */
package T5;

import java.util.Random;

public class NumberStacking {

    public static void main(String[] args) {

        Random r = new Random();
        Stack<Integer> even = new Stack<>();
        Stack<Integer> odd = new Stack<>();
        int[] arr = new int[10];
        
        System.out.print("The random numbers are : ");
        for(int i = 0; i < arr.length; i++) {
            arr[i] = 1 + r.nextInt(100);
            System.out.print(arr[i] + " ");
        }
        
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]%2 == 0) even.push(arr[i]);
            else odd.push(arr[i]);
        }

        Stack<Integer> st = new Stack<>();
        int loop = 0;
        if(even.getSize() == odd.getSize()) loop = arr.length;
        else if(even.getSize() < odd.getSize()) loop = (even.getSize()*2) + 1;
        else if(odd.getSize() < even.getSize()) loop = odd.getSize()*2;
        
        for(int i = 0; i < loop; i++){
            if(i%2==0) st.push(odd.pop());
            else st.push(even.pop());
        }
        
        System.out.print("\nThe numbers in the stack : ");
        st.showStack();
        
        System.out.println("\nThe numbers remain in the stack " + st.getSize());
    }
}
