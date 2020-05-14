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
        int[] arr = new int[10];
        Stack<Integer> st = new Stack<>();
        
        // Update from here
        int even = 0; 
        int odd = 0; 

        System.out.print("The random numbers are : "); 
        for(int i = 0; i < arr.length; i++) { 
            arr[i] = 1 + r.nextInt(100); 
            System.out.print(arr[i] + " "); 
            if(arr[i] % 2 == 0) even++; 
            else odd++; 
        } 

        int loop = 0; 
        if(even == odd) loop = arr.length; 
        else if(even < odd) loop = (even*2) + 1; 
        else if(odd < even) loop = odd*2; 
        // To here.
        
        /*
        System.out.print("The random numbers are : ");
        for(int i = 0; i < arr.length; i++) {
            arr[i] = 1 + r.nextInt(100);
            System.out.print(arr[i] + " ");
        }
        
// Using array & two stacks
        System.out.println("Using two stacks");
        Stack<Integer> even = new Stack<>();
        Stack<Integer> odd = new Stack<>();
        
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]%2 == 0) even.push(arr[i]);
            else odd.push(arr[i]);
        }

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
        */
// Using array & iterate
        System.out.println("\nUsing array and iteration");
        Stack<Integer> array = new Stack<>();
        int c = 0, i = 0;
        while(c < loop){
            if(c%2 == 0) {
                if(arr[i]%2 != 0) {
                    array.push(arr[i]);
                    arr[i] = 0;
                    c++;
                }
            }
            else {
                if(arr[i] != 0 && arr[i]%2 == 0) {
                    array.push(arr[i]);
                    arr[i] = 0;
                    c++;
                }
            }
            if(i == arr.length-1) i = 0;
            else i++;
        }
        System.out.print("The numbers in the stack : ");
        array.showStack();
        
        System.out.println("\nThe numbers remain in the stack " + array.getSize());
    }
    
}
