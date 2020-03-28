
package Lab4;

public class DoubleListNode<E> {
    
    private E data;
    private DoubleListNode previousLink;
    private DoubleListNode nextLink;

    public DoubleListNode() {
        data = null;
        previousLink = null;
        nextLink = null;
    }

    public DoubleListNode(E e, DoubleListNode a, DoubleListNode b) {
        data = e;
        previousLink = a;
        nextLink = b;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }
    
    public void setLink(DoubleListNode prev, DoubleListNode next){
        previousLink = prev;
        nextLink = next;
    }
    
    public DoubleListNode getPreviousLink() {
        return previousLink;
    }

    public void setPreviousLink(DoubleListNode p) {
        previousLink = p;
    }

    public DoubleListNode getNextLink() {
        return nextLink;
    }

    public void setNextLink(DoubleListNode n) {
        nextLink = n;
    }

    @Override
    public String toString() {
        return " <-- " + data + " --> ";
    }
}
