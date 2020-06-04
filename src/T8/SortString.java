/*
 * 2. Write a program that generates 10 random String (each with 8 small characters). Then sort the characters in ascending order. (Modify the SortTest.java) 
a. Merge Sort  
b. Quick Sort
Example output: [BELOW]
 */
package T8;

public class SortString {
    public static void main(String[] args) {
        
        long start;
        
        // MERGE SORT
        SortTest<String> mergeSorter = new SortTest<>("a", 10, 8, true);
        System.out.print("The random String are : ");
        mergeSorter.showValue();
        start = System.nanoTime();
        System.out.println("Merge Sort - Ascending Order");
        mergeSorter.mergeSort();
        System.out.printf("Time taken: %dns\n", System.nanoTime()-start);
        mergeSorter.showValue();
        
        // QUICK SORT
        SortTest<String> quickSorter = new SortTest<>("a", 10, 8, true);
        System.out.print("\nThe random String are : ");
        quickSorter.showValue();
        System.out.println("Quick Sort - Ascending Order");
        start = System.nanoTime();
        quickSorter.quickSort();
        System.out.printf("Time taken: %dns\n", System.nanoTime()-start);
        quickSorter.showValue();
        
    }
}

/*
Example output:
The random String are : lsuchkbh ybmbstcb glinpcyt xehswomz okuejuyu unvmjuce tzdflhys ubfwgnua txknuenv uejqauft 
Merge Sort - Ascending Order
glinpcyt lsuchkbh okuejuyu txknuenv tzdflhys ubfwgnua uejqauft unvmjuce xehswomz ybmbstcb 

The random String are : egbgqqjy waxxvumj jdlyybyv xquntfbz mdhkkceh mohamgsb soaewyno basgkrqo pfprsedw avonbuse 
Quick Sort - Ascending Order
avonbuse basgkrqo egbgqqjy jdlyybyv mdhkkceh pfprsedw mohamgsb soaewyno waxxvumj xquntfbz 
*/
