/*
 * Linked List for all Lab 4 questions
 */
package Lab4;

public class LinkedList<E extends Comparable<E>> {
    private ListNode head;

    public LinkedList() {
        head = null;
    }
    
    /**
     * c = current node
     * @return the size of the linked list
     */
    public int length(){
        int counter = 0;
        ListNode c = head;
        while(c != null){
            c = c.getLink();
            counter++;
        }
        return counter;
    }
    
    public void clear(){
        head = null;
    }
    
    public boolean isEmpty(){
        return head == null;
    }
    
    public void showList(){
        ListNode c = head;
        while(c != null){
            System.out.print(c.toString());
            c = c.getLink();
        }
    }
    
    /**
     * n = new node; c = current node
     * @param e = data to be added
     */
    public void addLastNode(E e){
        ListNode n = new ListNode(e, null);
        if(head == null) head = n;
        else {
            ListNode c = head;
            while(c.getLink() != null){
                c = c.getLink();
            }
            c.setLink(n);
        }
    }
    
    /**
     * c = current node; p = previous node
     * @return the deleted data
     */
    public E deleteLastNode(){
        ListNode p = null;
        ListNode c = head;
        if(head != null){
            if(c.getLink() == null){
                head = null;
            } else {
                while(c.getLink() != null){
                    p = c;
                    c = c.getLink();
                }
                p.setLink(null);
            }
        }
        return (E) c.getData();
    }
    
    public void addFirstNode(E e){
        head = new ListNode(e, head);
    }
    
    public E deleteFirstNode(){
        if(head == null) return null;
        else {
            E val = (E) head.getData();
            head = head.getLink();
            return val;
        }
    }
    
    public boolean contains(E e){
        ListNode c = head;
        while(c != null){
            if(e.compareTo((E) c.getData()) == 0) return true;
            c = c.getLink();
        }
        return false;
    }
    
    /**
     * @param e = data
     * @param i = index
     * n = new node
     */
    public void addNodeByPosition(E e, int i){
        if(i == 0) addFirstNode(e);
        else if(i == length()) addLastNode(e);
        else if(i > length()) System.err.println("IndexOutOfBound Exception");
        else {
            ListNode c = head;
            for(int j=1;j<i;j++) c = c.getLink();
            ListNode n = new ListNode(e, c.getLink());
            c.setLink(n);
        }
    }
    
    /**
     * @param i = index
     * @return deleted data
     */
    public E deleteNodeByPosition(int i){
        if(i == 0) return deleteFirstNode();
        else if(i == length()-1) return deleteLastNode();
        else if(i >= length()) {
            System.err.println("IndexOutOfBound Exception");
            return null;
        }
        else {
            ListNode c = head;
            for(int j=1;j<1;j++) c = c.getLink();
            c.setLink(c.getLink().getLink());
            return (E) c.getLink().getData();
        }
    }
    
    public void setFrontData(E e){
        if(head != null) head.setData(e);
        else System.err.println("EmptyLinkedList Exception");
    }
    
    public void setLastData(E e){
        if(head != null){
            ListNode c = head;
            while(c.getLink() != null) c = c.getLink();
            c.setData(e);
        } else System.err.println("EmptyLinkedList Exception");
    }
    
    public void set(E e, int i){
        if(i == 0) setFrontData(e);
        else if(i == length()-1) setLastData(e);
        else if(i >= length()) System.err.println("IndexOutOfBound Exception");
        else {
            ListNode c = head;
            for(int j=1;j<=i;j++) c = c.getLink();
            c.setData(e);
        }
    }
    
    public E getFrontData(){
        if(head != null) return (E) head.getData();
        else {
            System.err.println("EmptyLinkedList Exception");
            return null;
        }
    }
    
    public E getLastData(){
        if(head != null){
            ListNode c = head;
            while(c.getLink() != null) c = c.getLink();
            return (E) c.getData();
        } else {
            System.err.println("EmptyLinkedList Exception");
            return null;
        }
    }
    
    public E get(int i){
        if(i == 0) return getFrontData();
        else if(i == length()-1) return getLastData();
        else if(i >= length()){
            System.err.println("IndexOutOfBound Exception");
            return null;
        } else {
            ListNode c = head;
            for(int j=1;j<=i;j++) c = c.getLink();
            return (E) c.getData();
        }
    }
    
// Question 1c method
    public void addSortNode(E e){
        if(head == null) addFirstNode(e);
        else {
            if(length() == 1){
                if(e.compareTo(get(0)) >= 0) addLastNode(e);
                else addFirstNode(e);
            } else {
                for(int i = 0; i < length()-1; i++){
                    if(e.compareTo(get(i)) >= 0){
                        if(e.compareTo(get(i+1)) <= 0){
                            addNodeByPosition(e, i+1);
                            return;
                        }
                    } else {
                        addNodeByPosition(e, i);
                        return;
                    }
                }
                if(e.compareTo(get(length()-1)) >= 0) addLastNode(e);
                else addFirstNode(e);
            }
        }
    }
    
// Question 2 methods
    public LinkedList<E>[] splitList(){
        LinkedList<E>[] ret = new LinkedList[2];
        ret[0] = new LinkedList<>();
        ret[1] = new LinkedList<>();
        if(length()%2 == 0){
            for(int i=0;i<length()/2;i++)ret[0].addLastNode(get(i));
            for(int i=length()/2;i<length();i++)ret[1].addLastNode(get(i));
        } else {
            for(int i=0;i<(length()/2)+1;i++)ret[0].addLastNode(get(i));
            for(int i=(length()/2)+1;i<length();i++)ret[1].addLastNode(get(i));
        }
        
        return ret;
    }
    
    public LinkedList<E>[] alternateList(){
        LinkedList<E>[] ret = new LinkedList[2];
        ret[0] = new LinkedList<>();
        ret[1] = new LinkedList<>();
        
        for(int i=0;i<length();i++){
            if(i%2==0) ret[0].addLastNode(get(i));
            else ret[1].addLastNode(get(i));
        }
        
        return ret;
    }
    
    public void mergeList(LinkedList<E> list){
        int size = length() + list.length();
        for(int i=0,j=0;i<size;i++){
            if(i%2 != 0) {
                addNodeByPosition(list.get(j), i);
                j++;
            }
        }
    }
    
    public void reverse(int size){
        if(length()%2 == 0){
            if(size >= length()/2 + 1){
                E tmp = get(size-1);
                set(get(length()-size), size-1);
                set(tmp, length()-size);
                reverse(size-1);
            }
        } else {
            if(size > length()/2){
                E tmp = get(size-1);
                set(get(length()-size), size-1);
                set(tmp, length()-size);
                reverse(size-1);
            }
        }
            
        /* // Using original list, two parameters
        if(size == 1) set((E)list.get(0), list.length()-1);
        else {
            set((E)list.get(size-1), list.length()-size);
            reverse(list, size-1);
        }
        */
    }
    
    
    
}
