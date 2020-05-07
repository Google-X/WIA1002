
package Lab4;

public class DoubleLinkedList<E extends Comparable<E>> {
    private DoubleListNode head;

    public DoubleLinkedList() {
        head = null;
    }
    
    public int length(){
        int counter = 0;
        DoubleListNode c = head;
        while(c != null){
            counter++;
            c = c.getNextLink();
        }
        return counter;
    }
    
    public void showList(){
        DoubleListNode c = head;
        while(c != null){
            System.out.print(c.toString());
            c = c.getNextLink();
        }
    }
    
    public boolean isEmpty(){
        return head == null;
    }
    
    public void deleteLeftNode(){
        if(head != null){
            head = head.getNextLink();
            head.setPreviousLink(null);
        } else System.err.println("EmptyDoubleLinkedList Exception");
    }
    
    public void addLeftNode(E e){
        DoubleListNode c = head;
        head = new DoubleListNode(e, null, head);
        if(c != null){
            c.setPreviousLink(head);
        }
    }
    
    public void addRightNode(E e){
        DoubleListNode n = new DoubleListNode(e, null, null);
        if(head == null) head = n;
        else {
            DoubleListNode c = head;
            while(c.getNextLink() != null){
                c = c.getNextLink();
            }
            c.setNextLink(n);
            n.setPreviousLink(c);
        }
    }
    
    public void deleteRightNode(){
        if(head != null){
            if(head.getNextLink() == null) head = null;
            else {
                DoubleListNode c = head, p = null;
                while(c.getNextLink() != null){
                    p = c;
                    c = c.getNextLink();
                }
                c = null;
                p.setNextLink(null);
            }
        } else System.err.println("EmptyDoubleLinkedList Exception");
    }
    
    public void addNodeByPosition(E e, int index){
        if(index == 0) addLeftNode(e);
        else if(index == length()) addRightNode(e);
        else if(index > length()) System.err.println("IndexOutOfBound Exception");
        else {
            DoubleListNode n = new DoubleListNode(e, null, null);
            DoubleListNode c = head;
            for(int i=1;i<index;i++) c = c.getNextLink();
            DoubleListNode tmp = c.getNextLink();
            c.setNextLink(n);
            n.setLink(c, tmp);
            if(tmp != null) // <-- Is this line neccessary?
                tmp.setPreviousLink(n);
        }
    }
    
    public void deleteNodeByPosition(int index){
        if(index == 0) deleteLeftNode();
        else if(index == length()-1) deleteRightNode();
        else if(index >= length()) System.err.println("IndexOutOfBound Exception");
        else {
            DoubleListNode c = head;
            for(int i=1;i<index;i++) c = c.getNextLink();
            DoubleListNode tmp = c.getNextLink();
            c.setNextLink(tmp.getNextLink());
            if(tmp.getNextLink() != null) // Is this line neccessary?
                tmp.getNextLink().setPreviousLink(c);
            tmp = null;
        }
    }
    
    public void setFront(E e){
        if(head != null) head.setData(e);
        else System.err.println("EmptyDoubleLinkedList Exception");
    }
    
    public void setBack(E e){
        if(head != null){
            DoubleListNode c = head;
            while(c.getNextLink() != null) c = c.getNextLink();
            c.setData(c);
        } else System.err.println("EmptyDoubleLinkedList Exception");
    }
    
    public void set(E e, int index){
        if(index == 0) setFront(e);
        else if(index == length()-1) setBack(e);
        else if(index >= length()) System.err.println("IndexOutOfBoundException");
        else {
            DoubleListNode c = head;
            for(int i=1;i<=index;i++) c = c.getNextLink();
            c.setData(e);
        }
    }
    
    public E getFront(){
        if(head != null) return (E) head.getData();
        else return null;
    }
    
    public E getBack(){
        if(head != null){
            DoubleListNode c = head;
            while(c.getNextLink() != null) c = c.getNextLink();
            return (E) c.getData();
        } else return null;
    }
    
    public E get(int index){
        if(index == 0) return getFront();
        else if(index == length()-1) return getBack();
        else if(index >= length()) {
            System.err.println("IndexOutOfBoundException");
            return null;
        } else {
            DoubleListNode c = head;
            for(int i=1;i<=index;i++) c = c.getNextLink();
            return (E) c.getData();
        }
    }
    
// Question 6 method
    public void deleteEven(){
        for(int i=length()-1;i>=0;i--){
            if((Integer)get(i) % 2 == 0) deleteNodeByPosition(i);
        }
    }
}
