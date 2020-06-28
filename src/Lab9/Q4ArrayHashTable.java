/*
 * 4. Create a program to read the products from a text file (lab9Q4.txt). The product consists of PID and Description. Store the products in a class ArrayHashTableHashing. (Modify the ArrayHashTable created in Q3). Create the hash method that hashes the key by modulus the array size. Use linear probing if Collision occurs. Then, perform the following 
a. A method that returns the value of the element if the element can be found. 
b. A method that returns the location of the element if the element can be found.
 */
package Lab9;

public class Q4ArrayHashTable<K, V> {
    
    private int MAX = 20;
    private int size;
    private ArrayMapNode<K, V>[] HashTable;
    
    public Q4ArrayHashTable(){
        size = 0;
        HashTable = new ArrayMapNode[MAX];
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
        HashTable = new ArrayMapNode[MAX];
    }

    public void showHashTable() {
        if(isEmpty()) System.out.println("The table is empty.");
        else {
            for(int i = 0; i < MAX; i++){
                if(HashTable[i] != null) System.out.println(HashTable[i].toString());
            }
        }
    }
    
    public boolean containsKey(Comparable<K> key) {
        if(isEmpty()) System.out.println("The table is empty.");
        else {
            for(ArrayMapNode<K, V> row : HashTable){
                if(row != null){
                    if(key.compareTo(row.getKey()) == 0){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean containsValue(Comparable<V> val) {
        if(isEmpty()) System.out.println("The table is empty.");
        else {
            for(ArrayMapNode<K, V> row : HashTable){
                if(row != null){
                    if(val.compareTo(row.getValue()) == 0){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public V get(Comparable<K> key) {
        for(ArrayMapNode<K, V> row : HashTable){
            if(row != null){
                if(key.compareTo(row.getKey()) == 0){
                    return row.getValue();
                }
            }
        }
        return null;
    }
    
    public V remove(Comparable<K> key) {
        if(!isEmpty()) {
            for(int i = 0; i < MAX; i++){
                if(HashTable[i] != null){
                    if(key.compareTo(HashTable[i].getKey()) == 0){
                        V re = HashTable[i].getValue();
                        HashTable[i] = null;
                        size--;
                        return re;
                    }
                }
                if(i == MAX-1) System.out.println("There is no key : " + key);
            }
        } else System.out.println("The table is empty.");
        return null;
    }
    
    // Question 4 Hashing
    public void put(K key, V val){
        if(!isFull()){
            if(HashTable[getHashCode(key)] == null){
                HashTable[getHashCode(key)] = new ArrayMapNode<>(key, val);
                size++;
            }else{
                for (int i = getHashCode(key) + 1; i < MAX; i++) {
                    if (HashTable[i] == null) {
                        HashTable[i] = new ArrayMapNode<>(key, val);
                        size++;
                        break;
                    }
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
    
    public int getLocation(Comparable<K> key){
        for(int i = 0; i < MAX; i++){
            if(HashTable[i] != null){
                if(key.compareTo(HashTable[i].getKey()) == 0) return i;
            }
        }
        return -1;
    }

}