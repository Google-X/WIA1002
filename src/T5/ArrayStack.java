package T5;

public class ArrayStack<T> implements ADTStack<T> {
    private T[] a;
    private int size;

    public ArrayStack() {
        a = (T[]) new Object[MAX];
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == a.length + 1;
    }

    public int getSize() {
        return size;
    }

    public void push(T b) {
        if (isFull()) {
            System.out.println("The size is full.");
        } else {
            a[size] = b;
            size++;
        }
    }

    public T pop() {
        if (size == 0) {
            return null;
        } else {
            T temp = a[size - 1];
            a[size - 1] = null;
            size--;
            return temp;
        }
    }

    public T peek() {
        return a[size - 1];
    }

    public void showStack() {
        if (size == 0) {
            System.out.println("Empty stack.");
        } else {
            for (int i = size - 1; i >= 0; i--) {
                System.out.print(" <-- " + a[i]);
            }
        }
    }
}
