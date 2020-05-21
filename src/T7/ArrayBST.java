/*
 * 3. Create an ADT Binary Search Tree named ArrayBST. The ADT consists of the following method. Given the maximum size of the ADT is 20. Left child of node K is, 2K+1; Right child of node K is, 2K+2. If the node is root, K=0, left child is in position 1 and right child is in position 2. 
a. Constructor 
b. isEmpty 
c. getSize 
d. getHeight 
e. addNode 
f. inOrder 
g. preorder 
h. postOrder 
i. removeNode  

2K+2 < 20
2K < 18
K < 9

 */
package T7;

import T6.Queue;

public class ArrayBST<T extends Comparable<T>> {
    
    private static final int MAX = 20;
    private T[] arrayBST;
    private T[] arrayShow;
    private static final int INORDER = 1;
    private static final int PREORDER = 2;
    private static final int POSTORDER = 3;
    private int counter, arrayIndex;
    
    public ArrayBST(){
        arrayBST = (T[]) new Comparable[MAX];
        counter = 0;
    }
    
    public boolean isEmpty(){
        return counter == 0;
    }
    
    public int getSize(){
        return counter;
    }
    
    public int getHeight(){
        int index = -1;
        for(int i = MAX - 1; i >= 0; i--){
            if(arrayBST[i] != null){
                index = i;
                break;
            }
        }
        if(index != -1) return (int)(Math.log(index+1) / Math.log(2)) + 1;
        else return 0;
    }
    
    public void addNode(T t){
        boolean addable = false;
        if(counter == 0){
            arrayBST[0] = t;
            addable = true;
        } 
        else {
            int i = 0, index;
            while(i < MAX){
                if(t.compareTo(arrayBST[i]) <= 0) index = (2*i)+1;
                else index = (2*i)+2;
                if(arrayBST[index] == null){
                    arrayBST[index] = t;
                    addable = true;
                    break;
                }
                else i = index;
            }
        }
        if(addable) counter++;
    }
    
    public void setOrder(int a){
        arrayShow = (T[]) new Comparable[MAX];
        arrayIndex = 0; // ROOT INDEX
        if(a == INORDER) inOrder(0);
        else if(a == PREORDER) preOrder(0);
        else if(a == POSTORDER) postOrder(0);
    }
    
    public void showTree(){
        for(int i = 0; i < arrayIndex; i++) System.out.print(arrayShow[i] + " ");
    }
    
    private void inOrder(int a){
        if(a >= MAX) return;
        if(arrayBST[a] != null){
            inOrder(a*2+1);
            arrayShow[arrayIndex++] = arrayBST[a];
            inOrder(a*2+2);
        }
    }
    private void preOrder(int a){
        if(a >= MAX) return;
        if(arrayBST[a] != null){
            arrayShow[arrayIndex++] = arrayBST[a];
            preOrder(a*2+1);
            preOrder(a*2+2);
        }
    }
    private void postOrder(int a){
        if(a >= MAX) return;
        if(arrayBST[a] != null){
            postOrder(a*2+1);
            postOrder(a*2+2);
            arrayShow[arrayIndex++] = arrayBST[a];
        }
    }
    
    public boolean removeNode(T t){
        boolean found = false;
        if(isEmpty()) return false;
        else {
            for(int i = 0; i < MAX; i++){
                if(arrayBST[i] == t){
                    // REMOVING LEAF
                    if(2*i+1 >= MAX || 2*i+2 >= MAX){
                        arrayBST[i] = null;
                        found = true;
                        break;
                    }
                    else if(arrayBST[2*i+1] == null && arrayBST[2*i+2] == null){
                        arrayBST[i] = null;
                        found = true;
                        break;
                    }
                    
                    // REMOVING NODE WITH 1 CHILD
                    else if(arrayBST[2*i+2] == null){ // RIGHT CHILD EMPTY
                        replace(i, 2*i+1);
                        found = true;
                        break;
                    }
                    else if(arrayBST[2*i+1] == null){ // LEFT CHILD EMPTY
                        replace(i, 2*i+2);
                        found = true;
                        break;
                    }
                    
                    // REMOVING NODE WITH BOTH CHILDREN
                    else {
                        replaceWithChildren(i);
                        found = true;
                        break;
                    }
                }
            }
        }
        if(found) counter--;
        return found;
    }
    
    // OPPOSITE FROM BST IMPLEMENTATION
    private void replaceWithChildren(int a){
        // IT REPLACES THE RIGHT FIRST
        int currentIndex = a*2+2;
        
        // THEN REPLACE THE LEFT
        while(currentIndex*2+1 < MAX && arrayBST[currentIndex*2+1] != null) currentIndex = currentIndex*2+1;
        
        arrayBST[a] = arrayBST[currentIndex];
        int currentRoot = currentIndex;
        if(arrayBST[currentIndex*2+2] != null) replace(currentIndex, currentIndex*2+2);
        // IF NO CHILD
        else arrayBST[currentIndex] = null;
    }
    
    private void replace(int a, int b){
        Queue<Integer> temp = new Queue<>();
        Queue<Integer> oldQ = new Queue<>();
        Queue<Integer> newQ = new Queue<>();
        
        int currentIndex, oldIndex, newIndex;
        
        // QUEUE UP (NEW/LEFT)? SUBTREE
        temp.enqueue(b);
        
        // QUEUE UP NEW INDEX
        while(!temp.isEmpty()){
            currentIndex = temp.dequeue();
            newQ.enqueue(currentIndex);
            if((currentIndex*2+2) <= (Math.pow(2, getHeight())-2)){
                temp.enqueue(currentIndex*2+1);
                temp.enqueue(currentIndex*2+2);
            }
        }
        
        // QUEUE UP ORIGINAL SUBTREE
        temp.enqueue(a);
        
        // QUEUE UP ORIGINAL INDEX
        while(!temp.isEmpty()){
            currentIndex = temp.dequeue();
            oldQ.enqueue(currentIndex);
            if((currentIndex*2+2) <= (Math.pow(2, getHeight())-2)){
                temp.enqueue(currentIndex*2+1);
                temp.enqueue(currentIndex*2+2);
            }
        }
        
        // REPLACE THE OLD INDEX WITH THE NEW INDEX
        while(!newQ.isEmpty()){
            oldIndex = oldQ.dequeue();
            newIndex = newQ.dequeue();
            arrayBST[oldIndex] = arrayBST[newIndex];
            arrayBST[newIndex] = null; // SET NEW INDEX TO NULL
        }
    }   
}