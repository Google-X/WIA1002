/*
 * ArrayQueue Queue class
 */
package T6;

public class ArrayQueue<T> implements ArrayQueueADT<T>{
    
    private static final int size = 10;
    private T[] arr;
    private int currentSize = 0;
    private int front = 0, rear = 0;

    public ArrayQueue() {
        arr = (T[]) new Object[size];
    }
    
    public boolean isEmpty() {
        return currentSize == 0;
    }
    
    public boolean isFull() {
        return currentSize == size;
    }
    
    public int getSize() {
        return currentSize;
    }
    
    public void enqueue(T t) {
        if(!isFull()){
            arr[rear] = t;
            rear = ++rear%size; // during enqueue, ensure that the position is always within [0, MAX_SIZE-1]
            currentSize++;
        } else {
            System.out.println("Queue is full.");
        }
    }
    
    public T dequeue() {
        if(isEmpty()) {
            System.out.println("The queue is empty");
            return null;
        } else {
            T temp = arr[front];
            arr[front] = null; // <-- Necessary?
            front = ++front%size; // during dequeue, ensure that the position is always within [0, MAX_SIZE-1]
            currentSize--;
            return temp;
        }
    }
    
    public T peek() {
        if(isEmpty()) {
            System.out.println("The queue is empty");
            return null;
        } else return arr[front];
    }
    
    public void showQueue() {
        if(isEmpty()) System.out.println("EmptyQueueException");
        else 
            for(int i = 0; i < currentSize; i++)
                System.out.print(arr[(front+i)%size] + " --> ");
    }
    
    /*
    if rear >= front, then we will just use a single for loop to display everything (as usual).
    else if rear < front (as like our example), we can use TWO for loops. 
    First for loop display items from front position to MAX_SIZE-1, and second for loop display items from 0 to rear position.
    */
    public void showQueueV2() {
        if(isEmpty()) System.out.println("EmptyQueueException");
        else {
            if(front < rear){
                for(int i = front; i < rear; i++) System.out.print(arr[i] + " --> ");
            }
            else {
                for(int i = front; i <= size-1; i++) System.out.print(arr[i] + " --> ");
                for(int i = 0; i < rear; i++) System.out.print(arr[i] + " --> ");
            } 
        }
    }
    
}
