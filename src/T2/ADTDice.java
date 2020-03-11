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

public interface ADTDice<T> {
    
    public void rollDice();
//    public void insert(T t);
//    public boolean isFull();
//    public int size();
    public String toString();
    
}
