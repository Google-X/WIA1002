/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package T4;

/**
 *
 * @author User
 */
public class CurrencyLinkedList<T extends Comparable<T>>{
    
    private CurrencyListNode head;

    public CurrencyLinkedList() {
        head = null;
    }
    
    public boolean isEmpty(){
        return head == null;
    }
    
    public void clear(){
        head = null;
    }
    
    public void showList(){
        CurrencyListNode currentNode = head;
        while(currentNode != null){
            System.out.print(currentNode.toString());
            currentNode = currentNode.getLink();
        }
        System.out.println();
    }
    
    public int length(){
        int counter = 0;
        CurrencyListNode currentNode = head;
        while(currentNode != null){
            counter++;
            currentNode = currentNode.getLink();
        }
        return counter;
    }
    
    public void addNode(T data){
        CurrencyListNode newNode = new CurrencyListNode(data, null);
        CurrencyListNode currentNode = head;
        if(head == null) head = newNode;
        else {
            while(currentNode.getLink() != null){
                currentNode = currentNode.getLink();
            }
            currentNode.setLink(newNode);
        }
    }
    
    public void deleteNode(){
        CurrencyListNode currentNode = head;
        CurrencyListNode previousNode = head;
        if(head != null){
            if(currentNode.getLink() == null){
                head = null;
            } else {
                while(currentNode.getLink() != null){
                    previousNode = currentNode;
                    currentNode = currentNode.getLink();
                }
                previousNode.setLink(null);
            }
        } else {
            System.out.println("The list is already empty.");
        }
    }
    
    public void addFrontNode(T data){
        head = new CurrencyListNode(data, head);
    }
    
    public void removeFrontNode(){
        if(head != null){
            head = head.getLink();
        } else {
            System.out.println("The list is empty");
        }
    }
    
    public boolean contains(T data){
        CurrencyListNode currentNode = head;
        while(currentNode != null){
            if(data.compareTo((T)currentNode.getData()) == 0){
                return true;
            }
            currentNode = currentNode.getLink();
        }
        return false;
    }
    
    public void setFront(T data){
        if(head != null){
            head.setData(data);
        } else{
            System.out.println("Cannot update. List is empty");
        }
    }
    
    public void setBack(T data){
        if(head != null){
            CurrencyListNode currentNode = head;
            while(currentNode.getLink() != null){
                currentNode = currentNode.getLink();
            }
            currentNode.setData(data);
        } else {
            System.out.println("Cannot update. List is empty");
        }
    }
    
    public void set(T data, int index){
        if(index == 0){
            setFront(data);
        } else if(index == length()-1){
            setBack(data);
        } else if(index >= length()){
            System.out.println("Invalid index. Update failed.");
        } else {
            CurrencyListNode currentNode = head;
            for(int i = 1; i <= index; i++){
                currentNode = currentNode.getLink();
            }
            currentNode.setData(data);
        }
    }
    
    public T getFront(){
        if(head != null) return (T) head.getData();
        else return null;
    }
    
    public T getBack(){
        if(head == null) return null;
        else {
            CurrencyListNode currentNode = head;
            while(currentNode.getLink() != null){
                currentNode = currentNode.getLink();
            }
            return (T) currentNode.getData();
        }
    }
    
    public T get(int index){
        if(index == 0) return getFront();
        else if(index == length()-1) return getBack();
        else if(index >= length()) return null;
        else {
            CurrencyListNode currentNode = head;
            for(int i = 1; i <= index; i++){
                currentNode = currentNode.getLink();
            }
            return (T) currentNode.getData();
        }
    }
    
}
