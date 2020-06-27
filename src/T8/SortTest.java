/*
 * Sorter with list of sorting methods: Quick Sort, Insertion Sort, Merge Sort, Bubble Sort, Selection Sort.
 */
package T8;

import java.util.Random;

public class SortTest<T extends Comparable<T>> {

    private final int MAXCHAR = 26;
    private boolean ASCENDING;
    private int MaxValue;
    private int SIZE;
    private T[] value;
    private Random r = new Random();

    public SortTest(T t, int SIZE, int MaxValue, boolean ascending) {
        this.SIZE = SIZE;
        ASCENDING = ascending;
        value = (T[]) new Comparable[SIZE];
        char c;

        if (t instanceof Number || t instanceof String) this.MaxValue = MaxValue;

        for (int i = 0; i < value.length; i++) {
            if (t instanceof Integer) {
                value[i] = (T) ((Integer) r.nextInt(MaxValue));
            } 
            else if (t instanceof Double) {
                value[i] = (T) ((Double) (0.01 * r.nextInt(MaxValue*100)));
            } 
            else if (t instanceof Character){
                if(Character.isUpperCase((Character)t)) c = (char)('A' + r.nextInt(MAXCHAR));
                else c = (char)('a' + r.nextInt(MAXCHAR));
                value[i] = (T) ((Character) c);
            } 
            else if (t instanceof String){
                String tmp = "";
                if(Character.isUpperCase((Character)((String) t).charAt(0))){
                    for(int j = 0; j < this.MaxValue; j++){
                        c = (char)('A' + r.nextInt(MAXCHAR));
                        tmp += c;
                    }
                }
                else {
                    for(int j = 0; j < this.MaxValue; j++){
                        c = (char)('a' + r.nextInt(MAXCHAR));
                        tmp += c;
                    }
                }
                value[i] = (T) tmp;
            } else {
                System.out.println("Will update soon.");
            }
        }
    }
    
    public void setAscending(boolean ascending){
        ASCENDING = ascending;
    }

    public boolean isSorted(){
        for(int i = 0; i < value.length-1; i++){
            if(value[i].compareTo(value[i+1]) > 0 && ASCENDING) return false;
            else if(value[i].compareTo(value[i+1]) < 0 && !ASCENDING) return false;
        }
        return true;
    }
    
    public void swap(int index1, int index2){
        T tmp = value[index1];
        value[index1] = value[index2];
        value[index2] = tmp;
    }
    
    public void showValue(){
        for(int i = 0; i < value.length; i++){
            System.out.print(value[i] + " ");
            if((i+1) % 10 == 0) System.out.println();
        }
    }
    
    // SELECTION SORT
    private int getMinIndex(int start){
        T tmp = value[start];
        int index = start;
        for(int i = start+1; i < value.length; i++){
            if(tmp.compareTo(value[i]) > 0 && ASCENDING){
                index = i;
                tmp = value[i]; 
            }
            else if (tmp.compareTo(value[i]) < 0 && !ASCENDING){
                index = i;
                tmp = value[i]; 
            }
        }
        return index;
    }
    
    public void selectionSort(){
        for(int i = 0; i < value.length-1; i++) swap(i, getMinIndex(i));
    }
    
    // BUBBLE SORT
    public void bubbleSort(){
        for(int iteration = 0; iteration < value.length-1; iteration++){
            for(int i = 0; i < value.length-1-iteration; i++){
                if(value[i].compareTo(value[i+1]) > 0 && ASCENDING) swap(i, i+1);
                else if(value[i].compareTo(value[i+1]) < 0 && !ASCENDING) swap(i, i+1);
            }
        }
    }
    
    // INSERTION SORT
    public void insertionSort(){
        int j;
        for(int i = 1; i < value.length; i++){
            for(j = 0; j < i; j++){
                if(value[i].compareTo(value[j]) < 0 && ASCENDING){
                    swap(i, j);
                    break;
                }
                else if(value[i].compareTo(value[j]) > 0 && !ASCENDING){
                    swap(i, j);
                    break;
                }
            }
            for(j = j+1; j < i; j++) swap(j, i);
        }
    }
    
    // MERGE SORT
    public void mergeSort(){
        mergeSort(0, value.length-1);
    }
    
    private void mergeSort(int first, int last){
        if(first < last){
            int middle = (first+last)/2;
            mergeSort(first, middle);
            mergeSort(middle+1, last);
            merge(first, middle, middle+1, last);
        }
    }
    
    private void merge(int leftFirst, int leftLast, int rightFirst, int rightLast){
        T[] temp = (T[]) new Comparable[SIZE];
        int index = leftFirst;
        int currentIndex = leftFirst;
        
        while((leftFirst <= leftLast) && (rightFirst <= rightLast)){
            if( (value[leftFirst].compareTo(value[rightFirst]) < 0 && ASCENDING) || 
                (value[leftFirst].compareTo(value[rightFirst]) > 0 && !ASCENDING) ) {
                temp[index] = value[leftFirst];
                leftFirst++;
            }
            else {
                temp[index] = value[rightFirst];
                rightFirst++;
            }
            index++;
        }
        
        while(leftFirst <= leftLast){
            temp[index] = value[leftFirst];
            leftFirst++;
            index++;
        }
        
        while(rightFirst <= rightLast){
            temp[index] = value[rightFirst];
            rightFirst++;
            index++;
        }
        
        for(int i = currentIndex; i <= rightLast; i++) value[i] = temp[i];
    }
    
    // QUICK SORT
    public void quickSort(){
        quickSort(0, value.length-1);
    }
    
    private void quickSort(int first, int last){
        if(first < last){
            int splitIndex = split(first, last);
            quickSort(first, splitIndex-1);
            quickSort(splitIndex+1, last);
        }
    }
    
    private int split(int first, int last){
        boolean correctSide;
        T splitValue = value[first];
        int index = first;
        first++;
        do{
            correctSide = true;
            while(correctSide){
                if( (splitValue.compareTo(value[first]) < 0 && ASCENDING) || 
                    (splitValue.compareTo(value[first]) >= 0 && !ASCENDING) ){
                    correctSide = false;
                }
                else {
                    first++;
                    correctSide = first <= last;
                }
            }
            correctSide = first <= last;
            while(correctSide){
                if( (splitValue.compareTo(value[last]) >= 0 && ASCENDING) || 
                    (splitValue.compareTo(value[last]) < 0 && !ASCENDING) ){
                    correctSide = false;
                }
                else {
                    last--;
                    correctSide = first <= last;
                }
            }
            if(first < last) {
                swap(first, last);
                first++;
                last--;
            }
        } while(first <= last);
        
        swap(index, last);
        return last;
    }
    
}
