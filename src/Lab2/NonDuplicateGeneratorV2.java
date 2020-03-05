/* VER 2
 * 1. Create a class that used to generate N number of non-duplicate integer in between 0 – 100. The class must display the number in sorted list. The class must be generic to support array and linked-list implementation. Example output:  
Generate 20 non-duplicate integer within 0-100
Linked List Implementation
0 10 14 18 27 31 35 43 49 50 52 54 55 61 67 76 81 84 97 100
Array Implementation
1 5 6 15 17 20 33 39 44 47 49 52 53 69 744 78 82 85 96 98
 */
package Lab2;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

public class NonDuplicateGeneratorV2<T> {
    
    static int MAX = 101;
    static Random r;
    private T list;

    // Constructor
    NonDuplicateGeneratorV2(T list, int N) throws Exception{
        if(N > MAX) throw new Exception("Exceed limits");
        r = new Random();
        this.list = list;
        generate(N);
    }
    
    private void generate(int N){
        
    // Creating a list of number from 0 -> 100
        int[] numList = new int[MAX];
        for(int i = 0; i < MAX; i++) numList[i] = i;
        
    // Array Array Array Array Array Array Array Array Array Array Array Array Array Array Array
        if(list instanceof int[]){
            
            // Shuffle the array
            for(int i = 0; i < MAX; i++){
                int randomIndex = r.nextInt(MAX);
                int temp = numList[randomIndex];
                numList[randomIndex] = numList[i];
                numList[i] = temp;
            }
            
            // Copy the array from range 0 -> N
            list = (T) Arrays.copyOfRange(numList, 0, N);
            
            // Sorting
            Arrays.sort((int[]) list);
        }
        
    // LinkedList LinkedList LinkedList LinkedList LinkedList LinkedList LinkedList LinkedList
        if(list instanceof LinkedList){
            LinkedList tempLinked = (LinkedList) list;
            
            // Generating
            while(tempLinked.size() < N){
                int temp = r.nextInt(MAX);
                if(!tempLinked.contains(temp)) tempLinked.add(temp);
            }
            
            // Sorting
            Collections.sort(tempLinked);
        }
        
    }
    
    public String toString(){
        if(list instanceof int[]) {
            return "Array Implementation\n" + Arrays.toString((int[])list).replaceAll("[^0-9\\s+]", "");
        }
        else if(list instanceof LinkedList) {
            return "Linked List Implementation\n" + list.toString().replaceAll("[^0-9\\s+]", "");
        }
        else return "Undefined type";
    }
}