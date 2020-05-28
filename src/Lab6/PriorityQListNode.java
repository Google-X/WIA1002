
package Lab6;

public class PriorityQListNode<T extends Packet>{
    
    private T data;
    private PriorityQListNode link;
    
    public PriorityQListNode() {
        data = null;
        link = null;
    }

    public PriorityQListNode(T data, PriorityQListNode link) {
        this.data = data;
        this.link = link;
    }
    
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public PriorityQListNode getLink() {
        return link;
    }

    public void setLink(PriorityQListNode link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return data + " --> ";
    }
}
