
package T4;

import java.util.Random;

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
    
// Q2 method
    public void additionNode(){
        ListNode currentNode = head;
        while(currentNode != null){
            Double currentData = (Double) currentNode.getData();
            if(currentData > 20) currentNode.setData(currentData + 10.5);
            currentNode = currentNode.getLink();
        }
    }
    
// Q4 methods
    public T sum(){
        int ttl = 0;
        ListNode currentNode = head;
        if(head != null){
            while(currentNode != null){
                ttl += (Integer)currentNode.getData();
                currentNode = currentNode.getLink();
            }
        }
        return (T)(Integer)ttl;
    }
    
    public T even(){
        int counter = 0;
        ListNode currentNode = head;
        if(head != null){
            while(currentNode != null){
                if((Integer)currentNode.getData() % 2 == 0) counter++;
                currentNode = currentNode.getLink();
            }
        }
        return (T)(Integer)counter;
    }
    
// Q5 methods
    public void generateList(int n, int start, int end){
        Random r = new Random();
        for(int i = 0; i < n; i++){
            addNode((T)(Integer)(r.nextInt(end - start + 1) + start));
        }
        System.out.printf("Linked List has %d node(s)\n", length());
        showList();
    }
    
    public void deleteAll(T data){
        System.out.println("Delete " + data + " from the list.");
        ListNode currentNode = head;
        if(head == null){
            System.out.println("There is nothing in the list");
        } else {
            for(int i = 0; i < length(); i++){
                if(data.compareTo((T)currentNode.getData()) == 0)
                    deleteNodeByPosition(i);
                currentNode = currentNode.getLink();
            }
        }
        System.out.printf("Linked List has %d node(s)\n", length());
        showList();
    }
    
// Q6 method
    public void sort(){
        for(int i = 1; i < length(); i++){
            for(int j = 0; j < length()-1; j++){
                if(get(j).compareTo(get(j+1)) > 0){
                    T temp = get(j);
                    set(get(j+1), j);
                    set(temp, j+1);
                }
            }
        }
        System.out.print("The sorted list: ");
        showList();
    }
    
    public void showMedian(){
        // NOTE: get(int index)
        sort();
        if(length() % 2 == 0){
            System.out.println("The medians are: " + get(length()/2 - 1) + " & " + get((length()/2)));
        } else {
            System.out.println("The median is " + get(length()/2));
        }
    }
}
