/*
 * ListNode class for Stack
 */
package T5;

public class ListNode<T> {
    
    private T data;
    private ListNode link;

    public ListNode() {
        data = null;
        link = null;
    }
    
    public ListNode(T t, ListNode l) {
        data = t;
        link = l;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ListNode getLink() {
        return link;
    }

    public void setLink(ListNode link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return " <-- " + data;
    }
    
    public String toStringReverse(){
        return data + "";
    }
}
