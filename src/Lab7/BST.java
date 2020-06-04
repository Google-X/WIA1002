
package Lab7;

import T6.Queue;

public class BST<T extends Comparable<T>> {
    
    private BSTNode root;
    
    public BST(){
        root = null;
    }
    
    public BSTNode getRoot(){
        return root;
    }
    
    public boolean isEmpty(){
        return root == null;
    }
    
    public int getSize(){
        return getSize(root);
    }
    
    private int getSize(BSTNode<T> a){
        if(a == null) return 0;
        else return getSize(a.getLeft()) + getSize(a.getRight()) + 1;
    }
    
    public boolean contains(T t){
        return find(root, t);
    }
    
    private boolean find(BSTNode<T> a, T t){
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
    
    private T getElement(BSTNode<T> a, T t){
        if(a == null) return null;
        else if(t.compareTo(a.getData()) < 0)
            return getElement(a.getLeft(), t);
        else if(t.compareTo(a.getData()) > 0)
            return getElement(a.getRight(), t);
        else return a.getData();
    }
    
    // ADDING
    public void addNode(T t){
        root = add(root, t);
    }
    
    private BSTNode<T> add(BSTNode<T> a, T t){
        if(a == null) a = new BSTNode<>(t, null, null);
        else if(t.compareTo(a.getData()) <= 0)
            a.setLeft(add(a.getLeft(), t));
        else if(t.compareTo(a.getData()) > 0)
            a.setRight(add(a.getRight(), t));
        return a;
    }
    
    // REMOVING
    private boolean found;
    
    public boolean remove(T t){
        root = remove(root, t);
        return found;
    }
    
    private BSTNode<T> remove(BSTNode<T> a, T t){
        if(a == null) found = false;
        else if(t.compareTo(a.getData()) < 0)
            a.setLeft(remove(a.getLeft(), t));
        else if(t.compareTo(a.getData()) > 0)
            a.setRight(remove(a.getRight(), t));
        else {
            a = removeNode(a);
            found = true;
        }
        return a;
    }
    
    private BSTNode<T> removeNode(BSTNode<T> a){
        if(a.getLeft() == null) return a.getRight();
        else if(a.getRight() == null) return a.getLeft();
        else {
            T t = (T) getPredecessor(a.getLeft());
            a.setData(t);
            a.setLeft(remove(a.getLeft(), t));
            return a;
        }
    }
    
    private T getPredecessor(BSTNode<T> a){
        while(a.getRight() != null) a = a.getRight();
        return a.getData();
    }
    
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
    
    private void inOrder(BSTNode<T> a){
        if(a != null){
            inOrder(a.getLeft());
            Q.enqueue(a.getData());
            inOrder(a.getRight());
        }
    }
    
    private void preOrder(BSTNode<T> a){
        if(a != null){
            Q.enqueue(a.getData());
            preOrder(a.getLeft());
            preOrder(a.getRight());
        }
    }
    
    private void postOrder(BSTNode<T> a){
        if(a != null){
            postOrder(a.getLeft());
            postOrder(a.getRight());
            Q.enqueue(a.getData());
        }
    }
    
    // BALANCING
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
    
    // Question 1 methods
    // TO GET MINIMUM
    public T getMin(){
        BSTNode<T> tmp = root;
        while(tmp.getLeft() != null) tmp = tmp.getLeft();
        return tmp.getData();
    }
    
    public T getMax(){
        BSTNode<T> tmp = root;
        while(tmp.getRight() != null) tmp = tmp.getRight();
        return tmp.getData();
    }
    
    // TO GET TOTAL VALUE
    public int sum(){
        return sum(root);
    }
    
    private int sum(BSTNode root){
        if(root == null) return 0;
        return (int) root.getData() + sum(root.getLeft()) + sum(root.getRight());
    }
    
    /* LONGER METHOD
    private int sum(BSTNode a){
        if (a.getLeft() == null && a.getRight() == null) {
            return (int) a.getData();
        } else if (a.getLeft() == null) {
            return (int) a.getData() + sum(a.getRight());
        } else if (a.getRight() == null) {
            return (int) a.getData() + sum(a.getLeft());
        } else {
            return (int) a.getData() + sum(a.getLeft()) + sum(a.getRight());
        }
    }
    */
    
    // TO COUNT THE NUMBER OF OCCURANCE
    private static int cnt;
    public int numberCount(T t){
        cnt = 0;
        return numberCount(root, t);
    }
    
    private int numberCount(BSTNode<T> a, T t){
        if(a == null) return cnt;
        else if(t.compareTo(a.getData()) < 0)
            return numberCount(a.getLeft(), t);
        else if(t.compareTo(a.getData()) > 0)
            return numberCount(a.getRight(), t);
        else {
            cnt++;
            return numberCount(a.getLeft(), t);
        }
    }
    
    // Another way of finding occurance by Yan Cheng[Better], no need create cnt
    public int findOccurence(T t) {
        return findOccurence(root, t, 0);
    }

    public int findOccurence(BSTNode<T> a, T t, int count) {
        if (a == null) {
            return count;
        } else if (t.compareTo(a.getData()) < 0) {
            return findOccurence(a.getLeft(), t, count);
        } else if (t.compareTo(a.getData()) > 0) {
            return findOccurence(a.getRight(), t, count);
        } else {
            return count + 1 + findOccurence(a.getLeft(), t, count);
        }
    }
    
    // WORD FREQUENCY GENERATOR
    public void wordCounter(){
        System.out.println("Word Frequency Generator Program");
        setOrder(BST.INORDER);
        int cnt = 1;
        while(!Q.isEmpty()){
            T tmp = Q.dequeue();
            if(!Q.isEmpty()){
                if(tmp.compareTo(Q.peek()) == 0) cnt++;
                else {
                    System.out.printf("%04d %s -->\n", cnt, tmp);
                    cnt = 1;
                }
            }
        }
    }
    
    // EXPRESSION
//    public void addLeftNode(T t){
//        BSTNode<T> left = new BSTNode<>();
//        left.setData(t);
//        root.setLeft(left);
//    }
//    
//    public void addRightNode(T t){
//        BSTNode<T> right = new BSTNode<>();
//        right.setData(t);
//        root.setRight(right);
//    }
//    
    
}