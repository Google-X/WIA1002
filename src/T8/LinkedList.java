/*
 * LinkedList
 */
package T8;

public class LinkedList<E extends Comparable<E>> {
    
    private ListNode head;
    private boolean ASCENDING;
    
    
    public LinkedList(boolean ascending) {
        ASCENDING = ascending;
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
            for(int j=1;j<i;j++) c = c.getLink(); // <-- Bug found
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
    
    // Method swap for Q3 and Q4
//    /*
    private void swap(int index1, int index2){
        ListNode c = head;
        ListNode swapNode = head;
        
        E tmp = null, tmp1 = null;
        
        for(int i = 0; i < index1; i++) c = c.getLink();
        tmp = (E) c.getData();
        
        for(int i = 0; i < index2; i++) swapNode = swapNode.getLink();
        tmp1 = (E) swapNode.getData();
        c.setData(tmp1);
        swapNode.setData(tmp);
    }
//  */
    /* CONSUMED 2 more loops for the get(index)
    private void swap(int index1, int index2){
        E tmp = get(index1);
        ListNode c = head;
        
        for(int i = 0; i < index1; i++) c = c.getLink();
        c.setData(get(index2));
        
        ListNode s = head;
        for(int i = 0; i < index2; i++) s = s.getLink();
        s.setData(tmp);
    }
//  */
    
    // Question 3: Selection Sort
    public void selectionSort(){
        for(int i = 0; i < length()-1; i++) swap(i, getSelectionIndex(i));
    }
//  /*
    private int getSelectionIndex(int start){
        E tmp = null, tmp1 = null;
        ListNode c = head;
        int index = start;
        
        for(int i = 0; i <= start; i++){
            if(i == start){
                tmp = (E) c.getData();
                c = c.getLink();
            } 
            else c = c.getLink();
        }
        
        for(int i = start+1; i < length(); i++){
            tmp1 = (E) c.getData();
            if(tmp.compareTo(tmp1) > 0 && ASCENDING){
                index = i;
                tmp = tmp1; 
            }
            else if (tmp.compareTo(tmp1) < 0 && !ASCENDING){
                index = i;
                tmp = tmp1; 
            }
            c = c.getLink();
        }
        return index;
    }
//  */
    /* CONSUMED MORE TIME
    private int getSelectionIndex(int start){
        E tmp = get(start);
        int index = start;
        for(int i = start+1; i < length(); i++){
            if(tmp.compareTo(get(i)) > 0 && ASCENDING){
                index = i;
                tmp = get(i); 
            }
            else if (tmp.compareTo(get(i)) < 0 && !ASCENDING){
                index = i;
                tmp = get(i); 
            }
        }
        return index;
    }
//    */
    
    // Question 4: Bubble Sort
    public void bubbleSort(){
        E tmp = null, tmp1 = null;
        
        for(int iteration = 0; iteration < length()-1; iteration++){
            ListNode c = head;
            ListNode n = head.getLink();
            for(int i = 0; i < length()-1-iteration; i++){
                tmp = (E) c.getData();
                tmp1 = (E) n.getData();
                if(tmp.compareTo(tmp1) > 0 && ASCENDING) swap(i, i+1);
                else if(tmp.compareTo(tmp1) < 0 && !ASCENDING) swap(i, i+1);
                c = c.getLink();
                n = n.getLink();
            }
        }
    }
    
}