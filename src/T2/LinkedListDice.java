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

import java.util.LinkedList;
import java.util.Random;

public class LinkedListDice<T> implements ADTDice<T>{
    
    private LinkedList<T> linkList;
    private int maxSize;
    private Random r = new Random();

    public LinkedListDice(int maxSize) {
        this.maxSize = maxSize;
        linkList = new LinkedList<>();
    }
    
    public void rollDice() {
        for(int i = 0; i < maxSize; i++){
            linkList.add((T)(Integer)(1 + r.nextInt(6)));
        }
    }
    
    public String toString() {
        int total = 0;
        String temp = "Linked List Implementation: Roll " + maxSize + " time(s)\n";
        for(int i = 0; i < maxSize; i++){
            temp += linkList.get(i) + " ";
            total += Integer.parseInt(String.valueOf(linkList.get(i)));
        }
        
        temp += "\nTotal is " + total;
        
        return temp;
    }
}
//    public void insert(T t) {
//        if(!isFull()){
//            linkList.add((T) t);
//        } else {
//            System.out.println("The log is full.");
//        }
//    }
//    
//    public boolean isFull() {
//        return (linkList.size() == maxSize);
//    }
//    
//    public int size() {
//        return linkList.size();
//    }