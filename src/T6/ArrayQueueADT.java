/*
 * 2. Create an ADT queue named ArrayQueue. The ADT consists of the following method and the maximum size of the ADT is 10. (Arrange the array in a circle) 
a. Constructor 
b. isEmpty 
c. isFull 
d. getSize 
e. enqueue 
f. dequeue 
g. peek 
h. showQueue

 */
package T6;

public interface ArrayQueueADT<T> {
    
    final int MAX = 10;
    
    public boolean isEmpty();
    public boolean isFull();
    public int getSize();   
    public void enqueue(T t);
    public T dequeue();
    public T peek();
    public void showQueue();
    
}
