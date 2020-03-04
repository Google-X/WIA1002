/*
 * 3. Create an ADT for the UNO card. This ADT contains the following specifications. 
 A method to draw the card for a number of times.  
 A toString method that returns the value of each card drawed.  
Implement the ADT using Array and LinkedList. Create a Tester class to test the program, given output below. 

Array Implementation
Player 1 draws 7 times
Yellow Zero :: Yellow Draw Two :: Green Skip :: Draw Four :: Green Zero :: Yellow Three :: Red Zero ::
Array Implementation
Player 2 draws 7 times
Red Four :: Green Three :: Green Six :: Red Nine :: Yellow Five :: Yellow Four :: Blue Five ::

Linked List Implementation
Player 1 draws 7 times
Green Five :: Blue Reverse :: Pick Colour :: Green Reverse :: Red Nine :: Red Zero :: Red Two ::
Linked List Implementation
Player 2 draws 7 times
Green One :: Blue One :: Yellow Four :: Green Zero :: Green Draw Two :: Pick Colour :: Red Three ::
 */
package Lab2;

public interface ADTUno {
    
    // 0: Wild card   1: Red   2: Yellow   3: Green   4: Blue
    public String[] color = {"", "Red", "Yellow", "Green", "Blue"};
    // if 0 is chosen, below is the list of 
    public String[] action = {"Draw Four", "Pick Colour"};
    // else
    public String[] colorCard = {"Zero" , "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
    "Skip", "Reverse", "Draw Two"};
    
    public void draw(int N);
    public String toString();
    
}
