/*
 * 2. Create an ADT stack named ArrayStack. The ADT consists of the following method and the maximum size of the ADT is 10. 
a. Constructor 
b. isEmpty 
c. isFull 
d. getSize 
e. Push 
f. Pop 
g. Peek 
h. showStack    
Example output:

 */
package T5;

public interface ADTStack<T> {
    
    int MAX = 10;
    public boolean isEmpty();
    public boolean isFull();
    public int getSize();
    public void push(T t);
    public T pop();
    public T peek();
    public void showStack();
    
}
