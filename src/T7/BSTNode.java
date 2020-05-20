
package T7;

public class BSTNode<T extends Comparable<T>>{
    
    private T data;
    private BSTNode leftLink;
    private BSTNode rightLink;

    public BSTNode() {
        data = null;
        leftLink = null;
        rightLink = null;
    }

    public BSTNode(T t, BSTNode l, BSTNode r) {
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

    public BSTNode getLeft() {
        return leftLink;
    }

    public void setLeft(BSTNode l) {
        leftLink = l;
    }

    public BSTNode getRight() {
        return rightLink;
    }

    public void setRight(BSTNode r) {
        rightLink = r;
    }
    
}
