
package T4;

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
            counter++;
            currentNode = currentNode.getLink();
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
        head = new ListNode(data, head);
    }
    
    public void removeFrontNode(){
        if(head != null){
            head = head.getLink();
        } else {
            System.out.println("The list is empty");
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
    
}
