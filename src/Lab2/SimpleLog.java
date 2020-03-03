/*
 * 2. Create a TextFile based implementation named TextFileLog that implements the SimpleLog interface. 
The interface contains the following specifications: 
 A method to insert item to the log 
 A method to check whether the log is full 
 A method to get the size of the log 
 A method to check whether the item exists in the log 
 A method to delete the log 
 A method to display all items in the log  
Create a Tester class to test the program, given output below. 
 */
package Lab2;

public interface SimpleLog<T> {
    
    public void insert(T t);
    public boolean isFull();
    public int getSize();
    public boolean search(T t);
    public void clear();
    public String toString();
    
}
