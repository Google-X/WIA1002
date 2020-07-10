/*
 * 1. Create an ADT Graph named ArrayGraph. The ADT consists of the following method and the maximum size of the ADT is 20.
a. Constructor 
b. isEmpty 
c. isFull 
d. getVerticeSize 
e. clear 
f. addVertice 
g. hasVertice //return -1 if no vertex found, otherwise, return the index
h. addEdge 
i. deleteEdge 
j. isEdge 
k. getWeight 
l. markVertice 
m. isMarked 
n. getAdjacent
 */
package T10;

import java.util.ArrayList;

public interface ArrayGraphADT<V, E> {
    
    public boolean isEmpty();
    public boolean isFull();
    public int getVerticeSize();
    public void clear();
    public void addVertice(V v);
    public int hasVertice(V v);
    public boolean addEdge(V from, V to, E w);
    public boolean deleteEdge(V from, V to);
    public boolean isEdge(V from, V to);
    public E getWeight(V from, V to);
    public void markVertice(V v);
    public boolean isMarked(V v);
    public ArrayList getAdjadent(V v);
    
}
