
package Lab9;

public class Q5HashChainNode<K, V> {
    
    private K key;
    private V val;
    private Q5HashChainNode link;

    public Q5HashChainNode(K key, V val, Q5HashChainNode link) {
        this.key = key;
        this.val = val;
        this.link = link;
    }
    
    public Q5HashChainNode() {
        key = null;
        val = null;
        link = null;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getVal() {
        return val;
    }

    public void setVal(V val) {
        this.val = val;
    }

    public Q5HashChainNode getLink() {
        return link;
    }

    public void setLink(Q5HashChainNode link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return key + " : " + val + " --> ";
    }
    
    public String toStringNoArrow() {
        return key + " : " + val;
    }
}
