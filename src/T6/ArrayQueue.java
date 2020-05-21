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
            rear = ++rear%size;
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
            front = ++front%size;
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
}
