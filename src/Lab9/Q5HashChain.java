/*
 * Sort of like LinkedList 
 */
package Lab9;

public class Q5HashChain<K, V> {
    
    private Q5HashChainNode head;
    private int size;
    
    public Q5HashChain(){
        size = 0;
        head = null;
    }
    
    public Q5HashChain(K key, V val){
        Q5HashChainNode newNode = new Q5HashChainNode(key, val, null);
        head = newNode;
        size = 1;
    }
    
    public void clear(){
        head = null;
        size = 0;
    }
    
    public int getSize() {
        return size;
    }
    
//  WHEN FOUND THE SAME KEY, AMEND THE VALUE
    public void addNode(Comparable<K> key, V val){
        if(containsKey(key)){
            getNodeByKey(key).setVal(val);
        } else {
            Q5HashChainNode newNode = new Q5HashChainNode(key, val, null);
            Q5HashChainNode currentNode = head;
            if(head == null) head = newNode;
            else {
                while(currentNode.getLink() != null){
                    currentNode = currentNode.getLink();
                }
                currentNode.setLink(newNode);
                size++;
            }
        }
    }
    
//  REMOVE KEY
    public void remove(Comparable<K> key){
        if(containsKey(key)){
            int index = indexOf(key);
            if(index == 0) deleteFrontNode();
            else if (index == size-1) deleteLastNode();
            else if(index >= size) System.out.println("Invalid index. No node is deleted.");
            else {
                Q5HashChainNode currentListNode = head;
                for(int i = 1; i < index; i++) currentListNode = currentListNode.getLink();
                currentListNode.setLink(currentListNode.getLink().getLink());
                size--;
            }
        } else System.out.println("No such key : " + key);
    }
    
    private int indexOf(Comparable<K> key){
        int index = 0;
        Q5HashChainNode currentNode = head;
        while(currentNode != null){
            if(key.compareTo((K) currentNode.getKey()) == 0) return index;
            currentNode = currentNode.getLink();
            index++;
        }
        return -1;
    }
    
    private void deleteFrontNode(){
        if(head != null) {
            head = head.getLink();
            size--;
        }
        else System.out.println("The list is empty");
    }
    
    private void deleteLastNode(){
        Q5HashChainNode currentNode = head;
        if(head != null) {
            if(currentNode.getLink() == null) head = null;
            else {
                while(currentNode.getLink().getLink() != null){
                    currentNode = currentNode.getLink();
                }
                currentNode.setLink(null);
            }
            size--;
        }
    }
    
    public void showList(){
        Q5HashChainNode currentNode = head;
        while(currentNode != null){
            System.out.print(currentNode.toString());
            currentNode = currentNode.getLink();
        }
        System.out.println();
    }
    
    public void showKeyAndVal(){
        Q5HashChainNode currentNode = head;
        while(currentNode != null){
            System.out.println(currentNode.toStringNoArrow());
            currentNode = currentNode.getLink();
        }
    }
    
    public V get(Comparable<K> key){
        Q5HashChainNode currentNode = head;
        while(currentNode != null){
            if(key.compareTo((K) currentNode.getKey()) == 0){
                return (V) currentNode.getVal();
            }
            currentNode = currentNode.getLink();
        }
        System.out.println("No such key : " + key);
        return null;
    }
    
    public boolean containsKey(Comparable<K> key){
        Q5HashChainNode currentNode = head;
        while(currentNode != null){
            if(key.compareTo((K) currentNode.getKey()) == 0){
                return true;
            }
            currentNode = currentNode.getLink();
        }
        return false;
    }
    
    public boolean containsVal(Comparable<V> val){
        Q5HashChainNode currentNode = head;
        while(currentNode != null){
            if(val.compareTo((V) currentNode.getVal()) == 0){
                return true;
            }
            currentNode = currentNode.getLink();
        }
        return false;
    }
    
    public Q5HashChainNode getNodeByKey(Comparable<K> key){
        Q5HashChainNode currentNode = head;
        while(currentNode != null){
            if(key.compareTo((K) currentNode.getKey()) == 0){
                return currentNode;
            }
            currentNode = currentNode.getLink();
        }
        return null;
    }
    
    public Q5HashChainNode getNodeByValue(Comparable<V> val){
        Q5HashChainNode currentNode = head;
        while(currentNode != null){
            if(val.compareTo((V) currentNode.getVal()) == 0){
                return currentNode;
            }
            currentNode = currentNode.getLink();
        }
        return null;
    }
}
