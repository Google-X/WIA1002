/*
 * 5. Iterator is used to cycle through a linked list to get the data of an element or remove an element. Create an inner class LinkedListIterator in LinkedList.java that implements the Iterator. Then, insert the following word ARS, CHE, LEI, MAN, LIV, TOT into the LinkedList. After that, demonstrate the use of the iterator methods to remove the word that consists of the A character. Create the listIterator method in the LinkedList.java to return the iterator  
Example output:

The list consists of ARS --> AST --> CHE -->  LEI --> MAN --> LIV --> TOT --> 
Remove all the word that consists of the A character using iterator.
The update list consists of CHE --> LEI --> LIV --> TOT -->

 */
package Lab4;

import java.util.Iterator;

public class IteratorTesterClass {
    public static void main(String[] args) {
        
        LinkedList<String> li = new LinkedList<>();
        li.addLastNode("ARS");
        li.addLastNode("AST");
        li.addLastNode("CHE");
        li.addLastNode("LEI");
        li.addLastNode("MAN");
        li.addLastNode("LIV");
        li.addLastNode("TOT");
        
        System.out.print("The list consists of ");
        li.showList();
        
        Iterator it = li.iterator();
        
        int count = 0;
        while(it.hasNext()){
            String tmp = (String)it.next();
            if(tmp.contains("A")) {
                li.deleteNodeByPosition(count);
            } else {
                count++;
            }
        }
        
        System.out.println("\nRemove all the word that consists of the A character using iterator.");
        System.out.print("The update list consists of ");
        li.showList();
        
    }
}
