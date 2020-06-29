/*
 * 5. Modify Q4 by using hash chain. Then, perform the following  
a. A method that returns the value of the element if the element can be found. 
b. A method that returns all the elements in the same location if the element can be found.  
Example output: [In Q5ArrayHashTableChaining.java]
 */
package Lab9;

public class Q5ArrayHashTable<K, V> {
    
    private int MAX = 20;
    private int size;
    private Q5HashChain<K, V>[] HashTable;
    
    public Q5ArrayHashTable(){
        size = 0;
        HashTable = new Q5HashChain[MAX];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == MAX;
    }

    public int getSize() {
        return size;
    }

    public void clear() {
        size = 0;
        HashTable = new Q5HashChain[MAX];
    }

    public void showHashTable() {
        if(isEmpty()) System.out.println("The table is empty.");
        else {
            for(int i = 0; i < MAX; i++){
                if(HashTable[i] != null) HashTable[i].showKeyAndVal();
            }
        }
    }
    
    public boolean containsKey(Comparable<K> key) {
        if(isEmpty()) {
            System.out.println("The table is empty.");
            return false;
        }
        else return HashTable[getHashCode((K) key)].containsKey(key);
    }

    public boolean containsValue(Comparable<V> val) {
        if(isEmpty()) System.out.println("The table is empty.");
        else {
            for(Q5HashChain<K, V> row : HashTable){
                if(row != null){
                    if(row.containsVal(val)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public V get(Comparable<K> key) {
        if(isEmpty()) {
            System.out.println("The table is empty.");
            return null;
        }
        else return HashTable[getHashCode((K) key)].get(key);
    }
    
    public V remove(Comparable<K> key) {
        if(isEmpty()) System.out.println("The table is empty.");
        else {
            int code = getHashCode((K) key);
            if(HashTable[code].containsKey(key)){
                V re = HashTable[code].get(key);
                HashTable[code].remove(key);
                size--;
                return re;
            }
        }
        return null;
    }
    
    // Question 5 Chaining
    public void put(K key, V val){
        if(!isFull()){
            if(HashTable[getHashCode(key)] == null){
                HashTable[getHashCode(key)] = new Q5HashChain<>(key, val);
                size++;
            } else {
                int code = getHashCode(key);
                if(!HashTable[code].containsKey((Comparable<K>) key)){
                    HashTable[code].addNode((Comparable<K>) key, val);
                    size++;
                } else {
                    HashTable[code].addNode((Comparable<K>) key, val);
                }
            }
        } else System.out.println("The table is full.");
    }
    
    private int getHashCode(K key){
        if(key instanceof Integer){
            return (Integer) key % MAX;
        } 
        return -1;
    }
    
    public void getLocation(Comparable<K> key){
        int code = getHashCode((K) key);
        if(HashTable[code].containsKey(key)){
            System.out.println("The elements in the same location are : ");
            HashTable[code].showList();
        }
    }

}