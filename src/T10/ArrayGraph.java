/*
 * 1. Create an ADT Graph named ArrayGraph. The ADT consists of the following method and the maximum size of the ADT is 20.  
 */
package T10;

import java.util.ArrayList;

public class ArrayGraph<V extends Comparable<V>, E> implements ArrayGraphADT<V, E>{
    
    private int index, MAX;
    private V[] vertex;
    private E[][] weight;
    private boolean[] marked;
    
    public ArrayGraph(int size){
        index = -1;
        MAX = size;
        vertex = (V[]) new Comparable[size];
        weight = (E[][]) new Object[size][size];
        marked = new boolean[size];
    }
    
    public boolean isEmpty() {
        return index == -1;
    }
    
    public boolean isFull() {
        return index == MAX;
    }
    
    public int getVerticeSize() {
        return index+1;
    }
    
    public void clear() {
        index = -1;
    }
    
    public void addVertice(V v) {
        index++;
        if(isFull()){
            System.out.println("Graph is full");
            index--;
        } else vertex[index] = v;
    }
    
    public int hasVertice(V v) {
        if(isEmpty()) return -1;
        else {
            for(int i = 0; i <= index; i++){
                if(v.compareTo(vertex[i]) == 0) return i;
            }
        }
        return -1;
    }
    
    public boolean addEdge(V from, V to, E w) {
        int fromIndex = hasVertice(from);
        int toIndex = hasVertice(to);
        if(fromIndex == -1 || toIndex == -1) return false;
        else weight[fromIndex][toIndex] = w;
        return true;
    }
    
    public boolean deleteEdge(V from, V to) {
        int fromIndex = hasVertice(from);
        int toIndex = hasVertice(to);
        if(fromIndex == -1 || toIndex == -1) return false;
        else weight[fromIndex][toIndex] = null;
        return true;
    }
    
    public boolean isEdge(V from, V to) {
        int fromIndex = hasVertice(from);
        int toIndex = hasVertice(to);
        if(fromIndex == -1 || toIndex == -1) return false;
        else if(weight[fromIndex][toIndex] != null) return true;
        return false;
    }
    
    public E getWeight(V from, V to) {
        int fromIndex = hasVertice(from);
        int toIndex = hasVertice(to);
        if(fromIndex == -1 || toIndex == -1) return null;
        else return weight[fromIndex][toIndex];
    }
    
    public void markVertice(V v) {
        int vIndex = hasVertice(v);
        if(vIndex != -1) marked[vIndex] = true;
    }
    
    public boolean isMarked(V v) {
        int vIndex = hasVertice(v);
        if(vIndex != -1) return marked[vIndex];
        return false;
    }
    
    public ArrayList getAdjadent(V v) {
        ArrayList<V> list = new ArrayList();
        int vIndex = hasVertice(v);
        if(vIndex != -1){
            for(int i = 0; i <= index; i++){
                if(weight[vIndex][i] != null) list.add(vertex[i]);
            }
        }
        return list;
    }
    
    public void showGraph(){
        if(!isEmpty()){
            for(int i = 0; i <= index; i++) {
                System.out.println(vertex[i] + " --> ");
                for(int j = 0; j <= index; j++) {
                    if(weight[i][j] != null) 
                        System.out.print(" -> " + vertex[j] + " : " + weight[i][j]);
                }
                System.out.println();
            }
        } else {
            System.out.println("Graph is empty.");
        }
    }
    
}
