/*
 * 7. Create the ListNode.java and CircularLinkedList.java file. The CircularLinkedList class must contains the following method: 
a. length() 
b. addCircularNode - insert at the back 
c. deleteCircularNode - delete from the back 
d. showCircularList 
e. getCicularItem – return the item by index  
Then, insert the words from a sentence to the CircularLinkedList. Then, delete a word from the list. After that, display the second item of the list.  

Example output: 

Enter a sentence : Welcome to FSKTM UM
The words in the circular linked list
Welcome --> to --> FSKTM --> UM --> Welcome
After delete a word
Welcome --> to --> FSKTM --> Welcome
The second item in the list is to

 */
package Lab4;

import java.util.Scanner;

public class SentenceBanner {
    public static void main(String[] args) {
        
        CircularLinkedList<String> li = new CircularLinkedList<>();

        Scanner s = new Scanner(System.in);
        System.out.print("Enter a sentence : ");
        String[] tmp = s.nextLine().split(" ");
        for(String word : tmp) li.addCircularNode(word);
        
        System.out.println("The words in the circular linked list");
        li.showCircularNode();
        
        System.out.println("After delete a word");
        li.deleteCircularNode();
        li.showCircularNode();
        
        System.out.print("The second item in the list is " + li.getCicularItem(1) + "\n");
    }
}
