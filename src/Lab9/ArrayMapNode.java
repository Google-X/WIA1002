/*
3. Create an ADT HashTable named ArrayHashTable. The ADT consists of the following method and the maximum size of the ADT is 20. The ADT consists of the following method 
*/
package Lab9;

public class ArrayMapNode<K, V> {
    
    private K key;
    private V value;

    public ArrayMapNode() {
        key = null;
        value = null;
    }

    public ArrayMapNode(K a, V b) {
        key = a;
        value = b;
    }

    public void setKey(K a) {
        key = a;
    }

    public K getKey() {
        return key;
    }

    public void setValue(V a) {
        value = a;
    }

    public V getValue() {
        return value;
    }

    public String toString() {
        return key + " : " + value + " | ";
    }

}