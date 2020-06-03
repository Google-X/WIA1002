/*
 * 1. Write a program that generates 10 random characters. Then sort the characters in descending order. (Modify the SortTest.java) 
a. Selection Sort 
b. Bubble Sort 
c. Insertion Sort 
d. Merge Sort  
e. Quick Sort   
Example output: [BELOW]

 */
package T8;

public class SimpleSorting {
    public static void main(String[] args) {
        
        long start;
        
        // SELECTION SORT
        SortTest selectionSorter = getSorter();
        System.out.println("Selection Sort - Descending Order");
        start = System.nanoTime();
        selectionSorter.selectionSort();
        System.out.printf("Time taken: %dns\n", System.nanoTime()-start);
        selectionSorter.showValue();
        System.out.println();
        
        // BUBBLE SORT
        SortTest bubbleSorter = getSorter();
        System.out.println("Bubble Sort - Descending Order");
        start = System.nanoTime(); 
        bubbleSorter.bubbleSort();
        System.out.printf("Time taken: %dns\n", System.nanoTime()-start);
        bubbleSorter.showValue();
        System.out.println();
        
        // INSERTION SORT
        SortTest insertionSorter = getSorter();
        System.out.println("Insertion Sort - Descending Order");
        start = System.nanoTime();
        insertionSorter.insertionSort();
        System.out.printf("Time taken: %dns\n", System.nanoTime()-start);
        insertionSorter.showValue();
        System.out.println();
        
        // MERGE SORT
        SortTest mergeSorter = getSorter();
        System.out.println("Merge Sort - Descending Order");
        start = System.nanoTime();
        mergeSorter.mergeSort();
        System.out.printf("Time taken: %dns\n", System.nanoTime()-start);
        mergeSorter.showValue();
        System.out.println();
        
        // MERGE SORT
        SortTest quickSorter = getSorter();
        System.out.println("Quick Sort - Descending Order");
        start = System.nanoTime();
        quickSorter.mergeSort();
        System.out.printf("Time taken: %dns\n", System.nanoTime()-start);
        quickSorter.showValue();
        System.out.println();
        
    }
    
    public static SortTest getSorter(){
        SortTest sorter = new SortTest('A', 10, 0, false);
        System.out.print("The random characters are : ");
        sorter.showValue();
        return sorter;
    }
}

/*
Example output:
The random characters are : V T Z K F W R W Q J 
Selection Sort - Descending Order
Z W W V T R Q K J F 

The random characters are : M H D F G F N Y C L 
Bubble Sort - Descending Order
Y N M L H G F F D C 

The random characters are : W L M U E P R S V E 
Insertion Sort - Descending Order
W V U S R P M L E E 

The random characters are : L W S V J K Y O N N 
Merge Sort - Descending Order
Y W V S O N N L K J 

The random characters are : S J A N U L B M X I 
Quick Sort - Descending Order
X U S N M L J I B A 
*/