/*
3. Create an ADT HashTable named ArrayHashTable. The ADT consists of the following method and the maximum size of the ADT is 20. The ADT consists of the following method 
*/
package Lab9;

import java.util.ArrayList;

public class ArrayHashTable<K, V> implements ArrayHashTableADT<K, V>{
    
    private int size, index;
    private ArrayList<Integer> removedIndex;
    private ArrayMapNode<K, V>[] HashTable;
    
    public ArrayHashTable(){
        size = 0;
        index = 0;
        removedIndex = new ArrayList<>();
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
            if(removedIndex.contains(i)) continue;
            System.out.print(HashTable[i].toString());
        }
    }

    public boolean containsKey(Comparable<K> key) {
        for(int i = 0; i < index; i++){
            if(removedIndex.contains(i)) continue;
            if(key.compareTo(HashTable[i].getKey()) == 0){
                System.out.println(HashTable[i].toString());
                return true;
            }
        }
        return false;
    }

    public boolean containsValue(Comparable<V> val) {
        for(int i = 0; i < index; i++){
            if(removedIndex.contains(i)) continue;
            if(val.compareTo(HashTable[i].getValue()) == 0){
                return true;
            }
        }
        return false;
    }

    public V get(Comparable<K> key) {
        for(int i = 0; i < index; i++){
            if(removedIndex.contains(i)) continue;
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
        if(!containsKey(key)){
            if(!removedIndex.isEmpty()){
                int getIndex = removedIndex.remove(0);
                HashTable[getIndex].setKey((K) key);
                HashTable[getIndex].setValue(val);
                size++;
            } else if (!isFull()) {
                HashTable[index] = new ArrayMapNode<>();
                HashTable[index].setKey((K) key);
                HashTable[index].setValue(val);
                index++;
                size++;
            } else if(isFull()) {
                System.out.println("Cannot add, table is full.");
            }
        } else {
            for(int i = 0; i < index; i++){
                if(removedIndex.contains(i)) continue;
                if(key.compareTo(HashTable[i].getKey()) == 0){
                    HashTable[i].setValue(val);
                    return;
                }
            }
        }
        
        
    }

    public V remove(Comparable<K> key) {
        if(isEmpty()) System.out.println("Nothing to removed");
        for(int i = 0; i < index; i++){
            if(removedIndex.contains(i)) continue;
            if(key.compareTo(HashTable[i].getKey()) == 0){
                V re = HashTable[i].getValue();
                HashTable[i] = new ArrayMapNode<>();
                removedIndex.add(i);
                size--;
                return re;
            }
        }
        return null;
    }
    
}
