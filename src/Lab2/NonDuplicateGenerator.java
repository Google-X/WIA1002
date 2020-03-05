/*
 * 1. Create a class that used to generate N number of non-duplicate integer in between 0 – 100. The class must display the number in sorted list. The class must be generic to support array and linked-list implementation. Example output:  
Generate 20 non-duplicate integer within 0-100.
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

public class NonDuplicateGenerator<T extends Comparable<? super T>>{
    
    private T[] arr;
    private LinkedList<T> list;
    private int maxSize;
    private int index;
    private boolean isArray;
    private Random r = new Random();
    
    public NonDuplicateGenerator(int maxSize, String choice) {
        this.maxSize = maxSize;
        
        if(choice.toLowerCase().contains("arr")){
            isArray = true;
            index = -1;
            arr = (T[])new Comparable[maxSize];
            generate();
            sorter();
        } else if (choice.toLowerCase().contains("linked")){
            index = -1;
            isArray = false;
            list = new LinkedList<>();
            generate();
            sorter();
        }
    }
    
    public void generate(){
        
        int temp;
        //Array
        if(isArray){
            do{
                temp = r.nextInt(101);
                index++;
                arr[index] = (T)(Integer)temp;
                
            } while(isExist(temp) || index < maxSize - 1);
            
        }
        // Linked List
        else {
            temp = r.nextInt(101);
            list.add((T)(Integer)temp);
            
            do{
                temp = r.nextInt(101);
                
                if(!isExist(temp)){
                    list.add((T)(Integer)temp);
                }
                
            } while(getSize() < maxSize);
        }
        
    }
    
    public boolean isExist(int numToCheck){
        // Array
        if(isArray){
            for(int i = 0; i < arr.length; i++){
                
                if(i != index){
                    if((T)(Integer)numToCheck == arr[i]) {
                        index--;
                        return true;
                    }
                }
                
            }
        } 
        // Linked List
        else {
            if(list.contains((T)(Integer)numToCheck)){
                return true;
            }
        }

        return false;
    }
    
    public void sorter(){
        if(isArray){
            Arrays.sort(arr);
        }
        // Linked List
        else {
           Collections.sort(list);
        }
    }
    
    public int getSize(){
        // Array
        if(isArray) return index + 1;
        // Linked List
        else return list.size();
    }
    
    public String toString() {
        
        String temp = "";
        
        // Array
        if(isArray){
            temp += "Array Implementation\n";
//            temp += Arrays.toString(arr);
            temp += Arrays.toString(arr).replaceAll("[^0-9\\s+]", "");
        } 
        // Linked List
        else {
            temp += "Linked List Implementation\n";
            temp += list.toString().replaceAll("[^0-9\\s+]", "");
        }
        
        return temp;
    }
}
