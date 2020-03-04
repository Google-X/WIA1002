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

public class UNOTesterClass {
    public static void main(String[] args) {
        
    // GAME 1
        UNOArray<String> game1 = new UNOArray<>(7);
        
        //Player 1 draws in game 1
        game1.draw(7);
        System.out.println(game1.toString());
        
        //Player 2 draws in game 1
        game1.draw(7);
        System.out.println(game1.toString());
        
        System.out.println();
    // GAME 2
        UNOLinkedList<String> game2 = new UNOLinkedList<>();
        
        //Player 1 draws in game 2
        game2.draw(7);
        System.out.println(game2.toString());
        
        //Player 2 draws in game 2
        game2.draw(7);
        System.out.println(game2.toString());
    }
}
