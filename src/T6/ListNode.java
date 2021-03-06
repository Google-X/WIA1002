/*
 * ListNode for Queue
 */
package T6;

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
        return data + " --> ";
    }
    
    // LAB 7 Q3
    public String toStringStack(){
        return " <-- " + data;
    }
    
    // For Tutorial Question 3
    public String toStringCustomer(){
        return data + " set(s) -->\n";
    }
    
    // For Tutorial Question 4
    public String toStringPalindrome(){
        return data + "";
    }
    // Change commit
}
