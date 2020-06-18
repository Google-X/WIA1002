/*
4. Heap sort is a comparison based sorting technique based on Binary Heap data structure. It is similar to selection sort where we first find the maximum element and place the maximum element at the end. We repeat the same process for remaining element. A heap is an implementation of a priority queue using the BST. The tree must be a complete binary tree. In the array implementation of BST, if the root is K, the left child is 2K+1 and the right child is 2K+2. The parent of K is (K1)/2. Create a program to sort N random characters using Heap Sort in ascending order. The heapSort method can be added in the SortTest class. 
 */
package Lab8;

import java.util.Scanner;

public class HeapSort {
    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        System.out.print("Enter N characters : ");
        int N = s.nextInt();
        
        SortTest<Character> sorter = new SortTest<>('A', N, 20, true);
        System.out.print("The characters are : ");
        sorter.showValue();
        
        sorter.heapSort();
        sorter.showValue();

    }
    
    /* Version 1
    public static void heapSort(char[] arr) {
        buildMaxHeap(arr);

        // i starts from length - 1 (means last element) 
        for (int i = arr.length - 1; i > 0; i--) {

            // swap the largest (element at 0th index) with the ith element 
            swap(arr, i, 0);

            // by passing i as size, we are actually decreasing the length of heap by one 
            // reason: we need to exclude the last element because we swapped it with the largest element 
            maxHeapify(arr, i, 0);
        }
    }

    public static void buildMaxHeap(char[] arr) {
        int n = arr.length;
        for (int i = (n / 2) - 1; i >= 0; i--) {
            // we max heapify the smallest tree first 
            maxHeapify(arr, n, i);
        }

    }

    public static void maxHeapify(char[] arr, int size, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < size && arr[left] > arr[largest]) {
            largest = left; 
        }
        if (right < size && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != i) {
            swap(arr, i, largest);
            // propagates downwards 
            maxHeapify(arr, size, largest);
        }
    }

    public static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    */
    
    /* Version 2
    public static void heapsort(int arr[]){
        int n = arr.length;
        
        // Build heap (rearrange array)
        for(int i = n/2-1; i >= 0; i--) heapify(arr, n, i);
        
        // One by one extract an element from heap
        for(int i = n-1; i > 0; i--){
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            
            // Call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }
    
    public static void heapify(int arr[], int n, int i){
        int largest = i; // Initialize largest as root
        int l = 2*i + 1; // left = 2*i+1
        int r = 2*i + 2; // right = 2*i+2
        
        // if left child is larger than root
        if(l < n && arr[l] > arr[largest]) largest = r;
        
        // if largest is not root
        if(largest != i){
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            
            // recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }
    */
}
