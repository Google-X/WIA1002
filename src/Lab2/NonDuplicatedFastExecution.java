/*
 * The easiest and fastest way to generate 20 different non-duplicated number between 1 - 100
 */
package Lab2;

import java.util.Arrays;
import java.util.Random;

public class NonDuplicatedFastExecution {
    public static void main(String[] args) {
        
        int[] arr = new int[101];   
        Random r = new Random();
        int N = 20;
        
        // Setting 1 -> N to an array
        for(int i = 0; i < arr.length; i++) arr[i] = i;
        
        // Shuffling the array
        for(int i = 0; i < arr.length; i++){
            int randomIndex = r.nextInt(arr.length);
            int temp = arr[randomIndex];
            arr[randomIndex] = arr[i];
            arr[i] = temp;
        }
        
        int[] generated = Arrays.copyOfRange(arr, 0, N);
        
        // Sort array
        Arrays.sort(generated);
        
        System.out.println("List of generated number: " + Arrays.toString(generated));
        
    }
}
