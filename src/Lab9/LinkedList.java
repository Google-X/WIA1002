/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab9;

public class LinkedList<T extends Comparable<T>> {
    
    private ListNode head;

    public LinkedList() {
        head = null;
    }
    
    public boolean isEmpty(){
        return head == null;
    }
    
    public void clear(){
        head = null;
    }
    
    public void showList(){
        ListNode currentNode = head;
        while(currentNode != null){
            System.out.print(currentNode.toString());
            currentNode = currentNode.getLink();
        }
        System.out.println();
    }
    
    public int length(){
        int counter = 0;
        ListNode currentNode = head;
        while(currentNode != null){
            currentNode = currentNode.getLink();
            counter++;
        }
        return counter;
    }
    
    public void addNode(T data){
        ListNode newNode = new ListNode(data, null);
        ListNode currentNode = head;
        if(head == null) head = newNode;
        else {
            while(currentNode.getLink() != null){
                currentNode = currentNode.getLink();
            }
            currentNode.setLink(newNode);
        }
    }
    
    public void deleteNodeShorter(){
        ListNode currentNode = head;
        if(head != null) {
            if(currentNode.getLink() == null) head = null;
            else {
                while(currentNode.getLink().getLink() != null){
                    currentNode = currentNode.getLink();
                }
                currentNode.setLink(null);
            }
        }
    }
    
    public void deleteNode(){
        ListNode currentNode = head;
        ListNode previousNode = head;
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
        head = new ListNode(data, head); // the link cannot be null, as the link need to be link to the previous head
    }
    
    public void deleteFrontNode(){
        if(head != null){
            head = head.getLink();
        } else {
            System.out.println("The list is empty");
        }
    }
    
    public void addNodeByPosition(T data, int index){
        if(index == 0) addFrontNode(data);
        else if (index == length()) addNode(data);
        else if(index > length()) System.out.println("Invalid index. No node is added");
        else {
            ListNode newNode = new ListNode(data, null);
            ListNode currentListNode = head;
            for(int i = 1; i < index; i++) currentListNode = currentListNode.getLink();
            ListNode tempNode = currentListNode.getLink();
            currentListNode.setLink(newNode);
            newNode.setLink(tempNode);
        }
    }
    
    public void addNodeByPositionShorter(T data, int index){
        if(index == 0) addFrontNode(data);
        else if (index == length()) addNode(data);
        else if(index > length()) System.out.println("Invalid index. No node is added");
        else {
            ListNode currentNode = head;
            for(int i = 1; i < index; i++) currentNode = currentNode.getLink();
            ListNode newNode = new ListNode(data, currentNode.getLink());
            currentNode.setLink(newNode);
        }
    }
    
    public void deleteNodeByPosition(int index){
        if(index == 0) deleteFrontNode();
        else if (index == length()-1) deleteNode();
        else if(index >= length()) System.out.println("Invalid index. No node is deleted.");
        else {
            ListNode currentListNode = head;
            for(int i = 1; i < index; i++) currentListNode = currentListNode.getLink();
            ListNode tempNode = currentListNode.getLink();
            currentListNode.setLink(tempNode.getLink());
            tempNode = null;
        }
    }
    
    public void deleteNodeByPositionShorter(int index){
        if(index == 0) deleteFrontNode();
        else if (index == length()-1) deleteNode();
        else if(index >= length()) System.out.println("Invalid index. No node is deleted.");
        else {
            ListNode currentListNode = head;
            for(int i = 1; i < index; i++) currentListNode = currentListNode.getLink();
            currentListNode.setLink(currentListNode.getLink().getLink());
        }
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
            ListNode currentNode = head;
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
            ListNode currentNode = head;
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
            ListNode currentNode = head;
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
            ListNode currentNode = head;
            for(int i = 1; i <= index; i++){
                currentNode = currentNode.getLink();
            }
            return (T) currentNode.getData();
        }
    }
    
    // Question 2
    public boolean contains(T data){
        ListNode currentNode = head;
        while(currentNode != null){
            if(data.compareTo((T)currentNode.getData()) == 0){
                return true;
            }
            currentNode = currentNode.getLink();
        }
        return false;
    }
    
    public int occurenceOf(T data){
        int count = 0;
        ListNode currentNode = head;
        while(currentNode != null){
            if(data.compareTo((T)currentNode.getData()) == 0){
                count++;
            }
            currentNode = currentNode.getLink();
        }
        return count;
    }
    
    public boolean containsBetween(T d1, T d2){
        ListNode currentNode = head;
        while(currentNode != null){
            if(d1.compareTo((T)currentNode.getData()) <= 0 && d2.compareTo((T)currentNode.getData()) >= 0){
                return true;
            }
            currentNode = currentNode.getLink();
        }
        return false;
    }
    
    public int occurenceBetween(T d1, T d2){
        int count = 0;
        ListNode currentNode = head;
        while(currentNode != null){
            if(d1.compareTo((T)currentNode.getData()) <= 0 && d2.compareTo((T)currentNode.getData()) >= 0){
                count++;
            }
            currentNode = currentNode.getLink();
        }
        return count;
    } 
}
