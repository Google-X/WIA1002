/*
 * 4. Create an ADT Dice which contains the specifications below: 
 A method that rolls the dice for a number of times. 
 A toString method that returns the value of each dice rolled and the total value.  
Implement the ADT Dice using ArrayDice and LinkedListDice. Example output: 

Array Implementation: Roll 5 times(s)
5 1 3 2 5
Total is 16
Array Implementation: Roll 4 times(s)
2 2 3 2
Total is 9
Linked List Implementation: Roll 3 time(s)
5 1 1
Total is 7
Linked List Implementation: Roll 4 time(s)
2 5 2 1
Total is 10

 */
package T2;

import java.util.Random;

// Without "extends Comparable<T>" also can
// With "extends Comparable" also can
// But we are not comparing so both are not needed
public class ArrayDice<T> implements ADTDice<T>{
    
    private T[] arr;
    private int index, maxSize;
    private Random r = new Random();
    
    public ArrayDice(int numOfRoll) {
        index = -1;
        maxSize = numOfRoll;
        arr = (T[]) new Object[numOfRoll]; // What is the meaning of number in the square here?
    }
    
    public void rollDice() {
        for(int i = 0; i < maxSize; i++){
            arr[i] = ((T)(Integer)(1 + r.nextInt(6)));
        }
    }
    
    public String toString() {
        int total = 0;
        String temp = "Array Implementation: Roll " + maxSize + " time(s)\n";
        
        for(int i = 0; i < arr.length; i++){
            temp += arr[i] + " ";
            total += (Integer) arr[i];
        }
        
        temp += "\nTotal is " + total;
        
        return temp;
    }
}

// REMOVED
//    public void insert(T t) {
//        if(!isFull()){
//            index++;
//            arr[index] = t;
////            arr[index] = (T)(Integer)r.nextInt(5); // <-- This one also can, but the question one
//            System.out.println(arr[index]);
//        } else {
//            System.out.println("The log is full");
//        }
//    }
//    
//    public boolean isFull() {
//        return maxSize == size();
//    }
//    
//    public int size() {
//        return index + 1;
//    }