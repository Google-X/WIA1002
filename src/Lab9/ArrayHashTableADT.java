/*
3. Create an ADT HashTable named ArrayHashTable. The ADT consists of the following method and the maximum size of the ADT is 20. The ADT consists of the following method 
a. Constructor 
b. isEmpty 
c. isFull 
d. getSize 
e. clear 
f. showHashTable 
g. containsKey 
h. containsValue 
i. get 
j. put 
k. remove 
*/
package Lab9;

public interface ArrayHashTableADT<K, V> {
    
    public int MAX = 5;
    public boolean isEmpty();
    public boolean isFull();
    public int getSize();
    public void clear();
    public void showHashTable();
    public boolean containsKey(Comparable<K> key);
    public boolean containsValue(Comparable<V> val);
    public V get(Comparable<K> key);
    public void put(Comparable<K> key, V val);
    public V remove(Comparable<K> key);
    
}
