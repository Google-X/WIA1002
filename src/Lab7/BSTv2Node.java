/*
 * BST is not supposed to have duplicated elements, if really need to find the frequency for a specified element,
 * we will use counter
 */
package Lab7;

public class BSTv2Node<T extends Comparable<T>> {
    
    private T data;
    private BSTv2Node<T> leftLink;
    private BSTv2Node<T> rightLink;
    
    // Extra methods
    //=============================================================
    private int count;
    public void increment(){
        count++;
    }
    
    public void decrement(){
        count--;
    }
    
    public int getCount(){
        return count;
    }
    //=============================================================
    
    public BSTv2Node() {
        data = null;
        leftLink = null;
        rightLink = null;
    }

    public BSTv2Node(T t, BSTv2Node<T> l, BSTv2Node<T> r) {
        data = t;
        leftLink = l;
        rightLink = r;
    }

    public T getData() {
        return data;
    }

    public void setData(T t) {
        data = t;
    }

    public BSTv2Node<T> getLeft() {
        return leftLink;
    }

    public void setLeft(BSTv2Node<T> l) {
        leftLink = l;
    }
    
    public BSTv2Node<T> getRight() {
        return rightLink;
    }

    public void setRight(BSTv2Node<T> r) {
        rightLink = r;
    }
    
}
