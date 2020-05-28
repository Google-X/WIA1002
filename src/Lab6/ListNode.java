/*
 * ListNode for Queue
 */
package Lab6;

public class ListNode<T> {
    
    private T data;
    private ListNode link;
    
    public ListNode() {
        data = null;
        link = null;
    }

    public ListNode(T data, ListNode link) {
        this.data = data;
        this.link = link;
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
    
    // Question 4 toString()
    public String toStringStock(){
        String[] arr = String.valueOf(data).split(" ");
        
        String buyOrSell;
        if(arr[1].equals("B")) buyOrSell = "Buy";
        else buyOrSell = "Sell";
        
        return String.format("Day %s : %s %s shares at RM %s --> \n", arr[0], buyOrSell, arr[2], arr[3]);
    }
}
