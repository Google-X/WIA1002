/*
 * Lab 5: ListNode for Stack
 */
package Lab5;

public class ListNode<E> {
    
    private E data;
    private ListNode link;

    public ListNode() {
        data = null;
        link = null;
    }

    public ListNode(E data, ListNode link) {
        this.data = data;
        this.link = link;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
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
}
