/*
3. Create an ADT HashTable named ArrayHashTable. The ADT consists of the following method and the maximum size of the ADT is 20. The ADT consists of the following method 
*/
package Lab9;

public class ArrayHashTable<K, V> implements ArrayHashTableADT<K, V>{
    
    private int size, index;
    private ArrayMapNode<K, V>[] HashTable;
    
    public ArrayHashTable(){
        size = 0;
        index = 0;
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
        HashTable = new ArrayMapNode[MAX];
    }

    public void showHashTable() {
        for(int i = 0; i < index; i++){
            System.out.print(HashTable[i].toString() + " | ");
        }
    }
    
    public void search(Comparable<K> key){
        for(int i = 0; i < index; i++){
            if(key.compareTo(HashTable[i].getKey()) == 0){
                System.out.println("Course " + HashTable[i].toString());
                return;
            }
        }
        System.out.println("There is no key : " + key);
    }
    
    public boolean containsKey(Comparable<K> key) {
        for(int i = 0; i < index; i++){
            if(key.compareTo(HashTable[i].getKey()) == 0){
                return true;
            }
        }
        return false;
    }

    public boolean containsValue(Comparable<V> val) {
        for(int i = 0; i < index; i++){
            if(val.compareTo(HashTable[i].getValue()) == 0){
                return true;
            }
        }
        return false;
    }

    public V get(Comparable<K> key) {
        for(int i = 0; i < index; i++){
            if(key.compareTo(HashTable[i].getKey()) == 0){
                return HashTable[i].getValue();
            }
        }
        return null;
    }

    public void put(Comparable<K> key, V val) {
        
        // First insertion
        if(isEmpty()){
            HashTable[index] = new ArrayMapNode<>();
            HashTable[index].setKey((K) key);
            HashTable[index].setValue(val);
            index++;
            size++;
            return;
        }
        
        // Second insertion and so on
        if(containsKey(key)){
            for(int i = 0; i < index; i++){
                if(key.compareTo(HashTable[i].getKey()) == 0){
                    HashTable[i].setValue(val);
                    return;
                }
            }
        } else {
            if (!isFull()) {
                HashTable[index] = new ArrayMapNode<>();
                HashTable[index].setKey((K) key);
                HashTable[index].setValue(val);
                index++;
                size++;
            } 
        }
    }

    public V remove(Comparable<K> key) {
        if(!isEmpty()) {
            for(int i = 0; i < index; i++){
                if(key.compareTo(HashTable[i].getKey()) == 0){
                    V re = HashTable[i].getValue();
                    HashTable[i].setKey(HashTable[index-1].getKey());
                    HashTable[i].setValue(HashTable[index-1].getValue());
                    HashTable[index-1] = new ArrayMapNode<>();
                    index--;
                    size--;
                    return re;
                }
                if(i == index-1) System.out.println("There is no key : " + key);
            }
        } else System.out.println("HashTableEmptyException");
        
        return null;
    }
    
}