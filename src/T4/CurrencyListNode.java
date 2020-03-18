
package T4;

public class CurrencyListNode<T> {
    
    private T data;
    private CurrencyListNode link;

    public CurrencyListNode(T data, CurrencyListNode link) {
        this.data = data;
        this.link = link;
    }
    
    public CurrencyListNode() {
        data = null;
        link = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public CurrencyListNode getLink() {
        return link;
    }

    public void setLink(CurrencyListNode link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return data + " --> ";
    }
}
