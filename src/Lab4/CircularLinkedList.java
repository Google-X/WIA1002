/*
 * 7. Create the ListNode.java and CircularLinkedList.java file. The CircularLinkedList class must contains the following method:
a. length() 
b. addCircularNode - insert at the back 
c. deleteCircularNode - delete from the back 
d. showCircularList 
e. getCicularItem – return the item by index 
 */
package Lab4;

public class CircularLinkedList<E> {
    private ListNode head;

    public CircularLinkedList() {
        head = null;
    }
    
    public int length(){
        int counter = 1;
        ListNode c = head;
        while(c.getLink() != head) {
            counter++;
            c = c.getLink();
        }
        return counter;
    }
    
    public void showCircularNode(){
        if(head != null){
            ListNode c = head;
            System.out.print(c.toString());
            c = c.getLink();
            while(c != head){
                System.out.print(c.toString());
                c = c.getLink();
            }
            System.out.println(c.toString());
        } else System.err.println("EmptyCircularLinkedListException");
    }
    
    public void addCircularNode(E e){
        ListNode n = new ListNode(e, head);
        if(head == null) {
            head = n;
            head.setLink(head);
        }
        else {
            if(head.getLink() == head) head.setLink(n);
            else {
                ListNode c = head;
                while(c.getLink() != head) c = c.getLink();
                c.setLink(n);
            }
        }
    }
    
    public void deleteCircularNode(){
        if(head != null){
            if(head.getLink() == head) head = null;
            else {
                ListNode c = head, p = null;
                while(c.getLink() != head){
                    p = c;
                    c = c.getLink();
                }
                c = null;
                p.setLink(head);
            }
        } else System.err.println("EmptyDoubleLinkedList Exception");
    }
    
    public E getFront(){
        if(head != null) return (E) head.getData();
        else return null;
    }
    
    public E getBack(){
        if(head != null){
            ListNode c = head;
            while(c.getLink() != head) c = c.getLink();
            return (E) c.getData();
        } else return null;
    }
    
    public E getCicularItem(int index){
        if(index == 0) return getFront();
        else if(index == length()-1) return getBack();
        else if(index >= length()) {
            System.err.println("IndexOutOfBoundException");
            return null;
        } else {
            ListNode c = head;
            for(int i=1;i<=index;i++) c = c.getLink();
            return (E) c.getData();
        }
    }
    
}
