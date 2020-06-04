package Lab7;

public class BSTNode<T extends Comparable<T>> {
    
    private T data;
    private BSTNode<T> leftLink;
    private BSTNode<T> rightLink;

    public BSTNode() {
        data = null;
        leftLink = null;
        rightLink = null;
    }

    public BSTNode(T t, BSTNode<T> l, BSTNode<T> r) {
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

    public BSTNode<T> getLeft() {
        return leftLink;
    }

    public void setLeft(BSTNode<T> l) {
        leftLink = l;
    }
    
    public BSTNode<T> getRight() {
        return rightLink;
    }

    public void setRight(BSTNode<T> r) {
        rightLink = r;
    }
}
