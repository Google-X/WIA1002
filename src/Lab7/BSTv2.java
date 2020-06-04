/*
 * Things that need modification for BSTv2Node:
 * 1. add() method
 * 2. findOccurance() method
 */
package Lab7;

import T6.Queue;

public class BSTv2<T extends Comparable<T>> {
    private BSTv2Node root;
    
    public BSTv2(){
        root = null;
    }
    
    public BSTv2Node getRoot(){
        return root;
    }
    
    public boolean isEmpty(){
        return root == null;
    }
    
    public int getSize(){
        return getSize(root);
    }
    
    private int getSize(BSTv2Node<T> a){
        if(a == null) return 0;
        else return getSize(a.getLeft()) + getSize(a.getRight()) + 1;
    }
    
    public boolean contains(T t){
        return find(root, t);
    }
    
    private boolean find(BSTv2Node<T> a, T t){
        if(a == null) return false;
        else if(t.compareTo(a.getData()) < 0)
            return find(a.getLeft(), t);
        else if(t.compareTo(a.getData()) > 0)
            return find(a.getRight(), t);
        else return true;
    }
    
    public T getElement(T t){
        return (T) getElement(root, t);
    }
    
    private T getElement(BSTv2Node<T> a, T t){
        if(a == null) return null;
        else if(t.compareTo(a.getData()) < 0)
            return getElement(a.getLeft(), t);
        else if(t.compareTo(a.getData()) > 0)
            return getElement(a.getRight(), t);
        else return a.getData();
    }
    
    //=============================================================
    // SPECIAL ADD() METHOD
    //=============================================================
    public void addNode(T t){
        add(root, t);
    }
    
    private BSTv2Node<T> add(BSTv2Node<T> a, T newValue) {
        if (a == null) {
            a = new BSTv2Node<>(newValue, null, null);
        } else if (newValue.compareTo(a.getData()) < 0) {
            a.setLeft(add(a.getLeft(), newValue));
        } else if (newValue.compareTo(a.getData()) > 0) {
            a.setRight(add(a.getRight(), newValue));
        } else {
            a.increment();
        }
        return a;
    }
    
    //=============================================================
    // SPECIAL REMOVE() METHOD
    //=============================================================
    private boolean found;
    
    public boolean remove(T t){
        root = remove(root, t);
        return found;
    }
    
    private BSTv2Node<T> remove(BSTv2Node<T> a, T t){
        if(a == null) found = false;
        else if(t.compareTo(a.getData()) < 0)
            a.setLeft(remove(a.getLeft(), t));
        else if(t.compareTo(a.getData()) > 0)
            a.setRight(remove(a.getRight(), t));
        else {
            // NOT SURE FROM HERE
            found = true;
            if(a.getCount() == 1) a = removeNode(a);
            else a.decrement();
        }
        return a;
    }
    
    private BSTv2Node<T> removeNode(BSTv2Node<T> a){
        if(a.getLeft() == null) return a.getRight();
        else if(a.getRight() == null) return a.getLeft();
        else {
            T t = (T) getPredecessor(a.getLeft());
            a.setData(t);
            a.setLeft(remove(a.getLeft(), t));
            return a;
        }
    }
    
    private T getPredecessor(BSTv2Node<T> a){
        while(a.getRight() != null) a = a.getRight();
        return a.getData();
    }
    
    //=============================================================
    // IN-ORDER, PRE-ORDER, POST-ORDER
    //=============================================================
    public static final int INORDER = 1;
    public static final int PREORDER = 2;
    public static final int POSTORDER = 3;
    private Queue<T> Q;
    private int traverse;
    
    public void showTree(){
        Q.showQueue();
    }
    
    public void setOrder(int a){
        traverse = a;
        Q = new Queue<>();
        if(traverse == INORDER) inOrder(root);
        else if(traverse == PREORDER) preOrder(root);
        else postOrder(root);
    }
    
    private void inOrder(BSTv2Node<T> a){
        if(a != null){
            inOrder(a.getLeft());
            Q.enqueue(a.getData());
            inOrder(a.getRight());
        }
    }
    
    private void preOrder(BSTv2Node<T> a){
        if(a != null){
            Q.enqueue(a.getData());
            preOrder(a.getLeft());
            preOrder(a.getRight());
        }
    }
    
    private void postOrder(BSTv2Node<T> a){
        if(a != null){
            postOrder(a.getLeft());
            postOrder(a.getRight());
            Q.enqueue(a.getData());
        }
    }
    
    //=============================================================
    // BALANCE THE TREE
    //=============================================================
    public void balance(){
        int size = this.getSize();
        setOrder(INORDER);
        T[] data = (T[]) new Comparable[size];
        for(int i = 0; i < size; i++) data[i] = Q.dequeue();
        root = null;
        insertBalanceTree(data, 0, size-1);
    }
    
    private void insertBalanceTree(T[] t, int low, int high){
        if(low == high) this.addNode(t[low]);
        else if((low + 1) == high){
            this.addNode(t[low]);
            this.addNode(t[high]);
        }
        else {
            int mid = (low + high) / 2;
            this.addNode(t[mid]);
            insertBalanceTree(t, low, mid-1);
            insertBalanceTree(t, mid+1, high);
        }
    }
    
    //=============================================================
    // GET THE MINIMUM & MAXIMUM VALUE
    //=============================================================
    public T getMin(){
        BSTv2Node<T> tmp = root;
        while(tmp.getLeft() != null) tmp = tmp.getLeft();
        return tmp.getData();
    }
    
    public T getMax(){
        BSTv2Node<T> tmp = root;
        while(tmp.getRight() != null) tmp = tmp.getRight();
        return tmp.getData();
    }
    
    //=============================================================
    // TO GET SUM OF ALL VALUES
    //=============================================================
    public int sum(){
        return sum(root);
    }
    
    private int sum(BSTv2Node root){
        if(root == null) return 0;
        return (int) root.getData() + sum(root.getLeft()) + sum(root.getRight());
    }
    
    //=============================================================
    // SPECIAL findOccurance() METHOD
    //=============================================================
    public int findOccurrence(BSTv2Node<T> root, T value) {
        if (root == null) {
            return 0;
        } else if (value.compareTo(root.getData()) < 0) {
            return findOccurrence(root.getLeft(), value);
        } else if (value.compareTo(root.getData()) > 0) {
            return findOccurrence(root.getRight(), value);
        } else {
            return root.getCount();
        }
    }
    
}
