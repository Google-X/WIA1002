/*
 * Lab 5: Stack Class
 */
package Lab5;

public class Stack<E> {
    
    private ListNode head;
    /**
     * Cur  : { }
     * Par  : ( )
     * Sq   : [ ]
     */
    private int Cur, Par, Sq;
    private boolean curBal, parBal, sqBal;
    
    public Stack() {
        head = null;
    }
    
    /**
     * The constructor below just for the Q4 Parentheses, Square Bracket & Curly Bracket Evaluation
     * @param type has nothing to do, this is just to differentiate with the original constructor
     */
    public Stack(boolean type) {
        head = null;
        Cur = 0;
        Par = 0;
        Sq = 0;
        curBal = true;
        parBal = true;
        sqBal = true;
    }
    
    public boolean isEmpty(){
        return head == null;
    }
    
    public int getSize(){
        int count = 0;
        ListNode c = head;
        while(c != null) {
            count++;
            c = c.getLink();
        }
        return count;
    }
    
    public void push(E e){
        head = new ListNode(e, head);
    }
    
    public E pop(){
        if(head == null) return null;
        E tmp = (E) head.getData();
        head = head.getLink();
        return tmp;
    }
    
    public E peek(){
        if(head == null) return null;
        return (E) head.getData();
    }
    
    public void showStack(){
        if(isEmpty()) System.out.println("The stack is empty");
        else {
            ListNode c = head;
            while(c != null){
                System.out.print(c.toString());
                c = c.getLink();
            }
        }
    }
    
    // Question 4 Push
    public int pushParen(E e){
        head = new ListNode(e, head);
        int offset = 0;
        switch((Character) e){
            case '{':
                Cur++;
            case '}':
                Cur--;
                break;
            case '(':
                Par++;
                break;
            case ')':
                Par--;
                break;
            case '[':
                Sq++;
                break;
            case ']':
                Sq--;
                break;
            case '\\':
                offset++;
                System.out.println(offset);
                break;
            default:
                
        }
        return Cur + Par + Sq - offset;
    }
    
    public char check(){
        if(Cur < 0) return '{';
        else if(Cur > 0) return '}';
        else if(Par < 0) return '(';
        else if(Par > 0) return ')';
        else if(Sq < 0) return '[';
        else if(Sq > 0) return ']';
        else return ' ';
    }
}
