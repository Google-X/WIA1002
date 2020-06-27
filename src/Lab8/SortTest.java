/*
 * Sorter with list of sorting methods: Quick Sort, Insertion Sort, Merge Sort, Bubble Sort, Selection Sort.
 */
package Lab8;

import java.util.Random;

public class SortTest<T extends Comparable<T>> {

    private final int MAXCHAR = 26;
    private boolean ASCENDING;
    private int MaxValue;
    private int SIZE;
    private T[] value;
    private Random r = new Random();
    
    // For SortTime to pass in the array, clone is used so it is not pointing to the array
    public SortTest(T[] arr){
        value = (T[])(Integer[]) arr.clone();
        SIZE = arr.length;
        ASCENDING = true;
    }
    
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
//            if((i+1) % 10 == 0) System.out.println();
        }
        System.out.println();
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
    
    // @ Muhamad Azri
    public void mergeSortV3(){
        mergeSortV3(0, value.length-1);
    }
    
    private void mergeSortV3(int first, int last){
        if(first < last){
            int middle = (first+last)/2;
            mergeSortV3(first, middle);
            mergeSortV3(middle+1, last);
            mergeV3(first, middle, middle+1, last);
        }
    }
    
    private void mergeV3(int leftFirst, int leftLast, int rightFirst, int rightLast) { 
        T[] temp = (T[]) new Comparable[value.length]; 
        int index = leftFirst; 
        int currentIndex = leftFirst; 
        
        while (leftFirst<=leftLast && rightFirst <= rightLast) { 
            if ((Integer) value[leftFirst] % 2 == 0 && (Integer) value[rightFirst] % 2 != 0) { 
                temp[index] = value[rightFirst]; 
                rightFirst++; 
            } else if ((Integer) value[leftFirst] % 2 != 0 && (Integer) value[rightFirst] % 2 == 0) { 
                temp[index] = value[leftFirst]; 
                leftFirst++; 
            } else { 
                if(value[leftFirst].compareTo(value[rightFirst]) < 0) { 
                    temp[index] = value[leftFirst]; 
                    leftFirst++; 
                } else { 
                    temp[index] = value[rightFirst]; 
                    rightFirst++; 
                } 
            } 
            index++; 
        } 
        
        while (leftFirst <= leftLast) { 
            temp[index] = value[leftFirst]; 
            leftFirst++; 
            index++; 
        } 
        
        while (rightFirst <= rightLast) { 
            temp[index] = value[rightFirst]; 
            rightFirst++; 
            index++; 
        } 
        
        for (int i = currentIndex; i <= rightLast; i++) { 
            value[i] = temp[i]; 
        } 
    } 
    
    /*
    // MERGE SORT V2
    // @ Huaiyu Khaw
    public void mergeSortV2(){
        mergeSortV2(0, value.length-1);
    }
    
    private void mergeSortV2(int l, int r){
        if(l < r){
//          Find the middle point
            int m = (l + r) / 2;
            
//          Sort first and second halves
            mergeSortV2(l, m);
            mergeSortV2(m+1, r);
            
//          Merge the sorted halves
            mergeV2(l, m, r);
        }
    }
    
    private void mergeV2(int l, int m, int r){
//      Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
        
//      Create tmp arrays
        int L[] = new int[n1];
        int R[] = new int[n2];
        
//      Copy data to tmp arrays
        for(int i = 0; i < n1; i++){
            L[i] = (Integer) value[l+i];
        }
        for(int j = 0; j < n2; j++){
            R[j] = (Integer) value[m+1+j];
        }
        
        // Merge the tmp arrays
        // Initial indexed of first and second subarrays
        int i = 0, j = 0;
        
        // Initial index of merged subarray
        int k = l;
        while(i < n1 && j < n2){
            // Check if the element in two array are both odd or both even
            // if true, perform the same sorting
            if(((Integer)L[i] + (Integer)R[j]) % 2 == 0) {
                if((Integer)L[i] <= (Integer)(R[j])){
                    value[k] = (T)(Integer) L[i];
                    i++;
                } else {
                    value[k] = (T)(Integer) R[j];
                    j++;
                }
            }
            // else pull the odd number to the front
            else {
                if((Integer)L[i] % 2 == 1){
                    value[k] = (T)(Integer) L[i];
                    i++;
                } else {
                    value[k] = (T)(Integer) R[j];
                    j++;
                }
            }
            k++;
        }
//        for(int c = k; c <= r; c++) value[i] = temp[i];
    }*/
    
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
    
    // Question 4: HeapSort 
    public void heapSort() {
        buildMaxHeap();

        // i starts from length - 1 (means last element) 
        for (int i = value.length - 1; i > 0; i--) {

            // swap the largest (element at 0th index) with the ith element 
            swap(i, 0);

            // by passing i as size, we are actually decreasing the length of heap by one 
            // reason: we need to exclude the last element because we swapped it with the largest element 
            maxHeapify(i, 0);
        }
    }

    public void buildMaxHeap() {
        int n = value.length;
        for (int i = (n / 2) - 1; i >= 0; i--) {
            // we max heapify the smallest tree first 
            maxHeapify(n, i);
        }

    }

    public void maxHeapify(int size, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < size && value[left].compareTo(value[largest]) > 0) {
            largest = left; 
        }
        if (right < size && value[right].compareTo(value[largest]) > 0) {
            largest = right;
        }
        if (largest != i) {
            swap(i, largest);
            // propagates downwards 
            maxHeapify(size, largest);
        }
    }

}
