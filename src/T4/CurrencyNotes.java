/*
 * 3. The currency notes of a country consist of 100, 50, 20, 10, 5 and 1. Create the ListNode.java and LinkedList.java file (only the methods required based on the lecture notes). Then, create a tester class that insert the currency notes into a linked list. Then, write a program that convert the amount of money to the currency notes. Store the number of notes in another linked list.   

Example output:
Enter the total amount: 1468
Total amount: 1468
MYR 100 : 14
MYR 50 : 1
MYR 20 : 0
MYR 10 : 1
MYR 5 : 1
MYR 1 : 3

 */
package T4;

import java.util.Scanner;

public class CurrencyNotes {
    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        
        System.out.print("Enter the total amount: ");
        int amount = s.nextInt();
        System.out.println("Total amount: " + amount);
        
        int[] notesArr = {100, 50, 20, 10, 5, 1};
        CurrencyLinkedList<Integer> Notes = new CurrencyLinkedList<>();
        for(int i : notesArr) Notes.addNode(i);
        
        CurrencyLinkedList<Integer> numOfNotes = new CurrencyLinkedList<>();
        int count = 0;
        while(amount > 0){
            int c = amount / Notes.get(count);
            amount %= Notes.get(count);
            numOfNotes.addNode(c);
            count++;
        }
        
        for(int i = 0; i < Notes.length(); i++){
            System.out.println("MYR " + Notes.get(i) + " : " + numOfNotes.get(i));
        }
    }
}
